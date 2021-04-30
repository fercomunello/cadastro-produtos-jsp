CREATE DATABASE IF NOT EXISTS `produtos_web`;

USE `produtos_web`;

CREATE TABLE IF NOT EXISTS `produto` (
    `codigo` INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    `descricao` VARCHAR(255) NOT NULL,
    `marca` VARCHAR(255),
    `preco` DECIMAL(10, 2),
    PRIMARY KEY (`codigo`)
);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 1, 'Produto 1', 'Marca 1', 49.88
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 1);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 2, 'Produto 2', 'Marca 2', 11.29
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 2);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 3, 'Produto 3', 'Marca 3', 99.10
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 3);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 4, 'Produto 4', 'Marca 4', 1000.00
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 4);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 5, 'Produto 5', 'Marca 5', 800.99
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 5);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 6, 'Produto 6', 'Marca 6', 1545.84
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 6);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 7, 'Produto 7', 'Marca 7', 5000.0
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 7);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 8, 'Produto 8', 'Marca 8', 3700.00
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 8);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 9, 'Produto 9', 'Marca 9', 550.00
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 9);

INSERT INTO `produto` (`codigo`, `descricao`, `marca`, `preco`) SELECT 10, 'Produto 10', 'Marca 10', 988.0
FROM DUAL WHERE NOT EXISTS (SELECT `codigo` FROM `produto` WHERE `codigo` = 10);