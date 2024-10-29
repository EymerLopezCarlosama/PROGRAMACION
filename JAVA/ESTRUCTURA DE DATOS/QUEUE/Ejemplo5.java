package QUEUE;

import javax.swing.*;

public class Ejemplo5 {

    public static void main(String[] args) {
        Ejemplo5Clinica clinica = new Ejemplo5Clinica();
        boolean salir = false;

        while (!salir) {
            String opc = JOptionPane.showInputDialog("Bienvenido a la Clinica \n1. Registrar Paciente \n2. Atender Paciente \n3. Mostrar Pacientes \n4. Salir");

            switch (opc) {
                case "1":
                    String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Paciente");
                    String motivoConsulta = JOptionPane.showInputDialog("Ingrese el Motivo de la Consulta");
                    Ejemplo5Paciente paciente = new Ejemplo5Paciente(nombre, motivoConsulta);
                    clinica.registrarPacientes(paciente);
                    break;

                case "2":
                    clinica.atenderPacientes();
                    break;

                case "3":
                    clinica.mostrarEstadoFilas();
                    break;

                case "4":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Gracias!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }
}
