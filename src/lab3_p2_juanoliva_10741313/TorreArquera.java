package lab3_p2_juanoliva_10741313;
public class TorreArquera extends Torre{
    private int ataque;

    public TorreArquera() {
        super();
    }

    public TorreArquera(int ataque, int vida) {
        super(vida);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public String toString() {
        return "TorreArquera " + super.toString() +  " ataque=" + ataque;
    }
    
}
