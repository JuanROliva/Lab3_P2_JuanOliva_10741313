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
                case "1" -> inicio = false;
                case "2" -> agregarJugador();
                case "3" -> agregarCartaJugador();
                case "4" -> agregarTorreJugador();
                case "5" -> agregarTorreReyJugador();
                case "6" -> moficarJugador();
                case "7" -> listarJugador();
                case "8" -> listarJugadores();
                case "9" -> eliminarTorreArqueraJugador();
                case "10" -> eliminarTorreReyJugador();
                default -> System.out.println("Seleccion invalida");
            }
            if (!inicio) {
                System.out.println("Juego Terminado");
            }
            System.out.println("----------------------------------------------------");
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
        int numeroJugador = seleccionarJugador();
        System.out.println("Que tipo de carta desea agregar: ");
        System.out.println("""
                           1. Carta Especial
                           2. Carta Epica
                           3. Carta Legendaria
                           """);
        System.out.print("Ingrese la opcion que desea ejecutar");
        String opc = lea.nextLine();
        Jugador j = listaJugadores.get(numeroJugador);
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
    
    static int seleccionarJugador(){
        listarJugadores();
        System.out.print("Ingrese el No. del Jugador: ");
        String numeroJugadorCadena = lea.nextLine();
        int numeroJugador = 0;
        boolean flag = true;
        while (flag) {
            try {
                numeroJugador = Integer.parseInt(numeroJugadorCadena);
                if ((numeroJugador >= 0 && numeroJugador <= listaJugadores.size())) {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.print("Ingrese un valor entero entre 0 y  " + listaJugadores.size());
                numeroJugadorCadena = lea.nextLine();
            }
        }
        return numeroJugador;
    }

    static void listarJugadores() {
        if (listaJugadores.size() == 0) {
            System.out.println("Aun no ha registrador ningun jugador");
            return;
        }
        for (Jugador jugador : listaJugadores) {
            System.out.println(listaJugadores.indexOf(jugador) + " " + jugador.getNombre());
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
    
    static void agregarTorreJugador(){
        System.out.println("Para agregar la Torre Arquera identifique el jugador a modificar");
        int numeroJugador = seleccionarJugador();
        int vida = retornoVida();
        int ataque = retornoAtaque();
        listaJugadores.get(numeroJugador).agregarTorre(new TorreArquera(ataque, vida));
    }
    
    static void agregarTorreReyJugador(){
        System.out.println("Para agregar la Torre Rey identifique el jugador a modificar");
        int numeroJugador = seleccionarJugador();
        int vida = retornoVida();
        System.out.print("Ingrese el nombre del Reino: ");
        String nombreReino = lea.nextLine();
        listaJugadores.get(numeroJugador).setTorreRey(new TorreRey(nombreReino, vida));
    }

    static void moficarJugador(){
        if (listaJugadores.size()>0) {
            int numeroJugador = seleccionarJugador();
            System.out.println("Ingrese el nuevo nombre del Jugador");
            listaJugadores.get(numeroJugador).setNombre(lea.nextLine());
        }else{
            System.out.println("No hay jugadores registrados");
        }
    }
    
    static void listarJugador(){
        System.out.println("Identifique el Jugador al cual quiere listar sus caracteristicas");
        int numeroJugador = seleccionarJugador();
        listaJugadores.get(numeroJugador).toString();
    }
    
    static void eliminarTorreArqueraJugador(){
        System.out.println("Identifique el Jugador a Eliminar Torres Aqueras");
        int numeroJugador = seleccionarJugador();
        Jugador j = listaJugadores.get(numeroJugador);
        if (!j.tieneTorresArqueras()) {
            System.out.println("El jugador no tiene Torres Arqueras");
            return;
        }
        int cantidadTorres = j.cantidadTorresArqueras();
        switch (cantidadTorres) {
            case 1:
                System.out.println("El jugador solo tiene una torre arquera");
                System.out.print("Desea Eliminarla? S/N: ");
                String resp = lea.nextLine();
                if (resp.toLowerCase().charAt(0) == 's') {
                    j.setTorres(new ArrayList<Torre>());
                }else{
                    System.out.println("Seleccion invalida");
                }
                break;
                
            case 2:
                System.out.println("Que desea hacer:");
                System.out.println("""
                                   1. Eliminar Torre Arquera 1
                                   2. Eliminar Torre Arquera 2
                                   3. Eliminar las dos torres;
                                   """);
                String seleccion = lea.nextLine();
                switch (seleccion) {
                    case "1":
                        j.eliminarTorreArquera(0);
                        System.out.println("Torre Arquera 1 eliminada con exito");
                        break;
                    case "2":
                        j.eliminarCarta(1);
                        System.out.println("Torre Arquera 2 eliminada con exito");
                        break;
                    case "3":
                        j.eliminarTorreArquera(0);
                        j.eliminarTorreArquera(1);
                        System.out.println("Torres Arqueras eliminadas con exito");
                        break;
                    default:
                        System.out.println("Seleccion invalida");
                        break;
                }
                break;
        }
    }
    
    static void eliminarTorreReyJugador(){
        System.out.println("Seleccion el Jugador a eliminar Torre Rey");
        int numeroJugador = seleccionarJugador();
        Jugador j = listaJugadores.get(numeroJugador);
        if (j.getTorreRey() == null) {
            System.out.println("El jugador no tiene Torre Rey");
        }else{
            j.eliminarTorreRey();
            System.out.println("Torre Rey Elimina con exito");
        }
    }
    
}
