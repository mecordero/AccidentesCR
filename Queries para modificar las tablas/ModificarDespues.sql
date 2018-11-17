UPDATE Canton
   SET Canton.id_provincia = Provincia.id_provincia,
	   Canton.nombre = substring(Canton.nombre,1,len(Canton.nombre)-5) 
   FROM Canton  INNER JOIN  Provincia ON Canton.nombre_provincia = Provincia.nombre
   
ALTER TABLE Canton
DROP COLUMN nombre_provincia          

ALTER TABLE CANTON
ALTER COLUMN id_provincia int NOT NULL            
       

UPDATE Distrito
	SET Distrito.id_canton = Canton.id_canton,
		Distrito.nombre = substring(Distrito.nombre,1,len(Distrito.nombre)-5) 
	FROM Distrito INNER JOIN Canton ON substring(Distrito.nombre_canton,1,len(Distrito.nombre_canton)-5) = Canton.nombre

ALTER TABLE Distrito
DROP COLUMN nombre_canton

ALTER TABLE Distrito
ALTER COLUMN id_canton int NOT NULL



SELECT a.id_afectado, a.nombre_provincia, p.id_provincia, a.nombre_canton,c.id_canton, a.nombre_distrito, d.nombre
FROM Afectado a
LEFT JOIN Provincia p ON RTRIM(UPPER(a.nombre_provincia)) = RTRIM(p.nombre)
LEFT JOIN Canton c ON RTRIM(UPPER(a.nombre_canton)) LIKE RTRIM(c.nombre)
LEFT JOIN Distrito d on RTRIM(UPPER(a.nombre_distrito)) LIKE RTRIM(d.nombre
WHERE d.nombre IS NULL


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
	SET nombre = 'LA UNI�N'
	where nombre = 'UNI�N'

UPDATE Afectado
	SET nombre_distrito = 'San Francisco de Dos R�os'
	where nombre_distrito = 'San Fco. de Dos R�os'        
	
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
	SET nombre_distrito = '�ngeles'
	where nombre_distrito = 'Ángeles'  

UPDATE Afectado
	SET nombre_distrito = 'Brats�'
	where nombre_distrito = 'Brats� o Bri Bri' 

UPDATE Afectado
	SET nombre_distrito = 'Ribera'
	where nombre_distrito = 'La Rivera'

UPDATE Afectado
	SET nombre_distrito = 'San Jos� de la Monta�a'
	where nombre_distrito = 'S.J. de la Monta�a' 

UPDATE Afectado
	SET nombre_distrito = 'Monteverde'
	where nombre_distrito = 'Monte Verde'
	
UPDATE Afectado
	SET nombre_distrito = 'Duacar�'
	where nombre_distrito = 'Daucar�'  

UPDATE Afectado
	SET nombre_distrito = 'Buena Vista'
	where nombre_distrito = 'Buenavista' 

SELECT *
FROM Afectado a
LEFT JOIN Distrito d ON UPPER(d.nombre) COLLATE SQL_LATIN1_GENERAL_CP1_CI_AI = a.nombre_distrito COLLATE SQL_LATIN1_GENERAL_CP1_CI_AI
WHERE a.nombre_distrito <> 'Caldera'
and a.nombre_distrito <> 'La Colonia'
and a.nombre_distrito <> 'Canalete'
and a.nombre_distrito <> 'Labrador'
and a.nombre_distrito <> 'Escobal'
and a.nombre_distrito <> 'La Isabel'
and a.nombre_distrito <> 'Chirrip�'
and a.nombre_distrito <> 'Bah�a Drake'
GROUP BY a.id_afectado

SELECT * FROM Afectado where nombre_distrito like 'LA%'

SELECT * FROM Distrito d
WHERE RTRIM(d.nombre) LIKE 'AGUACALIENTE'

delete from Distrito