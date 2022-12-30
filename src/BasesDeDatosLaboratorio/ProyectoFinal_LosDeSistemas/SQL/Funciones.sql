-- 1. Función para calcular el número de viajes hechos por un cliente. 
create or replace function numViajesCliente(VARCHAR) returns int
as $$
declare
   a varchar;
   res int := 0;
begin
   a := $1;
   res := count(idViaje) from cliente natural join realizar natural join viaje where email = a;
   return res;
end;
$$
Language plpgsql;

-- 2. Función para calcular el número de destinos que tiene un viaje.
create or replace function numDestinos(VARCHAR) returns int
as $$
declare
   a varchar;
   res int := 0;
begin
   a := $1;
   res := count(idViaje) from destino natural join viaje where idViaje = a;
   return res;
end;
$$
Language plpgsql;

-- 3. Función para calcular el número de orígenes que tiene un viaje.
create or replace function numOrigenes(VARCHAR) returns int
as $$
declare
   a varchar;
   res int := 0;
begin
   a := $1;
   res := count(idViaje) from origen natural join viaje where idViaje = a;
   return res;
end;
$$
Language plpgsql;

-- 4. Función para checar si el viaje empezó en CU, revisa todos sus origenes. 
create or replace function origenEnCU(VARCHAR, int) returns boolean 
as $$
declare
	a varchar;
	b int;
	c int;
	res boolean := false; 
	contador int := 0;
begin
	a := $1;
	b := $2;
	c := count (idViaje) from origen natural join viaje where origen = 'CU' and idViaje = a;
	if (b < c or b>c) then
		res := false;
	else
		res:= true;
	end if;
	return res;
end;
$$
Language plpgsql;

-- 5. Función para checar si el viaje terminó en CU, revisa todos sus destinos. 
create or replace function destinoEnCU(VARCHAR, int) returns boolean 
as $$
declare
	a varchar;
	b int;
	c int;
	res boolean := false; 
	contador int := 0;
begin
	a := $1;
	b := $2;
	c := count (idViaje) from destino natural join viaje where destino = 'CU' and idViaje = a;
	if (b = c) then
		res := true;
	else
		res:= false;
	end if;
	return res;
end;
$$
Language plpgsql;

-- 6. Función para comprobar si algún alumno en un viaje es un alumno.
create or replace function algunoEsAlumno(varchar) returns boolean
as $$
declare
	a varchar := $1;
	alumno boolean;
	alumnos int := 0;
begin
	alumnos := count(email) from viaje natural join realizar natural join cliente where idViaje = a group by esEstudiante having (esEstudiante = true);
	if(alumnos > 0) then
		alumno:= true;
	else
		alumno:= false;
	end if;
	return alumno;
end;
$$
Language plpgsql;

-- 7. Función para calcular la distancia de un viaje.
create or replace function distanciaViaje(varchar) returns varchar
as $$
declare
	a varchar := $1;
	d varchar;
begin
	d = distancia from viaje where idViaje = a;
	return d;
end;
$$
Language plpgsql;


-- 8. Función para calcular el número de pasajeros en un viaje.
create or replace function pasajerosViaje(varchar) returns int
as $$
declare
	a varchar := $1;
	p int = 0;
begin
	p = numeroP from viaje where idViaje = a;
	return p;
end;
$$
Language plpgsql;


--9. Función para devolver algún cliente que haya participado en un viaje (determinista).
create or replace function clienteEnViaje(varchar) returns varchar
as $$
declare
	a varchar := $1;
	cliente varchar;
begin
	cliente :=  min(email) from viaje natural join realizar natural join cliente where idViaje = a order by 1;
	return cliente;
end;
$$
Language plpgsql;

--10. Función para calcular el costo de un viaje.
create or replace function costoViaje(int, boolean, boolean, boolean, int, varchar) returns numeric(10,2)
as $$
declare
	numeroPasajeros int := $1;
	destino boolean:= $2;
	origen boolean:= $3;
	esEstudiante boolean:= $4;
	numViajesCliente int := $5;
	costo int := 0;
	a varchar := $6;
	distancia float;
begin
	distancia := a::float;
	if(numViajesCliente % 5 = 0) then		
		if(destino = true and origen = true) then
			costo := 15;
		else
			costo := 15;
			costo := costo + (distancia * 8);
		end if;
	end if;
	if (destino = true and origen = true) then
		costo := 20;
	else
		costo := 20;
		costo := costo + (distancia * 10);
	end if;
	if(esEstudiante) then
		costo := costo * (.15);
	else 
		costo := costo * (.1);
	end if;
	if(numeroPasajeros > 1) then
		costo := costo * ((numeroPasajeros-1) *(.08));
	end if;
	return costo;
