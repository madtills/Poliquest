CREATE DATABASE showdomilhao2;

USE showdomilhao2;


CREATE TABLE professor(
	id_professor INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
	PRIMARY KEY (id_professor)
);

CREATE TABLE turma(
	id_turma INT NOT NULL AUTO_INCREMENT,
    -- id_professor INT NOT NULL,
    nome VARCHAR(255),
    PRIMARY KEY (id_turma)
    -- FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

CREATE TABLE aluno(
	id_aluno INT NOT NULL AUTO_INCREMENT,
    id_turma INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    -- a senha seria a data de nasciemento
    senha DATE NOT NULL,
    PRIMARY KEY (id_aluno),
    FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
);

CREATE TABLE materia(
	id_materia INT NOT NULL AUTO_INCREMENT,
    -- id_professor INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_materia)
    -- FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

CREATE TABLE questao(
	id_questao INT NOT NULL AUTO_INCREMENT,
    id_materia INT NOT NULL,
    ano_escolar INT,
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

CREATE TABLE rodada (
    id_rodada INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT,
    id_professor INT,
    pontuacao INT,
    data_hora DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

CREATE TABLE rodada_questao (
    id_rodada_questao INT PRIMARY KEY AUTO_INCREMENT,
    id_rodada INT,
    id_questao INT,
    resposta_dada VARCHAR(255),
    acertou BOOLEAN,
    FOREIGN KEY (id_rodada) REFERENCES rodada(id_rodada),
    FOREIGN KEY (id_questao) REFERENCES questao(id_questao)
);

INSERT INTO professor(nome, email, senha) VALUES
('admin', 'admin@gmail.com', 'admin');

-- INSERT INTO aluno(nome, email, senha) VALUES
-- ('admin', 'admin@gmail.com', 0000-00-00);

INSERT INTO turma(nome) VALUES
('6 Ano A'),
('6 Ano B'),
('7 Ano A'),
('7 Ano B');

INSERT INTO materia(nome) VALUES
('Matemática'),
('Português'),
('Geografia'),
('História'),
('Ciências');

INSERT INTO questao (ano_escolar, id_materia, enunciado, opcao_a, opcao_b, opcao_c, opcao_d, opcao_correta) VALUES
(6, 2, 'Qual a função do verbo numa frase?', 'Nomear coisas', 'Indicar ação ou estado', 'Indicar lugar', 'Descrever pessoas', 'B'),
(6, 2, 'O que é um substantivo?', 'Palavra que indica ação', 'Palavra que indica qualidade', 'Palavra que indica objeto, pessoa, lugar', 'Palavra que liga orações', 'C'),
(6, 2, 'Na frase “O gato dorme.”, qual é o sujeito?', 'Dorme', 'O gato', 'A frase não tem sujeito', 'Gato dorme', 'B'),
(6, 2, 'O que é um adjetivo?', 'Palavra que indica ação', 'Palavra que modifica o verbo', 'Palavra que modifica o substantivo', 'Palavra que liga frases', 'C'),
(6, 2, 'Qual a diferença entre “por que” e “porque”?', '“Por que” é usado em perguntas; “porque” é usado para responder', '“Porque” é usado em perguntas; “por que” para responder', 'São iguais', 'Nenhuma alternativa está correta', 'A'),
(6, 2, 'Cite um sinônimo para “feliz”.', 'Triste', 'Alegre', 'Bravo', 'Cansado', 'B'),
(6, 2, 'O que é uma oração?', 'Conjunto de palavras com sentido completo', 'Somente verbo', 'Nome de pessoa', 'Frase sem sentido', 'A'),
(6, 2, 'Como identificar um artigo definido?', 'A, o, as, os', 'Um, uma', 'Ele, ela', 'Esse, essa', 'A'),
(6, 2, 'Explique o que é um advérbio.', 'Palavra que modifica verbo, adjetivo ou outro advérbio', 'Palavra que indica objeto', 'Palavra que liga frases', 'Palavra que indica pessoa', 'A'),
(6, 2, 'O que é uma frase exclamativa?', 'Frase com ponto final', 'Frase que expressa emoção e termina com “!”', 'Frase que faz pergunta', 'Frase afirmativa', 'B'),
(6, 2, 'O que é um pronome pessoal?', 'Palavra que substitui o sujeito', 'Palavra que modifica o verbo', 'Palavra que indica lugar', 'Palavra que liga orações', 'A'),
(6, 2, 'Cite um verbo no presente do indicativo.', 'Correr', 'Correu', 'Corre', 'Correria', 'C');

-- 6º ano - Matemática
INSERT INTO questao (ano_escolar, id_materia, enunciado, opcao_a, opcao_b, opcao_c, opcao_d, opcao_correta) VALUES
(6, 1, 'Quanto é 5 + 7?', '12', '10', '14', '11', 'A'),
(6, 1, 'O que é um número par?', 'Número que termina em 1, 3, 5', 'Número que não pode ser dividido', 'Número que termina em 0, 2, 4, 6, 8', 'Número negativo', 'C'),
(6, 1, 'Como calcular a área de um retângulo?', 'Multiplicar base pela altura', 'Somar base e altura', 'Dividir base pela altura', 'Somar todos os lados', 'A'),
(6, 1, 'O que é um ângulo reto?', '45 graus', '90 graus', '180 graus', '60 graus', 'B'),
(6, 1, 'Qual é o valor de 10 × 4?', '14', '40', '100', '20', 'B'),
(6, 1, 'O que é uma fração?', 'Parte de um todo', 'Número inteiro', 'Número decimal', 'Número primo', 'A'),
(6, 1, 'Qual é o resultado de 12 ÷ 3?', '6', '3', '4', '9', 'C'),
(6, 1, 'O que é um triângulo equilátero?', 'Triângulo com três lados iguais', 'Triângulo com um lado maior', 'Triângulo com todos os lados diferentes', 'Triângulo com dois lados iguais', 'A'),
(6, 1, 'O que é um número primo?', 'Número que tem apenas dois divisores: 1 e ele mesmo', 'Número par', 'Número divisível por 3', 'Número decimal', 'A'),
(6, 1, 'O que é o perímetro de um quadrado?', 'Soma dos quatro lados', 'Área do quadrado', 'Diagonal do quadrado', 'Lado multiplicado por 3', 'A'),
(6, 1, 'O que representa o número zero?', 'Nada ou ausência de quantidade', 'Número negativo', 'Número par', 'Número primo', 'A'),
(6, 1, 'Como fazer uma soma com números negativos?', 'Somar normalmente', 'Subtrair valores absolutos', 'Somar valores absolutos e colocar o sinal do maior', 'Multiplicar números', 'C');

INSERT INTO questao (ano_escolar, id_materia, enunciado, opcao_a, opcao_b, opcao_c, opcao_d, opcao_correta) VALUES
(6, 3, 'O que é um mapa?', 'Desenho de animais', 'Representação gráfica de um lugar', 'Texto sobre lugares', 'História de cidades', 'B'),
(6, 3, 'Qual é o maior oceano do mundo?', 'Atlântico', 'Índico', 'Ártico', 'Pacífico', 'D'),
(6, 3, 'Qual instrumento indica os pontos cardeais?', 'Termômetro', 'Régua', 'Bússola', 'Calculadora', 'C'),
(6, 3, 'O que são pontos cardeais?', 'Países do mundo', 'Direções principais no mapa', 'Rios famosos', 'Tipos de relevo', 'B'),
(6, 3, 'O que é uma capital?', 'Cidade principal de um país ou estado', 'Cidade pequena', 'Zona rural', 'Floresta', 'A'),
(6, 3, 'Qual continente o Brasil pertence?', 'Ásia', 'Europa', 'América', 'África', 'C'),
(6, 3, 'Qual elemento natural representa a água no mapa?', 'Verde', 'Azul', 'Marrom', 'Amarelo', 'B'),
(6, 3, 'O que são legendas em mapas?', 'Histórias escritas no mapa', 'Símbolos e explicações sobre o mapa', 'Nomes de cidades', 'Desenhos coloridos', 'B'),
(6, 3, 'O que é uma zona urbana?', 'Área rural e de agricultura', 'Área sem pessoas', 'Área das cidades', 'Área de floresta', 'C'),
(6, 3, 'Qual país faz fronteira com o Brasil?', 'Espanha', 'França', 'Argentina', 'Portugal', 'C'),
(6, 3, 'Como se chama a linha que divide o planeta em dois hemisférios?', 'Meridiano de Greenwich', 'Linha do Equador', 'Trópico de Capricórnio', 'Paralelo Norte', 'B'),
(6, 3, 'Qual é o bioma predominante da região Norte do Brasil?', 'Caatinga', 'Mata Atlântica', 'Pampa', 'Floresta Amazônica', 'D');

INSERT INTO questao (ano_escolar, id_materia, enunciado, opcao_a, opcao_b, opcao_c, opcao_d, opcao_correta) VALUES
(6, 4, 'Quem foi o primeiro imperador do Brasil?', 'Dom João VI', 'Dom Pedro I', 'Getúlio Vargas', 'Pedro Álvares Cabral', 'B'),
(6, 4, 'Quem descobriu o Brasil?', 'Dom Pedro II', 'Cristóvão Colombo', 'Pedro Álvares Cabral', 'Tiradentes', 'C'),
(6, 4, 'O que foi o período colonial?', 'Tempo em que o Brasil era colônia de Portugal', 'Domínio da Espanha', 'Tempo dos índios', 'Época do império romano', 'A'),
(6, 4, 'Quem foram os indígenas?', 'Exploradores europeus', 'Habitantes originais do Brasil', 'Soldados portugueses', 'Imigrantes africanos', 'B'),
(6, 4, 'O que foi a escravidão no Brasil?', 'Serviço voluntário', 'Trabalho pago', 'Exploração de mão de obra africana forçada', 'Migração indígena', 'C'),
(6, 4, 'Em que ano o Brasil se tornou independente?', '1500', '1822', '1889', '2022', 'B'),
(6, 4, 'O que é um documento histórico?', 'Texto de ficção', 'Filme antigo', 'Fonte que registra o passado', 'Mensagem eletrônica', 'C'),
(6, 4, 'Qual foi a principal atividade econômica no Brasil colonial?', 'Pecuária', 'Indústria', 'Comércio', 'Plantação de cana-de-açúcar', 'D'),
(6, 4, 'Quem proclamou a Independência do Brasil?', 'Dom João VI', 'Dom Pedro I', 'Marechal Deodoro', 'Getúlio Vargas', 'B'),
(6, 4, 'O que foi o ciclo do ouro?', 'Exploração de petróleo', 'Período de mineração no Brasil', 'Ciclo de vida dos insetos', 'Tempo de construção de cidades', 'B'),
(6, 4, 'O que são fontes históricas?', 'Imagens do presente', 'Relatos e objetos do passado', 'Notícias atuais', 'Plantas medicinais', 'B'),
(6, 4, 'Quem habitava o Brasil antes da chegada dos portugueses?', 'Espanhóis', 'Africanos', 'Indígenas', 'Italianos', 'C');

INSERT INTO questao (ano_escolar, id_materia, enunciado, opcao_a, opcao_b, opcao_c, opcao_d, opcao_correta) VALUES
(6, 5, 'O que é fotossíntese?', 'Processo de reprodução', 'Alimentação dos animais', 'Transformação da luz em energia pelas plantas', 'Movimento das nuvens', 'C'),
(6, 5, 'Qual é o maior órgão do corpo humano?', 'Pulmão', 'Fígado', 'Pele', 'Coração', 'C'),
(6, 5, 'O que é um ser vivo?', 'Objeto inanimado', 'Algo que se move', 'Organismo com funções vitais', 'Máquina inteligente', 'C'),
(6, 5, 'Qual é o estado da água em forma de vapor?', 'Líquido', 'Sólido', 'Gasoso', 'Pastoso', 'C'),
(6, 5, 'O que é ecossistema?', 'Conjunto de prédios', 'Grupo de animais', 'Conjunto de seres vivos e ambiente', 'Sistema de informática', 'C'),
(6, 5, 'Onde ocorre a digestão dos alimentos?', 'No coração', 'Nos pulmões', 'No sistema digestório', 'Na pele', 'C'),
(6, 5, 'Qual é a função do coração?', 'Respirar', 'Bombear sangue', 'Pensar', 'Digestionar alimentos', 'B'),
(6, 5, 'Qual é o planeta mais próximo do Sol?', 'Terra', 'Marte', 'Mercúrio', 'Júpiter', 'C'),
(6, 5, 'Como se chama a transformação da água em gelo?', 'Fusão', 'Evaporação', 'Condensação', 'Solidificação', 'D'),
(6, 5, 'Qual é a principal fonte de energia da Terra?', 'Eletricidade', 'Sol', 'Água', 'Vento', 'B'),
(6, 5, 'Qual parte do corpo é responsável pela respiração?', 'Estômago', 'Pulmões', 'Rins', 'Fígado', 'B'),
(6, 5, 'O que os animais precisam para viver?', 'Plástico', 'Papel', 'Ar, água e alimento', 'Somente luz', 'C');

DROP DATABASE showdomilhao2;

SELECT * FROM aluno;
SELECT * FROM professor;
SELECT * FROM turma;
SELECT * FROM materia;
SELECT * FROM questao;