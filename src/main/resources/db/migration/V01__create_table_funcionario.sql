CREATE TABLE funcionario(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(80) NOT NULL,
matricula VARCHAR(90) NOT NULL,
data_nascimento DATE,
sexo CHAR(1),
cep VARCHAR(9) NOT NULL,
estado CHAR(2),
bairro VARCHAR(40),
cidade VARCHAR(40)
);