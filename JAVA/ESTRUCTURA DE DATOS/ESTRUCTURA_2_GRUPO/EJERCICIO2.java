package ESTRUCTURA_2_GRUPO;

/*Obtener el promedio de 5 temperaturas
 *Imprimir las temperaturas mayores a 15 y cuente cuantas hay
 *Buscar una temperatura en el arreglo e indicar si esta registrada o no
 */

import java.util.Scanner;

public class EJERCICIO2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[5];
        double promedio = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println("Ingrese la temperatura " + (i + 1) + ": ");
            temperaturas[i] = sc.nextDouble();
            promedio += temperaturas[i];
        }
        promedio /= temperaturas.length;
        System.out.println("El promedio de las temperaturas es: " + promedio);
        int contador = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > 15) {
                System.out.println("La temperatura " + (i + 1) + " es mayor a 15");
                contador++;
            }
        }
        System.out.println("Hay " + contador + " temperaturas mayores a 15");
        System.out.println("Ingrese la temperatura a buscar: ");
        double temperaturaBuscada = sc.nextDouble();
        boolean encontrada = false;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] == temperaturaBuscada) {
                encontrada = true;
                break;
            }
        }
        if (encontrada) {
            System.out.println("La temperatura " + temperaturaBuscada + " está registrada");
        } else {
            System.out.println("La temperatura " + temperaturaBuscada + " no está registrada");
        }

        sc.close();
        
    }

}
