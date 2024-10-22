package PARCIAL;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<Integer>();
        int x = 99;

        pila.push(-2);
        pila.push(5);
        pila.push(50);
        pila.push(6);
        pila.push(80);
        pila.push(10);
        pila.push(100);
        pila.push(200);
        
        Stack<Integer> pilaAuxiliar = new Stack<Integer>();
            while (!pila.isEmpty()) {
                int elemento = pila.pop();
                    if (elemento >= x) {
                        pilaAuxiliar.push(elemento);
                    }
            }
        
            while (!pilaAuxiliar.isEmpty()) {
                pila.push(pilaAuxiliar.pop());
            }
        
        StringBuilder sb = new StringBuilder();
            while (!pila.isEmpty()) {
                int elemento = pila.pop();
                sb.append(elemento).append(" ");
        }

        String[] elementos = sb.toString().trim().split(" ");
        sb = new StringBuilder();
        for (int i = elementos.length - 1; i >= 0; i--) {
            sb.append(elementos[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        

    }
}
