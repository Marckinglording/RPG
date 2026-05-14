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
	('Guerreiro', 300, 50, 30, 10, 10, 0, 1),
    ('Arqueiro', 300, 50, 30, 10, 10, 20, 1),
    ('Mago', 300, 50, 30, 10, 10, 100, 1);
    
    -- ALTERAR PARA:
    
    -- ('Guerreiro', 360, 50, 33, 10, 10, 0, 1),
    -- ('Arqueiro', 300, 55, 30, 12, 14, 20, 1),
    -- ('Mago', 210, 70, 24, 11, 8, 100, 1);