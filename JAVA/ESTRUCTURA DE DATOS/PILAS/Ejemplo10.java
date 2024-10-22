package PILAS;

/* Dada una pila de numeros y dado un valor x= 150 escribir un programa que elinime aquellos menores a x */

import java.util.Stack;
import javax.swing.*;

public class Ejemplo10 {

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<Integer>();
        int x = 150;
        int valor;

        for (int i = 0; i < 8; i++) {
            valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));
            pila.push(valor);
        }
        
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
        JOptionPane.showMessageDialog(null,sb.toString());
        

    }

}
