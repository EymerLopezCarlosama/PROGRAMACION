import javax.swing.*;

public class ArbolMain {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        // Pedir valores al usuario
        String[] valores = JOptionPane.showInputDialog(
                "Ingrese los valores del árbol separados por espacios:").split(" ");
        for (String valor : valores) {
            arbol.insertar(Integer.parseInt(valor.trim()));
        }

        // Mostrar el árbol en una ventana gráfica
        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new ArbolGrafico(arbol.inicial)); // Enviar la raíz al panel gráfico
        frame.setVisible(true);

        // También mostrar los recorridos en un cuadro de diálogo
        StringBuilder sb = new StringBuilder();
        sb.append("Preorden: ").append(arbol.dispararPreorden()).append("\n");
        sb.append("Inorden: ").append(arbol.dispararInorden()).append("\n");
        sb.append("Postorden: ").append(arbol.dispararPostorden()).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
