drop schema if exists test;

drop user if exists 'user'@'localhost';

create schema tabela;

create user 'userNaiara'@'localhost' identified by 'pass000';

grant select, insert, delete, update on spring.* to userNaiara@'localhost';

use tabela;

create table if not exists anc_anuncio (
 anc_id bigint primary key auto_increment,
 anc_nome_produto varchar(100) not null,
 anc_descricao varchar(200),
 anc_data_hora datetime not null,
 anc_preco float,
 anc_peso float,
);

insert into anc_anuncio (anc_nome_produto, anc_data_hora,anc_peso)
 values ('Resistência 6800w', '2024-03-15 23:59:59',0.2),
 ('Liquidificador', current_timestamp(), null);
