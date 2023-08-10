GRANT ALL PRIVILEGES ON Estadias2DD.* TO root@'%' IDENTIFIED BY '';
FLUSH PRIVILEGES;
create database Estadias2DD
use Estadias2DD

--- TABLA UNIVERSIDADES ---
create table Universidades(
    clave varchar(5) primary key,
    nombre varchar(70) unique not null,
    dirColonia varchar(30) not null,
    dirCalle varchar(30) not null,
    dirNumero varchar(15) not null,
    CP varchar(5) not null,
    correoElect varchar(50) not null,
    telefono char(15) not null
)

--- TABLA CARRERAS ---
create table Carreras(
    clave varchar(5) primary key,
    nombre varchar(150) not null
)

--- TABLA PROYECTOS ---
create table Proyectos (
    codigo varchar(5) primary key,
    nombre varchar(30) unique not null,
    descripcion varchar(1000) not null
)

--- TABLA ASESORES ---
create table Asesores (
    numero int primary key auto_increment,
    nombre varchar(30) not null,
    apPaterno varchar(30),
    apMaterno varchar(30),
    correoElect varchar(50) not null,
    numTel char(15) not null
)

--- TABLA UNI_CARRERAS ---
create table UNI_CARRERAS (
  Universidad varchar(5) not null,
  Carrera varchar(5) not null,
  primary key (Universidad, Carrera),
  foreign key (Universidad) references Universidades(clave),
  foreign key (Carrera) references Carreras(clave)
)

--- TABLA ALUMNOS ---
create table Alumnos(
    matricula char(10) primary key,
    nombre varchar(30) not null,
    apPaterno varchar(30),
    apMaterno varchar(30),
    correoElect varchar(50) not null,
    numTel char(15) not null,
    Universidad varchar(5),
    Carrera varchar(5),
    foreign key(Universidad) references Universidades(clave),
    foreign key(Carrera) references Carreras(clave)
)

--- TABLA ESTADIAS ---
create table Estadias(
    codigo varchar(5) primary key,
    fechaInicio date,
    fechaFin date,
    Proyecto varchar(5),
    Alumno char(10) not null,
    Asesor int,
    foreign key(Proyecto) references Proyectos(codigo),
    foreign key(Alumno) references Alumnos(matricula),
    foreign key(Asesor) references Asesores(numero)
)

--- TABLA PAGOS ---
create table Pagos(
    numero int primary key,
    fechaPago date,
    cantidad float not null,
    concepto varchar(20) not null,
    Estadia varchar(5),
    foreign key(Estadia) references Estadias(codigo)
)

--REGISTROS UNIVERSIDADES--
INSERT INTO universidades (clave, nombre, dirColonia, dirCalle, dirNumero, CP, correoElect, telefono)
VALUES
('UDC', 'Universidad de las Californias', 'Fracc. Los Españoles', 'Blvd. Federico Benítez', 460, 22430, 'udc@udc.com.mx', '(664) 622-65-20'),
('UNIDEP', 'Universidad del Desarrollo Profesional Plantel Tijuana 1', 'Col. Bentón', 'Blvd. Gustavo Díaz Ordaz', 15260, 21115, 'keiko.nishikawa@tij.unidep.edu.mx', '(664) 876-45-42'),
('UTT', 'Universidad Tecnológica de Tijuana', 'Fracc. El Refugio Quintas Campestre', 'Carr. Libre Tijuana-Tecate', 10, 22253, 'informes@uttijuana.edu.mx', '(664) 969-47-00'),
('CESN', 'Centro de Estudios Superiores del Noroeste', 'Fracc. El Lago', 'Blvd. Cucapah Sur', 20100, 20100, 'info@cesunbc.edu.mx', '(664) 903-41-15'),
('ITT', 'Instituto Tecnológico de Tijuana', 'Fracc. Tomás Aquino', 'Calz. Tecnológico', '12950', 22414, 'actualización.docenteda@tectijuana.edu.mx', '(664) 607-84-00'),
('UABC', 'Universidad Autónoma de Baja California, Campus Tijuana', 'Col. Parque Industrial', 'Calz. Universidad', 14418, 22427, 'dit.desarrollo.soporte@uabc.edu.mx', '(664) 979-75-00'),
('UNID', 'Universidad Interamericana para el Desarrollo Sede Tijuana', 'Col. Parque Industrial Internacional, Mesa de Otay', 'Rampa Aeropuerto', 16002, 22424, 'tijuana@unid.mx', '(664) 608-77-77'),
('UNIAT', 'University of Advanced Technologies Tijuana', 'Fracc. El Paraíso', 'Blvd. Díaz Ordaz', 12415, 22106, 'informes.tijuana@uniat.edu.mx', '(664) 567-03-94'),
('TBC', 'Tecnológico de Baja California, Campus Tijuana', 'Col. Libramiento', 'Blvd. Insurgentes', 18235, 22225, 'contacto@tbc.mx', '(664) 621-71-11'),
('CUT', 'Universidad de Tijuana Campus Tijuana', 'Col. Altamira', 'Av. J. Lucrecia Torriz', 1010, 22120, 'administracioncut@udetijuana.edu.mx', '(664) 687-94-54'),
('CETYS', 'Centro de Enseñanza Técnica y Superior Campus Tijuana', 'Fracc. El Lago', 'Av. Cetys Universidad', 4, 22210, 'infocetystij@cetys.mx', '(664) 903-18-00');


