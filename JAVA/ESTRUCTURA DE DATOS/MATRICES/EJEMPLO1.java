import javax.swing.*;

public class EJEMPLO1 {
    
    public static void main(String[] args) {
        
        int[][] matriz = new int[5][3]; // Declarar una matriz de enteros con 5 filas y 3 columnas
        // Llenar la matriz con valores ingresados por el usuario
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String dato = JOptionPane.showInputDialog("Ingrese el valor para la fila " + (i + 1) + " y la columna " + (j + 1) + ": ");
                matriz[i][j] = Integer.parseInt(dato); // Convertir la entrada de texto a un número entero y almacenarla en la matriz
            }
        }
        // Mostrar la matriz
        

    }

}
