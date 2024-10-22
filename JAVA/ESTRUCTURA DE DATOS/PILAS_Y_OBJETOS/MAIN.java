package PILAS_Y_OBJETOS;

import java.util.Stack;
import javax.swing.*;

public class MAIN {

    public static void main(String[] args) {
        
        Stack<Inventario> pila = new Stack<Inventario>();
        int n, stock;
        String nombre, codigo;
        n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos desea ingresar?"));
        for (int i = 0; i < n; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i+1));
            codigo = JOptionPane.showInputDialog("Ingrese el código del producto " + (i+1));
            stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto " + (i+1)));
            Inventario producto = new Inventario(nombre, Integer.parseInt(codigo), stock);
            pila.push(producto);
        }
        StringBuilder sb = new StringBuilder();
        while (!pila.empty()) {
            Inventario producto = (Inventario) pila.pop();
            if (producto.getStock() < 10) {
                sb.append(producto.getNombre()).append(" ").append(producto.getCodigo()).append(" ").append(producto.getStock()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Datos de los productos con stock menor a 10:\n" + sb.toString());


    }

}
