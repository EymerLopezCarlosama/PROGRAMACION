package TALLER_2;


import java.util.Stack;
import javax.swing.*;

public class EJERCICIO4 {

    public static void main(String[] args) {
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entero:"));
        Stack<Integer> pila = new Stack<>();
        while (numero > 0) {
            int residuo = numero % 2;
            pila.push(residuo);
            numero /= 2;
        }
        StringBuilder binario = new StringBuilder();
        while (!pila.isEmpty()) {
            binario.append(pila.pop());
        }
        JOptionPane.showMessageDialog(null, "El número en binario es: " + binario);

    }}
