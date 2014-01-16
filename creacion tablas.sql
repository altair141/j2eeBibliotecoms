create database bibliotecom;

CREATE TABLE
    usuario
    (
        rut VARCHAR(9) NOT NULL,
        nombreUsuario VARCHAR(25) NOT NULL,
        apellido1 VARCHAR(25) NOT NULL,
        apellido2 VARCHAR(25) NOT NULL,
        direccion VARCHAR(30),
        fono INT,
        email VARCHAR(30),
        id_TipoUsuario INT NOT NULL,
        PRIMARY KEY (rut)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE
    tipo_usuario
    (
        idTUsuario INT NOT NULL,
        tipoNombre VARCHAR(25) NOT NULL,
        PRIMARY KEY (idTUsuario)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE
    libro
    (
        codigoRegistro INT NOT NULL,
        tituloLibro VARCHAR(25) NOT NULL,
        isbn VARCHAR(25) NOT NULL,
        autor VARCHAR(15) NOT NULL,
        editorial VARCHAR(25) NOT NULL,
        descripcion mediumtext NOT NULL,
        idArea INT NOT NULL,
        PRIMARY KEY (codigoRegistro)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE
    cuenta
    (
        idCuenta INT NOT NULL,
        rutUsuario VARCHAR(9) NOT NULL,
        clave VARCHAR(25) NOT NULL,
        PRIMARY KEY (idCuenta)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE
    area
    (
        id_area INT NOT NULL,
        nombreArea VARCHAR(30) NOT NULL,
        PRIMARY KEY (id_area)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE
    cuenta_libro
    (
        idCuenta INT NOT NULL,
        codigoRegistroLibro INT NOT NULL,
        fechaPrestamo DATE NOT NULL,
        estado TINYINT(1) NOT NULL,
        PRIMARY KEY (idCuenta, codigoRegistroLibro)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;