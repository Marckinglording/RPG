public class Assassino extends Personagem {

    private static final double reducaoDevida = 0.75;
    private static final double aumentoDeAtaque = 1.6;
    private static final double reducaoDeDefesa = 0.6;
    private static final double aumentoDeVelocidade = 1.4;
    private static final double aumentoDeVelocidadeAtaque = 1.2;

    public Assassino(String nome, double vida, double ataque, double defesa, double velocidade, double velocidadeDeAtaque, double mana, int nivel) {

        super ( nome,  (vida * reducaoDevida), (ataque * aumentoDeAtaque), (defesa * reducaoDeDefesa), (velocidade * aumentoDeVelocidade), (velocidadeDeAtaque * aumentoDeVelocidadeAtaque), mana, nivel);

    }

    
}
