drop database if exists negocio;
create database negocio;
use negocio;

create table if not exists clientes (
codigo integer auto_increment,
nombre varchar(20) not null,
apellido varchar(20) not null,
cuit char(13),
direccion varchar(50),
comentarios varchar(140),
primary key (codigo)
);

create table facturas(
letra char(1),
numero integer,
fecha date,
monto double,
primary key (letra,numero)
);

create table articulos(
codigo integer auto_increment,
descripcion varchar(50),
precio double,
stock integer,
primary key (codigo)
);

alter table facturas add codigocliente integer not null;
alter table facturas
add constraint FK_facturas_codcli
foreign key (codigocliente)
references clientes(codigo)
on delete cascade;


create table detalles(
letra char(1) not null,
numero int not null,
codigo int not null,
cantidad int unsigned not null,
primary key(letra,numero,codigo)
);

alter table detalles
add constraint FK_facturas_letra_numero
foreign key (letra,numero)
references facturas(letra,numero)
on delete cascade;

select * from articulos;
select * from clientes;