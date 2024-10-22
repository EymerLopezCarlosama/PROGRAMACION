
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EJEMPLO7 {

    public static void main(String[] args) {
        
        double [][] notas = new double [4][4];  
        double suma = 0;  

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                String nota = JOptionPane.showInputDialog("Ingrese la nota " + (j+1) + " del alumno " + (i+1));
                notas[i][j] = Double.parseDouble(nota);
                suma += notas[i][j];
            }
            notas[i][3] = suma / 3;
            suma = 0;
            
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Alumno");
        modelo.addColumn("Nota 1");
        modelo.addColumn("Nota 2");
        modelo.addColumn("Nota 3");
        modelo.addColumn("Promedio");

        for (int i = 0; i < 4; i++) {
            modelo.addRow(new Object[]{"Alumno " + (i+1), notas[i][0], notas[i][1], notas[i][2], notas[i][3]});
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
                
        JFrame frame = new JFrame("Notas de Alumnos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
        

    }

}
