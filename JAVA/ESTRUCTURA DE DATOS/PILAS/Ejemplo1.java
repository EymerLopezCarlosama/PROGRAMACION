package PILAS;

import java.util.Stack;
import javax.swing.*;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        Stack <Integer> pila = new Stack <Integer>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        

        StringBuilder mensaje = new StringBuilder("Elementos de la pila:\n");
        while (!pila.isEmpty()) {
            mensaje.append(pila.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Contenido de la Pila", JOptionPane.INFORMATION_MESSAGE);

        Stack <Integer> pila2 = new Stack<>();
        pila2.push(1);
        pila2.push(2);
        pila2.push(3);
        pila2.push(4);
        pila2.push(5);

        pila2.set(0, 10);

        StringBuilder mensaje2 = new StringBuilder("Elementos de la pila:\n");
        while (!pila2.isEmpty()) {
            mensaje2.append(pila2.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje2.toString(), "Contenido de la Pila", JOptionPane.INFORMATION_MESSAGE);
        
    }

}
