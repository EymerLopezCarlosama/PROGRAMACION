package QUEUE;

import java.util.*;
import javax.swing.*;

public class Ejemplo6Cafeteria {
    private Queue<Ejemplo6Pedido> colaPedidos;

    public Ejemplo6Cafeteria() {
        this.colaPedidos = new LinkedList<>();
    }

    public void registrarPedido() {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        Ejemplo6Pedido pedido = new Ejemplo6Pedido(nombreCliente);

        boolean agregarProducto = true;

        while (agregarProducto) {
            String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de " + producto + ":"));
            pedido.agregarProducto(producto, cantidad);

            // Pregunta si el usuario desea agregar más productos
            String respuesta = JOptionPane.showInputDialog("¿Desea agregar otro producto? (SI/NO)").toUpperCase();
            agregarProducto = respuesta.equals("SI") || respuesta.equals("S") || respuesta.equals("Y");

        }

        colaPedidos.offer(pedido);
        JOptionPane.showMessageDialog(null, "Pedido registrado exitosamente.");
    }

    public void atenderPedido() {
        Ejemplo6Pedido pedidoAtendido = colaPedidos.poll();
        if (pedidoAtendido != null) {
            JOptionPane.showMessageDialog(null, "Atendiendo pedido:\n" + pedidoAtendido.obtenerDetallePedido());
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos en la cola.");
        }
    }

    public void mostrarEstadoPedidos() {
        if (colaPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos pendientes.");
        } else {
            StringBuilder estado = new StringBuilder("Pedidos pendientes:\n");
            for (Ejemplo6Pedido pedido : colaPedidos) {
                estado.append(pedido.obtenerDetallePedido()).append("\n");
            }
            JOptionPane.showMessageDialog(null, estado.toString());
        }
    }
}