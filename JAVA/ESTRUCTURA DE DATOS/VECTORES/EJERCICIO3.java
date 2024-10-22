package VECTORES;

import javax.swing.*;

/* Se quiere diseñar un programa que:
1º) Pida por teclado un número (dato entero).
2º) Pregunte al usuario si desea introducir otro o no (introducirá “si” o “no”).
3º) Repita los pasos 1º y 2º, mientras que, el usuario no responda “no”.
4º) Muestre por pantalla la suma y el promedio de los números introducidos por el
usuario. */

public class EJERCICIO3 {

    public static void main(String[] args) {
        
        try {
            
            String continuar;

            do {
                JOptionPane.showInputDialog("Ingrese un número entero:");

                continuar = JOptionPane.showInputDialog("¿Desea introducir otro número? (si/no)").toLowerCase();
            } while (continuar.equals("si"));
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR! INGRESE UN DATO VALIDO");
        }

    }

}
