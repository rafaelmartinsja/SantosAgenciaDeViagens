create database santosagencia;
use santosagencia;

CREATE TABLE Viagens (
cod_vi int PRIMARY KEY auto_increment,
cod_func VARCHAR(10),
origem_vi VARCHAR(50),
data_origem_vi DATETIME,
destino_vi VARCHAR(50),
data_destino_vi DATETIME
);

CREATE TABLE Funcionarios (
cod_func int PRIMARY KEY auto_increment,
nome_func VARCHAR(50),
senha_func VARCHAR(32),
email_func VARCHAR(50),
cpf_nasc NUMERIC(16),
data_nasc_func DATETIME,
data_ingresso_func DATETIME,
rua_func VARCHAR(50),
complemento_func VARCHAR(50),
cep_func NUMERIC(10),
municipio_func VARCHAR(50),
estado_func VARCHAR(50)
);

CREATE TABLE Reservas (
cod_cli int,
cod_vi int,
FOREIGN KEY(cod_vi) REFERENCES Viagens (cod_vi)
);

CREATE TABLE Clientes (
cod_cli int PRIMARY KEY auto_increment,
nome_cli VARCHAR(50),
estado_cli VARCHAR(50),
municipio_cli VARCHAR(50),
cep_cli NUMERIC(10),
rua_cli VARCHAR(50),
complemento_cli VARCHAR(25),
senha_cli VARCHAR(32),
email_cli VARCHAR(50),
cpf_cli NUMERIC(16),
data_nasci_cli DATETIME,
milhas_cli DECIMAL(10)
);

ALTER TABLE Reservas ADD FOREIGN KEY(cod_cli) REFERENCES Clientes (cod_cli);
