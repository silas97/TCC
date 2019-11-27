--Campos de data = timestamp = TIMESTAMP (DEFAULT LOCALTIMESTAMP),
--Alterar na documentação, no diagrama de classes.
CREATE TABLE usuario(--Removido o campo email porque na tabela login já tem.
    idUsuario SERIAL,
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(45) NOT NULL,
    cep VARCHAR(45) NOT NULL,
    endereco VARCHAR(45) NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    estado VARCHAR(45) NOT NULL,
    perfil VARCHAR(45) NOT NULL,
    PRIMARY KEY(idUsuario)
);

CREATE TABLE curso(
    idCurso SERIAL,
    nome VARCHAR(45) NOT NULL, 
    PRIMARY KEY(idCurso)
);

CREATE TABLE disciplina(
    idDisciplina SERIAL,
    nome VARCHAR(45) NOT NULL,
    creditos VARCHAR(45) NOT NULL,
    cargaHoraria VARCHAR(45) NOT NULL,
    idCurso_FK INTEGER NOT NULL,
    PRIMARY KEY(idDisciplina),
    FOREIGN KEY(idCurso_FK) REFERENCES curso(idCurso)
);

CREATE TABLE turma(
    idTurma SERIAL,
    periodo VARCHAR(45) NOT NULL,
    sigla VARCHAR(2) NOT NULL,
    idCurso_FK INTEGER NOT NULL,
    PRIMARY KEY(idTurma),
    FOREIGN KEY(idCurso_FK) REFERENCES curso(idCurso)
);

CREATE TABLE login(
    idLogin SERIAL,
    email VARCHAR(45) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    idUsuario_FK INTEGER NOT NULL,
    PRIMARY KEY(idLogin),
    FOREIGN KEY(idUsuario_FK) REFERENCES usuario(idUsuario)
);

CREATE TABLE master(
    idMaster SERIAL,
    idUsuario_FK INTEGER NOT NULL,
    PRIMARY KEY(idMaster),
    FOREIGN KEY(idUsuario_FK) REFERENCES usuario(idUsuario)
);

CREATE TABLE aluno(
    idAluno SERIAL,
    matricula VARCHAR(45) NOT NULL,
    idCurso_FK INTEGER NOT NULL,
    idUsuario_FK INTEGER NOT NULL,
    PRIMARY KEY(idAluno),
    FOREIGN KEY(idCurso_FK) REFERENCES curso(idCurso),
    FOREIGN KEY(idUsuario_FK) REFERENCES usuario(idUsuario)
);

CREATE TABLE processos(
    idProcessos SERIAL,
    tipo VARCHAR(100) NOT NULL,
    idAluno_FK INTEGER NOT NULL,
    PRIMARY KEY(idProcessos),
    FOREIGN KEY(idAluno_FK) REFERENCES aluno(idAluno)
);

CREATE TABLE arquivo_upload_download(--Corrigir implementação
    idArquivo SERIAL,
    caminho VARCHAR(45) NOT NULL,
    dataArquivoEnviado DATE NOT NULL,
    dataArquivoRecebido DATE NOT NULL,
    idAluno_FK INTEGER NOT NULL,
    idMaster_FK INTEGER NOT NULL,
    idProcessos_FK INTEGER NOT NULL, --implementar na classe arquivo
    status VARCHAR(10),
    PRIMARY KEY(idArquivo),
    FOREIGN KEY(idAluno_FK) REFERENCES aluno(idAluno),
    FOREIGN KEY(idProcessos_FK) REFERENCES processos(idProcessos),
    FOREIGN KEY(idMaster_FK) REFERENCES master(idMaster)
);

CREATE TABLE cancelamentoMatricula(
    idCancelamentoMatricula SERIAL,
    justificativa VARCHAR(45) NOT NULL,
    dataCadastro DATE,
    PRIMARY KEY(idCancelamentoMatricula)
);

CREATE TABLE regimeDomiciliar(--Corrigir implementação (retirar o campo disciplina)
    idRegimeDomiciliar SERIAL,
    dataInicio DATE NOT NULL,
    dataFim DATE NOT NULL,
    dataCadastro DATE,
    situacao VARCHAR(45),
    tipo VARCHAR(10) NOT NULL,
    PRIMARY KEY(idRegimeDomiciliar)
);

CREATE TABLE dispensaDisciplina( --Alterado dia 11.11.2019 (corrigir implementação)
    idDispensaDisciplina SERIAL,
    idAluno_FK INTEGER NOT NULL,
    PRIMARY KEY(idDispensaDisciplina),
    FOREIGN KEY(idAluno_FK) REFERENCES aluno(idAluno)
);

CREATE TABLE disciplinaCursada(--corrigir implementação
    idDisciplinaCursada SERIAL,
    instituicaoOrigem VARCHAR(45) NOT NULL,
    curso VARCHAR(45) NOT NULL,
    disciplina VARCHAR(45) NOT NULL,
    creditos VARCHAR(45) NOT NULL,
    horasCursadas VARCHAR(45) NOT NULL,
    idDispensaDisciplina_FK INTEGER NOT NULL, --Adicionado dia 11.11.2019
    FOREIGN KEY(idDispensaDisciplina_FK) REFERENCES dispensaDisciplina(idDispensaDisciplina), --Adicionado dia 11.11.2019
    PRIMARY KEY(idDisciplinaCursada)
);