--Fueron correcciones del registro con clave 1345--
update universidades 
set correoElect = 'difusion@tectijuana.edu.mx'
where clave = 'ITT';

update universidades
set dirNumero = '12950'
where clave = 'ITT';
select * from universidades

--ELIMINACIÖN DE REGISTRO--
delete from universidades
where clave = '1296';

delete from universidades
where clave = '1194';

delete from universidades
where clave = '115';

--REGISTROS CARRERAS--

INSERT INTO carreras (clave, nombre) VALUES
('DGE', 'Diseño gráfico y electrónico'),
('TSI', 'Tecnologías de sistemas inteligentes'),
('ICT', 'Ingeniería en ciberseguridad y telecomunicaciones'),
('IDSA', 'Ingeniería en desarrollo de software y aplicaciones'),
('LND', 'Licenciatura en negocios digitales'),
('LMDD', 'Licenciatura en marketing y diseño digital'),
('IDGS', 'Ingeniería en desarrollo y gestion de software'),
('IEVND', 'Ingenieria en entornos virtuales y negocios digitales'),
('IRIC', 'ingenieria en redes inteligentes y ciberseguridad'),
('IM', 'Ingeniería en multimedia'),
('IDS', 'Ingeniería en desarrollo de software'),
('II', 'Ingeniería en informática'),
('ISC', 'Ingeniería en sistemas computacionales'),
('ITICS', 'Ingeniería en tecnologías de la información y comunicación'),
('IC', 'Ingeniería en computación'),
('ISTE', 'Ingeniería en software y tecnologías emergentes'),
('IDG', 'Ingeniería en diseño gráfico'),
('LSC', 'Licenciado en sistemas computacionales'),
('ISSC', 'Ingeniería de software y sistemas computacionales'),
('LCAD', 'Licenciatura en cine y animación digital'),
('LNIA', 'Licenciatura en negocios en inteligencia artificial'),
('IPV', 'Ingeniería en programación de videojuegos'),
('LA3D', 'Licenciatura en arquitectura 3D'),
('LMD', 'Licenciatura en marketing digital'),
('IDST', 'Ingeniería en desarrollo de software'),
('INTA', 'Ingeniería en negocios de tecnologías avanzadas'),
('IDSF', 'Ingeniería en desarrollo de software'),
('ITIC', 'Ingeniería en tecnologías de la información y comunicación'),
('DG', 'Diseño gráfico'),
('ICC', 'Ingeniería en ciencias computacionales'),
('IDGD', 'Ingeniería en diseño gráfico digital'),
('IS', 'Ingeniería en software');

update carreras
set clave = 'II'
where clave = 'IIF';

