package VECTORES;

/* Mediante un vector muestre el alfaabeto */

import javax.swing.*;

public class EJEMPLO3 {

    public static void main(String[] args) {

        StringBuilder alfabeto = new StringBuilder();
        for (char letra = 'a'; letra <= 'z'; letra++) {
            alfabeto.append(letra).append("\n");
        }
        JOptionPane.showMessageDialog(null, alfabeto.toString(), "Alfabeto", JOptionPane.INFORMATION_MESSAGE);

    }

}
