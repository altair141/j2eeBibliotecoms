DROP TABLE area;
CREATE TABLE area (idArea int NOT NULL, nombreArea varchar(30) NOT NULL, PRIMARY KEY (idArea)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE cuenta;
CREATE TABLE cuenta (idCuenta int NOT NULL, rut varchar(9) NOT NULL, clave varchar(25) NOT NULL, PRIMARY KEY (idCuenta), INDEX cuenta_fk1 (rut)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE cuenta_libro;
CREATE TABLE cuenta_libro (idCuentaLibro int NOT NULL, idCuenta int NOT NULL, codigoRegistro int NOT NULL, idPrestamo int NOT NULL, PRIMARY KEY (idCuentaLibro), INDEX cuenta_libro_fk1 (idCuenta), INDEX cuenta_libro_fk2 (codigoRegistro), INDEX cuenta_libro_fk3 (idPrestamo)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE libro;
CREATE TABLE libro (codigoRegistro int NOT NULL, tituloLibro varchar(25) NOT NULL, isbn varchar(25) NOT NULL, autor varchar(15) NOT NULL, editorial varchar(15) NOT NULL, descripcion mediumtext NOT NULL, idArea int NOT NULL, estado tinyint(1) NOT NULL, PRIMARY KEY (codigoRegistro), INDEX libro_fk1 (idArea)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE prestamo;
CREATE TABLE prestamo (idPrestamo int NOT NULL, fechaPrestamo date NOT NULL, codigoRegistro int NOT NULL, PRIMARY KEY (idPrestamo), INDEX prestamo_fk1 (codigoRegistro)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE tipo_usuario;
CREATE TABLE tipo_usuario (idTUsuario int NOT NULL, tipoNombre varchar(25) NOT NULL, PRIMARY KEY (idTUsuario)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE usuario;
CREATE TABLE usuario (rut varchar(9) NOT NULL, nombreUsuario varchar(25) NOT NULL, apellido1 varchar(25) NOT NULL, apellido2 varchar(25) NOT NULL, direccion varchar(30), fono int, email varchar(30), idTUsuario int NOT NULL, PRIMARY KEY (rut), INDEX usuario_fk1 (idTUsuario)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE cuenta ADD CONSTRAINT cuenta_fk1 FOREIGN KEY (rut) REFERENCES usuario (rut);
ALTER TABLE cuenta_libro ADD CONSTRAINT cuenta_libro_fk3 FOREIGN KEY (idPrestamo) REFERENCES prestamo (idPrestamo) ;
ALTER TABLE cuenta_libro ADD CONSTRAINT cuenta_libro_fk1 FOREIGN KEY (idCuenta) REFERENCES cuenta (idCuenta) ;
ALTER TABLE cuenta_libro ADD CONSTRAINT cuenta_libro_fk2 FOREIGN KEY (codigoRegistro) REFERENCES libro (codigoRegistro);
ALTER TABLE libro ADD CONSTRAINT libro_fk1 FOREIGN KEY (idArea) REFERENCES area (idArea) ON UPDATE CASCADE;
ALTER TABLE prestamo ADD CONSTRAINT prestamo_fk1 FOREIGN KEY (codigoRegistro) REFERENCES libro (codigoRegistro);
ALTER TABLE usuario ADD CONSTRAINT usuario_fk1 FOREIGN KEY (idTUsuario) REFERENCES tipo_usuario (idTUsuario) ON UPDATE CASCADE;
