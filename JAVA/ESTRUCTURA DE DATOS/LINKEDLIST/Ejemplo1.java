package LINKEDLIST;

import java.util.*;
import javax.swing.*;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10);

        // Obtener elemento en la pocision 6
        int elemento = lista.get(6);
        JOptionPane.showMessageDialog(null, "El elemento en la posición 6 es: " + elemento);

        // Sumar las pociciones 2 y 8
        int suma = lista.get(2) + lista.get(8);
        JOptionPane.showMessageDialog(null, "La suma de las posiciones 2 y 8 es: " + suma);

        // Eliminar el Primer Elemento de la lista
        int eliminado = lista.removeFirst();
        JOptionPane.showMessageDialog(null, "El elemento " + eliminado + " ha sido eliminado");

        StringBuilder sb = new StringBuilder();
        for (Integer num : lista) {
            sb.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, "La lista es: " + sb.toString());

        // Agregar un elemento al principio de la lista
        lista.addFirst(0);
        int agregado = lista.getFirst();
        JOptionPane.showMessageDialog(null, "El elemento "+ agregado + " ha sido agregado");

        StringBuilder sb2 = new StringBuilder();
        for (Integer num : lista) {
            sb2.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, "La lista es: " + sb2.toString());
        
    }
}
