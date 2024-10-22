package PILAS.OBJETOS;

import javax.swing.*;
import java.util.Stack;

public class MAIN {

    public static void main(String[] args) {
        OBJETOS OBJETOS = new OBJETOS();
        
        String Objec = JOptionPane.showInputDialog("Ingrese la expresion en notación postfija ¡CADA DIGITO DEBE IR SEPARADO POR UN ESPACIO!");
        String[] post = Objec.split(" ");

        Stack<String> E = new Stack<>();
        Stack<String> P = new Stack<>();

        for (int i = post.length - 1; i >= 0; i--) {
            E.push(post[i]);
        }

        String operadores = "+-*/%";

        while (!E.isEmpty()) {
            if (operadores.contains("" + E.peek())) {
                P.push(OBJETOS.evaluar(E.pop(), P.pop(), P.pop()) + "");
            } else {
                P.push(E.pop());
            }
        }

        JOptionPane.showMessageDialog(null, "Resultado: " + P.peek());
        JOptionPane.showMessageDialog(null, "Expresion: " + Objec);


    }

}
