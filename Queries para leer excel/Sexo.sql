SELECT (cod_sexo + 1) as id_sexo, Sexo as nombre FROM [acc$]
GROUP BY cod_sexo, Sexo
HAVING cod_sexo IS NOT NULL
