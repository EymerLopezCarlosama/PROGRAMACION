package PILAS;

/* Ordenas una pila usanso otra pila, se deben se dordenar en orden ascenente, sin usar arrays o listas
 */

import java.util.Stack;
import javax.swing.*;

public class Ejemplo9 {

    public static void main(String[] args) {
        // Crear una pila y agregar elementos
        Stack<Integer> pila = new Stack<>();
        pila.push(5);
        pila.push(2);
        pila.push(8);
        pila.push(1);
        pila.push(3);

        Stack<Integer> pilaOrdenada = new Stack<>();

        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            while (!pilaOrdenada.isEmpty() && pilaOrdenada.peek() < elemento) {
                pila.push(pilaOrdenada.pop());
            }
            pilaOrdenada.push(elemento);
        }
        StringBuilder sb = new StringBuilder();
        while (!pilaOrdenada.isEmpty()) {
            sb.append(pilaOrdenada.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
