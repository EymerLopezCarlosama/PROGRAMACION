package QUEUE;

import java.util.*;
import javax.swing.*;

public class Ejemplo5Clinica {

    private Queue<Ejemplo5Paciente> filaMedicinaGeneral;
    private Queue<Ejemplo5Paciente> filaOdontologia;
    private Queue<Ejemplo5Paciente> filaPediatria;

    public Ejemplo5Clinica() {
        this.filaMedicinaGeneral = new LinkedList<>();
        this.filaOdontologia = new LinkedList<>();
        this.filaPediatria = new LinkedList<>();
    }

    public void registrarPacientes(Ejemplo5Paciente paciente) {
        String opc = JOptionPane.showInputDialog("Ingrese la especialidad del paciente: \n1. Medicina General \n2. Odontologia \n3. Pediatria");
        switch (opc) {
            case "1":
                filaMedicinaGeneral.offer(paciente);
                break;
            case "2":
                filaOdontologia.offer(paciente);
                break;
            case "3":
                filaPediatria.offer(paciente);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }

    public void atenderPacientes() {
        Ejemplo5Paciente pacienteAtendido = null;
        String opc2 = JOptionPane.showInputDialog("Paciente a Atender en: \n1. Medicina General \n2. Odontologia \n3. Pediatria");
        switch (opc2) {
            case "1":
                pacienteAtendido = filaMedicinaGeneral.poll();
                break;
            case "2":
                pacienteAtendido = filaOdontologia.poll();
                break;
            case "3":
                pacienteAtendido = filaPediatria.poll();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                return;
        }
        if (pacienteAtendido != null) {
            JOptionPane.showMessageDialog(null, "Se atendió al paciente: " + pacienteAtendido.getNombre() + " con motivo: " + pacienteAtendido.getMotivoConsulta());
        } else {
            JOptionPane.showMessageDialog(null, "No hay pacientes en la fila");
        }
    }

    public void mostrarEstadoFilas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estado de las Filas en Espera:\n");
        sb.append("Medicina General: ").append(filaMedicinaGeneral.size()).append(" pacientes en espera\n");
        for (Ejemplo5Paciente paciente : filaMedicinaGeneral) {
            sb.append(" - ").append(paciente.getNombre()).append(" - Motivo Consulta - ").append(paciente.getMotivoConsulta()).append("\n");
        }
        sb.append("Odontologia: ").append(filaOdontologia.size()).append(" pacientes en espera\n");
        for (Ejemplo5Paciente paciente : filaOdontologia) {
            sb.append(" - ").append(paciente.getNombre()).append(" - Motivo Consulta - ").append(paciente.getMotivoConsulta()).append("\n");
        }
        sb.append("Pediatria: ").append(filaPediatria.size()).append(" pacientes en espera\n");
        for (Ejemplo5Paciente paciente : filaPediatria) {
            sb.append(" - ").append(paciente.getNombre()).append(" - Motivo Consulta - ").append(paciente.getMotivoConsulta()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
