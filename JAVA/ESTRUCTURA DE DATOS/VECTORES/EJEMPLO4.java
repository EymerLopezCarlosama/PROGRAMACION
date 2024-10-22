package VECTORES;

import javax.swing.*;
import java.util.*;


public class EJEMPLO4 {

            public static void main(String[] args) {
        
                    // Crear un vector de 10 elementos
                    int[] vector = new int[10];
                    // Llenar el vector con números aleatorios entre 0 y 99
                    for (int i = 0; i < 10; i++) {
                        vector[i] = (int)(Math.random()*100);
                    }

                    // Mostrar el vector desordenado
                    JOptionPane.showMessageDialog(null, "Vector desordenado: " + Arrays.toString(vector));

                    // Ordenar el vector de menor a mayor
                    Arrays.sort(vector);

                    // Mostrar el vector ordenado de menor a mayor
                    JOptionPane.showMessageDialog(null, "Vector ordenado de menor a mayor: " + Arrays.toString(vector));

                    // Ordenar de mayor a menor
                    // Convertir el vector de int a Integer para poder usar Collections.reverseOrder()
                    Integer[] vectorInteger = Arrays.stream(vector).boxed().toArray(Integer[]::new);
                    // Ordenar el vector de Integer en orden descendente
                    Arrays.sort(vectorInteger, Collections.reverseOrder());

                    // Mostrar el vector ordenado de mayor a menor
                    JOptionPane.showMessageDialog(null, "Vector ordenado de mayor a menor: " + Arrays.toString(vectorInteger));

            }

}
