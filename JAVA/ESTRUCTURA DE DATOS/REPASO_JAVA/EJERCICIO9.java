package REPASO_JAVA;

/* Programa que lea un número n luego desplegar la tabla de multiplicar de ese número.Realizar el programa:
    a) utilizando for
    b) Utilizando while
    c) utilizando do while. */

    import javax.swing.*;
    import javax.swing.table.*;
    
    public class EJERCICIO9 {
        public static void main(String[] args) {

            try {
                
            String input = JOptionPane.showInputDialog("Ingresa un número:");
            int n = Integer.parseInt(input);
    
            String[] columnas = {"For", "While", "Do-While"};
    
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    
            // Usando for
            for (int i = 1; i <= 10; i++) {
                int resultadoFor = n * i;
                String operacionFor = n + " x " + i + " = " + resultadoFor;
                modelo.addRow(new Object[]{operacionFor, "", ""});
            }
    
            // Usando while
            int i = 1;
            while (i <= 10) {
                int resultadoWhile = n * i;
                String operacionWhile = n + " x " + i + " = " + resultadoWhile;
                modelo.setValueAt(operacionWhile, i - 1, 1);
                i++;
            }
    
            // Usando do-while
            i = 1;
            do {
                int resultadoDoWhile = n * i;
                String operacionDoWhile = n + " x " + i + " = " + resultadoDoWhile;
                modelo.setValueAt(operacionDoWhile, i - 1, 2);
                i++;
            } while (i <= 10);
    
            JTable tabla = new JTable(modelo);

            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                tabla.getColumnModel().getColumn(j).setCellRenderer(renderer);
            }
            
    
            JScrollPane scrollPane = new JScrollPane(tabla);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
    
            JFrame frame = new JFrame("Tablas de Multiplicar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.add(panel);
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
        }
        }
    }
    