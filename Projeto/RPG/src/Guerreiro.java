import java.util.Random;

public class Guerreiro extends Personagem {

    Random aleatorio = new Random();
    private static final double aumentoDeDefesa = 1.1;
    private static final double aumentoDeVida = 1.2;
    private final int intervaloAtaqueCritico = 3;
    private final int criticoMin = 10;
    private final int criticoMax = 30;
    private final double reducaoDeDano = 0.9;
    int ataqueCritico = 0;
    
    public Guerreiro(String nome, double vida, double ataque, double defesa, double velocidade, double velocidadeDeAtaque, double mana, int nivel) {

        super ( nome,  (vida * aumentoDeVida), ataque, (defesa * aumentoDeDefesa), velocidade, velocidadeDeAtaque, mana, nivel);

    }

    @Override
    public double atacar(Personagem alvo) {

        double golpeCritico = 0;

        if(ataqueCritico >= intervaloAtaqueCritico) {
            golpeCritico = aleatorio.nextDouble(criticoMin, criticoMax);
            System.out.println("\n/Crítico aplicado");
            ataqueCritico = 0;
        }else {
            ataqueCritico ++;
        }

        double danoFinal = getAtaque() + (getAtaque() * (golpeCritico / 100));

        return danoFinal;

    }

    @Override
    public void receberDano(double dano) {

        double danoRecebido = dano * reducaoDeDano - getDefesa();

        if(danoRecebido <= 0) {
            danoRecebido = 0;
        }else {
            setVida(getVida() - danoRecebido);
        }

    }

}
