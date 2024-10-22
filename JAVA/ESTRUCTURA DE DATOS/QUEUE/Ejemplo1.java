package QUEUE;

import java.util.*;
import javax.swing.*;

public class Ejemplo1 {

    //Cola.add => Agregar elementos a la cola, arroja una excepción si la cola está llena
    //Cola.offer => Agregar elementos a la cola, devuelve false si la cola está llena
    //Cola.peek => Devuelve el primer elemento de la cola sin eliminarlo
    //Cola.element => Devuelve el primer elemento de la cola sin eliminarlo
    //Cola.poll => Devuelve el primer elemento de la cola y lo elimina
    //Cola.remove => Devuelve el primer elemento de la cola y lo elimina
    //Cola.size => Devuelve el número de elementos de la cola
    //Cola.isEmpty => Devuelve true si la cola está vacía
    //Cola.clear => Elimina todos los elementos de la cola
    //Cola.contains => Devuelve true si la cola contiene el elemento especificado
    //Cola.toArray => Devuelve una matriz con los elementos de la cola
    //Cola.iterator => Devuelve un iterador para recorrer la cola

    
        public static void main(String[] args) {
            Queue<Integer> cola = new LinkedList<>();
            
            // Agregar elementos a la cola
            cola.offer(10);
            cola.offer(20);
            cola.offer(30);
            
            // Imprimir la cola
            StringBuilder sb = new StringBuilder();
            sb.append("Cola: ").append("\n");
            List<Integer> listaInvertida = new ArrayList<>(cola);
            Collections.reverse(listaInvertida);
            for (Integer elemento : listaInvertida) {
                sb.append(elemento).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
            
            // Remover y mostrar el primer elemento
            JOptionPane.showMessageDialog(null, "Elemento removido: " + cola.poll());
            
            // Imprimir la cola actualizada
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cola actualizada: ").append("\n");
            List<Integer> listaInvertida2 = new ArrayList<>(cola);
            Collections.reverse(listaInvertida2);
            for (Integer elemento : listaInvertida2) {
                sb2.append(elemento).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb2.toString());

            JOptionPane.showMessageDialog(null, "Elemento removido: " + cola.poll());

            // Imprimir la cola actualizada
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cola actualizada: ").append("\n");
            for (Integer elemento : cola) {
                sb3.append(elemento).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb3.toString());

            JOptionPane.showMessageDialog(null, "Elemento removido: " + cola.poll());

            // Imprimir la cola actualizada
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Cola actualizada: ");
            if (cola.isEmpty()) {
                sb4.append("La cola está vacía");
            } else {
                for (Integer elemento : cola) {
                    sb4.append(elemento).append(" ");
                }
            }
            JOptionPane.showMessageDialog(null, sb4.toString());
            }

        }
    


