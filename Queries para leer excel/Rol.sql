SELECT [Codigo de Rol] as id_rol, Rol as nombre FROM [acc$]
GROUP BY [Codigo de Rol], Rol
HAVING [Codigo de Rol] IS NOT NULL
