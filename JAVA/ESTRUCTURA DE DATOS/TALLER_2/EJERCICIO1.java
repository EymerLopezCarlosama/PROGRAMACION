package TALLER_2;

import javax.swing.*;

public class EJERCICIO1 {

    public static void main(String[] args) {
        
        String dato1 = JOptionPane.showInputDialog("Ingrese el numero de filas: ");
        int filas = Integer.parseInt(dato1);
        String dato2 = JOptionPane.showInputDialog("Ingrese el numero de columnas: ");
        int columnas = Integer.parseInt(dato2);

        double[][] matriz = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String dato3 = JOptionPane.showInputDialog("Ingrese el valor de la matriz en la posicion " + i + "," + j + ": ");
                matriz[i][j] = Double.parseDouble(dato3);
            }
        }

        for (int i = 0; i < filas; i++) {
            double sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                sumaFila += matriz[i][j];
            }

            StringBuilder sb = new StringBuilder();
            sb.append("La suma de la fila " + i + " es: " + sumaFila);
            JOptionPane.showMessageDialog(null, sb.toString());

        }

        for  (int j = 0; j < columnas; j++) {
            double sumaColumna = 0;
            for (int i = 0; i < filas; i++) {
                sumaColumna += matriz[i][j];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("La suma de la columna " + j + " es: " + sumaColumna);
            JOptionPane.showMessageDialog(null, sb.toString());
        }

    }



}
