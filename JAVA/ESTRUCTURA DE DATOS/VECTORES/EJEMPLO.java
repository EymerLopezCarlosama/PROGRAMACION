package VECTORES;


import javax.swing.*;

public class EJEMPLO {

    public static void main(String[] args) {

        try {

        float[] numeros = new float[3];	
        
        String sueldon1 = JOptionPane.showInputDialog("Introduce el sueldo:");
        float sueldo1 = Float.parseFloat(sueldon1);
        numeros[0] = sueldo1;

        String sueldon2 = JOptionPane.showInputDialog("Introduce el sueldo:");
        float sueldo2 = Float.parseFloat(sueldon2);
        numeros[1] = sueldo2;

        String sueldon3 = JOptionPane.showInputDialog("Introduce el sueldo:");
        float sueldo3 = Float.parseFloat(sueldon3);
        numeros[2] = sueldo3;

        // Buscar saldo por indice

        String indice = JOptionPane.showInputDialog("Introduce el indice del sueldo a buscar:");
        int indiceBuscado = Integer.parseInt(indice);
        float sueldoBuscado = numeros[indiceBuscado];
        JOptionPane.showMessageDialog(null, "El sueldo buscado es: " + sueldoBuscado);

        // Imprimir todos los datos
        StringBuilder mensaje = new StringBuilder("Todos los sueldos:\n");
        for (int i = 0; i < numeros.length; i++) {
            mensaje.append("Sueldo ").append(i + 1).append(": ").append(numeros[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());


    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR! , POR FAVOR INGRESE UN DATO VALIDO");
    }



    }

}