-- REGISTROS PROYECTOS --
INSERT INTO proyectos (codigo, nombre, descripcion) VALUES
('A598', 'Clínica veterinaria', 'Este proyecto se refiere al desarrollo de una aplicación o sistema de gestión para una clínica veterinaria. El objetivo es optimizar el proceso de agendamiento de citas y seguimiento a pacientes. Esto puede incluir funcionalidades como registro de pacientes y mascotas, programación de citas, historial médico, entre otros.'),
('A798', 'Sistema de gestión de biblioteca', 'Este proyecto implica el desarrollo de un sistema informático para gestionar las operaciones de una biblioteca. El sistema puede incluir funciones como registro y búsqueda de libros, préstamos y devoluciones, gestión de usuarios, generación de informes, entre otros. El objetivo es facilitar la administración y el acceso a los recursos de la biblioteca.'),
('A1053', 'Plataforma de aprendizaje en línea', 'Este proyecto se trata de crear una plataforma digital para el aprendizaje en línea. La plataforma puede ofrecer cursos, materiales educativos, evaluaciones y herramientas de interacción entre estudiantes y profesores. El objetivo es brindar una experiencia de aprendizaje flexible y accesible a través de internet.'),
('A104', 'Aplicación de seguimiento de tareas', 'Este proyecto consiste en desarrollar una aplicación que permita realizar un seguimiento y gestión eficiente de las tareas. Puede incluir funciones como creación de tareas, asignación de responsables, establecimiento de fechas límite, seguimiento del progreso y generación de informes. El objetivo es facilitar la organización y el seguimiento de las actividades en un entorno de trabajo o proyecto.');

-- REGISTROS ASESORES --

INSERT INTO Asesores (numero, nombre, apPaterno, apMaterno, correoElect, numTel) VALUES
(10, 'Ivan Alonso', 'Lopez', 'Sanchez', 'ivan.a.lopez.sanchez@gmail.com', '(664) 265-65-98'),
(20, 'Clara', 'Lidia', 'Uyeda', 'clara.uyeda@uttijuana.edu.mx', '(644) 248-85-96'),
(30, 'Humberto', 'Vejar', 'Polanco', 'humberto.vejar@uttijuana.edu.mx', '(663) 157-62-51'),
(40, 'Cleotilde', 'Tenorio', 'Hernández', 'cleotilde.tenorio@uttijuana.edu.mx', '(663) 123-63-41');

-- REGISTROS UNI_CARRERAS --

INSERT INTO uni_carreras (universidad, carrera) VALUES
('UDC', 'DGE'),
('UDC', 'TSI'),
('UNIDEP', 'ICT'),
('UNIDEP', 'IDSA'),
('UNIDEP', 'LND'),
('UNIDEP', 'LMDD'),
('UTT', 'IDGS'),
('UTT', 'IEVND'),
('UTT', 'IRIC'),
('CESN', 'IM'),
('CESN', 'IDS'),
('ITT', 'II'),
('ITT', 'ISC'),
('ITT', 'ITICS'),
('UABC', 'IC'),
('UABC', 'ISTE'),
('UABC', 'IDG'),
('UABC', 'LSC'),
('UNID', 'ISSC'),
('UNIAT', 'LCAD'),
('UNIAT', 'LNIA'),
('UNIAT', 'IPV'),
('UNIAT', 'LA3D'),
('UNIAT', 'LMD'),
('UNIAT', 'IDST'),
('UNIAT', 'INTA'),
('TBC', 'IDSF'),
('CUT', 'ITIC'),
('CUT', 'DG'),
('CETYS', 'ICC'),
('CETYS', 'IDGD'),
('CETYS', 'IS');

