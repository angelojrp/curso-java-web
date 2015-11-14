CREATE DATABASE IF NOT EXISTS `curso-java-web`;
USE `curso-java-web`;

-- TABELAS DE AUTENTICACAO
CREATE TABLE IF NOT EXISTS `perfil_usuario` (
  `email` varchar(15) NOT NULL,
  `nome_perfil` varchar(15) NOT NULL,
  PRIMARY KEY (`email`,`nome_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE  TABLE IF NOT EXISTS  `usuario` (
  `email` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABELAS DE APOIO

CREATE TABLE IF NOT EXISTS `curso-java-web`.`UF` (
  `sigla` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sigla`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `curso-java-web`.`categoria` (
  `id_categoria` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- CARGA BASICA - LIMPA A BASE E INSERE NOVAMENTE TODOS OS REGISTROS
TRUNCATE TABLE `curso-java-web`.`UF`;
INSERT INTO `curso-java-web`.`UF` VALUES
('AC','Acre'), ('AL','Alagoas'),('AP','Amapá'),('AM','Amazonas'),('BA','Bahia'),
('CE','Ceará'),('DF','Distrito Federal'),('ES','Espírito Santo'),('GO','Goiás'),
('MA','Maranhão'),('MT','Mato Grosso'),('MS','Mato Grosso do Sul'),('MG','Minas Gerais'),
('PA','Pará'),('PB','Paraíba'),('PR','Paraná'),('PE','Pernambuco'),('PI','Piauí'),
('RJ','Rio de Janeiro'),('RN','Rio Grande do Norte'),('RS','Rio Grande do Sul'),
('RO','Rondônia'),('RR','Roraima'),('SC','Santa Catarina'),('SP','São Paulo'),
('SE','Sergipe'),('TO','Tocantins');

TRUNCATE TABLE `curso-java-web`.`categoria`;
INSERT INTO `curso-java-web`.`categoria` (`nome`) VALUES
('Animais'),
('Esportes'),
('Casa e Utensílios'),
('Eletrônicos'),
('Celulares'),
('Música e hobbies'),
('Moda infantil'),
('Moda adulto'),
('Carros e Motos'),
('Imóveis'),
('Empregos');


-- NOTA: A partir deste ponto cada aluno deve inserir a estrutura do seu projeto.

-- TABELA DE ANÚNCIOS (APENAS UM EXEMPLO, CADA ALUNO DEVE ALTERAR DE ACORDO COM A FUNCIONALIDADE PROPOSTA)
CREATE TABLE IF NOT EXISTS `curso-java-web`.`anuncio` (
  `id_anuncio` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(5000) NOT NULL,
  `sigla_uf` VARCHAR(2) NOT NULL,
  `id_categoria` BIGINT NOT NULL,
  PRIMARY KEY (`id_anuncio`),
  INDEX `fk_anuncio_uf_idx` (`sigla_uf` ASC),
  INDEX `fk_anuncio_categoria_idx` (`id_categoria` ASC),
  INDEX `titulo_idx` (`titulo` ASC), -- NOTEM QUE FOI CRIADO UM INDICE PARA O TITULO, ISTO TORNA AS PESQUISAS MAIS RÁPIDAS
  CONSTRAINT `fk_anuncio_uf`
    FOREIGN KEY (`sigla_uf`)
    REFERENCES `curso-java-web`.`UF` (`sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anuncio_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `curso-java-web`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE=InnoDB DEFAULT CHARSET=latin1;
