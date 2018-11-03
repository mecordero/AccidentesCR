SELECT [Codigo de Lesion] as id_lesion, [Tipo de Lesion] as nombre FROM [acc$]
GROUP BY [Codigo de Lesion], [Tipo de Lesion]
HAVING [Codigo de Lesion] IS NOT NULL
