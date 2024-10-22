package PILAS;

import java.util.Stack;
import javax.swing.*;


// Programa que permita al usuario ingresar los numeros que el desee y los muestre

public class Ejemplo3 {

    public static void main(String[] args) {
        
        Stack<Integer> pila = new Stack<Integer>();
        int num;
        num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de valores a ingresar: "));
        for (int i = 0; i < num; i++) {
            pila.push(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor: ")));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(pila.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Los valores ingresados son: " + "\n" + sb.toString());

    }

}
