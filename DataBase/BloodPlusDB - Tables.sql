CREATE DATABASE BloodPlusDB

USE BloodPlusDB

CREATE TABLE Doador (
email			VARCHAR(50) NOT NULL,
senha			VARCHAR(50) NOT NULL,
nome			VARCHAR(40) NOT NULL,
sobrenome		VARCHAR(100) NOT NULL,
dt_nascimento	DATE NOT NULL,
tel_fixo		VARCHAR(25),
celular			VARCHAR(25) NOT NULL,
peso			DECIMAL(5,2) NOT NULL,
tipo_sangue		CHAR(2) NOT NULL,
sangue			binary NOT NULL,
rim				binary NOT NULL,
fígado			binary NOT NULL,
medula			binary NOT NULL,
pulmao			binary NOT NULL,
pâncreas		binary NOT NULL,
regiao			VARCHAR(20) NOT NULL,
endereco		VARCHAR(45) NOT NULL,
ult_doacao		DATE,
ativo			binary NOT NULL,
dt_block		DATE,
block			INT,
PRIMARY KEY (email)	
)

CREATE TABLE Receptor (
email			VARCHAR(50) NOT NULL,
senha			VARCHAR(50) NOT NULL,
nome			VARCHAR(40) NOT NULL,
sobrenome		VARCHAR(100) NOT NULL,
dt_nascimento	DATE NOT NULL,
tel_fixo		VARCHAR(25),
celular			VARCHAR(25) NOT NULL,
peso			DECIMAL(3,2) NOT NULL,
tipo_sangue		CHAR(2) NOT NULL,
necessidade		VARCHAR(10) NOT NULL,
prime_vez		binary NOT NULL,
regiao			VARCHAR(20) NOT NULL,
ativo			binary NOT NULL,
PRIMARY KEY (email)	
)

CREATE TABLE Match (
email_doador	VARCHAR(50) NOT NULL,
email_receptor  VARCHAR(50) NOT NULL,
doação			VARCHAR(10),
fracasso		binary NOT NULL,
sucesso			binary NOT NULL,
motivo			VARCHAR(80) NOT NULL,
PRIMARY KEY (email_doador, email_receptor),
FOREIGN KEY (email_doador) REFERENCES Doador(email),
FOREIGN KEY (email_receptor) REFERENCES Receptor(email)
)

CREATE TRIGGER testeConexão
ON Doador
AFTER INSERT AS
BEGIN
	DECLARE @valor VARCHAR(50)
	SELECT @valor = email FROM INSERTED
	IF @valor = 'teste@teste.com'
		DELETE FROM Doador WHERE email = 'teste@teste.com'
END