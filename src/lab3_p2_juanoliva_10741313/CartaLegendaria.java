package lab3_p2_juanoliva_10741313;
public class CartaLegendaria extends Carta{
    private int ataque;
    private int vida;

    public CartaLegendaria() {
        super();
    }
    public CartaLegendaria(int ataque, int vida, double costoElixir, int velocidad, String nombre) {
        super(costoElixir, velocidad, nombre);
        this.ataque = ataque;
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
