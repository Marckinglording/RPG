public class App {
    public static void main(String[] args) throws Exception {
        
        Personagem lucksky = new Arqueiro("Lucksky", 300, 50, 30, 15, 8, 1);
        Personagem marckinglord = new Mago("Marcking", 300, 50, 30, 15, 8, 1);
        Personagem firefly = new Guerreiro("Firefly", 300, 50, 30, 15, 1)

        lucksky.mostrarStatus();
        marckinglord.mostrarStatus();

        int turno = 1;

        while (true) {
            
            System.out.println("\n========== TURNO " + turno + " ==========");

            if(lucksky.getVida() > 0) {

                marckinglord.carregarAtaque();

                if(marckinglord.podeAtacar()) {

                    double danoFinal = marckinglord.atacar(lucksky);
                    
                    if (danoFinal > 0) {
                        lucksky.receberDano(danoFinal);
                    }
                
                    lucksky.mostrarVida();
                    marckinglord.resetarAtaque();

                    System.out.println("\n" + marckinglord.getNome() + " atacou!");

                }
                
            }else {
                System.out.println("\nO arqueiro foi morto");
                break;
            }

            if(marckinglord.getVida() > 0) {

                lucksky.carregarAtaque();

                if(lucksky.podeAtacar()) {

                    double danoFinal = lucksky.atacar(marckinglord);
                    marckinglord.receberDano(danoFinal);
                    marckinglord.mostrarVida();
                    lucksky.resetarAtaque();

                    System.out.println("\n" + lucksky.getNome() + " atacou!");

                }

            }else {
                System.out.println("\nO mago foi morto");
                break;
            }

            lucksky.atualizarEfeitos();
            marckinglord.atualizarEfeitos();

            turno++;

        }

    }
}
