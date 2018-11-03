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



SELECT * FROM Distrito d
WHERE RTRIM(d.nombre) LIKE 'AGUACALIENTE o SAN FRANCISCO'

delete from Distrito