USE rpg;

INSERT INTO tipos_personagem (
	tipo,
    vida,
    ataque,
    defesa,
    velocidade_movimento,
    velocidade_ataque,
    mana,
    nivel
) 
VALUES 
	('Guerreiro', 300, 50, 30, 8, 10, 0, 1),
    ('Arqueiro', 260, 45, 20, 12, 15, 20, 1),
    ('Mago', 240, 60, 15, 8, 8, 100, 1);