package PARCIAL;

import java.util.Stack;
import javax.swing.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();

        pila.push(4);
        pila.push(5);
        pila.push(6);
        pila.push(5);
        pila.push(4);
        pila.push(5);
        pila.push(7);

        StringBuilder imp = new StringBuilder();
        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            if (!pila.contains(elemento)) {
                imp.append(elemento).append(" ");
            }
            
        }
                    
        
        String[] elementos = imp.toString().trim().split(" ");
        imp = new StringBuilder();
        for (int i = elementos.length - 1; i >= 0; i--) {
            imp.append(elementos[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, imp.toString());       
    }    
}
