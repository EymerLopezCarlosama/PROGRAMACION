package LINKEDLIST;

import java.util.LinkedList;

import javax.swing.*;

public class Ejemplo3Clinica {

    private LinkedList<Ejemplo3Paciente> listaEspera;

    public Ejemplo3Clinica() {
        this.listaEspera = new LinkedList<>();
    }

    public void AgregarPaciente (Ejemplo3Paciente Paciente){
        listaEspera.add(Paciente);
        JOptionPane.showMessageDialog(null, "Paciente Registrado: " + Paciente.getNombre() +"\n" + "Motivo Consulta: " + Paciente.getMotivoConsulta());
    }

    public void AtenderPaciente(){
        if (!listaEspera.isEmpty()) {
            Ejemplo3Paciente ClienteAtendido = listaEspera.removeFirst();
            JOptionPane.showMessageDialog(null, "Atendiendo a: " + ClienteAtendido.getNombre() + "\n" + "Por movito de consulta: "+ ClienteAtendido.getMotivoConsulta());
        }else{
            JOptionPane.showMessageDialog(null, "No hay pacientes en Lista de Espera");
        }
    }

    public void mostrarListaEspera(){
        if (listaEspera.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay Pacientes");
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("LISTA DE ESPERA").append("\n");
            for (Ejemplo3Paciente Paciente : listaEspera) {
                            sb.append("Nombre: ").append(Paciente.getNombre())
                              .append(" - Motivo de Consulta: ").append(Paciente.getMotivoConsulta())
                              .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
            
        }
    }


}

    

