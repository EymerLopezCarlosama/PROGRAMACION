package TALLER_2;

import javax.swing.*;
import java.util.Stack;

public class EJERCICIO3 {

    public static void main(String[] args) {
        
        String date = JOptionPane.showInputDialog("Ingrese una cadena de caracteres: ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < date.length(); i++) {
            stack.push(date.substring(i, i + 1));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        JOptionPane.showMessageDialog(null, sb.toString());


    }

}
