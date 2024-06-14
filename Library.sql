create database Library

use Library

create table usuario (
id_usr INT NOT NULL,
PRIMARY KEY(id_usr),
nome VARCHAR(80) NOT NULL,
sobrenome VARCHAR(80) NOT NULL,
Tipo VARCHAR(80) NOT NULL,
rua VARCHAR(80) NOT NULL,
bairro VARCHAR(80) NOT NULL,
cep INT NOT NULL,
Tel1 INT NOT NULL,
Tel2 INT NULL)

create table livro(
id_livro INT NOT NULL,
PRIMARY KEY(id_livro),
titulo VARCHAR(80) NOT NULL,
autor1 VARCHAR(80) NOT NULL,
autor2 VARCHAR(80) NULL,
autor3 VARCHAR(80) NULL,
edicao VARCHAR(80) NOT NULL,
ISBN VARCHAR(80) NOT NULL,
ano INT NOT NULL,
copias INT NULL)

CREATE TABLE emprestimo (
    id_emp INT NOT NULL,
    PRIMARY KEY (id_emp),
    data_emprestimo DATE NOT NULL,
    data_retorno DATE NOT NULL,
    cod_usuario INT,
    cod_livro INT,
    CONSTRAINT fk_emprestimo_usuario FOREIGN KEY (cod_usuario) REFERENCES usuario (id_usr),
    CONSTRAINT fk_emprestimo_livro FOREIGN KEY (cod_livro) REFERENCES livro (id_livro)
);


CREATE TABLE reserva (
    id_reserva INT NOT NULL,
    PRIMARY KEY(id_reserva),
    cod_usuario INT,
    cod_livro INT,
    FOREIGN KEY (cod_usuario) REFERENCES usuario (id_usr),
    FOREIGN KEY (cod_livro) REFERENCES livro (id_livro)
);

CREATE TABLE multa (
    id_multa INT NOT NULL,
    PRIMARY KEY(id_multa),
    dias_atraso INT NOT NULL,
    valor INT NOT NULL,
    cod_emprestimo INT,
    FOREIGN KEY (cod_emprestimo) REFERENCES emprestimo (id_emp)
);


