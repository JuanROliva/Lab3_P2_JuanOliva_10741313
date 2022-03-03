package lab3_p2_juanoliva_10741313;

public class CartaEspecial extends Carta{
    private  int vida;

    public CartaEspecial() {
        super();
    }

    public CartaEspecial(int vida, double costoElixir, int velocidad, String nombre) {
        super(costoElixir, velocidad, nombre);
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
