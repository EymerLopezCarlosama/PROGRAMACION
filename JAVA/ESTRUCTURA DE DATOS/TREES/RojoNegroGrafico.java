import javax.swing.*;
import java.awt.*;

// Clase Nodo
class Nodo {
    int valor;
    Nodo izquierdo, derecho, padre;
    boolean esRojo; // true si el nodo es rojo, false si es negro

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
        this.esRojo = true; // Los nuevos nodos se insertan como rojos inicialmente
    }
}

// Clase Árbol Rojo-Negro
class ArbolRojoNegro {
    private Nodo raiz;

    public ArbolRojoNegro() {
        raiz = null;
    }

    // Rotación a la izquierda
    private void rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        x.derecho = y.izquierdo;
        if (y.izquierdo != null) {
            y.izquierdo.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            raiz = y;
        } else if (x == x.padre.izquierdo) {
            x.padre.izquierdo = y;
        } else {
            x.padre.derecho = y;
        }
        y.izquierdo = x;
        x.padre = y;
    }

    // Rotación a la derecha
    private void rotarDerecha(Nodo x) {
        Nodo y = x.izquierdo;
        x.izquierdo = y.derecho;
        if (y.derecho != null) {
            y.derecho.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            raiz = y;
        } else if (x == x.padre.derecho) {
            x.padre.derecho = y;
        } else {
            x.padre.izquierdo = y;
        }
        y.derecho = x;
        x.padre = y;
    }

    // Insertar un nodo en el árbol
    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.izquierdo = null;
        nuevoNodo.derecho = null;

        Nodo y = null;
        Nodo x = raiz;

        while (x != null) {
            y = x;
            if (nuevoNodo.valor < x.valor) {
                x = x.izquierdo;
            } else {
                x = x.derecho;
            }
        }

        nuevoNodo.padre = y;
        if (y == null) {
            raiz = nuevoNodo; // El árbol estaba vacío
        } else if (nuevoNodo.valor < y.valor) {
            y.izquierdo = nuevoNodo;
        } else {
            y.derecho = nuevoNodo;
        }

        // Corregir las propiedades del Árbol Rojo-Negro
        arreglarInsercion(nuevoNodo);
    }

    // Corregir las propiedades del árbol tras la inserción
    private void arreglarInsercion(Nodo nodo) {
        Nodo tio;
        while (nodo.padre != null && nodo.padre.esRojo) {
            if (nodo.padre == nodo.padre.padre.izquierdo) {
                tio = nodo.padre.padre.derecho;
                if (tio.esRojo) { // Caso 1: El tío es rojo
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    nodo = nodo.padre.padre;
                } else {
                    if (nodo == nodo.padre.derecho) { // Caso 2: Nodo es hijo derecho
                        nodo = nodo.padre;
                        rotarIzquierda(nodo);
                    }
                    // Caso 3: Nodo es hijo izquierdo
                    nodo.padre.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    rotarDerecha(nodo.padre.padre);
                }
            } else {
                tio = nodo.padre.padre.izquierdo;
                if (tio.esRojo) { // Caso 1: El tío es rojo
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    nodo = nodo.padre.padre;
                } else {
                    if (nodo == nodo.padre.izquierdo) { // Caso 2: Nodo es hijo izquierdo
                        nodo = nodo.padre;
                        rotarDerecha(nodo);
                    }
                    // Caso 3: Nodo es hijo derecho
                    nodo.padre.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    rotarIzquierda(nodo.padre.padre);
                }
            }
        }
        raiz.esRojo = false; // La raíz siempre es negra
    }

    // Buscar un nodo
    public Nodo buscar(int valor) {
        Nodo actual = raiz;
        while (actual != null && valor != actual.valor) {
            if (valor < actual.valor) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return actual;
    }

    // Mostrar el árbol (In-Orden)
    public void mostrar() {
        mostrarInOrden(raiz);
    }

    private void mostrarInOrden(Nodo nodo) {
        if (nodo != null) {
            mostrarInOrden(nodo.izquierdo);
            System.out.print(nodo.valor + (nodo.esRojo ? "R " : "N "));
            mostrarInOrden(nodo.derecho);
        }
    }

    // Getter para la raíz
    public Nodo getRaiz() {
        return raiz;
    }

    // Métodos adicionales como eliminación pueden ser implementados aquí
}

// Clase para la representación gráfica
class ArbolRojoNegroGrafico {
    private Nodo raiz;

