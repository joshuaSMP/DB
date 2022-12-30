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
	FOREIGN KEY(curpSupervisor) REFERENCES persona(curp) ON UPDATE CASCADE ON DELETE CASCADE
);
COMMENT ON TABLE persona IS 'Tabla que se encarga de guardar todos los datos de una persona, que puede ser un cliente y/o un repartidor.';
COMMENT ON COLUMN persona.curp IS 'La CURP de la persona, el identificador.';
COMMENT ON COLUMN persona.curpSupervisor IS 'Si es un repartidor, la CURP de su supervisor.';
COMMENT ON COLUMN persona.nombre IS 'El nombre o nombres de la persona.';
COMMENT ON COLUMN persona.apellidoPaterno IS 'El apellido paterno de la persona.';
COMMENT ON COLUMN persona.apellidoMaterno IS 'El apellido materno de la persona.';
COMMENT ON COLUMN persona.genero IS 'El género de la persona, puede ser M o F.';
COMMENT ON COLUMN persona.fechaNacimiento IS 'La fecha de nacimiento de la persona.';
COMMENT ON COLUMN persona.calle IS 'La calle donde vive la persona.';
COMMENT ON COLUMN persona.codigoPostal IS 'El código postal de la dirección de la persona.';
COMMENT ON COLUMN persona.estado IS 'El estado donde vive la persona.';
COMMENT ON COLUMN persona.municipio IS 'El municipio donde vive la persona.';
COMMENT ON COLUMN persona.numero IS 'El número de casa donde vive la persona.';
COMMENT ON COLUMN persona.contrasenia IS 'Si es un cliente la contraseña de la persona.';
COMMENT ON COLUMN persona.email IS 'Si es un cliente su correo electrónico.';
COMMENT ON COLUMN persona.horaSalida IS 'Si es un repartidor su hora de salida.';
COMMENT ON COLUMN persona.horaEntrada IS 'Si es un repartidor su hora de entrada.';
COMMENT ON COLUMN persona.calificacion IS 'Si es un repartidor su calificación.';
COMMENT ON COLUMN persona.numEnvios IS 'Si es un repartidor el número de envíos realizado.';
COMMENT ON COLUMN persona.esCliente IS 'Booleano para saber si la persona es un cliente.';
COMMENT ON COLUMN persona.esRepartidor IS 'Booleano para saber si la persona es un repartidor.';

CREATE TABLE efectivo(
	idDinero CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idDinero) = 18) UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	monto MONEY NOT NULL,
	PRIMARY KEY(idDinero),
	FOREIGN KEY (curp) REFERENCES persona(curp) ON UPDATE CASCADE ON DELETE NO ACTION
);
COMMENT ON TABLE efectivo IS 'datos del efectivo ';
COMMENT ON COLUMN efectivo.idDinero IS 'identificador del dinero ';
COMMENT ON COLUMN efectivo.curp IS 'curp de la persona';
COMMENT ON COLUMN efectivo.monto IS 'monto del dinero en efectivo ';


CREATE TABLE tarjeta(
	numero CHAR(16) NOT NULL CHECK(CHAR_LENGTH(numero) = 16) UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	titular VARCHAR(50) CHECK(titular <> ''), 
	vencimiento DATE NOT NULL,
	ccv INT CHECK (ccv between 100 and 999),
	tipo VARCHAR(20) CHECK(tipo <> ''),
	PRIMARY KEY(numero),
	FOREIGN KEY (curp) REFERENCES persona(curp) ON UPDATE CASCADE ON DELETE NO ACTION
);

COMMENT ON TABLE tarjeta IS 'los datos de la tarjeta ';
COMMENT ON COLUMN tarjeta.numero IS 'numero de la tarjeta ';
COMMENT ON COLUMN tarjeta.curp IS 'curp de la persona';
COMMENT ON COLUMN tarjeta.titular IS 'nombre del titular de la tarjeta ';
COMMENT ON COLUMN tarjeta.vencimiento IS 'fecha del vencimiento de la tarjeta';
COMMENT ON COLUMN tarjeta.ccv IS 'ccv de la tarjeta';
COMMENT ON COLUMN tarjeta.tipo IS 'tiepo de tarjeta que es';

CREATE TABLE pedido(
	idPedido CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idPedido) = 18) UNIQUE, 
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	PRIMARY KEY(idPedido),
	FOREIGN KEY (curp) REFERENCES persona(curp) ON UPDATE CASCADE ON DELETE NO ACTION
);

COMMENT ON TABLE pedido IS 'datos del pedido ';
COMMENT ON COLUMN pedido.idPedido IS 'identificador del pedido ';
COMMENT ON COLUMN pedido.curp IS 'curp de la persona';
COMMENT ON COLUMN pedido.fecha IS 'fecha del pedido ';
COMMENT ON COLUMN pedido.hora IS 'hora del pedido';


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
	FOREIGN KEY (idPedido) REFERENCES pedido(idPedido) ON UPDATE CASCADE ON DELETE NO ACTION, 
	FOREIGN KEY (curp) REFERENCES persona(curp) ON UPDATE CASCADE ON DELETE NO ACTION
);

