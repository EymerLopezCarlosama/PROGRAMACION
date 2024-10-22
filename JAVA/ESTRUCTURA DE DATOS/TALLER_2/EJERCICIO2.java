package TALLER_2;

import javax.swing.JOptionPane;
import java.util.Stack;

public class EJERCICIO2 {

    // Método para determinar la precedencia de los operadores aritméticos
    // Devuelve un valor entero que indica la prioridad del operador.
    // Mayor valor indica mayor precedencia.
    private static int precedencia(char operador) {
        switch (operador) {
            case '+': 
            case '-': 
                return 1; // Precedencia baja
            case '*': 
            case '/': 
                return 2; // Precedencia media
            case '^':
                return 3; // Precedencia alta
        }
        return -1; // Retorna -1 si no es un operador reconocido
    }

    // Método para verificar si un carácter es un operador válido (+, -, *, /, ^)
    private static boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^';
    }

    // Método para convertir una expresión de notación infija a notación postfija (notación polaca inversa)
    public static String infijaAPostfija(String expresion) {
        // StringBuilder se usa para construir la expresión postfija
        StringBuilder resultado = new StringBuilder();
        // Stack para almacenar operadores y paréntesis
        Stack<Character> pila = new Stack<>();

        // Recorre cada carácter de la expresión infija
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            // Si el carácter es un operando (letra o dígito), lo añade directamente al resultado
            if (Character.isLetterOrDigit(caracter)) {
                resultado.append(caracter);
            }
            // Si es un paréntesis de apertura, lo coloca en la pila
            else if (caracter == '(') {
                pila.push(caracter);
            }
            // Si es un paréntesis de cierre, saca operadores de la pila hasta encontrar el paréntesis de apertura
            else if (caracter == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado.append(pila.pop()); // Añade operadores al resultado hasta encontrar '('
                }
                pila.pop();  // Elimina el '(' de la pila
            }
            // Si es un operador
            else if (esOperador(caracter)) {
                // Saca operadores de la pila mientras tengan mayor o igual precedencia que el operador actual
                while (!pila.isEmpty() && precedencia(caracter) <= precedencia(pila.peek())) {
                    resultado.append(pila.pop()); // Añade el operador con mayor precedencia al resultado
                }
                pila.push(caracter); // Coloca el operador actual en la pila
            }
        }

        // Una vez recorrida la expresión, saca todos los operadores restantes de la pila
        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }

        return resultado.toString(); // Devuelve la expresión convertida a postfija
    }

    // Método para convertir una expresión de notación infija a prefija (notación polaca)
    public static String infijaAPrefija(String expresion) {
        // Invertir la expresión infija para procesarla de derecha a izquierda
        StringBuilder invertida = new StringBuilder(expresion).reverse();
        
        // Cambia los paréntesis '(' por ')' y viceversa en la expresión invertida
        for (int i = 0; i < invertida.length(); i++) {
            if (invertida.charAt(i) == '(') {
                invertida.setCharAt(i, ')'); // Cambia '(' a ')'
            } else if (invertida.charAt(i) == ')') {
                invertida.setCharAt(i, '('); // Cambia ')' a '('
            }
        }
        
        // Convierte la expresión invertida a notación postfija
        String postfijaInvertida = infijaAPostfija(invertida.toString());
        
        // Invertir el resultado postfijo para obtener la expresión en notación prefija
        return new StringBuilder(postfijaInvertida).reverse().toString();
    }
    
    

    public static void main(String[] args) {
        // Solicita al usuario que ingrese una expresión en notación infija mediante una ventana emergente
        String expresionInfija = JOptionPane.showInputDialog(null, "Introduce una expresión infija:");

        // Verifica que se haya ingresado una expresión válida (no vacía)
        if (expresionInfija != null && !expresionInfija.trim().isEmpty()) {
            // Convierte la expresión infija a postfija
            String expresionPostfija = infijaAPostfija(expresionInfija);
            // Convierte la expresión infija a prefija
            String expresionPrefija = infijaAPrefija(expresionInfija);

            // Construye el mensaje con los resultados
            StringBuilder resultado = new StringBuilder();
            resultado.append("Expresión infija: ").append(expresionInfija).append("\n");
            resultado.append("Expresión postfija: ").append(expresionPostfija).append("\n");
            resultado.append("Expresión prefija: ").append(expresionPrefija);

            // Muestra los resultados en una ventana emergente
            JOptionPane.showMessageDialog(null, resultado.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);

        } else {
            // Muestra un mensaje de error si no se ingresó una expresión válida
            JOptionPane.showMessageDialog(null, "No se ingresó una expresión válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
