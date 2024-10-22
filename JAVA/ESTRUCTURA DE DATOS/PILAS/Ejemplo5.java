package PILAS;

import java.util.Stack;
import javax.swing.*;

public class Ejemplo5 {
  public static void main(String[] args) {  
   
    // Solicitar al usuario que ingrese la expresión en notación postfija
    String expr = JOptionPane.showInputDialog("Ingrese la expresión en notación postfija ¡CADA DIGITO DEBE IR SEPARADO POR UN ESPACIO!");
    // Dividir la expresión en un array de strings, usando el espacio como separador
    String[] post = expr.split(" ");   
   
    // Declaración de las pilas
    Stack < String > E = new Stack < String > (); // Pila de entrada para almacenar los elementos de la expresión
    Stack < String > P = new Stack < String > (); // Pila de operandos para realizar las operaciones

    // Añadir los elementos del array 'post' a la Pila de entrada (E) en orden inverso
    for (int i = post.length - 1; i >= 0; i--) {
      E.push(post[i]);
    }
    // Algoritmo de Evaluación Postfija
    String operadores = "+-*/%"; // Cadena que contiene los operadores válidos
    while (!E.isEmpty()) {
      if (operadores.contains("" + E.peek())) {
        // Si el elemento en la cima de E es un operador, evaluar la operación
        P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
      }else {
        // Si no es un operador, simplemente mover el elemento de E a P
        P.push(E.pop());
      }
    }

    // Mostrar resultados:
    JOptionPane.showMessageDialog(null,"Expresion: " + expr); // Mostrar la expresión original
    JOptionPane.showMessageDialog(null,"Resultado: " + P.peek()); // Mostrar el resultado final (elemento en la cima de P)

  }

  private static int evaluar(String op, String n2, String n1) {
    int num1 = Integer.parseInt(n1);
    int num2 = Integer.parseInt(n2);
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    if (op.equals("%")) return (num1 % num2);
    return 0;
  }

}
