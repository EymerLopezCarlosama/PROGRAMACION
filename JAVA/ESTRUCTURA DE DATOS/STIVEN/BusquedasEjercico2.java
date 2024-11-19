package STIVEN;

import java.util.*;

public class BusquedasEjercico2 {

     public static void main(String[] args) {
          
          Scanner sc = new Scanner(System.in);
          int[] arreglo = new int[5];
          int opcion;

          do {
                         System.out.println("\nMENU DE OPCIONES");
                         System.out.println("1. Llenar y ordenar arreglo con 5 temperaturas");
                         System.out.println("2. Busqueda lineal de temperatura");
                         System.out.println("3. Busqueda binaria de temperatura");
                         System.out.println("4. Llenar arreglo con temperaturas aleatorias");
                         System.out.println("5. Salir");
                         System.out.print("Ingrese una opcion: ");
                         opcion = sc.nextInt();
          
                         switch(opcion) {
                              case 1:
                                   System.out.println("Ingrese 5 temperaturas:");
                                   for(int i = 0; i < arreglo.length; i++) {
                                        System.out.print("Temperatura " + (i+1) + ": ");
                                        arreglo[i] = sc.nextInt();
                                   }
                                   Arrays.sort(arreglo);
                                   System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
                                   break;
          
                              case 2:
                                   System.out.print("Ingrese la temperatura a buscar: ");
                                   int tempBuscar = sc.nextInt();
                                   boolean encontrado = false;
                                   for(int i = 0; i < arreglo.length; i++) {
                                        if(arreglo[i] == tempBuscar) {
                                             System.out.println("Temperatura encontrada en la posicion: " + i);
                                             encontrado = true;
                                             break;
                                        }
                                   }
                                   if(!encontrado) {
                                        System.out.println("Temperatura no encontrada");
                                   }
                                   break;
          
                              case 3:
                                   System.out.print("Ingrese la temperatura a buscar: ");
                                   int tempBuscarBin = sc.nextInt();
                                   int resultado = Arrays.binarySearch(arreglo, tempBuscarBin);
                                   if(resultado >= 0) {
                                        System.out.println("Temperatura encontrada en la posicion: " + resultado);
                                   } else {
                                        System.out.println("Temperatura no encontrada");
                                   }
                                   break;
          
                              case 4:
                                   Random rand = new Random();
                                   for(int i = 0; i < arreglo.length; i++) {
                                        arreglo[i] = rand.nextInt(50); // Temperaturas aleatorias entre 0 y 49
                                   }
                                   System.out.println("Arreglo con temperaturas aleatorias: " + Arrays.toString(arreglo));
                                   break;
          
                              case 5:
                                   System.out.println("Programa finalizado");
                                   break;
          
                              default:
                                   System.out.println("Opcion invalida");
                                   break;
                         }
                    } while(opcion != 5);
          
               sc.close();

     }

}
