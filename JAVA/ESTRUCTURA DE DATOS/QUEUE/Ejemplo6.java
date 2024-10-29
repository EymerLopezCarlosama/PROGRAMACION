package QUEUE;

import javax.swing.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        Ejemplo6Pedido sistemaPedidos = new Ejemplo6Pedido();
        boolean salir = false;

        while (!salir) {
            String opc = JOptionPane.showInputDialog("Cafetería \n1. Registrar Pedido \n2. Atender Pedido \n3. Mostrar Pedidos \n4. Salir");

            switch (opc) {
                case "1":
                    String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    Ejemplo6Cliente cliente = new Ejemplo6Cliente(nombreCliente);

                    String producto = JOptionPane.showInputDialog("Ingrese el producto:");
                    int cantidad;
                    try {
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
                        if (cantidad <= 0) throw new NumberFormatException();
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Cantidad inválida. Debe ser un número positivo.");
                        break;
                    }

                    Ejemplo6Pedido nuevoPedido = new Ejemplo6Pedido(cliente, producto, cantidad);
                    sistemaPedidos.agregarPedido(nuevoPedido);
                    JOptionPane.showMessageDialog(null, "Pedido registrado para " + nombreCliente + ": " + producto + " - Cantidad: " + cantidad);
                    break;
                case "2":
                    sistemaPedidos.atenderPedido();
                    break;
                case "3":
                    sistemaPedidos.mostrarPedidos();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija entre 1 y 4.");
                    break;
            }
        }
    }
}
