-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.


CREATE TABLE Clientes (
cod_cli NUMERIC(10) PRIMARY KEY,
nome_cli VARCHAR(50),
senha_cli VARCHAR(16),
email_cli VARCHAR(25),
cpf_cli NUMERIC(12),
complemento_cli VARCHAR(25),
data_nasci_cli DATETIME,
milhas_cli DECIMAL(10),
rua_cli VARCHAR(50),
cep_cli DECIMAL(10),
municipio_cli VARCHAR(50),
estado_cli VARCHAR(25)
)

CREATE TABLE Viagens (
cod_vi NUMERIC(10) PRIMARY KEY,
origem_vi VARCHAR(50),
data_origem_vi DATETIME,
destino_vi VARCHAR(50),
data_destino_vi DATETIME
)

CREATE TABLE Funcionário (
cod_func NUMERIC(10) PRIMARY KEY,
nome_func VARCHAR(50),
senha_func VARCHAR(16),
email_func VARCHAR(25),
cpf_nasc NUMERIC(12),
data_nasc_func DATETIME,
data_ingresso_func DATETIME,
rua_func VARCHAR(50),
complemento_func VARCHAR(25),
cep_func VARCHAR(25),
municipio_func VARCHAR(50),
estado_func VARCHAR(25)
)

CREATE TABLE Relacao1 (
cod_cli NUMERIC(10),
cod_vi NUMERIC(10),
FOREIGN KEY(cod_cli) REFERENCES Clientes (cod_cli),
FOREIGN KEY(cod_vi) REFERENCES Viagens (cod_vi)
)

CREATE TABLE Relacao2 (
cod_vi NUMERIC(10),
cod_func NUMERIC(10),
FOREIGN KEY(cod_vi) REFERENCES Viagens (cod_vi),
FOREIGN KEY(cod_func) REFERENCES Funcionário (cod_func)
)