COMMENT ON TABLE express IS 'Pedido con envío express';
COMMENT ON COLUMN express.idEnvio IS 'identificador del envío';
COMMENT ON COLUMN express.idPedido IS 'identificador del pedido';
COMMENT ON COLUMN express.curp IS 'curp de la persona';
COMMENT ON COLUMN express.hora IS 'hora en la que se realiza el pedido';
COMMENT ON COLUMN express.fecha IS 'fecha en la que se realiza el pedido';
COMMENT ON COLUMN express.costoExtra IS 'costo extra que se realiza el pedido';
COMMENT ON COLUMN express.tiempo IS 'tiempo que esta tardando el pedido';
COMMENT ON COLUMN express.estatus IS 'estado en el que se encuentra el pedido';


CREATE TABLE normal(
	idEnvio CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idEnvio) = 18) UNIQUE,
	idPedido CHAR(18) NOT NULL CHECK(CHAR_LENGTH(idPedido) = 18),
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	hora TIME NOT NULL,
	fecha DATE NOT NULL,
	estatus CHAR(15) NOT NULL,
	PRIMARY KEY(idEnvio), 
	FOREIGN KEY (idPedido) REFERENCES pedido(idPedido) ON UPDATE CASCADE ON DELETE NO ACTION,  
	FOREIGN KEY (curp) REFERENCES persona(curp) ON UPDATE CASCADE ON DELETE NO ACTION
);
COMMENT ON TABLE normal IS 'Pedido con envío normal';
COMMENT ON COLUMN normal.idEnvio IS 'identificador del envío';
COMMENT ON COLUMN normal.idPedido IS 'identificador del pedido';
COMMENT ON COLUMN normal.curp IS 'curp de la persona';
COMMENT ON COLUMN normal.hora IS 'hora en la que se realiza el pedido';
COMMENT ON COLUMN normal.fecha IS 'fecha en la que se realiza el pedido';
COMMENT ON COLUMN normal.estatus IS 'estado en el que se encuentra el pedido';

CREATE TABLE categoria(
	nombre VARCHAR(50) NOT NULL CHECK(CHAR_LENGTH(nombre) <= 50) UNIQUE,
	descripcion VARCHAR(75) CHECK(descripcion <> ''),
	PRIMARY KEY(nombre)
);
COMMENT ON TABLE categoria IS 'Tabla que se encarga de guardar las categorías a las cuales pertenecen los productos.';
COMMENT ON COLUMN categoria.nombre IS 'Nombre de la categoría, el identificador.';
COMMENT ON COLUMN categoria.descripcion IS 'Descripción de la categoría.';

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

COMMENT ON TABLE proveedor IS 'datos del proveedor ';
COMMENT ON COLUMN proveedor.rfc IS 'rfc del proveedor ';
COMMENT ON COLUMN proveedor.razonSocial IS 'razon social del proveedor';
COMMENT ON COLUMN proveedor.cp IS 'codigo postal del proveedor ';
COMMENT ON COLUMN proveedor.calle IS 'calle del proveedor';
COMMENT ON COLUMN proveedor.municipio IS 'municipio del proveedor';
COMMENT ON COLUMN proveedor.estado IS 'estado del proveedor';
COMMENT ON COLUMN proveedor.numero IS 'numero del proveedor';

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
	FOREIGN KEY (nombre) REFERENCES categoria(nombre) ON UPDATE CASCADE ON DELETE NO ACTION, 
	FOREIGN KEY (rfc) REFERENCES proveedor(rfc) ON UPDATE CASCADE ON DELETE NO ACTION
);

COMMENT ON TABLE producto IS 'Producto';
COMMENT ON COLUMN producto.idProducto IS 'identificador del producto';
COMMENT ON COLUMN producto.nombre IS 'nombre que tiene la categoria';
COMMENT ON COLUMN producto.rfc IS 'rfc del proveedor del producto';
COMMENT ON COLUMN producto.descActivo IS 'dato que nos dice si el producto tiene descuento';
COMMENT ON COLUMN producto.nomArchivo IS 'nombre de la imagen del producto';
COMMENT ON COLUMN producto.descripcion IS 'información que descriibe el producto';
COMMENT ON COLUMN producto.uniDispo IS 'cantidad de productos disponibles';
COMMENT ON COLUMN producto.precio IS 'precio del producto';
COMMENT ON COLUMN producto.nombreP IS 'nombre que tiene el producto';

CREATE TABLE telefonoProveedor(
	telefono CHAR(10) NOT NULL CHECK(CHAR_LENGTH(telefono) = 10) UNIQUE,
	rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc) =13),
	PRIMARY KEY(telefono, rfc), 
	FOREIGN KEY (rfc) REFERENCES proveedor(rfc) ON UPDATE CASCADE ON DELETE NO ACTION
);
COMMENT ON TABLE telefonoProveedor IS 'Tabla que se encarga de guardar los teléfonos de cada proveedor.';
COMMENT ON COLUMN telefonoProveedor.telefono IS 'Alguno de los teléfonos del proveedor.';
COMMENT ON COLUMN telefonoProveedor.rfc IS 'El RFC del proveedor, el identificador.';