-- REGISTROS ALUMNOS --
INSERT INTO alumnos (matricula, nombre, ApPaterno, ApMaterno, correoElect, numTel, Universidad, Carrera)
VALUES
('0322103696', 'Sebastian', 'Corbala', 'Lizarraga', '322103696@ut-tijuana.edu.mx', '6645865824', 'UTT', 'IDGS'),
('0320130344', 'Angel Esteban', 'Rojas', 'Villalobos', '0320130344@ut-tijuana.edu.mx', '6641234235', 'UTT', 'IRIC'),
('0423243239', 'Leonela', 'Navarro', 'Gonzales', '0423243239@uabc.edu.mx', '6647864567', 'UABC', 'IC'),
('0322103829', 'Jesus Guadalupe', 'Talla', 'Lerma', '0322103829@ut-tijuana.edu.mx', '6647899069', 'UTT', 'IDGS'),
('0322103778', 'Jesus Esteban', 'Olmos', 'Labastida', '0322103778@ut-tijuana.edu.mx', '6641261566', 'UTT', 'IDGS'),
('0234768964', 'Kevin', 'Ojeda', 'Torres', '0234768964@cetys.edu.mx', '6643425432', 'CETYS', 'IDGD'),
('0987452132', 'Daniela', 'Ackerman', 'Valenzuela', '0987452132@uabc.edu.mx', '6643542312', 'UABC', 'ISTE'),
('0967543422', 'Miguel', 'Camarena', 'Mendez', '0967543422@ut-tijuana.edu.mx', '6641234567', 'UTT', 'IEVND'),
('0378654324', 'Leslie', 'Camacho', 'Villalobos', '0378654324@uabc.edu.mx', '6647865342', 'UABC', 'ISTE'),
('0789654344', 'Fabrizio', 'Morales', 'Gasca', '0789654344@uabc.edu.mx', '6645309988', 'UABC', 'ISTE'),
('0977665544', 'Rodrigo', 'Sanchez', 'Virrelles', '0977665544@ut-tijuana.edu.mx', '6659098654', 'UTT', 'IRIC'),
('0322103121', 'Erick', 'Bonilla', 'Soriano', '0322103121@ut-tijuana.edu.mx', '6647865656', 'UTT', 'IEVND'),
('0322103339', 'Flores Rincon', 'Russel', 'Yissel', '0322103339@ut-tijuana.edu.mx', '6648886655', 'UTT', 'IDGS'),
('0787788889', 'Frida', 'Flores', 'Serrano', '0787788889@cetys.edu.mx', '6647855444', 'CETYS', 'IS'),
('0656677893', 'Luis', 'Gomez', 'Xochitl', '0656677893@cetys.edu.mx', '6649876543', 'CETYS', 'IS'),
('0877666666', 'Joselin', 'Cordoba', 'Escobar', '0877666666@cetys.edu.mx', '6643454342', 'CETYS', 'IS');

delete from alumnos;


-- REGISTROS ESTADIAS --
INSERT INTO estadias (codigo, fechaInicio, fechaFin, proyecto, alumno, asesor)
VALUES
('A12', '2023-07-07', '2023-07-20', 'A598', '0322103696', 10),
('A15', '2023-07-07', '2023-07-20', 'A598', '0320130344', 10),
('A18', '2023-07-07', '2023-07-20', 'A598', '0322103829', 10),
('A21', '2023-07-07', '2023-07-20', 'A598', '0322103778', 10),
('A24', '2023-05-06', '2023-05-25', 'A798', '0967543422', 20),
('A27', '2023-05-06', '2023-05-25', 'A798', '0977665544', 20),
('A30', '2023-05-06', '2023-05-25', 'A798', '0322103121', 20),
('A33', '2023-05-06', '2023-05-25', 'A798', '0322103339', 20),
('A36', '2023-01-16', '2023-01-28', 'A1053', '0234768964', 30),
('A39', '2023-01-16', '2023-01-28', 'A1053', '0787788889', 30),
('A42', '2023-01-16', '2023-01-28', 'A1053', '0656677893', 30),
('A45', '2023-01-16', '2023-01-28', 'A1053', '0877666666', 30),
('A48', '2023-02-24', '2023-03-25', 'A104', '0423243239', 40),
('A51', '2023-02-24', '2023-03-25', 'A104', '0987452132', 40),
('A54', '2023-02-24', '2023-03-25', 'A104', '0378654324', 40),
('A57', '2023-02-24', '2023-03-25', 'A104', '0789654344', 40);