CREATE TABLE cancelamentoMatricula_Processo(
    idCancelamentoMatriculaProcesso SERIAL,
    dataProcesso DATE,
    dataEncerramento DATE,
    status VARCHAR(10),
    visibilidade VARCHAR(10),
    idProcessos_FK INTEGER NOT NULL,
    idCancelamentoMatricula_FK INTEGER NOT NULL,
    PRIMARY KEY(idCancelamentoMatriculaProcesso),
    FOREIGN KEY(idProcessos_FK) REFERENCES processos(idProcessos),
    FOREIGN KEY(idCancelamentoMatricula_FK) REFERENCES cancelamentoMatricula(idCancelamentoMatricula)
);

CREATE TABLE regimeDomiciliar_Processo(
    idRegimeDomiciliarProcesso SERIAL,
    dataProcesso DATE,
    dataEncerramento DATE,
    status VARCHAR(10),
    visibilidade VARCHAR(10),
    idProcessos_FK INTEGER NOT NULL,
    idRegimeDomiciliar_FK INTEGER NOT NULL,
    PRIMARY KEY(idRegimeDomiciliarProcesso),
    FOREIGN KEY(idProcessos_FK) REFERENCES processos(idProcessos),
    FOREIGN KEY(idRegimeDomiciliar_FK) REFERENCES regimeDomiciliar(idRegimeDomiciliar)
);

CREATE TABLE dispensaDisciplina_Processo(
    idDispensaDisciplinaProcesso SERIAL,
    dataProcesso DATE,
    dataEncerramento DATE,
    status VARCHAR(10),
    visibilidade VARCHAR(10),
    idProcessos_FK INTEGER NOT NULL,
    idDispensaDisciplina_FK INTEGER NOT NULL,
    PRIMARY KEY(idDispensaDisciplinaProcesso),
    FOREIGN KEY(idProcessos_FK) REFERENCES processos(idProcessos),
    FOREIGN KEY(idDispensaDisciplina_FK) REFERENCES dispensaDisciplina(idDispensaDisciplina)
);

CREATE TABLE regimeDisciplina(--Nova tabela criada entre Regime_Domiciliar e Disciplinas 11.11.2019
    idRegimeDisciplina SERIAL, -- falta implementar
    idRegimeDomiciliar_FK INTEGER NOT NULL, -- falta implementar
    idDisciplina_FK INTEGER NOT NULL, -- falta implementar
    PRIMARY KEY(idRegimeDisciplina), -- falta implementar
    FOREIGN KEY(idRegimeDomiciliar_FK) REFERENCES regimeDomiciliar(idRegimeDomiciliar), -- falta implementar
    FOREIGN KEY(idDisciplina_FK) REFERENCES disciplina(idDisciplina) -- falta implementar
);

CREATE TABLE disciplinaAtual(--Nova tabela criada entre Regime_Domiciliar e Disciplinas 11.11.2019
    idDisciplinaAtual SERIAL, -- Falta implementar
    idDispensaDisciplina_FK INTEGER NOT NULL, -- Falta implementar
    idDisciplina_FK INTEGER NOT NULL, -- Falta implementar
    PRIMARY KEY(idDisciplinaAtual), -- Falta implementar
    FOREIGN KEY(idDispensaDisciplina_FK) REFERENCES dispensaDisciplina(idDispensaDisciplina), -- Falta implementar
    FOREIGN KEY(idDisciplina_FK) REFERENCES disciplina(idDisciplina) -- Falta implementar
);


CREATE TABLE dispensaVinculo(--Nova tabela criada entre Regime_Domiciliar e Disciplinas 11.11.2019
    idDispensaVinculo SERIAL, -- Falta implementar
    idDispensaDisciplina_FK INTEGER NOT NULL, -- Falta implementar
    idDisciplinaAtual_FK INTEGER NOT NULL, -- Falta implementar
    idDisciplinaCursada_FK INTEGER NOT NULL, -- Falta implementar
    status VARCHAR(10), --Falta implementar
    PRIMARY KEY(idDispensaVinculo), -- Falta implementar
    FOREIGN KEY(idDispensaDisciplina_FK) REFERENCES dispensaDisciplina(idDispensaDisciplina), -- Falta implementar
    FOREIGN KEY(idDisciplinaCursada_FK) REFERENCES disciplinaCursada(idDisciplinaCursada), -- Falta implementar
    FOREIGN KEY(idDisciplinaAtual_FK) REFERENCES disciplinaAtual(idDisciplinaAtual) -- Falta implementar
);

--SCRIPT PARA ACESSO AO SISTEMA:
INSERT INTO public.usuario(idusuario, nome, cpf, cep, endereco, bairro, cidade, estado, perfil) VALUES ('1', 'Master', '-', '-', '-', '-', '-', '-', 'Funcionario');
INSERT INTO public.login(idlogin, email, senha, idusuario_fk) VALUES ('1', 'admin@admin.com', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', '1');

/*
ACESSO MASTER!
EMAIL: admin@admin.com
SENHA: admin
*/