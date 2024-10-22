package PILAS;

import java.util.Stack;  
import javax.swing.*;    
import java.awt.*;       
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.Random;  

public class Ejemplo8 {

    // Variables de instancia para los componentes gráficos
    JFrame frame;           
    JTextField textField;   
    JTextField campoBusqueda;  
    JButton botonAtras;     
    JButton botonAdelante;  

    // Pilas para manejar las páginas anteriores y futuras
    Stack<String> atras = new Stack<>();    
    Stack<String> adelante = new Stack<>(); 

    // Método para inicializar la interfaz gráfica
    private void inicialize() {
        
        // Configuración de la ventana principal 
        frame = new JFrame("NAVEGACION");
        frame.setBounds(100, 100, 600, 400);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().setLayout(new BorderLayout());  

        // Configuración de la barra de búsqueda
        campoBusqueda = new JTextField();  
        campoBusqueda.setBackground(Color.LIGHT_GRAY);  
        JPanel panelBusqueda = new JPanel(new BorderLayout()); 
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        panelBusqueda.add(campoBusqueda, BorderLayout.CENTER); 

        frame.getContentPane().add(panelBusqueda, BorderLayout.NORTH);  

        // Acción cuando el usuario presiona "Enter" en la barra de búsqueda
        campoBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pagina = campoBusqueda.getText().toUpperCase();  
                if (!pagina.isEmpty()) {
                    navegarANuevaPagina(pagina);  
                }
                campoBusqueda.setText("");
            }
        });

        // Configuración del campo de texto que muestra la página actual
        textField = new JTextField();  
        textField.setEditable(false);  
        textField.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));  
        textField.setHorizontalAlignment(JTextField.CENTER);  
        frame.getContentPane().add(textField, BorderLayout.CENTER);  

        // Panel para los botones (ATRÁS y ADELANTE)
        JPanel panelBotones = new JPanel();  
        panelBotones.setBackground(Color.DARK_GRAY);  

        // Configuración del botón ATRÁS
        botonAtras = new JButton("ATRÁS");  
        botonAtras.setBackground(Color.GRAY);  
        botonAtras.setForeground(Color.WHITE);  

        // Configuración del botón ADELANTE
        botonAdelante = new JButton("ADELANTE");  
        botonAdelante.setBackground(Color.GRAY);  
        botonAdelante.setForeground(Color.WHITE);  

        // Acciones cuando se presionan los botones
        botonAtras.addActionListener(e -> irAtras());  
        botonAdelante.addActionListener(e -> irAdelante());  

        // Añade los botones al panel y luego añade el panel a la ventana
        panelBotones.add(botonAtras);  
        panelBotones.add(botonAdelante);
        frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);  

        // Muestra la ventana
        frame.setVisible(true);  
    }

    // Método para generar un color aleatorio
    private Color generarColorAleatorio() {
        Random random = new Random();  
        int r = random.nextInt(256);  
        int g = random.nextInt(256);  
        int b = random.nextInt(256);  
        return new Color(r, g, b);    
    }

    private Color generarColorAleatorio2() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    // Método para navegar a una nueva página
    public void navegarANuevaPagina(String pagina) {
        if (atras.isEmpty()) {  
            atras.push(pagina);  
            adelante.clear();  
            textField.setText(pagina);  
            textField.setForeground(generarColorAleatorio());  
            textField.setBackground(generarColorAleatorio2());  
            actualizarBotones();  
        }
    }


    // Método para ir a la página anterior (ATRÁS)
    public void irAtras() {
        if (!atras.isEmpty()) {  // Verifica si hay páginas en la pila "atras"
            String paginaActual = atras.pop();  // Saca la página actual de la pila "atras"
            adelante.push(paginaActual);  // Mueve la página actual a la pila "adelante" (páginas futuras)
            
            if (!atras.isEmpty()) {  // Si aún quedan páginas en "atras"
                String paginaAnterior = atras.peek();  // Obtiene la página anterior (sin eliminarla)
                textField.setText(paginaAnterior);  // Muestra la página anterior en el campo de texto
                textField.setForeground(generarColorAleatorio());  
                textField.setBackground(generarColorAleatorio2());  
            }
            actualizarBotones();  
        }
    }

    // Método para ir a la página siguiente (ADELANTE)
    public void irAdelante() {
        if (!adelante.isEmpty()) {  // Verifica si hay páginas en la pila "adelante"
            String paginaSiguiente = adelante.pop();  // Saca la siguiente página de la pila "adelante"
            atras.push(paginaSiguiente);  // Mueve la página siguiente a la pila "atras" (páginas visitadas)
            textField.setText(paginaSiguiente);  // Muestra la página siguiente en el campo de texto
            textField.setForeground(generarColorAleatorio());  
            textField.setBackground(generarColorAleatorio2());  
            actualizarBotones();  
        }
    }

    // Método para habilitar o deshabilitar los botones dependiendo de las pilas
    private void actualizarBotones() {
        botonAtras.setEnabled(!atras.isEmpty());  // Habilita el botón "ATRÁS" si hay páginas en la pila "atras"
        botonAdelante.setEnabled(!adelante.isEmpty());  // Habilita el botón "ADELANTE" si hay páginas en la pila "adelante"
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        // Ejecuta la inicialización de la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new Ejemplo8().inicialize());  // Inicializa
    }
}
