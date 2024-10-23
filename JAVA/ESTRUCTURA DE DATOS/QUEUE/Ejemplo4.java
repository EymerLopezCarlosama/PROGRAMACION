package QUEUE;

import javax.swing.JOptionPane;

public class Ejemplo4 {

    int[] pila;
    int tope, tamaño;

    // Constructor para inicializar la pila
    Ejemplo4(int tamaño) {
        this.tamaño = tamaño;
        pila = new int[tamaño];
        tope = -1; // Inicialmente la pila está vacía
    }

    // Método para apilar (insertar un elemento)
    void apilar(int valor) {
        if (estaLlena()) {
            JOptionPane.showMessageDialog(null, "La pila está llena");
        } else {
            pila[++tope] = valor;
            JOptionPane.showMessageDialog(null, "Elemento apilado: " + valor);
        }
    }

    // Método para desapilar (eliminar un elemento)
    int desapilar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
            return -1;
        } else {
            return pila[tope--];
        }
    }

    // Método para obtener el tope de la pila
    int obtenerTope() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
            return -1;
        } else {
            return pila[tope];
        }
    }

    // Método para mostrar los elementos de la pila
    String mostrarPila() {
        if (estaVacia()) {
            return "La pila está vacía";
        } else {
            StringBuilder elementos = new StringBuilder();
            for (int i = tope; i >= 0; i--) {
                elementos.append(pila[i]).append("\n");
            }
            return elementos.toString();
        }
    }

    // Método para verificar si la pila está vacía
    boolean estaVacia() {
        return tope == -1;
    }

    // Método para verificar si la pila está llena
    boolean estaLlena() {
        return tope == tamaño - 1;
    }

    // Método para vaciar la pila
    void vaciarPila() {
        tope = -1;
        JOptionPane.showMessageDialog(null, "La pila ha sido vaciada");
    }

    // Método para obtener el tamaño actual de la pila
    int obtenerTamaño() {
        return tope + 1;
    }

    // Método principal para mostrar el menú usando ventanas emergentes
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese el tamaño de la pila:");
        int tamaño = Integer.parseInt(input);

        Ejemplo4 miPila = new Ejemplo4(tamaño);
        int opcion;

        do {
            String menu = "Menú de operaciones de la pila:\n"
                        + "1. Apilar (Insertar)\n"
                        + "2. Desapilar (Eliminar)\n"
                        + "3. Obtener el tope de la pila\n"
                        + "4. Mostrar los elementos de la pila\n"
                        + "5. Verificar si la pila está vacía\n"
                        + "6. Verificar si la pila está llena\n"
                        + "7. Obtener el tamaño de la pila\n"
                        + "8. Vaciar la pila\n"
                        + "9. Salir\n"
                        + "Seleccione una opción:";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a apilar:"));
                    miPila.apilar(valor);
                    break;
                case 2:
                    int desapilado = miPila.desapilar();
                    if (desapilado != -1) {
                        JOptionPane.showMessageDialog(null, "Elemento desapilado: " + desapilado);
                    }
                    break;
                case 3:
                    int tope = miPila.obtenerTope();
                    if (tope != -1) {
                        JOptionPane.showMessageDialog(null, "El tope de la pila es: " + tope);
                    }
                    break;
                case 4:
                    String elementos = miPila.mostrarPila();
                    JOptionPane.showMessageDialog(null, elementos);
                    break;
                case 5:
                    if (miPila.estaVacia()) {
                        JOptionPane.showMessageDialog(null, "La pila está vacía");
                    } else {
                        JOptionPane.showMessageDialog(null, "La pila no está vacía");
                    }
                    break;
                case 6:
                    if (miPila.estaLlena()) {
                        JOptionPane.showMessageDialog(null, "La pila está llena");
                    } else {
                        JOptionPane.showMessageDialog(null, "La pila no está llena");
                    }
                    break;
                case 7:
                    int tamañoActual = miPila.obtenerTamaño();
                    JOptionPane.showMessageDialog(null, "El tamaño actual de la pila es: " + tamañoActual);
                    break;
                case 8:
                    miPila.vaciarPila();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        } while (opcion != 9);
    }
}

