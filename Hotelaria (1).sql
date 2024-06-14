CREATE DATABASE hotelaria;
USE hotelaria;

CREATE TABLE hospede(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    genero VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    cep INT NOT NULL,
    telefone INT NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE quarto(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    tipo ENUM('simples','superior','executivo','luxo','presidencial') NOT NULL DEFAULT 'simples',
    capacidade INT NOT NULL,
    andar INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    disponibilidade ENUM ('disponivel','ocupado','limpeza','manutencao') NOT NULL DEFAULT 'disponivel',
    diaria DECIMAL(10,2) NOT NULL,
    facilidades VARCHAR(255) NOT NULL
);

CREATE TABLE funcionario(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    genero VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    cep INT NOT NULL,
    telefone INT NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE evento(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    capacidade INT NOT NULL,
    organizador VARCHAR(255) NOT NULL,
    contato_organizador INT NOT NULL,
    disponibilidade ENUM('disponivel','ocupado','manutencao') NOT NULL DEFAULT 'disponivel',
    feedback VARCHAR(255) NULL,
    data_feed DATE NULL,
    avaliacao VARCHAR(255) NULL
);

CREATE TABLE reserva(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_hospede INT NOT NULL,
    id_quarto INT NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    disponibilidade ENUM('reservado','pendente','ausente','cancelado') NOT NULL DEFAULT 'reservado',
    metodo_pagamento ENUM('credito','debito','dinheiro','pix') NOT NULL DEFAULT 'credito',
    valor DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_hospede) REFERENCES hospede(id),
    FOREIGN KEY (id_quarto) REFERENCES quarto(id)
);

CREATE TABLE servico_quarto (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_quarto INT NOT NULL,
    id_funcionario INT NOT NULL,
    tipo ENUM('alimentacao','limpeza','concierge','entretenimento') NOT NULL DEFAULT 'alimentacao',
    descricao VARCHAR(255) NOT NULL,
    data_hora DATETIME NOT NULL,
    disponibilidade ENUM ('disponivel','em andamento','entregue','indisponivel') NOT NULL DEFAULT 'disponivel',
    valor DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_quarto) REFERENCES quarto(id),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

CREATE TABLE funcionario_evento (
    id_funcionario INT NOT NULL,
    id_evento INT NOT NULL,
    CONSTRAINT pk_funcionario_evento PRIMARY KEY (id_funcionario, id_evento),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id),
    FOREIGN KEY (id_evento) REFERENCES evento(id)
);

INSERT INTO hospede (nome, data_nascimento, genero, endereco, cep, telefone, email) VALUES
('Carlos Oliveira', '1990-05-15', 'Masculino', 'Rua A, 123', 12345678, 11223344, 'hospede1@example.com'),
('Ana Santos', '1985-10-20', 'Feminino', 'Av. B, 456', 98765432, 55443322, 'hospede2@example.com'),
('Pedro Almeida', '1978-03-25', 'Masculino', 'Rua C, 789', 11122233, 66778899, 'hospede3@example.com');

INSERT INTO quarto (tipo, capacidade, andar, descricao, diaria, facilidades) VALUES
('simples', 1, 2, 'Quarto Standard com cama de casal', 150.00, 'Wi-Fi, TV, Ar-condicionado'),
('executivo', 2, 5, 'Suíte com vista para o mar', 250.00, 'Wi-Fi, TV, Ar-condicionado, Banheira de hidromassagem'),
('luxo', 2, 10, 'Suíte Presidencial com piscina privativa', 500.00, 'Wi-Fi, TV 4K, Ar-condicionado, Piscina privativa');

INSERT INTO funcionario (nome, data_nascimento, genero, cargo, endereco, cep, telefone, email) VALUES
('João Silva', '1980-07-10', 'Masculino', 'Recepcionista', 'Rua X, 789', 54321678, 99887766, 'joao@example.com'),
('Maria Souza', '1995-01-20', 'Feminino', 'Camareira', 'Av. Y, 456', 65432198, 11223344, 'maria@example.com');

INSERT INTO evento (nome, descricao, data_inicio, data_fim, localizacao, capacidade, organizador, contato_organizador) VALUES
('Conferência Anual de Tecnologia', 'Evento anual sobre as últimas tendências em tecnologia.', '2024-08-15', '2024-08-18', 'Centro de Convenções ABC', 500, 'Tech Solutions Ltda.', 11223344),
('Casamento de Ana e Pedro', 'Casamento tradicional com festa e jantar.', '2024-09-20', '2024-09-20', 'Hotel XYZ - Salão de Festas', 100, 'Ana e Pedro', 99887766);

INSERT INTO reserva (id_hospede, id_quarto, check_in, check_out, valor) VALUES
(1, 1, '2024-08-01', '2024-08-05', 600.00),
(2, 2, '2024-09-10', '2024-09-15', 1250.00);

INSERT INTO servico_quarto (id_quarto, id_funcionario, tipo, descricao, data_hora, valor) VALUES
(1, 2, 'limpeza', 'Limpeza diária', '2024-08-02 10:00:00', 50.00),
(2, 2, 'alimentacao', 'Jantar romântico', '2024-09-12 20:00:00', 150.00);

INSERT INTO funcionario_evento (id_funcionario, id_evento) VALUES
(1, 1),
(2, 2);
