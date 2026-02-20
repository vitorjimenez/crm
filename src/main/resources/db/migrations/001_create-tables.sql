CREATE TABLE usuario (
    id INT PRIMARY KEY NOT NULL,
    nome VARCHAR(100),
    email VARCHAR(150),
    senha VARCHAR(100),
    telefone VARCHAR(12),
    cargo VARCHAR(20),
    ativo VARCHAR(20),
    data_Criacao DATETIME
);


CREATE TABLE cliente(
    id INT PRIMARY KEY NOT NULL,
    nome VARCHAR(100),
    email VARCHAR(150),
    ativo VARCHAR(20),
    telefone VARCHAR(12),
    data_Criacao DATETIME
    );

CREATE TABLE estoque(
    id INT PRIMARY KEY NOT NULL,
    nome VARCHAR(100),
    descricao VARCHAR(150),
    quantidade INT,
    ativo VARCHAR(20),
    preco DOUBLE
);

CREATE TABLE itens_orcamento (
    id INT PRIMARY KEY NOT NULL,
    item_id INT,

    FOREIGN KEY (item_id) REFERENCES estoque (id)
);

CREATE TABLE orcamento (
    id INT PRIMARY KEY NOT NULL,
    itens_orcamento_id INT,
    cliente_id INT,
    usuario_id INT,
    status_orcamento VARCHAR(100),
    data_Criacao DATETIME,

    FOREIGN KEY (itens_orcamento_id) REFERENCES itens_orcamento (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
)