end;
$$
Language plpgsql;


--11. Función para calcular las ganancias de un viaje para el condutor.
create or replace function gananciaViaje(varchar) returns numeric(10,2)
as $$
declare
	idV varchar := $1;
	costo int;
	esOrigen boolean := false;
	esDestino boolean := false;
begin
	costo := costoViaje( 
		(select pasajerosViaje(idV)),
		(select destinoEnCU(idV, numDestinos(idV))),
		(select origenEnCU(idV, numOrigenes(idV))),
		(select algunoEsAlumno(idV)),
		(select numViajesCliente(clienteEnViaje(idV))),
		(select distanciaViaje(idV)) 
			);
	esOrigen := origenEnCU(idV, numOrigenes(idV));
	esDestino := destinoEnCU(idV, numDestinos(idV));
	if (esDestino = true and esOrigen = true) then
		costo := costo * (.08);
	else 
		costo := costo * (.12);
	end if;
	return costo;
end;
$$
Language plpgsql;

-- 12. Función para calcular el costo de cada viaje realizado.
create or replace function costoViajesTotales() returns setof "record"
as $$
declare 
   r record;
begin
   for r in select idViaje, costoViaje(
	(select pasajerosViaje(idViaje)),
	(select destinoEnCU(idViaje, numDestinos(idViaje))),
	(select origenEnCU(idViaje, numOrigenes(idViaje))),
	(select algunoEsAlumno(idViaje)),
	(select numViajesCliente(clienteEnViaje(idViaje))),
	(select distanciaViaje(idViaje))   
   ) as Costo
            from viaje
      loop
         return next r;
      end loop;
   return;
end;
$$
language plpgsql; 

-- Uso de la función anterior:
select idViaje, costo from costoViajesTotales() as(idViaje varchar, costo numeric)

-- 13. Función para calcular la ganancia cumulativa total de cada chófer. 
create or replace function gananciaChofer() returns setof "record"
as $$
declare 
   r record;
begin 
   for r in select numlicencia, sum(gananciaViaje(idViaje)) as Ganancia
            from viaje natural join personal
			group by numlicencia
      loop
         return next r;
      end loop;
   return;
end;
$$
language plpgsql; 

-- Uso de la función anterior:
select numlicencia, ganancia from gananciaChofer() as(numLicencia varchar, ganancia numeric)

-- 14. Función para calcular los viajes realizados por un chofer en un periodo dado.
create or replace function ganaExtra(varchar, date, date) returns boolean
as $$
declare
	chofer varchar := $1;
	inicio date := $2;
	fin date := $3;
	contador int := 0;
	ganaExtra boolean := false;
begin
	contador := count(idViaje) from viaje natural join personal where numlicencia = chofer and fecha >= inicio and fecha <= fin;
	if (contador >= 25) then
		ganaExtra := true;
	end if;
	return ganaExtra;
end;
$$
Language plpgsql;


-- 15. Función para calcular el bono o no de un chofer 
create or replace function bonoPorViaje(varchar, date, date, varchar) returns numeric(10,2)
as $$
declare
	chofer varchar := $1;
	inicio date := $2;
	fin date := $3;
	bono real := 0.0;
	ganaExtraB boolean := false;
	costo numeric;
	viaje varchar := $4;
begin
	ganaExtraB := ganaExtra(chofer, inicio, fin);
	if (ganaExtraB) then
		bono := .1;
	end if;
	costo := costoViaje(
		(select pasajerosViaje(viaje)),
		(select destinoEnCU(viaje, numDestinos(viaje))),
		(select origenEnCU(viaje, numOrigenes(viaje))),
		(select algunoEsAlumno(viaje)),
		(select numViajesCliente(clienteEnViaje(viaje))),
		(select distanciaViaje(viaje))   
	);
	costo := costo * bono;
	return costo;
end;
$$
Language plpgsql;

-- 16. Función para calcular el bono mensual de un chofer.
create or replace function bonoChofer(date, date) returns setof "record"
as $$
declare 
   r record;
   inicio date := $1;
   fin date := $2;
begin
   for r in select numlicencia as chofer, count(idViaje), sum(bonoPorViaje(numlicencia, inicio, fin, idViaje)
   ) as bono
            from viaje natural join personal
			where fecha >= inicio and fecha <= fin
			group by numlicencia
      loop
         return next r;
      end loop;
   return;
end;
$$
language plpgsql; 

-- Para usarlo.
select numlicencia, cuenta, bono from bonoChofer('02-09-2020','24-01-2022') as(numLicencia varchar, cuenta bigint, bono numeric)







