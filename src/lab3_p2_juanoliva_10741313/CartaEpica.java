package lab3_p2_juanoliva_10741313;
public class CartaEpica extends Carta{
    private int ataque;

    public CartaEpica() {
        super();
    }

    public CartaEpica(int ataque, double costoElixir, int velocidad, String nombre) {
        super(costoElixir, velocidad, nombre);
        this.ataque = ataque;
    }
    
    public CartaEpica(int ataque, Carta c) {
        super(c.getCostoElixir(), c.getVelocidad(), c.getNombre());
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
        return "CartaEpica " + super.toString() + " ataque=" + ataque;
    }

    
}
