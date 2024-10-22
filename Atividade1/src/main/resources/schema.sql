create table tra_trabalho (
 tra_id bigint auto_increment primary key ,
 tra_titulo varchar(100) not null unique,
 tra_data_hora_entrega datetime not null,
 tra_descricao varchar(200),
 tra_grupo varchar(20) not null,
 tra_nota int,
 tra_justificativa varchar(100)
);



