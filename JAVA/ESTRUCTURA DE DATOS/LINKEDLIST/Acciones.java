package LINKEDLIST;

import javax.swing.*;

public class Acciones{

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, 
                    "Comandos principales de LinkedList:\n\n" +
                    "1. add(elemento) - Agrega un elemento al final\n" +
                    "2. add(indice, elemento) - Agrega en posición específica\n" +
                    "3. addFirst(elemento) - Agrega al inicio\n" +
                    "4. addLast(elemento) - Agrega al final\n" +
                    "5. remove(elemento) - Elimina primera ocurrencia\n" +
                    "6. remove(indice) - Elimina elemento en posición\n" +
                    "7. removeFirst() - Elimina primer elemento\n" +
                    "8. removeLast() - Elimina último elemento\n" +
                    "9. get(indice) - Obtiene elemento en posición\n" +
                    "10. getFirst() - Obtiene primer elemento\n" +
                    "11. getLast() - Obtiene último elemento\n" +
                    "12. clear() - Elimina todos los elementos\n" +
                    "13. size() - Obtiene tamaño de la lista\n" +
                    "14. isEmpty() - Verifica si está vacía\n" +
                    "15. contains(elemento) - Verifica si contiene elemento",
                    "Comandos LinkedList",
                    JOptionPane.INFORMATION_MESSAGE);
        
    }

}
