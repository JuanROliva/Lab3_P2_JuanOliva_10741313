package lab3_p2_juanoliva_10741313;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> cartas = new ArrayList<Carta>();
    private ArrayList<Torre> torresArqueras = new ArrayList<Torre>();
    private Torre torreRey;

    public Jugador() {
    }
    
    public Jugador(String nombre, Torre torreRey) {
        this.nombre = nombre;
        this.torreRey = torreRey;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Torre> getTorres() {
        return torresArqueras;
    }

    public void setTorres(ArrayList<Torre> torres) {
        this.torresArqueras = torres;
    }

    public Torre getTorreRey() {
        return torreRey;
    }

    public void setTorreRey(Torre torreRey) {
        this.torreRey = torreRey;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", cartas=" + cartas + ", torres=" + torresArqueras + ", torreRey=" + torreRey + '}';
    }
    
    public boolean agregarCarta(Carta c){
        if (cartas.size()<6) {
            cartas.add(c);
            return true;
        }
        return false;
    }
    
    public boolean eliminarCarta(int posicion){
        if (posicion < 6) {
            cartas.remove(posicion);
            return true;
        }
        return false;
    }
    
    public void listarCartasJugador(){
        for (Carta carta : cartas) {
            System.out.println(cartas.indexOf(carta)+" " + carta);
        }
    }
    
    public boolean agregarTorre(Torre t){
        if (torresArqueras.size()<2) {
            torresArqueras.add(t);
            return true;
        }
        return false;
    }
    public void eliminarTorreRey(){
        this.setTorreRey(new TorreRey());
    }
    
    
    
}
