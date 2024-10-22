package PILAS;

import javax.swing.*;
import java.util.Stack;

public class Ejemplo7 {

    public static void main(String[] args) {
        
        // Solicitar al usuario que ingrese una expresión matemática
        String entrada = JOptionPane.showInputDialog("Ingrese una expresion matematica");
        // Crear una pila para almacenar los paréntesis, corchetes y llaves
        Stack<Character> pila = new Stack<Character>();
        // Variable para controlar si la expresión está balanceada
        boolean balanceado = true;

        // Recorrer cada carácter de la expresión ingresada
        for (int i = 0; i < entrada.length(); i++) {
            char caracter = entrada.charAt(i);
            // Si es un paréntesis, corchete o llave de apertura, agregarlo a la pila
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                // Si es un paréntesis, corchete o llave de cierre, verificar si la pila está vacía
                if (pila.isEmpty()) {
                    balanceado = false;
                    break;
                }
                // Obtener el último carácter de apertura de la pila
                char ultimoCaracter = pila.pop();
                // Verificar si el carácter de cierre coincide con el último carácter de apertura
                if ((caracter == ')' && ultimoCaracter != '(') ||
                    (caracter == ']' && ultimoCaracter != '[') ||
                    (caracter == '}' && ultimoCaracter != '{')) {
                    balanceado = false;
                    break;
                }
            }
        }

        // Verificar si la expresión está balanceada y la pila está vacía
        if (balanceado && pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La expresion esta balanceada");
        } else {
            JOptionPane.showMessageDialog(null, "La expresion no esta balanceada");
        }

    }

}
