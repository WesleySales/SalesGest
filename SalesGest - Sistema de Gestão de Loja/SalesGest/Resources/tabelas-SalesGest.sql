create database SalesGest;
use  SalesGest;


CREATE TABLE `cargo_funcionario` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cargo` varchar(40) DEFAULT NULL,
  `remuneracao_base` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ;

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ;

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(30) DEFAULT NULL,
  `sobrenome_funcionario` varchar(30) DEFAULT NULL,
  `login_funcionario` varchar(30) DEFAULT NULL,
  `senha_funcionario` varchar(30) DEFAULT NULL,
  `id_cargo` int(11) DEFAULT NULL,
  `telefone_funcionario` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `login_funcionario` (`login_funcionario`),
  KEY `id_cargo` (`id_cargo`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `cargo_funcionario` (`id_cargo`)
) ;

CREATE TABLE `item_venda` (
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) DEFAULT NULL,
  `valor_item` decimal(10,0) DEFAULT NULL,
  `id_venda` int(11) NOT NULL,
  PRIMARY KEY (`id_produto`,`id_venda`),
  KEY `id_venda` (`id_venda`),
  CONSTRAINT `item_venda_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`),
  CONSTRAINT `item_venda_ibfk_2` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`)
) ;

CREATE TABLE `pagamento` (
  `id_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_venda` int(11) DEFAULT NULL,
  `metodo_pagamento` enum('CARTAO','PIX','BOLETO') NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `status_pagamento` enum('PENDENTE','APROVADO','CANCELADO') DEFAULT 'PENDENTE',
  `data_pagamento` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id_pagamento`),
  KEY `id_venda` (`id_venda`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`)
) ;

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(30) DEFAULT NULL,
  `preco_produto` double DEFAULT NULL,
  `estoque` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produto`)
) ;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) DEFAULT NULL,
  `data_venda` date DEFAULT NULL,
  `valor_total_venda` decimal(10,0) DEFAULT NULL,
  `status_venda` enum('ABERTO','PAGO','CANCELADO') DEFAULT 'ABERTO',
  PRIMARY KEY (`id_venda`),
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`)
) ;

