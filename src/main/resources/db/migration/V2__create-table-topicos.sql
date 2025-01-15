
create table topicos(

    id bigint not null auto_increment,
    mensaje varchar(300) not null,
    nombre_curso varchar (100) not null,
    titulo varchar (100) not null,
    usuario_id bigint not null,

    primary key(id),
    constraint fk_topicos_idUsuario foreign key(usuario_id) references usuarios(id)

);