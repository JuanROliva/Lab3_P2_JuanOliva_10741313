package lab3_p2_juanoliva_10741313;
class Carta {
    private double costoElixir;
    private int velocidad;
    private String nombre;

    public Carta() {
    }

    public Carta(double costoElixir, int velocidad, String nombre) {
        this.costoElixir = costoElixir;
        this.velocidad = velocidad;
        this.nombre = nombre;
    }
    
    public double getCostoElixir() {
        return costoElixir;
    }

    public void setCostoElixir(double costoElixir) {
        this.costoElixir = costoElixir;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "costoElixir=" + costoElixir + ", velocidad=" + velocidad + ", nombre=" + nombre;
    }
}
