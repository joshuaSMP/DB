DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

CREATE TABLE cliente(
	email VARCHAR(50)NOT NULL CHECK(email <> '') UNIQUE,
	estado VARCHAR(50) NOT NULL CHECK(estado <> ''),
	municipio VARCHAR(50) NOT NULL CHECK(municipio <> ''),
	numero INT NOT NULL,
	calle VARCHAR(50) NOT NULL CHECK(calle <> ''),
	codigoPostal CHAR(5) NOT NULL CHECK(CHAR_LENGTH(codigoPostal)=5), 
	horaEntrada TIME, -- Puede ser null
	horaSalida TIME,
	facultad VARCHAR(40) NOT NULL CHECK(facultad <> ''),
	nombre VARCHAR(50) NOT NULL CHECK(nombre <> ''),
	paterno VARCHAR(50) NOT NULL CHECK(paterno <> ''),
	materno VARCHAR(50) NOT NULL CHECK(materno <> ''),
	celular CHAR(10) NOT NULL CHECK(CHAR_LENGTH(celular)=10),
	casa CHAR(10) NOT NULL CHECK(CHAR_LENGTH(casa)=10),
	archivoFoto VARCHAR(50) NOT NULL CHECK(archivoFoto <> ''),
	esEstudiante BOOLEAN NOT NULL,
	esAcademico BOOLEAN NOT NULL,
	esTrabajador BOOLEAN NOT NULL,
	PRIMARY KEY(email)
);

COMMENT ON TABLE cliente IS 'Tabla que se encarga de guardar todos los datos de una persona que es un cliente';
COMMENT ON COLUMN cliente.email IS 'Correo electrónico del cliente, el identificador.';
COMMENT ON COLUMN cliente.estado IS 'El estado donde vive el cliente.';
COMMENT ON COLUMN cliente.municipio IS 'El municipio donde vive el cliente.';
COMMENT ON COLUMN cliente.numero IS 'El número de casa donde vive el cliente.';
COMMENT ON COLUMN cliente.calle IS 'La calle donde vive el cliente.';
COMMENT ON COLUMN cliente.codigoPostal IS 'El código postal de la dirección del liente.';
COMMENT ON COLUMN cliente.horaEntrada IS 'La hora de entrada a sus actividades del cliente.';
COMMENT ON COLUMN cliente.horaSalida IS 'La hora de salida a sus actividades del cliente.';
COMMENT ON COLUMN cliente.facultad IS 'La facultad, instituto o unidad en la que estudia o trabaja el cliente.';
COMMENT ON COLUMN cliente.nombre IS 'El nombre del cliente.';
COMMENT ON COLUMN cliente.paterno IS 'El apellido paterno del cliente.';
COMMENT ON COLUMN cliente.materno IS 'El apellido materno del cliente.';
COMMENT ON COLUMN cliente.celular IS 'El número de celular del cliente.';
COMMENT ON COLUMN cliente.casa IS 'El número de casa del cliente.';
COMMENT ON COLUMN cliente.archivoFoto IS 'Nombre del archivo de la foto del cliente.';
COMMENT ON COLUMN cliente.esEstudiante IS 'Booleano para saber si el cliente es un estudiante.';
COMMENT ON COLUMN cliente.esAcademico IS 'Booleano para saber si el cliente es un académico.';
COMMENT ON COLUMN cliente.esTrabajador IS 'Booleano para saber si el cliente es un trabajador.';

