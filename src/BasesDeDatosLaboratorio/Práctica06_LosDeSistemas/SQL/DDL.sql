DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

CREATE TABLE persona(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18) UNIQUE,
	curpSupervisor CHAR(18) CHECK(CHAR_LENGTH(curp) = 18),
	nombre VARCHAR(50) NOT NULL CHECK(nombre <> ''),
	apellidoPaterno VARCHAR(50) NOT NULL CHECK(apellidoPaterno <> ''),
	apellidoMaterno VARCHAR(50) NOT NULL CHECK(apellidoMaterno <> ''),
	genero CHAR(1) NOT NULL CHECK(genero <> ''),
	fechaNacimiento DATE NOT NULL,
	calle VARCHAR(50) NOT NULL CHECK(calle <> ''),
	codigoPostal INT NOT NULL CHECK(codigoPostal between 10000 and 99999), 
	estado VARCHAR(50) NOT NULL CHECK(estado <> ''),
	municipio VARCHAR(50) NOT NULL CHECK(municipio <> ''),
	numero INT NOT NULL,
	contrasenia VARCHAR(50) CHECK(contrasenia <> ''),
	email VARCHAR(50) CHECK(email <> ''),
	horaSalida TIME,
	horaEntrada TIME,
	calificacion REAL CHECK (calificacion between 0 and 5),
	numEnvios BIGINT CHECK (numEnvios >=0),
	esCliente BOOLEAN NOT NULL,
	esRepartidor BOOLEAN NOT NULL,
	PRIMARY KEY(curp),
	FOREIGN KEY(curpSupervisor) REFERENCES persona(curp)
);

CREATE TABLE efectivo(
	idDinero CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idDinero) = 18) UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	monto MONEY NOT NULL,
	PRIMARY KEY(idDinero),
	FOREIGN KEY (curp) REFERENCES persona(curp)
);

CREATE TABLE tarjeta(
	numero CHAR(16) NOT NULL CHECK(CHAR_LENGTH(numero) = 16) UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	titular VARCHAR(50) CHECK(titular <> ''), 
	vencimiento DATE NOT NULL,
	ccv INT CHECK (ccv between 100 and 999),
	tipo VARCHAR(20) CHECK(tipo <> ''),
	PRIMARY KEY(numero),
	FOREIGN KEY (curp) REFERENCES persona(curp)
);

CREATE TABLE pedido(
	idPedido CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idPedido) = 18) UNIQUE, 
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	PRIMARY KEY(idPedido),
	FOREIGN KEY (curp) REFERENCES persona(curp)
);

CREATE TABLE express(
	idEnvio CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idEnvio) = 18) UNIQUE,
	idPedido CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idPedido) = 18),
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	hora TIME NOT NULL,
	fecha DATE NOT NULL,
	costoExtra MONEY NOT NULL,
	tiempo TIME NOT NULL,
	estatus CHAR(15) NOT NULL,
	PRIMARY KEY(idEnvio), 
	FOREIGN KEY (idPedido) REFERENCES pedido(idPedido), 
	FOREIGN KEY (curp) REFERENCES persona(curp) 
);

CREATE TABLE normal(
	idEnvio CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idEnvio) = 18) UNIQUE,
	idPedido CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idPedido) = 18),
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	hora TIME NOT NULL,
	fecha DATE NOT NULL,
	estatus CHAR(15) NOT NULL,
	PRIMARY KEY(idEnvio), 
	FOREIGN KEY (idPedido) REFERENCES pedido(idPedido), 
	FOREIGN KEY (curp) REFERENCES persona(curp) 
);

CREATE TABLE categoria(
	nombre VARCHAR(50) NOT NULL CHECK(CHAR_LENGTH(nombre) <= 50) UNIQUE,
	descripcion VARCHAR(75) CHECK(descripcion <> ''),
	PRIMARY KEY(nombre)
);

CREATE TABLE proveedor(
	rfc VARCHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc) = 13) UNIQUE,
	razonSocial VARCHAR(75) NOT NULL,
	cp CHAR(5) NOT NULL CHECK(CHAR_LENGTH(cp) = 5),
	calle VARCHAR(50) NOT NULL, 
	municipio VARCHAR(50) NOT NULL,
	estado VARCHAR(50) NOT NULL,
	numero int CHECK(numero>=0),
	PRIMARY KEY(rfc)
);

CREATE TABLE producto(
	idProducto CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idProducto) = 18) UNIQUE,
	nombre VARCHAR(50) CHECK(nombre <>''),
	rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc) = 13),
	descActivo REAL NOT NULL CHECK(descActivo between 0 and 100),
	nomArchivo VARCHAR(75) CHECK(nomArchivo <> ''),
	descripcion VARCHAR(250) CHECK(descripcion <> ''),
	uniDispo int CHECK(uniDispo>=0),
	precio MONEY NOT NULL, 
	nombreP VARCHAR(50) CHECK(nombreP <> ''),
	PRIMARY KEY(idProducto), 
	FOREIGN KEY (nombre) REFERENCES categoria(nombre), 
	FOREIGN KEY (rfc) REFERENCES proveedor(rfc) 
);

