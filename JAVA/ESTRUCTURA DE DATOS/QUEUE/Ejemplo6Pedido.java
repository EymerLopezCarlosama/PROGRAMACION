package QUEUE;

import java.util.*;
import javax.swing.*;

public class Ejemplo6Pedido {

    private Ejemplo6Cliente cliente;
    private String producto;
    private int cantidad;

    Queue<Ejemplo6Pedido> colaPedidos;

    public Ejemplo6Pedido(Ejemplo6Cliente cliente, String producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Ejemplo6Pedido() {
        this.colaPedidos = new LinkedList<>();
    }

    public void agregarPedido(Ejemplo6Pedido pedido) {
        colaPedidos.offer(pedido);
    }

    public void atenderPedido() {
        if (colaPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos para atender.");
            return;
        }
        
        Ejemplo6Pedido pedidoAtendido = colaPedidos.poll();
        JOptionPane.showMessageDialog(null, "Pedido atendido de " + pedidoAtendido.cliente.getNombre() 
                                      + ": " + pedidoAtendido.producto + " - Cantidad: " + pedidoAtendido.cantidad);
    }

    public void mostrarPedidos() {
        if (colaPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.");
            return;
        }

        StringBuilder pedidos = new StringBuilder("PEDIDOS\n");
        for (Ejemplo6Pedido pedido : colaPedidos) {
            pedidos.append("Cliente: ").append(pedido.cliente.getNombre())
                   .append(" - Producto: ").append(pedido.producto)
                   .append(" - Cantidad: ").append(pedido.cantidad).append("\n");
        }
        JOptionPane.showMessageDialog(null, pedidos.toString());
    }
}
