package LINKEDLIST;

/* PRESENTADO POR:
 * EYMER LOPEZ
 * ALEJANDRO IDROBO
 * DANIEL ROJAS
 * MANUEL IDROBO
 */

import javax.swing.*;

public class Ejemplo3 {

    public static void main(String[] args) {
        
        Ejemplo3Clinica paciente = new Ejemplo3Clinica();
        boolean salir = false;

        while (!salir){
            String opc = JOptionPane.showInputDialog("CLINICA \n 1. Agregar Paciente \n 2. Atender Paciente \n 3. Mostrar Lista de Espera \n 4. Salir");
            switch (opc) {
                case "1":
                    String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
                    String motivoConsulta = JOptionPane.showInputDialog("Ingrese el Motivo de Consulta");
                    paciente.AgregarPaciente(new Ejemplo3Paciente(nombre,motivoConsulta));
                    break;
                case "2":
                    paciente.AtenderPaciente();
                    break;
                case "3":
                paciente.mostrarListaEspera();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION CORRECTA");
                    break;
            }
        }
    

    }

}