-- REGISTROS PAGOS --
INSERT INTO pagos (numero, fechaPago, cantidad, concepto, estadia)
VALUES
(1, '2023-07-14', 500, 'Biaticos', 'A12'),
(2, '2023-07-20', 500, 'Salario', 'A12'),
(3, '2023-07-14', 1000, 'Biaticos', 'A15'),
(4, '2023-07-20', 1000, 'Salario', 'A15'),
(5, '2023-07-14', 900, 'Biaticos', 'A18'),
(6, '2023-07-20', 900, 'Salario', 'A18'),
(7, '2023-07-14', 600, 'Biaticos', 'A21'),
(8, '2023-07-20', 600, 'Salario', 'A21'),
(9, '2023-05-12', 700, 'Biaticos', 'A24'),
(10, '2023-05-19', 700, 'Biaticos', 'A24'),
(11, '2023-05-25', 700, 'Salario', 'A24'),
(12, '2023-05-12', 800, 'Biaticos', 'A27'),
(13, '2023-05-19', 800, 'Biaticos', 'A27'),
(14, '2023-05-25', 800, 'Salario', 'A27'),
(15, '2023-05-12', 850, 'Biaticos', 'A30'),
(16, '2023-05-19', 850, 'Biaticos', 'A30'),
(17, '2023-05-25', 850, 'Salario', 'A30'),
(18, '2023-05-12', 725, 'Biaticos', 'A33'),
(19, '2023-05-19', 725, 'Biaticos', 'A33'),
(20, '2023-05-25', 725, 'Salario', 'A33'),
(21, '2023-01-20', 325, 'Biaticos', 'A36'),
(22, '2023-01-28', 325, 'Biaticos', 'A36'),
(23, '2023-01-20', 400, 'Biaticos', 'A39'),
(24, '2023-01-28', 400, 'Biaticos', 'A39'),
(25, '2023-01-20', 600, 'Salario', 'A42'),
(26, '2023-01-28', 600, 'Salario', 'A42'),
(27, '2023-01-20', 500, 'Salario', 'A45'),
(28, '2023-01-28', 500, 'Salario', 'A45'),
(29, '2023-03-04', 650, 'Salario', 'A48'),
(30, '2023-03-11', 650, 'Salario', 'A48'),
(31, '2023-03-18', 650, 'Biaticos', 'A48'),
(32, '2023-03-25', 650, 'Biaticos', 'A48'),
(33, '2023-03-04', 940, 'Salario', 'A51'),
(34, '2023-03-11', 940, 'Salario', 'A51'),
(35, '2023-03-18', 940, 'Biaticos', 'A51'),
(36, '2023-03-25', 940, 'Biaticos', 'A51'),
(37, '2023-03-04', 630, 'Salario', 'A54'),
(38, '2023-03-11', 630, 'Salario', 'A54'),
(39, '2023-03-18', 630, 'Biaticos', 'A54'),
(40, '2023-03-25', 630, 'Biaticos', 'A54'),
(41, '2023-03-04', 1050, 'Salario', 'A57'),
(42, '2023-03-11', 1050, 'Salario', 'A57'),
(43, '2023-03-18', 1050, 'Biaticos', 'A57'),
(44, '2023-03-25', 1050, 'Biaticos', 'A57');



----CONSULTAS----

/*
1.Mostrar la información de una estadía empresarial de un alumno:
--Matricula del alumno
--Nombre del alumno, en una columna
--Nombre de la universidad donde estudia el alumno
--Nombre de la carrera del alumno
--Nombre del proyecto asignado al alumno
--Nombre del asesor, en una columna
--Fecha de inicio
--Fecha final
*/
select a.matricula as Matricula, 
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 u.nombre as "Nombre de la universidad",
 c.nombre as "Nombre de la carrera",
 p.nombre as "Nombre del proyecto asignado", 
 concat(ifnull(concat(asr.nombre,' '),' '),
   ifnull(concat(asr.apPaterno,' '),' '),
   ifnull(concat(asr.apMaterno,' '),' ')
 ) as "Nombre del asesor",
 date_format(e.fechaInicio, "%d-%m-%Y") as "Fecha Inicio",
 date_format(e.fechaFin, "%d-%m-%Y") as "Fecha Final"
 from Estadias as e
 inner join Alumnos as a on e.Alumno=a.matricula
 inner join Universidades as u on a.Universidad=u.clave
 inner join Carreras as c on a.Carrera=c.clave
 inner join Proyectos as p on e.Proyecto=p.codigo
 inner join Asesores as asr on e.Asesor=asr.numero
 where a.matricula=0322103696
 
