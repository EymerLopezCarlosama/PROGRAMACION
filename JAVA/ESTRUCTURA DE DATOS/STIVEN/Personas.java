package STIVEN;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Personas {
    // Declaración de atributos
    int[] personas = new int[6]; // Arreglo para almacenar las edades de 6 personas
    Scanner in = new Scanner(System.in); // Objeto para leer entradas desde el teclado

    // ------------------------------- MÉTODO: Llenar arreglo manualmente -------------------------------
    void llenarArreglo() {
        System.out.println("---LLENAR ARREGLO---");
        for (int i = 0; i < personas.length; i++) { // Iterar sobre cada posición del arreglo
            int edad = -1; // Variable para almacenar la edad ingresada por el usuario
            while (edad <= 0) { // Validar que la edad ingresada sea mayor a 0
                System.out.println("Digite la Edad:");
                edad = in.nextInt(); // Leer la edad ingresada
                if (edad <= 0) { // Si la edad es negativa o cero, mostrar un mensaje de error
                    System.out.println("El número ingresado es negativo o cero, intente nuevamente...");
                }
            }
            personas[i] = edad; // Almacenar la edad válida en el arreglo
        }
        Arrays.sort(personas); // Ordenar el arreglo
        System.out.println("Arreglo llenado y ordenado:");
        for (int num : personas) { // Imprimir el arreglo ordenado
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea
    }

    // ------------------------------- MÉTODO: Búsqueda lineal -------------------------------
    void busquedaLineal() {
        System.out.println("BUSCANDO EDAD (Búsqueda Lineal)");
        System.out.print("Ingrese la edad a buscar: ");
        int edadBuscar = in.nextInt(); // Edad ingresada por el usuario
        boolean encontrado = false; // Indica si la edad fue encontrada (por defecto es false)

        // Bucle para recorrer el arreglo y buscar la edad
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == edadBuscar) {
                // Si la edad es encontrada, mostrar su posición y cambiar la bandera a true
                System.out.println("Edad encontrada en la posición: " + i);
                encontrado = true; // Cambia a true indicando que la búsqueda fue exitosa
                break; // Termina el bucle al encontrar la edad
            }
        }

        // Si la bandera 'encontrado' sigue siendo false, la edad no se encontró
        if (!encontrado) {
            System.out.println("Edad no encontrada");
        }
    }

    // ------------------------------- MÉTODO: Búsqueda binaria -------------------------------
    void busqueda() {
        System.out.println("BUSCANDO EDAD (Búsqueda Binaria)");
        System.out.print("Ingrese la edad que desea buscar: ");
        int edadABuscar = in.nextInt(); // Edad que el usuario desea buscar

        // Llamar al método de búsqueda binaria
        int resultado = this.busquedaBinaria(edadABuscar);

        // Verificar el resultado de la búsqueda
        if (resultado == -1) {
            System.out.println("Edad no encontrada");
        } else {
            System.out.println("Edad encontrada en la posición: " + resultado);
        }
    }

    // ------------------------------- MÉTODO: Algoritmo de búsqueda binaria -------------------------------
    public int busquedaBinaria(int elementoBusqueda) {
        int inferior = 0; // Límite inferior del área de búsqueda
        int superior = personas.length - 1; // Límite superior del área de búsqueda
        int medio = (inferior + superior) / 2; // Calcular el punto medio
        int ubicacion = -1; // Inicializar ubicación como -1 (no encontrada)

        // Bucle para realizar la búsqueda binaria
        while ((inferior <= superior) && (ubicacion == -1)) {
            if (elementoBusqueda == personas[medio]) { // Verificar si el elemento está en el medio
                ubicacion = medio; // Actualizar ubicación con el índice encontrado
            } else if (elementoBusqueda < personas[medio]) { // Si el elemento es menor, reducir el rango superior
                superior = medio - 1;
            } else { // Si el elemento es mayor, aumentar el rango inferior
                inferior = medio + 1;
            }
            medio = (inferior + superior) / 2; // Recalcular el punto medio
        }

        return ubicacion; // Devolver la posición encontrada o -1 si no existe
    }

    // ------------------------------- MÉTODO: Llenar arreglo con datos aleatorios -------------------------------
    void llenarConDatosAleatorios() {
        System.out.println("Llenando con datos aleatorios");
        Random generador = new Random(); // Crear un objeto para generar números aleatorios

        for (int i = 0; i < personas.length; i++) {
            personas[i] = generador.nextInt(90) + 1; // Generar números aleatorios entre 1 y 90
        }

        Arrays.sort(personas); // Ordenar el arreglo
        System.out.println("Datos ordenados:");
        for (int num : personas) { // Imprimir el arreglo ordenado
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea
    }

    // ------------------------------- MÉTODO: Menú de opciones -------------------------------
    void menu() {
        int opcion; // Variable para almacenar la opción del usuario

        do {
            // Mostrar las opciones del menú
            System.out.println("-----MENÚ-----");
            System.out.println("1. Llenar arreglo con edades");
            System.out.println("2. Búsqueda lineal de edades");
            System.out.println("3. Búsqueda binaria de edades");
            System.out.println("4. Llenar arreglo con edades aleatorias");
            System.out.println("5. Salir");
            System.out.print("Digite su opción: ");
            opcion = in.nextInt(); // Leer la opción ingresada por el usuario

            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    llenarArreglo();
                    break;
                case 2:
                    busquedaLineal();
                    break;
                case 3:
                    busqueda();
                    break;
                case 4:
                    llenarConDatosAleatorios();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente");
            }
        } while (opcion > 0 && opcion < 5); // Continuar mientras la opción sea válida
    }

    // ------------------------------- MÉTODO: MAIN -------------------------------
    public static void main(String[] args) {
        Personas programa = new Personas(); // Crear una instancia de la clase Personas
        programa.menu(); // Iniciar el programa mostrando el menú
    }
}
