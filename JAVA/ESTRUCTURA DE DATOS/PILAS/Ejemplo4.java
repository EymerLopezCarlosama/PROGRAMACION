package PILAS;

import java.util.Stack;
import javax.swing.*;

public class Ejemplo4 {

    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();
        int n, stock;
        String nombre, codigo;
        n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos desea ingresar?"));
        for (int i = 0; i < n; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i+1));
            codigo = JOptionPane.showInputDialog("Ingrese el código del producto " + (i+1));
            stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto " + (i+1)));
            pila.push(nombre + " " + codigo + " " + stock);

        } 
        StringBuilder sb = new StringBuilder();
        while (!pila.empty()) {
            String producto = pila.pop();
            String[] datos = producto.split(" ");
            if (Integer.parseInt(datos[2]) < 10) {
                sb.append(producto).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Datos de los productos con stock menor a 10:\n" + sb.toString());
        
    }
}
