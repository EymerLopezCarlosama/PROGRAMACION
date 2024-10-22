package REPASO_JAVA;

//Pedir tres números y mostrarlos ordenados de mayor a menor.

import javax.swing.*;
import java.util.*;

public class EJERCICIO3 {

    public static void main(String[] args) {
        
        try {

            String numero1 = JOptionPane.showInputDialog("Introduce el primer numero:");
            String numero2 = JOptionPane.showInputDialog("Introduce el segundo numero:");
            String numero3 = JOptionPane.showInputDialog("Introduce el tercer numero:");

            int num1 = Integer.parseInt(numero1);
            int num2 = Integer.parseInt(numero2);
            int num3 = Integer.parseInt(numero3);

            int[] numeros = {num1, num2, num3};

            Arrays.sort(numeros);

            // Invertir el array
            for (int i = 0; i < numeros.length / 2; i++) {
                int temp = numeros[i];
                numeros[i] = numeros[numeros.length - 1 - i];
                numeros[numeros.length - 1 - i] = temp;
            }

            String mensaje = "Números ordenados de mayor a menor:\n" + numeros[0] + ", " + numeros[1] + ", " + numeros[2];
            JOptionPane.showMessageDialog(null, mensaje);

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce solo números enteros válidos.");
        }

    }

}
