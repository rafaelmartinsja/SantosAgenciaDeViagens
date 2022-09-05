-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Clientes (
data_nasci_clientes VARCHAR(50),
cpf_clientes VARCHAR(50),
nome_clientes VARCHAR(50),
id_clientes VARCHAR(50) PRIMARY KEY
)

CREATE TABLE Viagens (
data_destino_viagens VARCHAR(50),
origem_viagens VARCHAR(50),
data_origem_viagens VARCHAR(50),
destino_viagens VARCHAR(50),
id_viagens VARCHAR(50) PRIMARY KEY
)

CREATE TABLE Compra (
id_clientes VARCHAR(10),
id_viagens VARCHAR(10),
FOREIGN KEY(id_clientes) REFERENCES Clientes (id_clientes),
FOREIGN KEY(id_viagens) REFERENCES Viagens (id_viagens)
)

