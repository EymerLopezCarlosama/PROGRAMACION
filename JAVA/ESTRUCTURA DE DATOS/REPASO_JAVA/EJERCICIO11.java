package REPASO_JAVA;

/*Usando funciones y la sentencia switch, escribir un programa que pida los datos
necesarios y calcule el área y el perímetro para cada figura indicada.
    a) Un cuadrado
    b) Un rectángulo
    c) Un triángulo
    d) Un círculo. */

import javax.swing.*;

public class EJERCICIO11 {

    public static void main(String[] args) {

        try {
            
            int opcion;
            double lado, base, altura, radio;
            double area, perimetro;
            
            String[] unidades = {"cm", "m", "km"};
            String unidad = (String) JOptionPane.showInputDialog(null, "Elija la unidad de medida:",
                    "Unidad de Medida", JOptionPane.QUESTION_MESSAGE, null, unidades, unidades[0]);

            opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una figura:\n1. Cuadrado\n2. Rectángulo\n3. Triángulo\n4. Círculo"));

            switch (opcion) {
                case 1:
                    lado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado del cuadrado (" + unidad + "):"));
                    area = lado * lado;
                    perimetro = 4 * lado;
                    JOptionPane.showMessageDialog(null, String.format("Área del cuadrado: %.2f %s²\nPerímetro del cuadrado: %.2f %s", area, unidad, perimetro, unidad));
                    break;
                case 2:
                    base = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la base del rectángulo (" + unidad + "):"));
                    altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura del rectángulo (" + unidad + "):"));
                    area = base * altura;
                    perimetro = 2 * (base + altura);
                    JOptionPane.showMessageDialog(null, String.format("Área del rectángulo: %.2f %s²\nPerímetro del rectángulo: %.2f %s", area, unidad, perimetro, unidad));
                    break;
                case 3:
                    base = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la base del triángulo (" + unidad + "):"));
                    altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura del triángulo (" + unidad + "):"));
                    area = 0.5 * base * altura;
                    perimetro = base + 2 * Math.sqrt(Math.pow(base / 2, 2) + Math.pow(altura, 2));
                    JOptionPane.showMessageDialog(null, String.format("Área del triángulo: %.2f %s²\nPerímetro del triángulo: %.2f %s", area, unidad, perimetro, unidad));
                    break;
                case 4:
                    radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo (" + unidad + "):"));
                    area = Math.PI * Math.pow(radio, 2);
                    perimetro = 2 * Math.PI * radio;
                    JOptionPane.showMessageDialog(null, String.format("Área del círculo: %.2f %s²\nPerímetro del círculo: %.2f %s", area, unidad, perimetro, unidad));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }
}