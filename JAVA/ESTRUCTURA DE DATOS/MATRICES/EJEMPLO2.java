import javax.swing.*;

public class EJEMPLO2 {

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        matriz[0][0] = 5;
        matriz[0][1] = 8;
        matriz[0][2] = 10;
        matriz[1][0] = 20;
        matriz[1][1] = -5;
        matriz[1][2] = 1;
        matriz[2][0] = 90;
        matriz[2][1] = 11;
        matriz[2][2] = 5;
        
        // Convertir la matriz de enteros a una matriz de Object para el JTable
        Object[][] data = new Object[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                data[i][j] = matriz[i][j];
            }
        }

        JTable table = new JTable(data, new Object[]{"", "", ""});

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Matriz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane); // Añadir el JScrollPane al JFrame
        frame.pack(); // Ajustar el tamaño del JFrame a sus componentes
        frame.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
        frame.setVisible(true); // Hacer visible el JFrame
        
        // Sumar todos los datos de la matriz
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        JOptionPane.showMessageDialog(null, "La suma de todos los datos de la matriz es: " + suma);

    }

}
