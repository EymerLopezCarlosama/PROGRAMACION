package PILAS;

import java.util.Stack;
import javax.swing.*;


public class PRUEBA {

    public static void main(String[] args) {
        
        Stack <String> pila = new Stack<>();
        pila.push("1");
        pila.push("2");
        pila.push("3");
        pila.push("4");
        pila.push("5");
        pila.push("6");
        pila.push("7");
        pila.push("8");
        pila.push("9");
        pila.push("10");

            //Imprimir con SWING basandose en primero en entrar ultimo en salir
            StringBuilder mensaje = new StringBuilder("Elementos en la pila:\n");
            Stack<String> pilaTemp = new Stack<>();
        
            while (!pila.isEmpty()) {
                String elemento = pila.pop();
                mensaje.append(elemento).append("\n");
                pilaTemp.push(elemento);
            }
        
            while (!pilaTemp.isEmpty()) {
                pila.push(pilaTemp.pop());
            }
        
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Contenido de la Pila", JOptionPane.INFORMATION_MESSAGE);
        
        

    }

}
