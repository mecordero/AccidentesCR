SELECT NULL as id_provincia, NULL as id_canton, NULL as id_distrito, NULL as id_dia, NULL as id_mes, Anho as anho, [Codigo de Rol] as id_rol, [Codigo de Lesion] as id_lesion,Edad as edad, Edadquinquenal as edad_quinquenal, cod_sexo + 1 as id_sexo, Provincia as nombre_provincia, Canton as nombre_canton, Distrito as nombre_distrito, Dia as nombre_dia, Mes as nombre_mes
FROM [acc$]
WHERE [acc$].[Numero Registro] IS NOT NULL 
