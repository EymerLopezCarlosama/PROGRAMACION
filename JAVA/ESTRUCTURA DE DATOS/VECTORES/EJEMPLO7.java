package VECTORES;

import javax.swing.*;

/*¨En tres vectores diferentes se guardan los nombres, temperaturas minimas y maximas de 5 ciudades.
 * - En el primer vector se guardan los nombres de las ciudades.
 * - En el segundo vector se guardan las temperaturas minimas de las ciudades.
 * - En el tercer vector se guardan las temperaturas maximas de las ciudades.
 * - Todo de la ultima semana.
 * 
 * Se necesita un programa que permita la carga de los datos en los vectores.
 * Ademas debera poder informar por pantalla cual fue la ciudad con mayor temperatura maxima y cual fue la ciudad con menor temperatura minima.
 */

public class EJEMPLO7 {

    public static void main(String[] args) {

        String[] ciudades = new String[5];
        float[] temperaturasMin = new float[5];
        float[] temperaturasMax = new float[5];

        try {
            for (int i = 0; i < ciudades.length; i++) {
                ciudades[i] = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad " + (i + 1));
                temperaturasMin[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la temperatura minima de la ciudad " + ciudades[i] + " en grados Centigrados"));
                temperaturasMax[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la temperatura maxima de la ciudad " + ciudades[i] + " en grados Centigrados"));
            }

            StringBuilder mensaje = new StringBuilder("Datos de las ciudades:\n\n");
            for (int i = 0; i < ciudades.length; i++) {
                mensaje.append("Ciudad: ").append(ciudades[i])
                       .append("\nTemperatura mínima: ").append(temperaturasMin[i]).append("°C")
                       .append("\nTemperatura máxima: ").append(temperaturasMax[i]).append("°C")
                       .append("\n\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());

            float maxTemp = 0;
            float minTemp = 0;
            String ciudadMaxTemp = "";
            String ciudadMinTemp = "";

            for (int i = 0; i < ciudades.length; i++) {
                float tempMax = temperaturasMax[i];
                float tempMin = temperaturasMin[i];
                String ciudadActual = ciudades[i];

                if (i == 0 || tempMax > maxTemp) {
                    maxTemp = tempMax;
                    ciudadMaxTemp = ciudadActual;
                }
                if (i == 0 || tempMin < minTemp) {
                    minTemp = tempMin;
                    ciudadMinTemp = ciudadActual;
                }
            }

            JOptionPane.showMessageDialog(null, "La ciudad con mayor temperatura maxima es: " + ciudadMaxTemp + " con " + maxTemp + " grados.");
            JOptionPane.showMessageDialog(null, "La ciudad con menor temperatura minima es: " + ciudadMinTemp + " con " + minTemp + " grados.");        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número válido para las temperaturas.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }
}