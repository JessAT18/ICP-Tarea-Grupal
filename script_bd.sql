CREATE DATABASE appjessicadb;

USE appjessicadb;

CREATE TABLE petbl_Clientes (
	id 				INT AUTO_INCREMENT,
    cliente_nm		VARCHAR(50) NOT NULL,
    cliente_app		VARCHAR(50) NOT NULL,
	cliente_apm 	VARCHAR(60) NOT NULL,
    direccion_desc	VARCHAR(120),
    telefono_desc  	VARCHAR(50),
    fch_nacimiento	DATE,
    estado_fl		INT NOT NULL,
    
    PRIMARY KEY (id)
);

#DROP DATABASE appjessicadb;

INSERT INTO petbl_Clientes (cliente_nm, cliente_app, cliente_apm, direccion_desc, telefono_desc, fch_nacimiento, estado_fl)
VALUES
    ("Jessica", "Aquino", "Torrez", "C. Chaco #12", "77306454", "1999-12-18", 1),
    ("Mariana", "Arnez", "Andia", "Calle #26", "75049821", "1999-02-05" ,1)
    ;

SELECT * FROM petbl_Clientes;

CREATE TABLE patbl_ECiviles (
	ecivil_id  		INT AUTO_INCREMENT,
    ecivil_desc 	VARCHAR(50) NOT NULL,
    estado_fl		SMALLINT NOT NULL,
    
    PRIMARY KEY (ecivil_id)
);

INSERT INTO patbl_ECiviles(ecivil_desc, estado_fl)
VALUES
	("Soltero/a", 0),
    ("Casado/a", 1)
	;

SELECT * FROM patbl_ECiviles;