import java.util.Random;

public class Arqueiro extends Personagem {
    
    Random aleatorio = new Random();
    private static final double aumentoDeVelocidadeAtaque = 1.4;
    private static final double aumentoDeVelocidade = 1.2;
    private final int multiplicadorEsquiva = 5;
    private final int esquivaBase = 20;
    private final int chanceEsquivaParcial = 3;
    private final int maximaChanceDeEsquiva = 40; 

    public Arqueiro(String nome, double vida, double ataque, double defesa, double velocidade, double velocidadeDeAtaque, int nivel) {

        super ( nome,  vida, ataque, defesa, (velocidade * aumentoDeVelocidade), (velocidadeDeAtaque * aumentoDeVelocidadeAtaque), nivel);

    }

    @Override
    public void receberDano(double dano) {

        int chanceEsquiva = aleatorio.nextInt(100) + 1; 
        int esquivaParcial = aleatorio.nextInt(chanceEsquivaParcial) + 1;
        double danoRecebido = dano;
        boolean esquiva = false;

        double esquivaTotal = esquivaBase + (aumentoDeVelocidade * multiplicadorEsquiva);

        if(esquivaTotal > maximaChanceDeEsquiva) esquivaTotal = 40;

        if (chanceEsquiva <= esquivaTotal) {
            esquiva = true;
            System.out.println("\nEsquiva aplicada");
        }

        if(esquiva) {

            if (esquivaParcial < chanceEsquivaParcial) {
                danoRecebido = dano / chanceEsquivaParcial;
                System.out.println("\nEsquiva parcial aplicada");
                }else { 
                    danoRecebido = 0;
                }

        }

        setVida(getVida() - danoRecebido);

    }

}
