-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE ConsultaDinamica
	-- Add the parameters for the stored procedure here
	@Provincia nchar(20), 
	@Canton nchar(40),
	@Distrito nchar(40),
	@Dia nchar(20),
	@Mes nchar(20),
	@Anho int,
	@Rol nchar(40),
	@Lesion nchar(30),
	@Edad_Quinquenal nchar(30),
	@Sexo nchar(20),
	@Count int OUTPUT

AS
BEGIN
	SET NOCOUNT ON;

    SELECT @Count =  count(*)
	FROM Afectado a
	INNER JOIN Provincia p on a.id_provincia = p.id_provincia
	INNER JOIN Canton c on a.id_canton = c.id_canton
	INNER JOIN Distrito di on a.id_distrito =di.id_distrito
	INNER JOIN Dia d on a.id_dia = d.id_día
	INNER JOIN Mes m on a.id_mes = m.id_mes
	INNER JOIN Rol r on a.id_rol = r.id_rol
	INNER JOIN Lesion l on a.id_lesion = l.id_lesion
	INNER JOIN Sexo s on a.id_sexo = s.id_sexo
	WHERE p.nombre = ISNULL(@Provincia, p.nombre)
	  and c.nombre = ISNULL(@Canton, c.nombre)
	  and di.nombre = ISNULL(@Distrito, di.nombre)
	  and d.nombre = ISNULL(@Dia, d.nombre)
	  and m.nombre = ISNULL(@Mes, m.nombre)
	  and a.anho = ISNULL(@Anho, a.anho)
	  and r.nombre = ISNULL(@Rol, r.nombre)
	  and l.nombre = ISNULL(@Lesion, l.nombre)
	  and a.edad_quinquenal = ISNULL(@Edad_Quinquenal, a.edad_quinquenal)
	  and s.nombre = ISNULL(@Sexo, s.nombre)

	  RETURN

END
GO
