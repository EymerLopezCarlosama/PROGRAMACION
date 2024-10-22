package VECTORES;

/* luego solicitar al usuario que ingrese los elementos del vector.
* Finalmente mostar el vector ingresado con sus respectivos valores y mostar valoresa anidados
*/

import java.util.*;
public class EJEMPLO2_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del vector: ");
        int cantidad = sc.nextInt();
        String[] vector = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
            vector[i] = sc.next();
        }
        System.out.println("Vector ingresado:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Elemento " + (i + 1) + ": " + vector[i]);
        }

        sc.close();
        
    }

}