CREATE TABLE personal(
	numlicencia VARCHAR(9) NOT NULL CHECK(CHAR_LENGTH(numlicencia) = 9) UNIQUE,
	celular VARCHAR(10) NOT NULL CHECK(CHAR_LENGTH(celular) = 10),
	casa VARCHAR(10) NOT NULL CHECK(CHAR_LENGTH(casa) = 10),
	email VARCHAR(50) CHECK(email <> '') UNIQUE,
	fechaSalida DATE, -- null si no han salido 
	fechaIngreso DATE NOT NULL,
	archivoFoto VARCHAR(50) NOT NULL,
	nombre VARCHAR(50) NOT NULL CHECK(nombre <> ''),
	paterno VARCHAR(50) NOT NULL CHECK(paterno <> ''),
	materno VARCHAR(50) NOT NULL CHECK(materno <> ''),
	municipio VARCHAR(50) NOT NULL,
	numero int NOT NULL,
	calle VARCHAR(50) NOT NULL,
	codigoPostal CHAR(5) NOT NULL CHECK(CHAR_LENGTH(codigoPostal) = 5),
	estado VARCHAR(50) NOT NULL,
	rfc VARCHAR(13), -- null si no son dueños
	esDuenio BOOLEAN NOT NULL,
	esChofer BOOLEAN NOT NULL,
	PRIMARY KEY(numlicencia)
);


COMMENT ON TABLE personal IS 'Tabla que se encarga de guardar todos los datos de personal';
COMMENT ON COLUMN personal.numLicencia IS 'numero de licencia de personal';
COMMENT ON COLUMN personal.celular IS 'numero de celular de personal';
COMMENT ON COLUMN personal.casa IS 'numero de telefono de casa de personal';
COMMENT ON COLUMN personal.email IS 'email de personal';
COMMENT ON COLUMN personal.fechaSalida IS 'fecha de salida de personal';
COMMENT ON COLUMN personal.fechaIngreso IS 'fecha de ingreso de personal';
COMMENT ON COLUMN personal.archivoFoto IS 'archivoFoto de personal';
COMMENT ON COLUMN personal.nombre IS 'nombre de personal';
COMMENT ON COLUMN personal.paterno IS 'apellido paterno de personal';
COMMENT ON COLUMN personal.materno IS 'apellido materno de personal';
COMMENT ON COLUMN personal.municipio IS 'municipio de personal';
COMMENT ON COLUMN personal.numero IS 'numero de casa de personal';
COMMENT ON COLUMN personal.calle IS 'calle de personal';
COMMENT ON COLUMN personal.codigoPostal IS 'codigo postal de personal';
COMMENT ON COLUMN personal.estado IS 'estado de personal';
COMMENT ON COLUMN personal.rfc IS 'rfc de personal';
COMMENT ON COLUMN personal.esDuenio IS 'el personal es dueño' ;
COMMENT ON COLUMN personal.esChofer IS 'el personal es chofer';

CREATE TABLE vehiculo(
	NumEconomico VARCHAR(6) NOT NULL CHECK(CHAR_LENGTH(NumEconomico) = 6) UNIQUE,
	NumLicenciaDueno VARCHAR(9) NOT NULL CHECK(CHAR_LENGTH(NumLicenciaDueno) = 9),
	NumLicenciaConductor VARCHAR(9) NOT NULL CHECK(CHAR_LENGTH(NumLicenciaConductor) = 9),
	tipoTransmision VARCHAR(20) NOT NULL CHECK(tipoTransmision <> ''),
	RazonBaja VARCHAR(700) NOT NULL CHECK(RazonBaja <> ''),
	TipoSeguro VARCHAR(50) NOT NULL CHECK(TipoSeguro <> ''),
	Estado VARCHAR(50) NOT NULL CHECK(Estado <> ''),
	Vigencia DATE NOT NULL,
	anio VARCHAR(4) NOT NULL CHECK(CHAR_LENGTH(anio)=4),
	TipoCombustible VARCHAR(50) NOT NULL CHECK(TipoCombustible <> ''),
	Aseguradora VARCHAR(50) NOT NULL CHECK(Aseguradora <> ''),
	Modelo VARCHAR(50) NOT NULL CHECK(Modelo <> ''),
	Pasajeros INT NOT NULL,
	NumCilindros INT NOT NULL,
	LlantaR BOOLEAN NOT NULL,
	Marca VARCHAR(50) NOT NULL CHECK(Marca <> ''),
	NumPuertas INT NOT NULL,
	PRIMARY KEY(NumEconomico),
	FOREIGN KEY (NumLicenciaDueno) REFERENCES personal(numlicencia) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY (NumLicenciaConductor) REFERENCES personal(numlicencia) ON UPDATE CASCADE ON DELETE NO ACTION
);

