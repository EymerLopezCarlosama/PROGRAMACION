package PILAS;

// Crear una pila y sacar un elemento de la pila.

import java.util.Stack;
import javax.swing.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(9);

        // Sacar el elemento del medio
        int tamano = pila.size();
        int mitad = tamano / 2; // Para una pila de 5 elementos, mitad será 2

        Stack<Integer> pilaTemp = new Stack<>();

        // Mover elementos a pilaTemp hasta llegar al elemento del medio
        for (int i = 0; i < mitad; i++) {
            pilaTemp.push(pila.pop());
        }

        // Sacar el elemento del medio
        int elementoMedio = pila.pop();

        // Mover los elementos de vuelta a la pila original
        while (!pilaTemp.isEmpty()) {
            pila.push(pilaTemp.pop());
        }

        // Mostrar el elemento del medio
        JOptionPane.showMessageDialog(null, "Elemento del medio: " + elementoMedio);

        // Mostrar la pila después de eliminar el elemento del medio
        StringBuilder pilaMostrada = new StringBuilder("Elementos en la pila:\n");
        for (Integer elemento : pila) {
            pilaMostrada.append(elemento).append("\n");
        }
        JOptionPane.showMessageDialog(null, pilaMostrada.toString());
    }
}
