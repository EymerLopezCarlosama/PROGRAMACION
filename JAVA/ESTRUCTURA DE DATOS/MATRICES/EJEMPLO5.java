
/* ESTABLECER UNA MATRIZ DE TAMAO ESTABLECIDO POR EL USUARIO Y QUE ESTE MISMO LA LLENE
 * ADEMAS DEBE HABER UN VECTOR PREESTABLECIDO Y CON ESTE COMPROBAR CUANTAS VECES APARECE EN LA MATRIZ
 */

import javax.swing.*;

public class EJEMPLO5 {

    public static void main(String[] args) {
        
        try {
            String filas = JOptionPane.showInputDialog("Ingrese el número de filas: ");
            String columnas = JOptionPane.showInputDialog("Ingrese el número de columnas: ");
            int filasInt = Integer.parseInt(filas);
            int columnasInt = Integer.parseInt(columnas);
            int[][] matriz = new int[filasInt][columnasInt];
            int[] vector = new int[columnasInt];
            int contador = 0;

            // Llenar el vector
            for (int i = 0; i < columnasInt; i++) {
                vector[i] = contador + 1;
                contador++;
            }

            // Mostrar el vector
            StringBuilder vectorString = new StringBuilder();
            for (int i = 0; i < columnasInt; i++) {
                vectorString.append("|").append(vector[i]).append(" | ");
            }
            JOptionPane.showMessageDialog(null, vectorString.toString(), "Vector", JOptionPane.INFORMATION_MESSAGE);

            // Llenar la matriz con valores ingresados por el usuario
            for (int i = 0; i < filasInt; i++) {
                for (int j = 0; j < columnasInt; j++) {
                    String valor = JOptionPane.showInputDialog("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                    matriz[i][j] = Integer.parseInt(valor);
                }
            }

            // Mostrar la matriz
            StringBuilder matrizString = new StringBuilder();
                for (int i = 0; i < filasInt; i++) {
                    for (int j = 0; j < columnasInt; j++) {
                            matrizString.append("| ").append(matriz[i][j]).append(" | ");
                    }
                    matrizString.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, matrizString.toString(), "Matriz", JOptionPane.INFORMATION_MESSAGE);


            int Apariciones = 0;
                for (int i = 0; i < filasInt; i++) {
                    boolean sonIguales = true;
                for (int j = 0; j < columnasInt; j++) {
                    if (matriz[i][j] != vector[j]) {
                        sonIguales = false;
                        break;
                        }
                    }
                    if (sonIguales) {
                        Apariciones++;
                    }
                }
        
                    // Mostrar el resultado
                    JOptionPane.showMessageDialog(null, "El vector aparece " + Apariciones + " veces como fila en la matriz.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
