package STIVEN;

import java.util.Scanner;

public class EncuestaCanciones {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int[][] canciones = new int[10][2]; // Almacena código y puntuación
        String[][] detalles = new String[10][3]; // Almacena nombre, género y artista
        int totalCanciones = 0; 
        int sumaPuntuaciones = 0;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Guardar canción");
            System.out.println("2. Listar canciones");
            System.out.println("3. Buscar canción por código");
            System.out.println("4. Sacar promedio de puntuación");
            System.out.println("5. Imprimir la canción más y menos votada");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (totalCanciones < 10) {
                        System.out.print("Ingrese el código de la canción: ");
                        int codigo = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer
                        
                        System.out.print("Ingrese el nombre de la canción: ");
                        String nombre = sc.nextLine();
                        
                        System.out.print("Ingrese el género de la canción: ");
                        String genero = sc.nextLine();
                        
                        System.out.print("Ingrese el artista de la canción: ");
                        String artista = sc.nextLine();

                        System.out.print("Ingrese la puntuación (0-100): ");
                        int puntuacion = sc.nextInt();

                        // Guardar canción en los arrays
                        canciones[totalCanciones][0] = codigo;
                        canciones[totalCanciones][1] = puntuacion;
                        detalles[totalCanciones][0] = nombre;
                        detalles[totalCanciones][1] = genero;
                        detalles[totalCanciones][2] = artista;

                        totalCanciones++;
                        System.out.println("Canción guardada correctamente.");
                    } else {
                        System.out.println("No se pueden agregar más canciones.");
                    }
                    break;

                case 2:
                    System.out.println("CODIGO\tNOMBRE\t\tGENERO\tARTISTA\tPUNTUACION");
                    for (int i = 0; i < totalCanciones; i++) {
                        System.out.println(canciones[i][0] + "\t" + detalles[i][0] + "\t\t" + detalles[i][1] + "\t" + detalles[i][2] + "\t" + canciones[i][1]);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código de la canción a buscar: ");
                    int codigoBuscar = sc.nextInt();
                    boolean encontrado = false;
                    for (int i = 0; i < totalCanciones; i++) {
                        if (canciones[i][0] == codigoBuscar) {
                            System.out.println("Canción encontrada:");
                            System.out.println("Código: " + canciones[i][0]);
                            System.out.println("Nombre: " + detalles[i][0]);
                            System.out.println("Género: " + detalles[i][1]);
                            System.out.println("Artista: " + detalles[i][2]);
                            System.out.println("Puntuación: " + canciones[i][1]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Canción no encontrada.");
                    }
                    break;

                case 4:
                    if (totalCanciones > 0) {
                        sumaPuntuaciones = 0;
                        for (int i = 0; i < totalCanciones; i++) {
                            sumaPuntuaciones += canciones[i][1];
                        }
                        int promedio = sumaPuntuaciones / totalCanciones;
                        System.out.println("El promedio de puntuación es: " + promedio);
                    } else {
                        System.out.println("No hay canciones registradas.");
                    }
                    break;

                case 5:
                    if (totalCanciones > 0) {
                        int mayorPuntuacion = canciones[0][1];
                        int menorPuntuacion = canciones[0][1];
                        int indiceMayor = 0;
                        int indiceMenor = 0;

                        for (int i = 1; i < totalCanciones; i++) {
                            if (canciones[i][1] > mayorPuntuacion) {
                                mayorPuntuacion = canciones[i][1];
                                indiceMayor = i;
                            }
                            if (canciones[i][1] < menorPuntuacion) {
                                menorPuntuacion = canciones[i][1];
                                indiceMenor = i;
                            }
                        }

                        System.out.println("La canción más votada es: ");
                        System.out.println("Código: " + canciones[indiceMayor][0] + " - Nombre: " + detalles[indiceMayor][0] + " - Puntuación: " + canciones[indiceMayor][1]);

                        System.out.println("La canción menos votada es: ");
                        System.out.println("Código: " + canciones[indiceMenor][0] + " - Nombre: " + detalles[indiceMenor][0] + " - Puntuación: " + canciones[indiceMenor][1]);
                    } else {
                        System.out.println("No hay canciones registradas.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 6);
        sc.close();
    }
}