package lab3_p2_juanoliva_10741313;

import java.util.ArrayList;
import java.util.Scanner;

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

    private static void agregarCartaJugador() {
        listarJugadores();
        System.out.print("Ingrese el No. del Jugador aquien desea agregar la carta");
        String numeroJugador = lea.nextLine();
        int posicion;
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
    }

    private static void listarJugadores() {
        if (listaJugadores.size() == 0) {
            System.out.println("Aun no ha registrador ningun jugador");
            return;
        }
        for (Jugador jugador : listaJugadores) {
            System.out.println(listaJugadores.indexOf(jugador) + " " + jugador);
        }
    }
    
//    private Carta crearCartaEspecial(){
//        System.out.println("Ingrese el costo de eli");
//        
//    }
//    
}
