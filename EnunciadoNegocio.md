# Negocio

## Ejercicio 1 – Inicio del proyecto.
Para desarrollar en grupo.-
Crear un proyecto nuevo llamado Negocio, usando el gestor de proyectos MAVEN. - 
Crear el repositorio git y commitear el inicio del proyecto. - 
Crear un repositorio github o equivalente.

## Ejercicio 2 – Armado de Base de datos.
Montar en un servidor de base datos la siguiente BD.

drop database if exists negocio;
create database negocio;
use negocio;
create table if not exists clientes (
codigo integer auto_increment,
nombre varchar(20) not null,
apellido varchar(20) not null,
cuit char(13), direccion varchar(50),
comentarios varchar(140),
primary key (codigo) );

create table facturas(
letra char(1),
numero integer,
fecha date,
monto double,
primary key (letra,numero) );

create table articulos(
codigo integer auto_increment,
descripcion varchar(50),
precio double,
stock integer,
primary key (codigo) );

alter table facturas
add codigocliente integer not null;

alter table facturas
add constraint FK_facturas_codcli 
foreign key (codigocliente) 
references clientes(codigo) on delete cascade;

create table detalles(
letra char(1) not null,
numero int not null,
codigo int not null,
cantidad int unsigned not null,
primary key(letra,numero,codigo) );

alter table detalles
add constraint FK_facturas_letra_numero
foreign key (letra,numero)
references facturas(letra,numero) on delete cascade;

## Ejercicio 3 – Armado de la aplicación. -
Armar el patron DAO que permita el acceso a la base dada. - 
Crear una GUI (AWT, SWING o JavaFx) que brinde un ABM de cada entidad. (debe tener validaciones y ser fácil de usar)


## Ejercicio 4 – Mejora de aplicación. -
Debatir en grupo que mejoras realizaría a la aplicación, y armar una lista de posibles mejoras, 
Ejemplo, mejoras en la base, mejoras en el patrón DAO, seguridad o mejoras en la GUI. - 
Armar un plan de trabajo para realizar dichas mejoras y ejecutarlas.