COMMENT ON TABLE vehiculo IS 'Tabla que se encarga de guardar todos los datos de una vehiculo';
COMMENT ON COLUMN vehiculo.NumEconomico IS 'numero economico que tiene el vehiculo';
COMMENT ON COLUMN vehiculo.NumLicenciaDueno IS 'numero de licencia del dueño del vehiculo';
COMMENT ON COLUMN vehiculo.NumLicenciaConductor IS 'numero de licencia que tiene el conductor del vehiculo';
COMMENT ON COLUMN vehiculo.tipoTransmision IS 'tipo de transmision que tiene el vehiculo';
COMMENT ON COLUMN vehiculo.RazonBaja IS 'razon de baja para el vehiculo';
COMMENT ON COLUMN vehiculo.TipoSeguro IS 'tipo de seguro que tiene el vehiculo';
COMMENT ON COLUMN vehiculo.Estado IS 'estado del vehiculo';
COMMENT ON COLUMN vehiculo.Vigencia IS 'Vigencia del vehiculo';
COMMENT ON COLUMN vehiculo.anio IS 'año del vehiculo';
COMMENT ON COLUMN vehiculo.TipoCombustible IS 'tipo de combustible del vehiculo';
COMMENT ON COLUMN vehiculo.Aseguradora IS 'aseguradora que cuenta el vehiculo';
COMMENT ON COLUMN vehiculo.NumEconomico IS 'numero economico que tiene el vehiculo';
COMMENT ON COLUMN vehiculo.Modelo IS 'modelo del vehiculo';
COMMENT ON COLUMN vehiculo.Pasajeros IS 'pasajeros que puede tener el vehiculo';
COMMENT ON COLUMN vehiculo.NumCilindros IS 'numero de cilindros que tiene el vehiculo';
COMMENT ON COLUMN vehiculo.LlantaR IS 'el vehiculo tiene llanta de refaccion';
COMMENT ON COLUMN vehiculo.Marca IS 'la marca del vehiculo';
COMMENT ON COLUMN vehiculo.NumPuertas IS 'el numero de puertas que cuenta el vehiculo';

CREATE TABLE infraccion(
	idInfraccion VARCHAR(14) NOT NULL CHECK(CHAR_LENGTH(idInfraccion) = 14) UNIQUE,
	numEconomico VARCHAR(6) NOT NULL CHECK(CHAR_LENGTH(numEconomico) = 6),
	alcaldia VARCHAR(50) NOT NULL CHECK(alcaldia <> ''),
	cp CHAR(5) NOT NULL,
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	monto MONEY NOT NULL,
	agente CHAR(6) NOT NULL,
	calle VARCHAR(50) NOT NULL CHECK(calle <> ''),
	PRIMARY KEY(idInfraccion),
	FOREIGN KEY (numEconomico) REFERENCES vehiculo(NumEconomico) ON UPDATE CASCADE ON DELETE NO ACTION
);
COMMENT ON TABLE infraccion IS 'Tabla para guardar los datos de una infracción.';
COMMENT ON COLUMN infraccion.idInfraccion IS 'ID para identificar la infracción.';
COMMENT ON COLUMN infraccion.numEconomico IS 'ID para identificar al vehículo dentro de la organización.';
COMMENT ON COLUMN infraccion.alcaldia IS 'Alcaldia donde sucedió la infracción.';
COMMENT ON COLUMN infraccion.cp IS 'Código postal donde sucedió la infracción.';
COMMENT ON COLUMN infraccion.fecha IS 'Fecha en que pasó la infracción.';
COMMENT ON COLUMN infraccion.hora IS 'Hora de la infracción.';
COMMENT ON COLUMN infraccion.monto IS 'Monto de la infracción.';
COMMENT ON COLUMN infraccion.agente IS 'Placa del Agente que dió la infracción.';
COMMENT ON COLUMN infraccion.calle IS 'Calle en que se dió la infracción.';

