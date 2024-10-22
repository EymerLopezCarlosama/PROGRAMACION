package VECTORES;

import java.util.*;

import javax.swing.JOptionPane;

public class EJEMPLO6 {

        public static void main(String[] args) {
        
            Vector<String> vector = new Vector<>(2, 2);
            vector.add("Hola");
            vector.add("Mundo");
            vector.add("!");
            vector.add("\n");
            vector.addElement("Adios");
            vector.addElement("Mundo");
            vector.addElement("!");
        
            JOptionPane.showMessageDialog(null, vector.toString() + " \n " + "Tamaño " + vector.size(), "Practica", 2);
            vector.insertElementAt("Ciao", 1);
            JOptionPane.showMessageDialog(null, vector, "Practica", 2);
            vector.set(1, "Gran");
            vector.set(2, "Amigo");
            JOptionPane.showMessageDialog(null, vector, "Practica", 2);
        

            Vector<Integer> vector2 = new Vector<>(2,2);
            vector2.add(1);
            vector2.add(2);
            vector2.add(3);
            vector2.addElement(4);
            vector2.addElement(5);
            vector2.addElement(6);
            JOptionPane.showMessageDialog(null, vector2, "Practica2", 0);

            vector2.insertElementAt(7, 6);
            JOptionPane.showMessageDialog(null, vector2, null, 0);
            vector2.remove(0);
            JOptionPane.showMessageDialog(null, vector2, null, 0);
            vector2.clear();
            JOptionPane.showMessageDialog(null, vector2, null, 0);
        }

}
