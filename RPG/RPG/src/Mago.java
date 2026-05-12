import java.util.Random;

public class Mago extends Personagem {

    Random aleatorio = new Random();
    private static final double reducaoDeVelocidadeAtaque = 0.8;
    private static final double aumentoDeVelocidade = 1.1;
    private static final double aumentoDeAtaque = 1.2;
    private double mana;
    private double ganhoDeMana;
    private final int reducaoAtaqueMin = 20;
    private final int reducaoAtaqueMax = 40;
     private final int reducaoVelocidadeMin = 10;
    private final int reducaoVelocidadeMax = 30;
     private final int reducaoVelocidadeAtaqueMin = 10;
    private final int reducaoVelocidadeAtaqueMax = 40;
    private double manaReduzirVelocidade = 30;
    private double manaReduzirAtaque = 50;
    private double manaIgnorardefesa = 100;
    
    public Mago(String nome, double vida, double ataque, double defesa, double velocidade, double velocidadeDeAtaque, int nivel) {

        super ( nome,  vida, (ataque * aumentoDeAtaque), defesa, (velocidade * aumentoDeVelocidade), (velocidadeDeAtaque * reducaoDeVelocidadeAtaque), nivel);

    }

    @Override
    public double atacar(Personagem alvo) {

        boolean ataqueMagicoAtivado = aleatorio.nextBoolean();
        int ataqueMagico = aleatorio.nextInt(3);
        int turnoMagiaAplicada = aleatorio.nextInt(3) + 1;
        double reducaoDeAtaque = aleatorio.nextDouble(reducaoAtaqueMin,reducaoAtaqueMax);
        double reducaoDeVelocidadeMovimento = aleatorio.nextDouble(reducaoVelocidadeMin,reducaoVelocidadeMax);
        double reducaoDeVelocidadeAtaque = aleatorio.nextDouble(reducaoVelocidadeAtaqueMin,reducaoVelocidadeAtaqueMax);

        ganhoDeMana = aleatorio.nextDouble(20) + 1;
        mana += ganhoDeMana;

        if(ataqueMagicoAtivado) {
            
            if(ataqueMagico == 0 && mana >= manaReduzirVelocidade) {
                alvo.aplicarReducaoDeVelocidade(reducaoDeVelocidadeMovimento, reducaoDeVelocidadeAtaque, turnoMagiaAplicada);
                mana -= manaReduzirVelocidade;
                return 0;
            }

            if(ataqueMagico == 1 && mana >= manaReduzirAtaque) {
                alvo.reduzirAtaque(reducaoDeAtaque, turnoMagiaAplicada);
                mana -= manaReduzirAtaque;
                return 0;
            }

            if(ataqueMagico == 2 && mana >= manaIgnorardefesa) {
                alvo.receberDanoIgnorandoDefesa(getAtaque());
                mana -= manaIgnorardefesa;
                return 0;
            }

        }

        return getAtaque();

    }
    
}
