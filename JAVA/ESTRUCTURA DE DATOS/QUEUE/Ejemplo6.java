package QUEUE;

import javax.swing.*;

public class Ejemplo6 {
    public static void main(String[] args) {
        Ejemplo6Cafeteria sistema = new Ejemplo6Cafeteria();
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog("Sistema de Gestión de Pedidos - Cafetería\n"
                    + "1. Registrar Pedido\n"
                    + "2. Atender Pedido\n"
                    + "3. Verificar Estado de Pedidos Pendientes\n"
                    + "4. Salir");

            switch (opcion) {
                case "1":
                    sistema.registrarPedido();
                    break;
                case "2":
                    sistema.atenderPedido();
                    break;
                case "3":
                    sistema.mostrarEstadoPedidos();
                    break;
                case "4":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Gracias por usar el sistema!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        }
    }
}
