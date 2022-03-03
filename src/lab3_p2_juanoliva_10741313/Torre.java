package lab3_p2_juanoliva_10741313;
class Torre {
    private int vida;

    public Torre() {
    }

    public Torre(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Torre";
    }
}
