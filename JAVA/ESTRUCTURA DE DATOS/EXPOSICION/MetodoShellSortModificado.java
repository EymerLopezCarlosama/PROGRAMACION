package EXPOSICION;

import javax.swing.*;

public class MetodoShellSortModificado {

    public static void main(String[] args) {
        try {
            // Solicitar el número de elementos al usuario mediante una ventana emergente
            String dato = JOptionPane.showInputDialog("Ingrese Número de Datos a Ingresar: ");
            int tam = Integer.parseInt(dato); // Convertir la entrada a un número entero

            // Crear un arreglo de enteros con el tamaño especificado por el usuario
            int[] arr = new int[tam];

            // Ciclo para pedir los elementos del arreglo al usuario
            for (int i = 0; i < arr.length; i++) {
                String dato2 = JOptionPane.showInputDialog("Elemento " + (i + 1) + " : ");
                arr[i] = Integer.parseInt(dato2); // Convertir cada entrada a entero y almacenarla en el arreglo
            }

            // Llamar al método para ordenar el arreglo usando el algoritmo Shell Sort
            shellSort(arr);

            // Mostrar el arreglo ordenado en una ventana emergente
            StringBuilder resultado = new StringBuilder("Arreglo Ordenado:\n");
            for (int num : arr) {
                resultado.append(num).append(" ").append("\n"); // Añadir cada elemento del arreglo al mensaje
            }
            JOptionPane.showMessageDialog(null, resultado.toString()); // Mostrar el arreglo ordenado

        } catch (NumberFormatException e) {
            // Manejar la excepción si el usuario ingresa un valor que no puede convertirse en entero
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
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j - increment];
                    arreglo[j - increment] = temp;
                }
            }
        }
    }
}
