package lab3_p2_juanoliva_10741313;
public class TorreRey extends Torre{
    private String nombreReino;

    public TorreRey() {
        super();
    }

    public TorreRey(String nombreReino, int vida) {
        super(vida);
        this.nombreReino = nombreReino;
    }

    public String getNombreReino() {
        return nombreReino;
    }

    public void setNombreReino(String nombreReino) {
        this.nombreReino = nombreReino;
    }

    @Override
    public String toString() {
        return super.toString() + " Rey";
    }
    
}
