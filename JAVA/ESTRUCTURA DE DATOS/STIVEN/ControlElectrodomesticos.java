package STIVEN;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlElectrodomesticos {
    ArrayList<Electrodomesticos> listaElectrodomesticos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void registrarElectrodomestico() {
        System.out.println("Ingresar el numero de Serial: ");
        int serial = scanner.nextInt();
        System.out.println("Ingrese la marca del Electrodomestico: ");
        String marca = scanner.next();
        System.out.println("Ingrese el Precio: ");
        double precio = scanner.nextDouble();

        Electrodomesticos electrodomestico = new Electrodomesticos();
        electrodomestico.setNumeroSerial(serial);
        electrodomestico.setMarcaElectrodomestico(marca);
        electrodomestico.setPrecioElectrodomestico(precio);
        listaElectrodomesticos.add(electrodomestico);
        System.out.println("Electrodomestico registrado con éxito.");
    }

    void consultarDatos() {
        if (listaElectrodomesticos.isEmpty()) {
            System.out.println("No hay electrodomésticos registrados.");
        } else {
            System.out.println("Listando Electrodomésticos:");
            for (Electrodomesticos electrodomestico : listaElectrodomesticos) {
                System.out.println("Serial: " + electrodomestico.getNumeroSerial() + "| Marca: " + electrodomestico.getMarcaElectrodomestico() + "| Precio: " + electrodomestico.getPrecioElectrodomestico());
            }
        }
    }

    void buscarPorSerial() {
        System.out.println("Buscando por número de Serial:");
        System.out.println("Digite el serial a buscar: ");
        int serialBuscar = scanner.nextInt();
        boolean encontrado = false;
        for (Electrodomesticos electrodomestico : listaElectrodomesticos) {
            if (electrodomestico.getNumeroSerial() == serialBuscar) {
                System.out.println("Marca: " + electrodomestico.getMarcaElectrodomestico());
                System.out.println("Precio: " + electrodomestico.getPrecioElectrodomestico());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Electrodoméstico NO encontrado.");
        }
    }

    void resetear() {
        listaElectrodomesticos.clear();
        System.out.println("Lista vacía.");
    }

    void menu() {
        int opcion;
        do {
            System.out.println("\n ++++ MENU DE OPCIONES ++++");
            System.out.println("1. Registrar Electrodoméstico");
            System.out.println("2. Consultar todos los registros");
            System.out.println("3. Eliminar Electrodoméstico");
            System.out.println("4. Buscar Electrodoméstico por Serial");
            System.out.println("5. Salir");
            System.out.print("Digite una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: registrarElectrodomestico(); break;
                case 2: consultarDatos(); break;
                case 3: resetear(); break;
                case 4: buscarPorSerial(); break;
                case 5: System.out.println("Saliendo del Programa."); break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion > 0 && opcion < 5);
    }
}
