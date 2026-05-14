CREATE DATABASE rpg;

USE rpg;

CREATE TABLE tipos_personagem (
	id 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(40),
    vida DOUBLE,
    ataque DOUBLE,
    defesa DOUBLE,
    velocidade_movimento DOUBLE,
    velocidade_ataque DOUBLE,
    mana double,
    nivel int
);