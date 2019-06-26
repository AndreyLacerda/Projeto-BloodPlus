BEGIN TRANSACTION;
DROP TABLE IF EXISTS "MatchComum";
CREATE TABLE IF NOT EXISTS "MatchComum" (
	"email_doador"	VARCHAR(50) NOT NULL,
	"email_receptor"	VARCHAR(50) NOT NULL,
	"doacao"	VARCHAR(10) NOT NULL,
	"fracasso"	binary NOT NULL,
	"sucesso"	binary NOT NULL,
	"motivo"	VARCHAR(80),
	"cancelada"	BLOB NOT NULL,
	"finalizada"	BLOB NOT NULL,
	PRIMARY KEY("email_doador","email_receptor"),
	FOREIGN KEY("email_doador") REFERENCES "Doador"("email"),
	FOREIGN KEY("email_receptor") REFERENCES "ReceptorComum"("email")
);
DROP TABLE IF EXISTS "Doador";
CREATE TABLE IF NOT EXISTS "Doador" (
	"email"	varchar(50) NOT NULL,
	"senha"	varchar(50) NOT NULL,
	"nome"	varchar(40) NOT NULL,
	"sobrenome"	varchar(100) NOT NULL,
	"dt_nascimento"	date NOT NULL,
	"tel_fixo"	varchar(25),
	"celular"	varchar(25) NOT NULL,
	"peso"	decimal(5 , 2) NOT NULL,
	"tipo_sangue"	varchar(3) NOT NULL,
	"sangue"	binary NOT NULL,
	"rim"	binary NOT NULL,
	"figado"	BLOB NOT NULL,
	"medula"	binary NOT NULL,
	"pulmao"	binary NOT NULL,
	"pancreas"	binary NOT NULL,
	"regiao"	varchar(20) NOT NULL,
	"endereco"	varchar(45) NOT NULL,
	"ativo"	binary NOT NULL,
	"cpf"	TEXT NOT NULL,
	PRIMARY KEY("email")
);
DROP TABLE IF EXISTS "MatchPessoaInst";
CREATE TABLE IF NOT EXISTS "MatchPessoaInst" (
	"email_doador"	TEXT NOT NULL,
	"email_receptorJuridico"	TEXT NOT NULL,
	"doacao"	TEXT NOT NULL,
	"motivo"	TEXT,
	"fracasso"	BLOB NOT NULL,
	"sucesso"	BLOB NOT NULL,
	"cancelada"	BLOB NOT NULL,
	"finalizada"	BLOB NOT NULL
);
DROP TABLE IF EXISTS "ReceptorJuridico";
CREATE TABLE IF NOT EXISTS "ReceptorJuridico" (
	"email"	TEXT NOT NULL,
	"senha"	TEXT NOT NULL,
	"nome_instituição"	TEXT NOT NULL,
	"CNPJ"	TEXT NOT NULL,
	"tel1"	TEXT NOT NULL,
	"tel2"	TEXT,
	"regiao"	TEXT NOT NULL,
	"endereco"	TEXT NOT NULL,
	"sangue"	BLOB NOT NULL,
	"rim"	BLOB NOT NULL,
	"figado"	BLOB NOT NULL,
	"medula"	BLOB NOT NULL,
	"pulmao"	BLOB NOT NULL,
	"pancreas"	BLOB NOT NULL,
	"ativo"	BLOB NOT NULL,
	"main_tipo_sangue"	varchar(3) NOT NULL
);
DROP TABLE IF EXISTS "ReceptorComum";
CREATE TABLE IF NOT EXISTS "ReceptorComum" (
	"email"	varchar(50) NOT NULL,
	"senha"	varchar(50) NOT NULL,
	"nome"	varchar(40) NOT NULL,
	"sobrenome"	varchar(100) NOT NULL,
	"dt_nascimento"	date NOT NULL,
	"tel_fixo"	varchar(25),
	"celular"	varchar(25) NOT NULL,
	"peso"	decimal(5 , 2) NOT NULL,
	"tipo_sangue"	varchar(3) NOT NULL,
	"regiao"	varchar(20) NOT NULL,
	"ativo"	binary NOT NULL,
	"sangue"	BLOB NOT NULL,
	"cpf"	TEXT NOT NULL,
	"pulmao"	BLOB NOT NULL,
	"figado"	BLOB NOT NULL,
	"rim"	BLOB NOT NULL,
	"pancreas"	BLOB NOT NULL,
	"medula"	BLOB NOT NULL,
	"endereco"	TEXT NOT NULL,
	PRIMARY KEY("email")
);

DROP TRIGGER IF EXISTS "testeConexao";
CREATE TRIGGER testeConexao AFTER INSERT
ON Doador
BEGIN
		DELETE FROM Doador WHERE email = 'teste@teste.com';
END;
COMMIT;
