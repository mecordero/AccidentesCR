SELECT Provincia as nombre FROM [Lugares$]
GROUP BY Provincia
HAVING Provincia IS NOT NULL
