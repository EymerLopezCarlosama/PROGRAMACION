package LINKEDLIST;

import java.util.*;

import javax.swing.JOptionPane;

public class Ejemplo2Salon {

    private LinkedList<Ejemplo2Cliente> listaEspera ;

    public Ejemplo2Salon() {
        this.listaEspera = new LinkedList<>();
    }
    
    public void agregarCliente (Ejemplo2Cliente Cliente){
        listaEspera.addLast(Cliente);
        JOptionPane.showMessageDialog(null,"Cliente Registrado " + Cliente.getNombre() + " Servicio " + Cliente.getServivio());

    }

    public void atenderCliente(){
        if (!listaEspera.isEmpty()) {
            Ejemplo2Cliente ClienteAtendido = listaEspera.removeFirst();
            JOptionPane.showMessageDialog(null,"Atendiendo a " + ClienteAtendido.getNombre() + " Servicio " + ClienteAtendido.getServivio());

        }else{
            JOptionPane.showMessageDialog(null, "No hay clientes en la lista de espera");
        }
    }

    public void mostrarListaEspera(){
        if (listaEspera.isEmpty()) {
            JOptionPane.showMessageDialog(null,"NO HAY CLIENTES");
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("LISTA DE ESPERA").append("\n");
            for (Ejemplo2Cliente cliente : listaEspera) {
                            sb.append("Nombre: ").append(cliente.getNombre())
                              .append(" - Servicio: ").append(cliente.getServivio())
                              .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
            
        }
    }

}
