package LINKEDLIST;

import javax.swing.*;

public class Ejemplo2 {

    public static void main(String[] args) {

    Ejemplo2Salon salon = new Ejemplo2Salon();
    boolean salir = false;

    while (!salir){
        String opc = JOptionPane.showInputDialog("SALON DE BELLEZA \n 1. Agregar Cliente \n 2. Atender Cliente \n 3. Mostrar Lista de Espera \n 4. Salir");
        switch (opc) {
            case "1":
                String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
                String servicio = JOptionPane.showInputDialog("Ingrese Servicio");
                salon.agregarCliente(new Ejemplo2Cliente(nombre,servicio));
                break;
            case "2":
                salon.atenderCliente();
                break;
            case "3":
                salon.mostrarListaEspera();
                break;
            case "4":
                salir = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION CORRECTA");
                break;
        }
    }

    }    
}