CREATE TABLE viaje(
	idViaje VARCHAR(12) NOT NULL UNIQUE,
	NumEconomico VARCHAR(6) NOT NULL CHECK(CHAR_LENGTH(NumEconomico) = 6),
	NumLicencia VARCHAR(9) NOT NULL CHECK(CHAR_LENGTH(NumLicencia) = 9),
	numeroP INT NOT NULL,
	Tiempo VARCHAR(50) NOT NULL CHECK(Tiempo <> ''), 
	Distancia VARCHAR(50) NOT NULL CHECK(Distancia <> ''),
	Fecha DATE NOT NULL,
	PRIMARY KEY(idViaje),
	FOREIGN KEY (NumEconomico) REFERENCES vehiculo(NumEconomico) ON UPDATE NO ACTION ON DELETE NO ACTION,
	FOREIGN KEY (NumLicencia) REFERENCES personal(numLicencia) ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMENT ON TABLE viaje IS 'Tabla que se encarga de guardar todos los datos de una viaje';
COMMENT ON COLUMN viaje.idViaje IS 'identificador que tiene un viaje';
COMMENT ON COLUMN viaje.NumEconomico IS 'numero economico que tiene el viaje';
COMMENT ON COLUMN viaje.NumLicencia IS 'numero de licencia que tiene un viaje';
COMMENT ON COLUMN viaje.numeroP IS 'numero de pasajero que tiene el viaje';
COMMENT ON COLUMN viaje.Tiempo IS 'tiempo estimado que tiene el viaje';
COMMENT ON COLUMN viaje.Distancia IS 'distancia estimada que tiene un viaje';

CREATE TABLE realizar(
	idViaje VARCHAR(12) NOT NULL,
	email VARCHAR(50)NOT NULL CHECK(email <> ''),
	FOREIGN KEY(idViaje) REFERENCES viaje(idViaje) ON UPDATE NO ACTION ON DELETE NO ACTION,
	FOREIGN KEY(email) REFERENCES cliente(email) ON UPDATE CASCADE ON DELETE NO ACTION
);

COMMENT ON TABLE realizar IS 'Tabla para unir los viajes hechos y sus respectivos usuarios del viaje.';
COMMENT ON COLUMN realizar.idViaje IS 'Identificador del número del viaje.';
COMMENT ON COLUMN realizar.email IS 'Identificador del cliente.';

CREATE TABLE destino(
	destino VARCHAR(50)NOT NULL CHECK(destino <> ''),
	idViaje VARCHAR(12) NOT NULL,
	FOREIGN KEY(idViaje) REFERENCES viaje(idViaje) ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMENT ON TABLE destino IS 'Tabla para guardar los múltiples destinos de un viaje.';
COMMENT ON COLUMN destino.destino IS 'Destino de un viaje';
COMMENT ON COLUMN destino.idViaje IS 'Identificador del viaje.';

CREATE TABLE origen(
	origen VARCHAR(50)NOT NULL CHECK(origen <> ''),
	idViaje VARCHAR(12) NOT NULL,
	FOREIGN KEY(idViaje) REFERENCES viaje(idViaje) ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMENT ON TABLE origen IS 'Tabla para guardar los múltiples origenes de un viaje.';
COMMENT ON COLUMN origen.origen IS 'Origen de un viaje';
COMMENT ON COLUMN origen.idViaje IS 'Identificador del viaje.';