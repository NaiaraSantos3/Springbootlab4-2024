
create table anc_anuncio (
    anc_id bigint primary key auto_increment,
    anc_nome_produto varchar (100) not null,
    anc_descricao varchar (200),
    anc_data_hora datetime not null,
    anc_preco float,
    anc_peso float
);