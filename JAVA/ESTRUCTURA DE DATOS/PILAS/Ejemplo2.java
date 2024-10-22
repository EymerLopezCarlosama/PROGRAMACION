package PILAS;

import java.util.Stack;
import javax.swing.*;


public class Ejemplo2 {

    public static void main(String[] args) {
        Stack<String> pila = new Stack<String>();
        for (int i = 0; i < 5; i++) {
            String datos = JOptionPane.showInputDialog("Ingrese un dato");
            pila.push(datos);
        }

        StringBuilder sb = new StringBuilder();
        while (!pila.isEmpty()) {
            sb.append(pila.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

}
