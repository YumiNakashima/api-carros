CREATE TABLE CARRO (
    ID bigint not null auto_increment,
    NOME varchar(255),
    DESCRICAO varchar(255),
    URL_FOTO varchar(255),
    URL_VIDEO varchar(255),
    LATITUDE varchar(255),
    LONGITUDE varchar(255),
    TIPO varchar(255),
    primary key (ID)
);