package VECTORES;

import javax.swing.*;

/* Teniendo el valor de la hora trabajada de 4.000. Leer una cantidad de empleados y de
cada uno de ellos preguntar su nombre y la cantidad de horas trabajadas para calcularle el
sueldo total que cada uno de los empleados se ganara, mostrando el nombre respectivo y
su sueldo en pantalla. */

public class EJERCICIO2 {

            public static void main(String[] args) {        

                try {

                    int valor_hora = 4000;
            
                    String cant_empleados = JOptionPane.showInputDialog(null, "Cantidad de empleados");
                    int cant_empleados_int = Integer.parseInt(cant_empleados);
                    String[] nombres = new String[cant_empleados_int];
                    int[] horas_trabajadas_array = new int[cant_empleados_int];

                    // Implementar un ciclo que se repita de acuerdo a la cantidad de trabajadores solicitando su nombre y horas trabajadas para despues imprimir tods estos datos en una tabla
                    for (int i = 0; i < cant_empleados_int; i++) {
                        nombres[i] = JOptionPane.showInputDialog(null, "Nombre del empleado " + (i + 1));
                        String horas = JOptionPane.showInputDialog(null, "Horas trabajadas por " + nombres[i]);
                        horas_trabajadas_array[i] = Integer.parseInt(horas);
                    }

                    StringBuilder tabla = new StringBuilder();
                    tabla.append("Nombre  Horas  Sueldo\n");
                    tabla.append("------\t\t-----\t\t------\n");

                    for (int i = 0; i < cant_empleados_int; i++) {
                        int sueldo = horas_trabajadas_array[i] * valor_hora;
                        tabla.append(nombres[i]).append("  ")
                             .append(horas_trabajadas_array[i]).append("  $")
                             .append(sueldo).append("\n");
                    }

                    JOptionPane.showMessageDialog(null, tabla.toString(), "Tabla de Empleados", JOptionPane.INFORMATION_MESSAGE);

            
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR! INGRESE UN DATO VALIDO");
                }
        
            }
}
