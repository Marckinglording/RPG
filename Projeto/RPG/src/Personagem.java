public class Personagem {
    
    private String nome;
    private double vida;
    private double ataque;
    private double ataqueBase;
    private double defesa;
    private double velocidade;
    private double velocidadeDeMovimentoBase;
    private double velocidadeDeAtaque;
    private double velocidadeDeAtaqueBase;
    private double tempoDeAtaque = 0;
    private double mana;
    private int nivel;

    private int turnosVelocidadeReduzida = 0;
    private boolean efeitoVelocidadeAtivo = false;

    private int turnosAtaqueReduzido = 0;
    private boolean efeitoAtaqueReduzidoAtivo = false;

    public Personagem(String nome, double vida, double ataque, double defesa, double velocidade, double velocidadeDeAtaque, double mana, int nivel) {

        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.ataqueBase = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.velocidadeDeMovimentoBase = velocidade;
        this.velocidadeDeAtaque = velocidadeDeAtaque;
        this.velocidadeDeAtaqueBase = velocidadeDeAtaque;
        this.mana = mana;
        this.nivel = nivel;

    }

    public void aplicarReducaoDeVelocidade(double reducaoMovimento, double reducaoAtaque, int turnos) {
        
        double velocidadeAtualReduzida = (this.velocidadeDeMovimentoBase * (1 - (reducaoMovimento / 100))); 
        double velocidadeAtualAtaqueReduzida = (this.velocidadeDeAtaqueBase * (1 - (reducaoAtaque / 100)));
        this.velocidade = velocidadeAtualReduzida;
        this.velocidadeDeAtaque = velocidadeAtualAtaqueReduzida;
        turnosVelocidadeReduzida = turnos;
        efeitoVelocidadeAtivo = true;
    }

    public void reduzirAtaque(double reducaoPercentualDeAtaque, int turnos) {
        double ataqueAtual = (ataqueBase * (reducaoPercentualDeAtaque / 100)) ;
        this.ataque = ataqueAtual;
        turnosAtaqueReduzido = turnos;
        efeitoAtaqueReduzidoAtivo = true;
    }

    public void receberDanoIgnorandoDefesa(double dano) {
        setVida(getVida() - dano);
    }

    public void atualizarEfeitos() {

        if (turnosVelocidadeReduzida <= 0) {
            efeitoVelocidadeAtivo = false;
        }

        if (efeitoVelocidadeAtivo) {
            turnosVelocidadeReduzida --;
        }else {
            this.velocidadeDeAtaque = velocidadeDeAtaqueBase;
            this.velocidade = velocidadeDeMovimentoBase;
        }   


        if (turnosAtaqueReduzido <= 0) {
            efeitoAtaqueReduzidoAtivo = false;
        }

        if (efeitoAtaqueReduzidoAtivo) {
           turnosAtaqueReduzido --;
        }else {
            this.ataque = ataqueBase;
        }

    }

    public void carregarAtaque() {
        tempoDeAtaque += velocidadeDeAtaque;
    }

    public boolean podeAtacar() {
        return tempoDeAtaque >= 100;
    }

    public void resetarAtaque() {
        tempoDeAtaque = 0;
    }

    public double atacar(Personagem alvo) {

        return ataque;

    }

    public void receberDano(double dano) {

        double danoRecebido = dano - defesa;

        if(danoRecebido <= 0) {
            danoRecebido = 0;
        }else {
            vida -= danoRecebido;
        }

    }

    public void mostrarStatus() {

        System.out.println("\n" + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Defesa: " + this.defesa);
        System.out.println("Velocidade: " + this.velocidade);
        System.out.println("Velocidade de ataque: " + this.velocidadeDeAtaque);
        System.out.println("Mana: " + this.mana);
        System.out.println("Nível: " + this.nivel);

    }
    
    public void mostrarVida() {

        System.out.println("\nO " + this.nome + " tem vida de " + this.vida);

    } 

    public String getNome() {
        return nome;
    }

    
    public double getVida() {
        return vida;
    }

    public void setVida(double novaVida) {
        if(novaVida >= 0) {
            this.vida = novaVida;
        }else {
            this.vida = 0;
        }
    }

    public double getAtaque() {
        return ataque;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double novaDefesa) {
        this.defesa = novaDefesa;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getVelocidadeDeAtaque() {
        return velocidadeDeAtaque;
    }

    public int getNivel() {
        return nivel;
    }

    public double getTempoDeAtaque() {
        return tempoDeAtaque;
    }

    public void setTempoDeAtaque(double novoTempoDeAtaque) {
        this.tempoDeAtaque = novoTempoDeAtaque;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double novaMana) {
        this.mana = novaMana;
    }

}