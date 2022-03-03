package lab3_p2_juanoliva_10741313;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab3_P2_JuanOliva_10741313 {
    
    static Scanner lea = new Scanner(System.in);
    static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    public static void main(String[] args) {
        boolean inicio = true;
        encabezado();
        while (inicio) {
            String opc = menu();
            switch (opc) {
                case "1":
                    agregarJugador();
                    break;
                case "2":
                    agregarCartaJugador();
                    break;
                    
                case "8":
                    listarJugadores();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    static void encabezado(){
        System.out.println("""
                           Universidad Tecnológica Centroamericana
                           Alumno: Juan Rafael Oliva Caballero
                           Clase: Laboratorio de Programacion II
                           Fecha: 3 de marzo 2022;
                           ---------------------------------------------------------
                           """);
    }
    
    static String menu(){
        System.out.println("""
                           Menu
                           1. Salir
                           2. Agregar Jugador
                           3. Agregar Carta
                           4. Agregar Torre Arquera
                           5. Agregar Torre Rey
                           6. Editar Jugador
                           7. Listar Jugador
                           8. Listar Jugadores
                           9. Eliminar Torre Arquera a Jugador
                           10. Eliminar Torre Rey a Jugador
                           """);
        System.out.print("Ingrese la opcion que desea: ");
        return lea.nextLine();
    }
    
    static void agregarJugador(){
        System.out.print("Ingrese el nombre del Jugador: ");
        Jugador j = new Jugador(lea.nextLine());
        listaJugadores.add(j);
    }

    static void agregarCartaJugador() {
        listarJugadores();
        System.out.print("Ingrese el No. del Jugador aquien desea agregar la carta");
        String numeroJugador = lea.nextLine();
        int posicion = 0;
        boolean flag = true;
        while (flag) {
            try {
                posicion = Integer.parseInt(numeroJugador);
                if ((posicion >= 0 && posicion <= listaJugadores.size())) {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.print("Ingrese un valor entero entre 0 y  " + listaJugadores.size());
                numeroJugador = lea.nextLine();
            }
        }
        
        System.out.println("Que tipo de carta desea agregar: ");
        System.out.println("""
                           1. Carta Especial
                           2. Carta Epica
                           3. Carta Legendaria
                           """);
        System.out.print("Ingrese la opcion que desea ejecutar");
        String opc = lea.nextLine();
        Jugador j = listaJugadores.get(posicion);
        Carta c = new Carta();
        switch (opc) {
            case "1":
                c = crearCartaEspecial();
                j.agregarCarta(c);
                System.out.println("Carta Agregada Exitosamente");
                break;
            case "2":
                c = crearCartaEpica();
                j.agregarCarta(c);
                System.out.println("Carta Agregada Exitosamente");
                break;
            case "3":
                c = crearCartaLegendaria();
                j.agregarCarta(c);
                System.out.println("Carta Agregada Exitosamente");
                break;
            default:
                System.out.println("Opcion invalida");
        }
        
    }

    static void listarJugadores() {
        if (listaJugadores.size() == 0) {
            System.out.println("Aun no ha registrador ningun jugador");
            return;
        }
        for (Jugador jugador : listaJugadores) {
            System.out.println(listaJugadores.indexOf(jugador) + " " + jugador);
        }
    }
    
    static Carta crearCarta(){
        System.out.print("Ingrese el costo del Elixir: ");
        String costoElixirCadena = lea.nextLine();
        double costoElixir = 0;
        boolean flag = true;
        while (flag) {
            try {
                costoElixir = Double.parseDouble(costoElixirCadena);
                if (costoElixir>0) {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.print("Ingrese un valor double positivo: ");
                costoElixirCadena = lea.nextLine();
            }
        }
        
        
        System.out.print("Ingrese la velocidad: ");
        String velocidadCadena = lea.nextLine();
        int velocidad = 0;
        boolean flag1 = true;
        while (flag1) {
            try {
                velocidad = Integer.parseInt(velocidadCadena);
                if (velocidad>0) {
                    flag1 = false;
                }
            } catch (Exception e) {
                System.out.print("Ingrese un valor entero positivo: ");
                velocidadCadena = lea.nextLine();
            }
        }
        
        System.out.print("Ingrese el nombre de la carta: ");
        String nombreCarta = lea.nextLine();
        Carta c= new Carta(costoElixir, velocidad, nombreCarta);
        return c;
    }
    
    static CartaEspecial crearCartaEspecial(){
        Carta c = crearCarta();
        int vida = retornoVida();
        CartaEspecial ce = new CartaEspecial(vida, c);
        return ce;
    }
    
    static int retornoVida(){
        System.out.print("Ingrese la vida: ");
        String vidaCadena = lea.nextLine();
        int vida = 0;
        boolean flag = true;
        while (flag) {
            try {
                vida = Integer.parseInt(vidaCadena);
                if (vida>0) {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.print("Ingrese un valor entero positivo: ");
                vidaCadena= lea.nextLine();
            }
        }
        return vida;
    }
    
    static CartaEpica crearCartaEpica(){
        Carta c = crearCarta();
        int ataque = retornoAtaque();
        CartaEpica ce = new CartaEpica(ataque, c);
        return ce;
    }
    
    static int retornoAtaque(){
        System.out.print("Ingrese el ataque: ");
        String ataqueCadena = lea.nextLine();
        int ataque = 0;
        boolean flag = true;
        while (flag) {
            try {
                ataque = Integer.parseInt(ataqueCadena);
                if (ataque>0) {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.print("Ingrese un valor entero positivo: ");
                ataqueCadena= lea.nextLine();
            }
        }
        return ataque;
    }
    
    static CartaLegendaria crearCartaLegendaria(){
        Carta c = crearCarta();
        int vida = retornoVida();
        int ataque = retornoAtaque();
        CartaLegendaria cl = new CartaLegendaria(ataque, vida, c);
        return cl;
    }
}
