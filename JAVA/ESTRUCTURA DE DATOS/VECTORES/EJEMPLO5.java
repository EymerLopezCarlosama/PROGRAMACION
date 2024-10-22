package VECTORES;

/* CREAR 2 VECTORES Y COMPARAR SI SUS DATOS SON IGUALES */


import javax.swing.*;

public class EJEMPLO5 {

    public static void main(String[] args) {
        
        int[] vector1 = {1, 2, 3, 4, 5};
        int[] vector2 = {1, 2, 3, 4, 5};
        boolean iguales = true;
        for (int i = 0; i < vector1.length; i++) {
            if (vector1[i] != vector2[i]) {
                iguales = false;
                break;
            }
        }
        if (iguales) {
            JOptionPane.showMessageDialog(null,"LOS VECTORES SON IGUALES");
        } else {
            JOptionPane.showMessageDialog(null, "LOS VECTORES NO SON IGUALES");
        }

    }

}
