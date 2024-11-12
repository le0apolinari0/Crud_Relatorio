create table relatorios(
    id bigint not null auto_increment,
    titulo varchar(50) not null,
    materia varchar(30) not null,
    mensagem varchar(5000) not null,
    status varchar(30) not null,
    data_criacao datetime not null,
    data_alteracao datetime not null,
    professor_id bigint not null,

    primary key(id),
    foreign key(professor_id) references professor(id)

);
