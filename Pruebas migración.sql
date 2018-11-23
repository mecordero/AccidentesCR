--Pruebas de migración correcta del excel

--TODO
select count(*) as "Numero de afectados"
from Afectado

--PROVINCIA
select p.nombre as "Provincia", count(*) as "Numero de afectados"
from Afectado a
inner join Provincia p on p.id_provincia = a.id_provincia
group by p.nombre

--DIA
select d.nombre as "Día", count(*) as "Numero de afectados"
from Afectado a
inner join Dia d on d.id_día = a.id_dia
group by d.nombre

--MES
select m.nombre as "Mes", count(*) as "Numero de afectados"
from Afectado a
inner join Mes m on m.id_mes = a.id_mes
group by m.nombre

--AÑO
select a.anho as "Año", count(*) as "Numero de afectados"
from Afectado a
group by a.anho

--ROL
select r.nombre as "Rol", count(*) as "Numero de afectados"
from Afectado a
inner join Rol r on r.id_rol = a.id_rol
group by r.nombre

--LESION
select l.nombre as "Lesion", count(*) as "Numero de afectados"
from Afectado a
inner join Lesion l on l.id_lesion = a.id_lesion
group by l.nombre

--SEXO
select s.nombre as "Sexo", count(*) as "Numero de afectados"
from Afectado a
inner join Sexo s on s.id_sexo = a.id_sexo
group by s.nombre
