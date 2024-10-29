package QUEUE;

import java.util.*;

public class Ejemplo6Pedido {
    private String nombreCliente;
    private ArrayList<String> productos; // Lista de nombres de los productos
    private ArrayList<Integer> cantidades; // Lista de cantidades de los productos

    public Ejemplo6Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void agregarProducto(String producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
    }

    public String obtenerDetallePedido() {
        StringBuilder detalle = new StringBuilder("Cliente: " + nombreCliente + "\n");
        for (int i = 0; i < productos.size(); i++) {
            detalle.append(" - ").append(productos.get(i)).append(": ").append(cantidades.get(i)).append("\n");
        }
        return detalle.toString();
    }
}
