import javax.swing.*;

public class EJEMPLO4 {

    public static void main(String[] args) {
        
        try {

            String dato = JOptionPane.showInputDialog("Ingrese el tamaño de la matriz cuadrada: ");
            int tamaño = Integer.parseInt(dato);

            int[][] matriz = new int [tamaño][tamaño]; 
            for ( int i = 0 ; i < tamaño ; i++){
                for ( int j = 0 ; j < tamaño; j++){
                    matriz[i][j] = (j + 1 > i) ? j + 1 - i : 1;
                }
            }

            
            StringBuilder matrizString = new StringBuilder();
                 for (int i = 0; i < tamaño; i++) {
                    for (int j = 0; j < tamaño; j++) {
                            matrizString.append("|").append(matriz[i][j]).append(" | ");
                    }
                                matrizString.append("\n");
                }
                JOptionPane.showMessageDialog(null, matrizString.toString(), "Matriz Cuadrada", JOptionPane.INFORMATION_MESSAGE);
                            
            
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}