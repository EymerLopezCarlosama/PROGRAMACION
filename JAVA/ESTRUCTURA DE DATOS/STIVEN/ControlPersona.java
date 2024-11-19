package STIVEN;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlPersona {
    
    ArrayList<Persona> registro = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    
    void agregarPersona(){
        System.out.println("Digite nombre: ");
        String nombre = entrada.next();
        System.out.println("Digite apellido: ");
        String apellido = entrada.next();
        System.out.println("Digite cédula: ");
        int cedula = entrada.nextInt();
        
        Persona persona = new Persona();
        persona.establecerNombre(nombre);
        persona.establecerApellido(apellido);
        persona.establecerCedula(cedula);
        
        registro.add(persona);
        System.out.println("Datos de la persona registrados con éxito.");
    }
    
    void consultarTodo(){
        if (registro.isEmpty()){
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Listando personas:");
            for (Persona persona : registro) {
                System.out.println(persona.obtenerNombre() + " " + persona.obtenerApellido() + " | C.C " + persona.obtenerCedula());               
            }
        }
    }

    void buscarPorCedula(){
        System.out.println("Buscando por cédula...");
        System.out.println("Digite la cédula a buscar:");
        int cedulaBuscada = entrada.nextInt();
        
        boolean encontrada = false;
        for (Persona persona : registro) {
            if (persona.obtenerCedula() == cedulaBuscada) {
                System.out.println("Nombre: " + persona.obtenerNombre());
                System.out.println("Apellido: " + persona.obtenerApellido());
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("Persona no encontrada.");
        }
    }
    
    void resetear(){
        registro.clear();
        System.out.println("Lista vacía.");
    }

    void mostrarMenu(){
        int opcion;
        do {
            System.out.println("\n ++++ MENU DE OPCIONES ++++");
            System.out.println("1. Registrar persona");
            System.out.println("2. Consultar todos los registros");
            System.out.println("3. Buscar por cédula");
            System.out.println("4. Resetear lista");
            System.out.println("5. Salir");
            System.out.print("Digite una opción: ");
            opcion = entrada.nextInt();
           
            switch (opcion) {
                case 1: agregarPersona(); break;
                case 2: consultarTodo(); break;
                case 3: buscarPorCedula(); break;
                case 4: resetear(); break;
                case 5: System.out.println("Saliendo del programa."); break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion > 0 && opcion < 5); 
    }
}
