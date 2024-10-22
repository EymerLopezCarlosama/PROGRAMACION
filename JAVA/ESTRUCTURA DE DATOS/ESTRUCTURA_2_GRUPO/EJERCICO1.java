package ESTRUCTURA_2_GRUPO;

/* REALIZE UN PROGRAMA QUE PERMITA GUARDAR 5 NOTAS Y QUE A TRAVEZ DE UN MENU PERMITA:
 * REGISTAR LAS NOTAS
 * MOSTRAR LAS NOTAS
 * OBTENER EL PROMEDIO DE LAS NOTAS
 * IMPRIMIR LAS NOTAS MAYORES A 3
  */


import java.util.Scanner;

public class EJERCICO1 {

    public static void main(String[] args) {
        
        float notas[] = new float[5];
        float suma = 0;
        float promedio = 0;
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("1. Registrar notas");
            System.out.println("2. Mostrar notas");
            System.out.println("3. Obtener promedio");
            System.out.println("4. Imprimir notas mayores a 3");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    for (int i = 0; i < notas.length; i++) {
                        System.out.println("Ingrese la nota " + (i + 1) + ": ");
                        notas[i] = scanner.nextFloat();
                    }
                    break;
                case 2:
                    for (int i = 0; i < notas.length; i++) {
                        System.out.println("La nota " + (i + 1) + " es: " + notas[i]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < notas.length; i++) {
                        suma = suma + notas[i];
                    }
                    promedio = suma / notas.length;
                    System.out.println("El promedio es: " + promedio);
                    break;
                case 4:
                    for (int i = 0; i < notas.length; i++) {
                        if (notas[i] > 3) {
                            System.out.println("La nota " + (i + 1) + " es: " + notas[i]);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }
}
