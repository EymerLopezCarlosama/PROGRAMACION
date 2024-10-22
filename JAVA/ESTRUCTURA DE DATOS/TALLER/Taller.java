package TALLER;

/* Presentado por:
    - Eymer López Carlosama
    - Jose Alejandro Idrobo
 */

import javax.swing.*;

public class Taller {

    public static void main(String[] args) {
        
        String vectores = JOptionPane.showInputDialog(null, "Ingrese el tamaño del vector");
        int tam = Integer.parseInt(vectores);
        float[] vector1 = new float[tam];
        float[] vector2 = new float[tam];
        float[] vector3 = new float[tam];
        float[] vector4 = new float[tam];

        boolean salir = false;
        // Crear menu
        do {

            try {
                
            String menu = JOptionPane.showInputDialog("Por favor seleccione una opcion:\n 1.Ingresar datos\n 2.Sumar\n 3.Restar\n 4.Multiplicar\n 5.Dividir\n 6.Pares\n 7.Impares\n 8.Ordenar\n 9.Salir");
            int opcion = Integer.parseInt(menu);

            switch (opcion) {
                case 1:
                    for (int i = 0; i < tam; i++) {
                        
                        try {
                            vector1[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor del vector 1"));
                            vector2[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor del vector 2"));
                            vector3[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor del vector 3"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error al ingresar los datos. Por favor, ingrese valores numéricos válidos.");
                            i--; // Volver a pedir el valor si hay un error
                        }
                        }
                        JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                        break;
                case 2:
                    StringBuilder sumResult = new StringBuilder("Resultado de la suma:\n");
                    for (int i = 0; i < tam; i++) {
                        vector4[i] = vector1[i] + vector2[tam - 1 - i] + vector3[i];
                        sumResult.append(vector1[i]).append(" + ").append(vector2[tam - 1 - i]).append(" + ").append(vector3[i]).append(" = ").append(vector4[i]).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sumResult.toString());
                    break;
                case 3:
                    StringBuilder restResult = new StringBuilder("Resultado de la resta:\n");
                    for (int i = 0; i < tam; i++) {
                        vector4[i] = vector1[i] - vector2[tam - 1 - i] - vector3[i];
                        restResult.append(vector1[i]).append(" - ").append(vector2[tam - 1 - i]).append(" - ").append(vector3[i]).append(" = ").append(vector4[i]).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, restResult.toString());
                    break;
                case 4:
                    StringBuilder multResult = new StringBuilder("Resultado de la multiplicación:\n");
                    for (int i = 0; i < tam; i++) {
                        vector4[i] = vector1[i] * vector2[tam - 1 - i] * vector3[i];
                        multResult.append(vector1[i]).append(" * ").append(vector2[tam - 1 - i]).append(" * ").append(vector3[i]).append(" = ").append(vector4[i]).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, multResult.toString());
                    break;
                case 5:
                    StringBuilder divResult = new StringBuilder("Resultado de la división:\n");
                    for (int i = 0; i < tam; i++) {
                        if (vector2[i] == 0 || vector3[i] == 0) {
                            divResult.append(vector1[i]).append(" / ").append(vector2[i]).append(" = No se puede dividir entre cero\n");
                            divResult.append(vector2[i]).append(" / ").append(vector3[i]).append(" = No se puede dividir entre cero\n");
                        } else {
                            float result1 = vector1[i] / vector2[i];
                            float result2 = vector2[i] / vector3[i];
                            divResult.append(vector1[i]).append(" / ").append(vector2[i]).append(" = ").append(result1).append("\n");
                            divResult.append(vector2[i]).append(" / ").append(vector3[i]).append(" = ").append(result2).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, divResult.toString());
                    break;
                case 6:
                    int[] pares = new int[4];
                    for (int i = 0; i < tam; i++) {
                        if (vector1[i] % 2 == 0) pares[0]++;
                        if (vector2[i] % 2 == 0) pares[1]++;
                        if (vector3[i] % 2 == 0) pares[2]++;
                        if (vector4[i] % 2 == 0) pares[3]++;
                    }
                    JOptionPane.showMessageDialog(null, "Números pares en cada vector:\nVector 1: " + pares[0] + "\nVector 2: " + pares[1] + "\nVector 3: " + pares[2] + "\nVector 4: " + pares[3]);
                    break;
                case 7:
                    int[] impares = new int[4];
                    for (int i = 0; i < tam; i++) {
                        if (vector1[i] % 2 != 0) impares[0]++;
                        if (vector2[i] % 2 != 0) impares[1]++;
                        if (vector3[i] % 2 != 0) impares[2]++;
                        if (vector4[i] % 2 != 0) impares[3]++;
                    }
                    JOptionPane.showMessageDialog(null, "Números impares en cada vector:\nVector 1: " + impares[0] + "\nVector 2: " + impares[1] + "\nVector 3: " + impares[2] + "\nVector 4: " + impares[3]);
                    break;
                case 8:
                    for (int i = 0; i < tam; i++) {
                        for (int j = 0; j < tam - 1; j++) {
                            if (vector2[j] < vector2[j + 1]) {
                                float temp = vector2[j];
                                vector2[j] = vector2[j + 1];
                                vector2[j + 1] = temp;
                            }
                            if (vector4[j] < vector4[j + 1]) {
                                float temp = vector4[j];
                                vector4[j] = vector4[j + 1];
                                vector4[j + 1] = temp;
                            }
                        }
                    }
                    StringBuilder ordenResult = new StringBuilder("Vectores ordenados de forma descendente:\nVector 2: ");
                    for (int i = 0; i < tam; i++) {
                        ordenResult.append(vector2[i]).append(" ");
                    }
                    ordenResult.append("\nVector 4: ");
                    for (int i = 0; i < tam; i++) {
                        ordenResult.append(vector4[i]).append(" ");
                    }
                    JOptionPane.showMessageDialog(null, ordenResult.toString());
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido para la opción del menú.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
            
        } while (!salir);


    }
}