/*
2. Pagos realizados a un alumno
--Matricula del alumno
--Nombre del alumno, en una columna
--Nombre del proyecto
--Numero del pago
--Fecha del pago
--Concepto del pago
--Monto del pago
*/

select
a.matricula as "Matricula del alumno",
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 p.nombre as "Nombre del proyecto",
 pa.numero as "Numero del pago",
 date_format(pa.fechaPago, "%d-%m-%Y") as "Fecha del pago",
 pa.concepto as "Concepto del pago",
 pa.cantidad as "Monto del pago"
 from Alumnos as a
 inner join Estadias as e on a.matricula=e.Alumno
 inner join Pagos as pa on pa.Estadia=e.codigo
 inner join Proyectos as p on p.codigo=e.Proyecto
 where a.matricula=0322103829

 /*
 3.Proyectos realizados por alumnos de la misma universidad
 --Nombre de la universidad
 --Nombre del alumno, en una columna
 --Nombre del proyecto
 --Descripción del proyecto
 --Nombre del asesor, en una columna
 --Fecha de inicio
 --Fecha final
 */

 select 
 u.nombre as "Nombre de la universidad",
 concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 p.nombre as "Nombre del proyecto",
 p.descripcion as "Descripcion del proyecto",
 concat(ifnull(concat(asr.nombre,' '),' '),
   ifnull(concat(asr.apPaterno,' '),' '),
   ifnull(concat(asr.apMaterno,' '),' ')
 ) as "Nombre del asesor",
 date_format(e.fechaInicio, "%d-%m-%Y") as "Fecha Inicio",
 date_format(e.fechaFin, "%d-%m-%Y") as "Fecha Final"
from Estadias as e
inner join Alumnos as a on e.Alumno=a.matricula
inner join Universidades as u on a.Universidad=u.clave
inner join Proyectos as p on e.Proyecto=p.codigo
inner join Asesores as asr on e.Asesor=asr.numero
where u.clave="UTT"

/*
4.Proyectos realizados por alumnos de la misma carrera
--Nombre de la carrera
--Nombre del alumno, en una columna
--Nombre de la universidad
--Nombre del proyecto
--Descripción del proyecto
--Nombre del asesor, en una columna
--Fecha de inicio
--Fecha final
*/

select 
c.nombre as "nombre de la carrera",
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 u.nombre as "Nombre de la universidad",
 p.nombre as "Nombre del proyecto",
 p.descripcion as "Descripcion del proyecto",
 concat(ifnull(concat(asr.nombre,' '),' '),
   ifnull(concat(asr.apPaterno,' '),' '),
   ifnull(concat(asr.apMaterno,' '),' ')
 ) as "Nombre del asesor",
 date_format(e.fechaInicio, "%d-%m-%Y") as "Fecha Inicio",
 date_format(e.fechaFin, "%d-%m-%Y") as "Fecha Final"
from Estadias as e
inner join Alumnos as a on e.Alumno=a.matricula
inner join Carreras as c on a.Carrera=c.clave
inner join Universidades as u on a.Universidad=u.clave
inner join Proyectos as p on e.Proyecto=p.codigo
inner join Asesores as asr on e.Asesor=asr.numero
where a.Carrera="IEVND"

/*
5.Estadías que ha asesorado un asesor
--Nombre del asesor, en una columna
--Nombre del proyecto
--Fecha de inicio 
--Fecha final
--Nombre de alumno, en una columna
--Nombre de la universidad del alumno
--Nombre de la carrera del alumno
*/

