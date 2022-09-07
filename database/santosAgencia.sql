-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.
drop database santosagencia;
create database santosAgencia;
use santosAgencia;

CREATE TABLE Clientes (
id_clientes int PRIMARY KEY auto_increment,
nome_clientes VARCHAR(50),
cpf_clientes VARCHAR(50),
data_nasci_clientes VARCHAR(50)
);

CREATE TABLE Viagens (
id_viagens int PRIMARY KEY auto_increment,
origem_viagens VARCHAR(50),
data_destino_viagens VARCHAR(50),
destino_viagens VARCHAR(50),
data_origem_viagens VARCHAR(50)
);

CREATE TABLE Compra (
id_clientes int,
id_viagens int,
FOREIGN KEY(id_clientes) REFERENCES Clientes (id_clientes),
FOREIGN KEY(id_viagens) REFERENCES Viagens (id_viagens)
);