CREATE TABLE telefonoProveedor(
	telefono CHAR(10) NOT NULL CHECK(CHAR_LENGTH(telefono) = 10) UNIQUE,
	rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc) =13),
	PRIMARY KEY(telefono, rfc), 
	FOREIGN KEY (rfc) REFERENCES proveedor(rfc)
);

INSERT INTO persona VALUES ('12345678901234567A', NULL, 'José', 'Cortéz', 'Córtez', 'M', '08-11-2021', 
							'Quiote', 14739, 'Veracruz', 'Iztapalapa', 13, 'brendita123', 'jcc@ciencias.unam.mx', '19:00:00', '09:00:00', 5, 3, TRUE, TRUE);
							
INSERT INTO persona VALUES ('12345678901234567B', '12345678901234567A', 'José', 'Cortéz', 'Córtez', 'M', '08-11-2021', 
							'Quiote', 14739, 'Veracruz', 'Iztapalapa', 13, 'brendita123', 'jcc@ciencias.unam.mx', '19:00:00', '09:00:00', 5, 3, TRUE, TRUE);
							
INSERT INTO persona VALUES ('12345678901234567C', '12345678901234567A', 'José', 'Cortéz', 'Córtez', 'M', '08-11-2021', 
							'Quiote', 14739, 'Veracruz', 'Iztapalapa', 13, 'brendita123', 'jcc@ciencias.unam.mx', '19:00:00', '09:00:00', 5, 3, TRUE, TRUE);
							
INSERT INTO efectivo VALUES('123456789012345678', '12345678901234567C', '$500');

INSERT INTO efectivo VALUES('12345678901234567A', '12345678901234567C', '$500');

INSERT INTO tarjeta VALUES(1234567890654321, '12345678901234567A', 'José CC', '29-11-2021', 112, 'Crédito');

INSERT INTO tarjeta VALUES(1234567890654324, '12345678901234567A', 'José CC', '29-11-2021', 112, 'Crédito'); 

INSERT INTO tarjeta VALUES(1234567890654323, '12345678901234567B', 'José CC', '29-11-2021', 112, 'Crédito');

INSERT INTO pedido VALUES('098765432187654321', '12345678901234567B', '29-11-2021', '19:00:00');

INSERT INTO pedido VALUES('098765432187654324', '12345678901234567B', '29-11-2021', '19:00:00');

INSERT INTO pedido VALUES('098765432187654323', '12345678901234567C', '29-11-2021', '19:00:00');

INSERT INTO express VALUES('1234567890ABCDE123', '098765432187654323', '12345678901234567B', '19:00:00', '29-11-2021', '$125', '03:37:43', 'Completado');

INSERT INTO express VALUES('1234567890ABCDE124', '098765432187654323', '12345678901234567A', '19:00:00', '29-11-2021', '$125', '03:37:43', 'Completado');

INSERT INTO express VALUES('1234567890ABCDE125', '098765432187654324', '12345678901234567A', '19:00:00', '29-11-2021', '$125', '03:37:43', 'Completado'); 

INSERT INTO normal VALUES('1234567890123ABCDE', '098765432187654323', '12345678901234567A', '19:00:00', '29-11-2021', 'En proceso');

INSERT INTO normal VALUES('1234567890123ABCDA', '098765432187654321', '12345678901234567B', '19:00:00', '29-11-2021', 'En proceso');

INSERT INTO categoria VALUES('Limpieza', 'dasldkjwqoidjalksdjal jabón líquido');

INSERT INTO categoria VALUES('Belleza', 'dasldkjwqoidjalksdjal para una piel suave como bebé');

INSERT INTO categoria VALUES('Deporte', 'para mantenerte fit');

INSERT INTO proveedor VALUES('1234567890123', 'Medio Ambiente', 54740, 'Juan Nepomuceno', 'GAM', 'Guanajuato', 23);

INSERT INTO proveedor VALUES('1234567890124', 'Medio Ambiente', 54740, 'Juan Nepomuceno', 'GAM', 'Guanajuato', 23);

INSERT INTO producto VALUES('12345678901234567A', 'Limpieza', '1234567890123', 5,  'fotoProducto.png', 'Axion completa', 97, '$24', 'Axion');

INSERT INTO telefonoProveedor VALUES('1234567890', '1234567890123');

INSERT INTO telefonoProveedor VALUES('1234567891', '1234567890123');