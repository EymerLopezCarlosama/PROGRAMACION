package QUEUE;

import java.util.*;
import javax.swing.*;

public class Ejemplo2 {

    public static void main(String[] args) {
        
        Queue<String> cola = new LinkedList<>();
        int opc = 0;
        do {
            String input = JOptionPane.showInputDialog("1.Registrar Cliente\n2.Atender Cliente\n3.Siguiente Cliente\n4.Cuantos Clientes Quedan\n5.Vaciar Cola\n6.Imprimir Cola\n7.Salir");
            opc = Integer.parseInt(input);

            switch (opc) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
                    cola.add(nombre);
                    break;
                case 2:
                    if (!cola.isEmpty()) {
                        String clienteAtender = cola.poll();
                        JOptionPane.showMessageDialog(null, "Atendiendo a: " + clienteAtender);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay clientes en la cola");
                    }
                    break;
                case 3:
                    if (!cola.isEmpty()) {
                        String siguienteCliente = cola.peek();
                        JOptionPane.showMessageDialog(null, "Siguiente Cliente: " + siguienteCliente);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay clientes en la cola");
                    }
                    break;
                case 4: 
                    int numClientes = cola.size();
                    JOptionPane.showMessageDialog(null, "Quedan " + numClientes + " clientes en la cola");
                    break;
                case 5: 
                    cola.clear();
                    JOptionPane.showMessageDialog(null, "Cola vaciada");
                    break;
                case 6:
                    StringBuilder sb = new StringBuilder();
                    for (String cliente : cola) {
                        sb.append(cliente).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, "Cola:\n" + sb.toString());
                    break;
            }
            
        } while (opc != 7);

    }
}
