package EXPOSICION; // Definir el paquete donde se encuentra la clase

import javax.swing.*; // Importar la biblioteca javax.swing para usar ventanas emergentes

public class MetodoShellSortComentadoTotal { // Definir la clase principal

    public static void main(String[] args) { // Método principal donde se ejecuta el programa
        try { // Iniciar un bloque try para manejar posibles excepciones

            // Solicitar el número de elementos al usuario mediante una ventana emergente
            String dato = JOptionPane.showInputDialog("Ingrese Número de Datos a Ingresar: ");
            int tam = Integer.parseInt(dato); // Convertir la entrada de texto a un número entero

            // Crear un arreglo de enteros con el tamaño especificado por el usuario
            int[] arr = new int[tam];

            // Ciclo para pedir los elementos del arreglo al usuario
            for (int i = 0; i < arr.length; i++) { 
                // Solicitar cada elemento del arreglo al usuario mediante una ventana emergente
                String dato2 = JOptionPane.showInputDialog("Elemento " + (i + 1) + " : ");
                arr[i] = Integer.parseInt(dato2); // Convertir cada entrada de texto a entero y almacenarla en el arreglo
            }

            // Llamar al método para ordenar el arreglo usando el algoritmo Shell Sort
            shellSort(arr);

            // Crear un StringBuilder para construir la cadena que mostrará el arreglo ordenado
            StringBuilder resultado = new StringBuilder("Arreglo Ordenado:\n");
            for (int num : arr) { // Recorrer cada elemento del arreglo
                resultado.append(num).append("\n"); // Añadir cada elemento del arreglo al mensaje con un salto de línea
            }
            JOptionPane.showMessageDialog(null, resultado.toString()); // Mostrar el arreglo ordenado en una ventana emergente

        } catch (NumberFormatException e) { // Capturar la excepción si el usuario ingresa un valor que no puede convertirse en entero
            // Mostrar un mensaje de error en caso de que el usuario ingrese un valor inválido
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
        }
    }

    // Método que implementa el algoritmo Shell Sort para ordenar un arreglo de enteros
    static void shellSort(int[] arreglo) {
        // Comenzar con un incremento que es la mitad del tamaño del arreglo
        for (int increment = arreglo.length / 2; increment > 0; increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
            // Ciclo para recorrer el arreglo aplicando el incremento
            for (int i = increment; i < arreglo.length; i++) {
                // Ciclo para comparar y reordenar los elementos con el incremento actual
                for (int j = i; j >= increment && arreglo[j - increment] > arreglo[j]; j -= increment) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    int temp = arreglo[j]; // Guardar el valor del elemento en una variable temporal
                    arreglo[j] = arreglo[j - increment]; // Mover el elemento anterior a la posición actual
                    arreglo[j - increment] = temp; // Colocar el valor guardado en la posición anterior
                }
            }
        }
    }
}
