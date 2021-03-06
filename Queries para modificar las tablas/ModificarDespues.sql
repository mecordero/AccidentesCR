﻿UPDATE Canton
   SET Canton.id_provincia = Provincia.id_provincia,
	   Canton.nombre = substring(Canton.nombre,1,len(Canton.nombre)-5) 
   FROM Canton  INNER JOIN  Provincia ON Canton.nombre_provincia = Provincia.nombre
   
ALTER TABLE Canton
DROP COLUMN nombre_provincia          

ALTER TABLE CANTON
ALTER COLUMN id_provincia int NOT NULL            
       


UPDATE Distrito
	SET Distrito.nombre = substring(Distrito.nombre,1,len(Distrito.nombre)-5) ,
	    Distrito.nombre_canton = substring(Distrito.nombre_canton,1, len(Distrito.nombre_canton)-5)
	
INSERT INTO Distrito VALUES	(NULL, 'CALDERA','09°56′36"', '-84°43′00"', 'ESPARZA'),
							(NULL, 'LA COLONIA','10°12′58"', '-83°47′33"', 'POCOCÍ'),
							(NULL, 'CANALETE','10.8357638', '-85.0489967', 'UPALA'),
							(NULL, 'LABRADOR','9.9434674', '-84.635786', 'SAN MATEO'),
							(NULL, 'ESCOBAL','9.9438247', '-84.4594581', 'ATENAS'),
							(NULL, 'LA ISABEL','9.9277189', '-83.6952431', 'TURRIALBA'),
							(NULL, 'CHIRRIPO','9.81667', '-83.4167', 'TURRIALBA'),
							(NULL, 'BAHIA DRAKE','8.7109841', '-83.6800827', 'OSA')

UPDATE Distrito
	SET Distrito.id_canton = Canton.id_canton		
	FROM Distrito INNER JOIN Canton ON Distrito.nombre_canton = Canton.nombre


ALTER TABLE Distrito
DROP COLUMN nombre_canton

ALTER TABLE Distrito
ALTER COLUMN id_canton int NOT NULL

UPDATE Afectado
	SET Afectado.id_mes = Mes.id_mes
	FROM Afectado INNER JOIN Mes ON Afectado.nombre_mes = Mes.nombre

ALTER TABLE Afectado
DROP COLUMN nombre_mes

UPDATE Afectado
	SET Afectado.id_dia = Dia.id_día
	FROM Afectado INNER JOIN Dia ON Afectado.nombre_dia = Dia.nombre

ALTER TABLE Afectado
DROP COLUMN nombre_dia

UPDATE Afectado 
	SET Afectado.id_provincia = Provincia.id_provincia
	FROM Afectado INNER JOIN Provincia ON RTRIM(UPPER(Afectado.nombre_provincia)) = RTRIM(Provincia.nombre)

ALTER TABLE Afectado
DROP COLUMN nombre_provincia

UPDATE Afectado 
	SET Afectado.id_canton = Canton.id_canton
	FROM Afectado INNER JOIN Canton ON RTRIM(UPPER(Afectado.nombre_canton)) = RTRIM(Canton.nombre)

ALTER TABLE Afectado
DROP COLUMN nombre_canton

UPDATE DISTRITO 
	SET nombre = 'SAN ISIDRO DEL GENERAL'
	where nombre = 'SAN ISIDRO DE EL GENERAL'

UPDATE DISTRITO 
	SET nombre = 'LA GRANJA'
	where nombre = 'GRANJA'

UPDATE DISTRITO 
	SET nombre = 'EL CAIRO'
	where nombre = 'CAIRO'

UPDATE DISTRITO 
	SET nombre = 'LA GARITA'
	where nombre = 'GARITA'

UPDATE DISTRITO 
	SET nombre = 'LA TIGRA'
	where nombre = 'TIGRA'

UPDATE DISTRITO 
	SET nombre = 'LA FORTUNA'
	where nombre = 'FORTUNA'

UPDATE DISTRITO 
	SET nombre = 'LA PALMERA'
	where nombre = 'PALMERA'

UPDATE DISTRITO 
	SET nombre = 'EL TEJAR'
	where nombre = 'TEJAR'

UPDATE DISTRITO 
	SET nombre = 'LA TRINIDAD'
	where nombre = 'TRINIDAD'

UPDATE DISTRITO 
	SET nombre = 'LA CRUZ'
	where nombre = 'LA'

UPDATE DISTRITO 
	SET nombre = 'LAS JUNTAS'
	where nombre = 'JUNTAS'

UPDATE DISTRITO 
	SET nombre = 'EL GENERAL'
	where nombre = 'GENERAL'

UPDATE DISTRITO 
	SET nombre = 'PALMITOS'
	where nombre = 'PALMITO'

UPDATE DISTRITO 
	SET nombre = 'LA LEGUA'
	where nombre = 'LEGUA'

UPDATE DISTRITO 
	SET nombre = 'BUENA VISTA'
	where nombre = 'BUENAVISTA'

UPDATE DISTRITO 
	SET nombre = 'LA UNIÓN'
	where nombre = 'UNIÓN'

UPDATE Afectado
	SET nombre_distrito = 'San Francisco de Dos Ríos'
	where nombre_distrito = 'San Fco. de Dos Ríos'        
	
UPDATE Afectado
	SET nombre_distrito = 'San Rafael Arriba'
	where nombre_distrito = 'S.R.Arriba'

UPDATE Afectado
	SET nombre_distrito = 'San Rafael Abajo'
	where nombre_distrito = 'S.R.Abajo'      
	
UPDATE Afectado
	SET nombre_distrito = 'La Rita'
	where nombre_distrito = 'Rita'      

UPDATE Afectado
	SET nombre_distrito = 'Ángeles'
	where nombre_distrito = 'Ãngeles'  

UPDATE Afectado
	SET nombre_distrito = 'Bratsí'
	where nombre_distrito = 'Bratsí o Bri Bri' 

UPDATE Afectado
	SET nombre_distrito = 'Ribera'
	where nombre_distrito = 'La Rivera'

UPDATE Afectado
	SET nombre_distrito = 'San José de la Montaña'
	where nombre_distrito = 'S.J. de la Montaña' 

UPDATE Afectado
	SET nombre_distrito = 'Monteverde'
	where nombre_distrito = 'Monte Verde'
	
UPDATE Afectado
	SET nombre_distrito = 'Duacarí'
	where nombre_distrito = 'Daucarí'  

UPDATE Afectado
	SET nombre_distrito = 'Buena Vista'
	where nombre_distrito = 'Buenavista' 

UPDATE Afectado 
	SET Afectado.id_distrito = Distrito.id_distrito
	FROM Afectado INNER JOIN Distrito ON RTRIM(UPPER(Afectado.nombre_distrito)) COLLATE SQL_LATIN1_GENERAL_CP1_CI_AI = 
	RTRIM(Distrito.nombre)  COLLATE SQL_LATIN1_GENERAL_CP1_CI_AI

ALTER TABLE Afectado
DROP COLUMN nombre_distrito
