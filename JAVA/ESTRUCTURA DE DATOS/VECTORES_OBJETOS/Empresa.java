package VECTORES_OBJETOS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Empresa {
    private Empleado[] empleados;
    public Empresa(int cantidadEmpleados) {
        empleados = new Empleado[cantidadEmpleados];
    }
    
    public void agregarEmpleado() {
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] == null) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
                String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado:"));
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));
                
                empleados[i] = new Empleado(nombre, apellido, edad, salario);
                JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente.");
                break;
            }
        }
    }
    
    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void imprimirDatosEnTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("Salario");

        for (Empleado empleado : empleados) {
            if (empleado != null) {
                modelo.addRow(new Object[]{
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getEdad(),
                    empleado.getSalario()
                });
            }
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(null, scrollPane, "Datos de Empleados", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        int cantidadEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados:"));

        Empresa empresa = new Empresa(cantidadEmpleados);
        int opcion;

        do {
            String[] opciones = {"Agregar empleado", "Imprimir datos en tabla", "Salir"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    empresa.agregarEmpleado();
                    break;
                case 1:
                    empresa.imprimirDatosEnTabla();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 2);
    }
}