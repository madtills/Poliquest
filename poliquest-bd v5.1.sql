CREATE DATABASE showdomilhao2;

USE showdomilhao2;

CREATE TABLE jogador(
	id_jogador INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id_jogador)
);

CREATE TABLE professor(
	id_professor INT NOT NULL AUTO_INCREMENT,
    id_jogador INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
	PRIMARY KEY (id_professor),
    FOREIGN KEY (id_jogador) REFERENCES jogador(id_jogador)
);

CREATE TABLE turma(
	id_turma INT NOT NULL AUTO_INCREMENT,
    id_professor INT NOT NULL,
    nome VARCHAR(255),
    PRIMARY KEY (id_turma),
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

CREATE TABLE aluno(
	id_aluno INT NOT NULL AUTO_INCREMENT,
    id_turma INT NOT NULL,
	id_jogador INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    -- a senha seria a data de nasciemento
    senha DATE NOT NULL,
    PRIMARY KEY (id_aluno),
    FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
	FOREIGN KEY (id_jogador) REFERENCES jogador(id_jogador)
);

CREATE TABLE rodada(
	id_rodada INT NOT NULL AUTO_INCREMENT,
    id_jogador INT NOT NULL,
    PRIMARY KEY (id_rodada),
    FOREIGN KEY (id_jogador) REFERENCES jogador(id_jogador)
);

CREATE TABLE materia(
	id_materia INT NOT NULL AUTO_INCREMENT,
    id_professor INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_materia), 
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

CREATE TABLE questao(
	id_questao INT NOT NULL AUTO_INCREMENT,
    id_materia INT NOT NULL,
    dificuldade ENUM('Fácil','Média','Difícil'),
    enunciado VARCHAR(255) NOT NULL,
    opcao_a VARCHAR(255) NOT NULL,
    opcao_b VARCHAR(255) NOT NULL,
    opcao_c VARCHAR(255) NOT NULL,
    opcao_d VARCHAR(255) NOT NULL,
    opcao_correta VARCHAR(1),
    feedback VARCHAR(255),
    dica VARCHAR(255),
    PRIMARY KEY (id_questao),
    FOREIGN KEY (id_materia) REFERENCES materia(id_materia)
);

DROP DATABASE showdomilhao2;
SELECT * FROM aluno;
SELECT * FROM professor;
