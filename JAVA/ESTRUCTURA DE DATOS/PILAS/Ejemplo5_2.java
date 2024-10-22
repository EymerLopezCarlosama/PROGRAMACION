package PILAS;

import javax.swing.*;
import java.util.Stack;

public class Ejemplo5_2 {

    public static void main(String[] args) {
        
        String Objec = JOptionPane.showInputDialog("Ingrese la expresion en notación postfija ¡CADA DIGITO DEBE IR SEPARADO POR UN ESPACIO!");
        String[] post = Objec.split(" ");

        Stack <Integer> pila = new Stack<>();

        for (int i = 0; i < post.length; i++) {
            if (post[i].equals("+") || post[i].equals("-") || post[i].equals("*") || post[i].equals("/") || post[i].equals("^")) {
                int b = pila.pop();
                int a = pila.pop();
                int res = evaluar(post[i], a, b);
                pila.push(res);
            } else {
                pila.push(Integer.parseInt(post[i]));            
            }
        }


        StringBuilder resultado = new StringBuilder();
        resultado.append("Expresion: ");
        resultado.append(Objec);
        
        resultado.append("\n");

        resultado.append("Resultado: ");
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()).append(" ");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());

    }

    private static int evaluar(String op, int a, int b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Operador no válido: " + op);
        }
    }

}
