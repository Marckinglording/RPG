import java.util.Random;

public class Mago extends Personagem {

    Random aleatorio = new Random();
    private static final double reducaoDeVelocidadeAtaque = 0.8;
    private static final double reducaoDevida = 0.7;
    private static final double reducaoDeDefesa = 0.8;
    private static final double aumentoDeVelocidade = 1.1;
    private static final double aumentoDeAtaque = 1.4;
    private final int reducaoAtaqueMin = 20;
    private final int reducaoAtaqueMax = 40;
    private final int reducaoVelocidadeMin = 10;
    private final int reducaoVelocidadeMax = 30;
    private final int reducaoVelocidadeAtaqueMin = 10;
    private final int reducaoVelocidadeAtaqueMax = 40;
    private double ganhoDeMana;
    private double ganhoDeManaPorAtaque = 10;    
    private double manaReduzirVelocidade = 50;
    private double manaReduzirAtaque = 80;
    private double manaIgnorardefesa = 150;
    
    public Mago(String nome, double vida, double ataque, double defesa, double velocidade, double velocidadeDeAtaque, double mana, int nivel) {

        super (nome,  (vida * reducaoDevida), (ataque * aumentoDeAtaque), (defesa * reducaoDeDefesa), (velocidade * aumentoDeVelocidade), (velocidadeDeAtaque * reducaoDeVelocidadeAtaque), mana, nivel);

    }

    @Override
    public double atacar(Personagem alvo) {

        boolean ataqueMagicoAtivado = aleatorio.nextBoolean();
        int ataqueMagico = aleatorio.nextInt(3);
        int turnoMagiaAplicada = aleatorio.nextInt(3) + 1;
        double reducaoDeAtaque = aleatorio.nextDouble(reducaoAtaqueMin,reducaoAtaqueMax);
        double reducaoDeVelocidadeMovimento = aleatorio.nextDouble(reducaoVelocidadeMin,reducaoVelocidadeMax);
        double reducaoDeVelocidadeAtaque = aleatorio.nextDouble(reducaoVelocidadeAtaqueMin,reducaoVelocidadeAtaqueMax);

        ganhoDeMana = aleatorio.nextDouble(ganhoDeManaPorAtaque) + 1;
        setMana(getMana() + ganhoDeMana);

        if(ataqueMagicoAtivado) {
            
            if(ataqueMagico == 0 && getMana() >= manaReduzirVelocidade) {
                alvo.aplicarReducaoDeVelocidade(reducaoDeVelocidadeMovimento, reducaoDeVelocidadeAtaque, turnoMagiaAplicada);
                setMana(getMana() - manaReduzirVelocidade);
                return 0;
            }

            if(ataqueMagico == 1 && getMana() >= manaReduzirAtaque) {
                alvo.reduzirAtaque(reducaoDeAtaque, turnoMagiaAplicada);
                setMana(getMana() - manaReduzirAtaque);
                return 0;
            }

            if(ataqueMagico == 2 && getMana() >= manaIgnorardefesa) {
                alvo.receberDanoIgnorandoDefesa(getAtaque());
                setMana(getMana() - manaIgnorardefesa);
                return 0;
            }

        }

        return getAtaque();

    }
    
}