    public ArbolRojoNegroGrafico() {
        raiz = null;
    }

    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.izquierdo = null;
        nuevoNodo.derecho = null;

        Nodo y = null;
        Nodo x = raiz;

        while (x != null) {
            y = x;
            if (nuevoNodo.valor < x.valor) {
                x = x.izquierdo;
            } else {
                x = x.derecho;
            }
        }

        nuevoNodo.padre = y;
        if (y == null) {
            raiz = nuevoNodo;
        } else if (nuevoNodo.valor < y.valor) {
            y.izquierdo = nuevoNodo;
        } else {
            y.derecho = nuevoNodo;
        }

        arreglarInsercion(nuevoNodo);
    }

    private void arreglarInsercion(Nodo nodo) {
     Nodo tio;
     while (nodo.padre != null && nodo.padre.esRojo) {
         if (nodo.padre == nodo.padre.padre.izquierdo) {
             tio = nodo.padre.padre.derecho;
             if (tio != null && tio.esRojo) { // Verificar que el tío no sea null
                 nodo.padre.esRojo = false;
                 tio.esRojo = false;
                 nodo.padre.padre.esRojo = true;
                 nodo = nodo.padre.padre;
             } else {
                 if (nodo == nodo.padre.derecho) {
                     nodo = nodo.padre;
                     rotarIzquierda(nodo);
                 }
                 nodo.padre.esRojo = false;
                 nodo.padre.padre.esRojo = true;
                 rotarDerecha(nodo.padre.padre);
             }
         } else {
             tio = nodo.padre.padre.izquierdo;
             if (tio != null && tio.esRojo) { // Verificar que el tío no sea null
                 nodo.padre.esRojo = false;
                 tio.esRojo = false;
                 nodo.padre.padre.esRojo = true;
                 nodo = nodo.padre.padre;
             } else {
                 if (nodo == nodo.padre.izquierdo) {
                     nodo = nodo.padre;
                     rotarDerecha(nodo);
                 }
                 nodo.padre.esRojo = false;
                 nodo.padre.padre.esRojo = true;
                 rotarIzquierda(nodo.padre.padre);
             }
         }
     }
     raiz.esRojo = false; // La raíz siempre es negra
 } 

    private void rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        x.derecho = y.izquierdo;
        if (y.izquierdo != null) {
            y.izquierdo.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            raiz = y;
        } else if (x == x.padre.izquierdo) {
            x.padre.izquierdo = y;
        } else {
            x.padre.derecho = y;
        }
        y.izquierdo = x;
        x.padre = y;
    }

    private void rotarDerecha(Nodo x) {
        Nodo y = x.izquierdo;
        x.izquierdo = y.derecho;
        if (y.derecho != null) {
            y.derecho.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            raiz = y;
        } else if (x == x.padre.derecho) {
            x.padre.derecho = y;
        } else {
            x.padre.izquierdo = y;
        }
        y.derecho = x;
        x.padre = y;
    }

    public Nodo getRaiz() {
        return raiz;
    }
}

class VentanaArbol extends JPanel {
    private final ArbolRojoNegroGrafico arbol;

    public VentanaArbol(ArbolRojoNegroGrafico arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarArbol(g, arbol.getRaiz(), getWidth() / 2, 50, 100);
    }

    private void dibujarArbol(Graphics g, Nodo nodo, int x, int y, int offset) {
        if (nodo != null) {
            if (nodo.izquierdo != null) {
                g.drawLine(x, y, x - offset, y + 50);
                dibujarArbol(g, nodo.izquierdo, x - offset, y + 50, offset / 2);
            }
            if (nodo.derecho != null) {
                g.drawLine(x, y, x + offset, y + 50);
                dibujarArbol(g, nodo.derecho, x + offset, y + 50, offset / 2);
            }
            g.setColor(nodo.esRojo ? Color.RED : Color.BLACK);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(nodo.valor), x - 8, y + 5);
        }
    }

    
}

public class RojoNegroGrafico {
    public static void main(String[] args) {
        ArbolRojoNegroGrafico arbol = new ArbolRojoNegroGrafico();
        arbol.insertar(10);
        arbol.insertar(100);
        arbol.insertar(20);
        arbol.insertar(80);
        arbol.insertar(40);
        arbol.insertar(70);

        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.add(new VentanaArbol(arbol));
        ventana.setVisible(true);
    }
}
