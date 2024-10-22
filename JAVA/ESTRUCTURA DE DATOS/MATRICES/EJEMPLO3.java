import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EJEMPLO3 {

        public static void main(String[] args) {
            try {
                String dato1 = JOptionPane.showInputDialog("Ingrese el numero de filas: ");
                int filas = Integer.parseInt(dato1);
                String dato2 = JOptionPane.showInputDialog("Ingrese el numero de columnas: ");
                int columnas = Integer.parseInt(dato2);

                double[][] matriz = new double[filas][columnas];
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        String dato = JOptionPane.showInputDialog("Ingrese el valor de la matriz en la posicion " + i + "," + j + ": ");
                        matriz[i][j] = Double.parseDouble(dato);
                    }
                } 

                Object[][] mat = new Object[filas][columnas];
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        mat[i][j] = matriz[i][j];
                    }
                }

                DefaultTableModel model = new DefaultTableModel(mat, new Object[columnas]); // Encabezados vacíos
                JTable table = new JTable(model);
                table.setTableHeader(null);
                JScrollPane scrollPane = new JScrollPane(table);
                JOptionPane.showMessageDialog(null, scrollPane, "Matriz Completa", JOptionPane.INFORMATION_MESSAGE);

                double suma = 0;
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        suma += matriz[i][j];
                    }
                }
                JOptionPane.showMessageDialog(null, "La suma de todos los datos de la matriz es: " + suma);

                
                double sumaPersonalizada = 0;
                boolean continuar = true;
                while (continuar) {
                    String dato3 = JOptionPane.showInputDialog("Ingrese la posición en la fila que desea sumar: ");
                    int posicion = Integer.parseInt(dato3);
                    String dato4 = JOptionPane.showInputDialog("Ingrese la posición en la columna que desea sumar: ");
                    int posicion2 = Integer.parseInt(dato4);
                    sumaPersonalizada += matriz[posicion][posicion2];
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea sumar otro dato?", "Continuar", JOptionPane.YES_NO_OPTION);
                    continuar = (opcion == JOptionPane.YES_OPTION);
                }
                JOptionPane.showMessageDialog(null, "La suma personalizada es: " + sumaPersonalizada);

                // SUMAS ZIGZAG
                double sumaDiagonalPrincipal = 0;
                double sumaDiagonalSecundaria = 0;

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (i == j || j == columnas - 1 - i) { 
                            sumaDiagonalPrincipal += matriz[i][j];
                        }
                    }
                }

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (i != j && j != columnas - 1 - i) {
                            sumaDiagonalSecundaria += matriz[i][j];
                        }
                    }
                }


                JOptionPane.showMessageDialog(null, "La suma de la diagonal principal es: " + sumaDiagonalPrincipal);
                JOptionPane.showMessageDialog(null, "La suma de la diagonal secundaria es: " + sumaDiagonalSecundaria);

                
                    
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}
