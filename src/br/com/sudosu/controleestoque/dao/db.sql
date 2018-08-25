CREATE TABLE equipamentos(
patrimonio INT NOT NULL PRIMARY KEY,
tipo VARCHAR(50) NOT NULL,
quantidade INT NOT NULL,
descricao TEXT NOT NULL);

CREATE TABLE bckup(
idBckup INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
midia VARCHAR(30) NOT NULL,
local VARCHAR(10) NOT NULL,
conteudo TEXT NOT NULL,
observacoes TEXT NOT NULL);

CREATE TABLE ordemServico(
idOs INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
patrimonio INT,
chamado INT NOT NULL,
contato VARCHAR(50) NOT NULL,
tecnico VARCHAR(50) NOT NULL,
defeito TEXT NOT NULL,
FOREIGN KEY (patrimonio) REFERENCES equipamentos (patrimonio));

CREATE TABLE retirada(
idRetirada INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dataRetirada TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
conteudo TEXT NOT NULL,
local VARCHAR(10) NOT NULL,
enviado VARCHAR(50) NOT NULL,
recebido VARCHAR(50) NOT NULL);

CREATE TABLE usuario(
idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
senha VARCHAR(30) NOT NULL,
condicao VARCHAR(30) NOT NULL);

INSERT INTO usuario(nome, senha, condicao)
VALUES('operador','op123','OPERADOR'),('delivery','del123','ADMINISTRADOR');