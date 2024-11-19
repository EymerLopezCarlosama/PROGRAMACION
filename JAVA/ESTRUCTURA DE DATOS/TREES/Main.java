package TREES;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Nodo {
    int valor;
    List<Nodo> hijos;

    public Nodo(int valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }
}

class ArbolNario {
    Nodo raiz;
    int contadorReales = 0;
    int contadorImaginarios = 0;
    int maxHijos;

    public ArbolNario(int valorRaiz, int maxHijos) {
        this.raiz = new Nodo(valorRaiz);
        this.maxHijos = maxHijos;
        contadorReales++;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public int getMaxHijos() {
        return maxHijos;
    }

    public void incrementarReales() {
        contadorReales++;
    }

    public void incrementarImaginarios() {
        contadorImaginarios++;
    }

    public int getContadorReales() {
        return contadorReales;
    }

    public int getContadorImaginarios() {
        return contadorImaginarios;
    }
}

class ArbolGrafico extends JPanel {
    private final ArbolNario arbol;

    public ArbolGrafico(ArbolNario arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arbol.getRaiz() != null) {
            dibujarNodo(g, arbol.getRaiz(), getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int distancia) {
        int numHijos = nodo.hijos.size();
        int espacio = distancia / (numHijos + 1);

        // Dibujar líneas y nodos hijos reales
        for (int i = 0; i < numHijos; i++) {
            Nodo hijo = nodo.hijos.get(i);
            int newX = x - distancia + (i + 1) * espacio;

            g.drawLine(x, y, newX, y + 50);
            dibujarNodo(g, hijo, newX, y + 50, distancia / 2);
        }

        // Dibuja el nodo actual
        g.setColor(new Color(173, 216, 230)); // Azul claro para nodos reales
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(nodo.valor), x - 7, y + 5);

        // Agregar nodos imaginarios, distribuidos en tres posiciones (izquierda, centro, derecha)
        if (nodo.hijos.size() < arbol.getMaxHijos()) {
            int numImaginarios = arbol.getMaxHijos() - nodo.hijos.size();
            for (int i = 0; i < numImaginarios; i++) {
                int positionFactor = (i % 3) - 1;  // -1 para izquierda, 0 para centro, 1 para derecha
                int imaginaryX = x + positionFactor * espacio;  // Distribuir en izquierda, centro y derecha
                int imaginaryY = y + 50;

                dibujarNodoImaginario(g, imaginaryX, imaginaryY);
            }
        }
    }

    private void dibujarNodoImaginario(Graphics g, int x, int y) {
        g.setColor(new Color(144, 238, 144)); // Verde para nodos imaginarios
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString("X", x - 5, y + 5);
    }
}

public class Main {
    public static void main(String[] args) {
        int valorRaiz = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del nodo raíz:"));
        int maxHijos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número máximo de hijos para cada nodo:"));
        
        // Crear el árbol con el valor de raíz y el número máximo de hijos
        ArbolNario arbol = new ArbolNario(valorRaiz, maxHijos);

        // Configuración de la ventana de visualización
        JFrame ventana = new JFrame("Visualización del Árbol N-ario");
        ArbolGrafico panel = new ArbolGrafico(arbol);
        ventana.add(panel);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        // Cola para gestionar los nodos
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(arbol.raiz);

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();

            int numHijos = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el número de hijos de " + nodoActual.valor + " (0 a " + maxHijos + "):"));

            for (int i = 0; i < numHijos; i++) {
                int valorHijo = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese el valor del hijo " + (i + 1) + " de " + nodoActual.valor + ":"));
                Nodo hijo = new Nodo(valorHijo);
                nodoActual.hijos.add(hijo);
                cola.add(hijo);
                arbol.incrementarReales();
            }

            // Agregar nodos imaginarios solo si es necesario para balancear
            if (numHijos < arbol.getMaxHijos()) {
                for (int i = numHijos; i < arbol.getMaxHijos(); i++) {
                    arbol.incrementarImaginarios();
                }
            }

            panel.repaint();  // Actualiza la visualización después de agregar nodos
        }

        // Mostrar los contadores de nodos reales e imaginarios
        JOptionPane.showMessageDialog(null, "Total de nodos reales: " + arbol.getContadorReales() +
                "\nTotal de nodos imaginarios: " + arbol.getContadorImaginarios());
    }
}