select
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del asesor",
 p.nombre as "Nombre del proyecto",
 date_format(e.fechaInicio, "%d-%m-%Y") as "Fecha Inicio",
 date_format(e.fechaFin, "%d-%m-%Y") as "Fecha Final",
concat(ifnull(concat(al.nombre,' '),' '),
   ifnull(concat(al.apPaterno,' '),' '),
   ifnull(concat(al.apMaterno,' '),' ')
 ) as "Nombre del alumno",
u.nombre as "Nombre de la universidad",
c.nombre as "Nombre de la carrera",
e.codigo as "Codigo de estadia"
from Estadias as e
inner join Asesores as a on e.Asesor = a.numero
inner join Proyectos as p on e.Proyecto = p.codigo
inner join Alumnos as al on e.Alumno = al.matricula
inner join Universidades as u on al.Universidad = u.clave
inner join Carreras as c on al.Carrera = c.clave
where e.Asesor = 20

/*
6.Cantidad de pagos por estadía
--Codigo de la estadia
--Nombre del proyecto
--Nombre del alumno, en una columna
--Cantidad de pagos realizados
*/

select 
e.codigo as "Codigo de la estadia",
p.nombre as "Nombre del proyecto",
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 COUNT(pa.numero) as "Cantidad de pagos realizados"
from Estadias as e
inner join Proyectos as p on e.Proyecto=p.codigo
inner join Alumnos as a on e.Alumno=a.matricula
inner join Pagos as pa on pa.Estadia=e.codigo
group by e.codigo, p.nombre, concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 )

/*
7.Carreras de una universidad
--Nombre de la universidad
--Nombre de la carrera
*/

select
u.nombre as "Nombre de la universidad",
c.nombre as "Nombre de la carrera"
from Universidades as u
inner join UNI_CARRERAS as uc on u.clave=uc.Universidad
inner join Carreras as c on uc.Carrera=c.clave
where u.clave="CETYS"

/*
8. Alumnos que son de la misma universidad
--Nombre de la universidad
--Nombre del alumno, en una columna
--Nombre de la carrera
*/

select
u.nombre as "Nombre de la universidad",
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
c.nombre as "Nombre de la carrera"
from Alumnos as a
inner join Universidades as u on a.Universidad=u.clave
inner join UNI_CARRERAS as uc on u.clave=uc.Universidad
inner join Carreras as c on uc.Carrera=c.clave
where a.Universidad="CETYS"

/*
9.Alumnos de la misma carrera
--Nombre de la carrera
--Nombre del alumno, en una columna
--Nombre de la universidad
*/

select
c.nombre as "Nombre de la carrera",
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 u.nombre as "Nombre de la universidad"
 from Alumnos as a
 inner join Universidades as u on a.Universidad=u.clave
inner join UNI_CARRERAS as uc on u.clave=uc.Universidad
inner join Carreras as c on uc.Carrera=c.clave
where a.Carrera="IS"

/*
10.Estadías que iniciaron el mismo mes
--Fecha de inicio
--Codigo de la estadia
--Nombre del proyecto
--Nombre del alumno, en una columna
--Nombre del asesor, en una columna
*/

select
date_format(e.fechaInicio, "%d-%m-%Y") as "Fecha Inicio",
e.codigo as "Codigo de la estadia",
p.nombre as "Nombre del proyecto",
concat(ifnull(concat(a.nombre,' '),' '),
   ifnull(concat(a.apPaterno,' '),' '),
   ifnull(concat(a.apMaterno,' '),' ')
 ) as "Nombre del alumno",
 concat(ifnull(concat(asr.nombre,' '),' '),
   ifnull(concat(asr.apPaterno,' '),' '),
   ifnull(concat(asr.apMaterno,' '),' ')
 ) as "Nombre del asesor"
 from Estadias as e
 inner join Proyectos as p on e.Proyecto=p.codigo
 inner join Alumnos as a on e.Alumno=a.matricula
 inner join Asesores as asr on e.Asesor=asr.numero
 where month(e.fechaInicio)=2