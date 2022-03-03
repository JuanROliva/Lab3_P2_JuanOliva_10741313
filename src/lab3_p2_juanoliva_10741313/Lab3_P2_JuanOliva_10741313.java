package lab3_p2_juanoliva_10741313;
public class Lab3_P2_JuanOliva_10741313 {

    public static void main(String[] args) {
        boolean inicio = true;
        encabezado();
        while (inicio) {
            
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
    
    public void menu(){
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
        
    }
}
