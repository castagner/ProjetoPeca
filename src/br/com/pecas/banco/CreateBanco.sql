CREATE TABLE `peca` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `peso` double(2,0),
  `tipo` varchar(15) DEFAULT NULL,
  `datacadastro` date,
  `valor` double(3,2),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;