package EXPOSICION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Importación de las clases necesarias para la entrada de datos desde la consola

public class MetodoShellSort {
    public static void main(String[] args) {
        try {
            // Creación de un BufferedReader para leer la entrada del usuario desde la consola
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("\nIngrese Número de Datos a Ingresar: ");

            // Lectura del tamaño del arreglo desde la entrada del usuario
            int tam = Integer.parseInt(in.readLine());

            // Creación del arreglo con el tamaño especificado por el usuario
            int arr[] = new int[tam];

            System.out.println(); // Imprimir una línea en blanco para mejor visualización

            int j = 0;

            // Bucle para leer los elementos del arreglo uno por uno
            for (int i = 0; i < arr.length; i++) {
                j += 1; // Incrementar el índice de los elementos
                System.out.print("Elemento " + j + " : ");
                // Leer cada elemento del arreglo desde la entrada del usuario
                arr[i] = Integer.parseInt(in.readLine());
            }

            // Llamada al método shellSort para ordenar el arreglo usando el algoritmo Shell Sort
            shellSort(arr);

        } catch (NumberFormatException e) {
            // Manejar la excepción si el usuario ingresa un valor no numérico
            System.out.println("Error: Ingrese un número válido.");

        } catch (IOException e) {
            // Manejar la excepción si ocurre un error de entrada/salida
            System.out.println("Error: Ocurrió un problema al leer la entrada.");
        }
    }

    // Método que implementa el algoritmo Shell Sort para ordenar el arreglo
    static void shellSort(int arreglo[]) {
        // Bucle exterior que define el tamaño del incremento para los saltos en Shell Sort
        for (int increment = arreglo.length / 2; increment > 0; increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
            // Bucle que recorre el arreglo desde el índice definido por el incremento
            for (int i = increment; i < arreglo.length; i++) {
                // Bucle que compara y, si es necesario, intercambia elementos separados por el incremento
                for (int j = i; j >= increment && arreglo[j - increment] > arreglo[j]; j -= increment) {
                    // Intercambio de elementos si están en el orden incorrecto
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j - increment];
                    arreglo[j - increment] = temp;
                }
            }
        }

        // Imprimir un mensaje indicando que el método Shell Sort ha finalizado
        System.out.println("\nMétodo de ShellSort");

        // Bucle para imprimir el arreglo ordenado en la consola
        for (int l = 0; l < arreglo.length; l++) {
            System.out.print(arreglo[l] + "\n"); // Imprimir cada elemento del arreglo en una nueva línea
        }
    }
}
