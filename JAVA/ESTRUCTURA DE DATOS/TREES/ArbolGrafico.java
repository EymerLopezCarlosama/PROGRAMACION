import javax.swing.*;
import java.awt.*;

public class ArbolGrafico extends JPanel {
    private NodoArbol raiz;

    public ArbolGrafico(NodoArbol raiz) {
        this.raiz = raiz;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            int ancho = getWidth();
            int xInicial = ancho / 2; // Nodo raíz centrado horizontalmente
            int yInicial = 50;       // Altura inicial de la raíz
            int nivelEspaciado = 70; // Distancia vertical entre niveles
            dibujarNodo(g, raiz, xInicial, yInicial, ancho / 4, nivelEspaciado);
        }
    }

    private void dibujarNodo(Graphics g, NodoArbol nodo, int x, int y, int xEspaciado, int nivelEspaciado) {
        if (nodo == null) {
            return;
        }

        // Dibujar líneas a los nodos hijos
        if (nodo.getNodIzq() != null) {
            int xIzq = x - xEspaciado;
            int yHijo = y + nivelEspaciado;
            g.drawLine(x, y, xIzq, yHijo);
            dibujarNodo(g, nodo.getNodIzq(), xIzq, yHijo, xEspaciado / 2, nivelEspaciado);
        }
        if (nodo.getNodDer() != null) {
            int xDer = x + xEspaciado;
            int yHijo = y + nivelEspaciado;
            g.drawLine(x, y, xDer, yHijo);
            dibujarNodo(g, nodo.getNodDer(), xDer, yHijo, xEspaciado / 2, nivelEspaciado);
        }

        // Dibujar el nodo actual
        g.setColor(Color.GREEN);
        g.fillOval(x - 15, y - 15, 30, 30); // Nodo circular
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(nodo.getValor()), x - 7, y + 5); // Texto centrado
    }
}
