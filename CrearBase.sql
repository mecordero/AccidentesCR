USE [master]
GO

/****** Object:  Database [BD_AccidentesCR]    Script Date: 10/29/2018 11:41:50 AM ******/
CREATE DATABASE [BD_AccidentesCR]
GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Sexo]    Script Date: 10/29/2018 11:43:18 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Sexo](
	[id_sexo] [int] NOT NULL,
	[nombre] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Sexo] PRIMARY KEY CLUSTERED 
(
	[id_sexo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Rol]    Script Date: 10/29/2018 11:43:32 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Rol](
	[id_rol] [int] NOT NULL,
	[nombre] [nchar](40) NOT NULL,
 CONSTRAINT [PK_Rol] PRIMARY KEY CLUSTERED 
(
	[id_rol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Provincia]    Script Date: 10/29/2018 11:43:46 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Provincia](
	[id_provincia] [int] NOT NULL IDENTITY(1,1),
	[nombre] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Provincia] PRIMARY KEY CLUSTERED 
(
	[id_provincia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Mes]    Script Date: 10/29/2018 11:43:56 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Mes](
	[id_mes] [int] NOT NULL IDENTITY(1,1),
	[nombre] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Mes] PRIMARY KEY CLUSTERED 
(
	[id_mes] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Lesion]    Script Date: 10/29/2018 11:44:05 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Lesion](
	[id_lesion] [int] NOT NULL,
	[nombre] [nchar](30) NOT NULL,
 CONSTRAINT [PK_Lesion] PRIMARY KEY CLUSTERED 
(
	[id_lesion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Dia]    Script Date: 10/29/2018 11:44:23 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Dia](
	[id_día] [int] NOT NULL IDENTITY(1,1),
	[nombre] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Dia] PRIMARY KEY CLUSTERED 
(
	[id_día] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Canton]    Script Date: 10/29/2018 11:44:39 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Canton](
	[id_canton] [int] NOT NULL IDENTITY(1,1),
	[id_provincia] [int] NOT NULL,
	[nombre] [nchar](40) NOT NULL,
 CONSTRAINT [PK_Canton] PRIMARY KEY CLUSTERED 
(
	[id_canton] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Canton]  WITH CHECK ADD  CONSTRAINT [FK_Canton_Provincia] FOREIGN KEY([id_provincia])
REFERENCES [dbo].[Provincia] ([id_provincia])
GO

ALTER TABLE [dbo].[Canton] CHECK CONSTRAINT [FK_Canton_Provincia]
GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Distrito]    Script Date: 10/29/2018 11:44:13 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Distrito](
	[id_distrito] [int] NOT NULL IDENTITY(1,1),
	[id_canton] [int] NOT NULL,
	[nombre] [nchar](40) NOT NULL,
	[latitud] [nchar](15) NOT NULL,
	[longitud] [nchar](15) NOT NULL,
 CONSTRAINT [PK_Distrito] PRIMARY KEY CLUSTERED 
(
	[id_distrito] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Distrito]  WITH CHECK ADD  CONSTRAINT [FK_Distrito_Canton] FOREIGN KEY([id_canton])
REFERENCES [dbo].[Canton] ([id_canton])
GO

ALTER TABLE [dbo].[Distrito] CHECK CONSTRAINT [FK_Distrito_Canton]
GO

USE [BD_AccidentesCR]
GO

/****** Object:  Table [dbo].[Afectado]    Script Date: 10/29/2018 11:45:39 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Afectado](
	[id_afectado] [int] NOT NULL IDENTITY(1,1),
	[id_provincia] [int] NOT NULL,
	[id_canton] [int] NOT NULL,
	[id_distrito] [int] NOT NULL,
	[id_dia] [int] NOT NULL,
	[id_mes] [int] NOT NULL,
	[anho] [int] NOT NULL,
	[id_rol] [int] NOT NULL,
	[id_lesion] [int] NOT NULL,
	[edad] [int] NOT NULL,
	[edad_quinquenal] [nchar](30) NOT NULL,
	[id_sexo] [int] NOT NULL,
 CONSTRAINT [PK_Afectado] PRIMARY KEY CLUSTERED 
(
	[id_afectado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Canton] FOREIGN KEY([id_canton])
REFERENCES [dbo].[Canton] ([id_canton])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Canton]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Dia] FOREIGN KEY([id_dia])
REFERENCES [dbo].[Dia] ([id_día])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Dia]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Distrito] FOREIGN KEY([id_distrito])
REFERENCES [dbo].[Distrito] ([id_distrito])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Distrito]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Lesion] FOREIGN KEY([id_lesion])
REFERENCES [dbo].[Lesion] ([id_lesion])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Lesion]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Mes] FOREIGN KEY([id_mes])
REFERENCES [dbo].[Mes] ([id_mes])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Mes]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Provincia] FOREIGN KEY([id_provincia])
REFERENCES [dbo].[Provincia] ([id_provincia])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Provincia]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Rol] FOREIGN KEY([id_rol])
REFERENCES [dbo].[Rol] ([id_rol])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Rol]
GO

ALTER TABLE [dbo].[Afectado]  WITH CHECK ADD  CONSTRAINT [FK_Afectado_Sexo] FOREIGN KEY([id_sexo])
REFERENCES [dbo].[Sexo] ([id_sexo])
GO

ALTER TABLE [dbo].[Afectado] CHECK CONSTRAINT [FK_Afectado_Sexo]
GO





