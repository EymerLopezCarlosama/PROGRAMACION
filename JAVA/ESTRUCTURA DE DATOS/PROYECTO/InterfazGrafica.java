package PROYECTO;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.print.PrinterException;

public class InterfazGrafica {
    // Atributos de la interfaz gráfica
    JFrame frame;
    // Lista de tipos de identificación
    private String[] tiposIdentificacion = {"Cédula de Ciudadanía", "Tarjeta de Identidad", "Pasaporte"};

    // Constructor de la interfaz gráfica
    public InterfazGrafica() {
        new Pasajero();
        new Ticket();
        new Vuelo();
        connectToDatabase(); // Conectar a la base de datos
        initialize(); // Inicializa la interfaz gráfica
    }

    // Método para conectar a la base de datos
    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Agregar esta línea
            String url = "jdbc:mysql://localhost:3306/basedatos";
            String user = "root";
            String password = "eymerl26";
            
            // Guardar la conexión en una variable
            Connection connection = DriverManager.getConnection(url, user, password);
            
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error con el driver de MySQL", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para inicializar la interfaz gráfica
    private void initialize() {
        frame = new JFrame("Sistema de Gestión de Vuelos");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.decode("#E3F2FD"));
        frame.getContentPane().add(panelPrincipal, "name_123");
        panelPrincipal.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Espacio entre los componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblTitulo = new JLabel("POR FAVOR SELECCIONE UN PROCESO");
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 16));
        gbc.gridwidth = 0;
        lblTitulo.setBounds(170, 30, 320, 50);
        panelPrincipal.add(lblTitulo, gbc);

        // Crear una dimensión fija para los botones
        Dimension buttonSize = new Dimension(200, 30);

        // Botón para adquirir un ticket
        JButton btnAdquirirVuelo = new JButton("Adquirir Vuelo");
        btnAdquirirVuelo.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnAdquirirVuelo.setForeground(Color.BLACK);
        btnAdquirirVuelo.setBackground(Color.decode("#007BFF"));
        btnAdquirirVuelo.setPreferredSize(buttonSize);
        gbc.gridy = 1;
        panelPrincipal.add(btnAdquirirVuelo, gbc);
        btnAdquirirVuelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adquirirVuelo(); // Llama al método para adquirir vuelo
            }
        });

        // Botón para imprimir ticket
        JButton btnImprimirTicket = new JButton("Imprimir Ticket");
        btnImprimirTicket.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnImprimirTicket.setForeground(Color.BLACK);
        btnImprimirTicket.setBackground(Color.decode("#007BFF"));
        btnImprimirTicket.setPreferredSize(buttonSize);
        gbc.gridy = 2;
        panelPrincipal.add(btnImprimirTicket, gbc);
        btnImprimirTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirTicket(); // Llama al método para imprimir ticket
            }
        });

        // Botón para modificar ticket y vuelo
        JButton btnModificar = new JButton("Modificar Ticket y Vuelo");
        btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnModificar.setForeground(Color.BLACK);
        btnModificar.setBackground(Color.decode("#007BFF"));
        btnModificar.setPreferredSize(buttonSize);
        gbc.gridy = 3;
        panelPrincipal.add(btnModificar, gbc);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarTicketYVuelo(); // Llama al método para modificar ticket y vuelo
            }
        });

        // Botón para salir del programa
        JButton btnSalir = new JButton("Salir del Programa");
        btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setBackground(Color.decode("#007BFF"));
        btnSalir.setPreferredSize(buttonSize);
        gbc.gridy = 4;
        panelPrincipal.add(btnSalir, gbc);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra el programa
            }
        });

        // Botón para el panel de administración
        JButton btnAdminPanel = new JButton("Panel de Administración");
        btnAdminPanel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnAdminPanel.setForeground(Color.BLACK);
        btnAdminPanel.setBackground(Color.decode("#007BFF"));
        btnAdminPanel.setPreferredSize(buttonSize); // Usa la misma dimensión fija de los otros botones
        gbc.gridy = 5; // Ajusta la posición en el GridBagLayout
        panelPrincipal.add(btnAdminPanel, gbc);

        // Listener para abrir el panel de administración
        btnAdminPanel.addActionListener(e -> adminPanel());

        frame.setVisible(true);
    }

    private void adquirirVuelo() {
        JFrame frameAdquirirVuelo = new JFrame("Adquirir Vuelo");
        frameAdquirirVuelo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAdquirirVuelo.setSize(500, 600);
        frameAdquirirVuelo.setLayout(new GridBagLayout());
        frameAdquirirVuelo.getContentPane().setBackground(Color.decode("#E3F2FD"));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Componentes se expanden horizontalmente
        gbc.anchor = GridBagConstraints.CENTER;
    
        // Título
        JLabel lblTitulo = new JLabel("Ingrese los datos del pasajero:");
        lblTitulo.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
        lblTitulo.setForeground(Color.BLACK);
        gbc.gridwidth = 2; // Abarca dos columnas
        gbc.gridx = 0;
        gbc.gridy = 0;
        frameAdquirirVuelo.add(lblTitulo, gbc);
    
        // Nombre Completo
        JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
        lblNombreCompleto.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblNombreCompleto.setForeground(Color.BLACK);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        frameAdquirirVuelo.add(lblNombreCompleto, gbc);
    
        JTextField nombreCompletoField = new JTextField();
        nombreCompletoField.setMargin(new Insets(5, 10, 5, 10)); // Espacio interno del campo
        gbc.gridx = 1;
        gbc.gridy = 1;
        frameAdquirirVuelo.add(nombreCompletoField, gbc);
    
        // Tipo de Identificación
        JLabel lblTipoIdentificacion = new JLabel("Tipo de Identificación:");
        lblTipoIdentificacion.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblTipoIdentificacion.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frameAdquirirVuelo.add(lblTipoIdentificacion, gbc);
    
        JComboBox<String> tipoIdentificacionComboBox = new JComboBox<>(tiposIdentificacion);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frameAdquirirVuelo.add(tipoIdentificacionComboBox, gbc);
    
        // Número de Identificación
        JLabel lblIdentificacion = new JLabel("Identificación:");
        lblIdentificacion.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblIdentificacion.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        frameAdquirirVuelo.add(lblIdentificacion, gbc);
    
        JTextField identificacionField = new JTextField();
        identificacionField.setMargin(new Insets(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 3;
        frameAdquirirVuelo.add(identificacionField, gbc);
    
        // Correo Electrónico
        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblCorreo.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        frameAdquirirVuelo.add(lblCorreo, gbc);
    
        JTextField correoField = new JTextField();
        correoField.setMargin(new Insets(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 4;
        frameAdquirirVuelo.add(correoField, gbc);
    
        // Teléfono
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblTelefono.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        frameAdquirirVuelo.add(lblTelefono, gbc);
    
        JTextField telefonoField = new JTextField();
        telefonoField.setMargin(new Insets(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 5;
        frameAdquirirVuelo.add(telefonoField, gbc);
    
        // Contacto de Emergencia
        JLabel lblContactoEmergencia = new JLabel("Nombre Contacto de Emergencia:");
        lblContactoEmergencia.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblContactoEmergencia.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        frameAdquirirVuelo.add(lblContactoEmergencia, gbc);
    
        JTextField contactoEmergenciaField = new JTextField();
        contactoEmergenciaField.setMargin(new Insets(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 6;
        frameAdquirirVuelo.add(contactoEmergenciaField, gbc);
    
        // Teléfono de Emergencia
        JLabel lblTelefonoEmergencia = new JLabel("Teléfono Emergencia:");
        lblTelefonoEmergencia.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblTelefonoEmergencia.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 7;
        frameAdquirirVuelo.add(lblTelefonoEmergencia, gbc);
    
        JTextField telefonoEmergenciaField = new JTextField();
        telefonoEmergenciaField.setMargin(new Insets(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 7;
        frameAdquirirVuelo.add(telefonoEmergenciaField, gbc);
    
        // Parentesco del Contacto de Emergencia
        JLabel lblParentescoEmergencia = new JLabel("Parentesco del Contacto:");
        lblParentescoEmergencia.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblParentescoEmergencia.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 8;
        frameAdquirirVuelo.add(lblParentescoEmergencia, gbc);
    
        JTextField parentescoEmergenciaField = new JTextField();
        parentescoEmergenciaField.setMargin(new Insets(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 8;
        frameAdquirirVuelo.add(parentescoEmergenciaField, gbc);
    
        // Botones
        JButton btnSeleccionarVuelo = new JButton("Seleccionar Vuelo");
        btnSeleccionarVuelo.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        btnSeleccionarVuelo.setBackground(Color.decode("#007BFF"));
        gbc.gridx = 0;
        gbc.gridy = 9;
        frameAdquirirVuelo.add(btnSeleccionarVuelo, gbc);
    
        JButton btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        btnAtras.setBackground(Color.decode("#DC3545"));
        gbc.gridx = 1;
        gbc.gridy = 9;
        frameAdquirirVuelo.add(btnAtras, gbc);
    
        // Listeners de botones
        btnAtras.addActionListener(e -> frameAdquirirVuelo.dispose());

        btnSeleccionarVuelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Selección de vuelo de partida
                Object[] vuelosPartida = {"CALI", "CARTAGENA", "SANTA MARTA", "MANIZALES", "POPAYAN", "BOGOTA", "MEDELLIN", "BOGOTA"};
                String vueloPartida = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, "Seleccione el vuelo de partida", "Vuelo de Partida", JOptionPane.QUESTION_MESSAGE, null, vuelosPartida, vuelosPartida[0]);

                if (vueloPartida != null) {
                    // Selección de vuelo de destino
                    Object[] vuelosDestino = {"CALI", "CARTAGENA", "SANTA MARTA", "MANIZALES", "POPAYAN", "BOGOTA", "MEDELLIN", "BOGOTA"};
                    String vueloDestino = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, "Seleccione el vuelo de destino", "Vuelo de Destino", JOptionPane.QUESTION_MESSAGE, null, vuelosDestino, vuelosDestino[0]);

                    if (vueloDestino != null) {
                        // Selección de hora
                        Object[] horas = {"8:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00"};
                        String hora = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, "Seleccione la hora", "Hora", JOptionPane.QUESTION_MESSAGE, null, horas, horas[0]);

                        if (hora != null) {
                            // Selección de fecha
                            JDateChooser dateChooser = new JDateChooser();
                            dateChooser.setDateFormatString("yyyy-MM-dd");
                            dateChooser.setMinSelectableDate(new Date()); // Esto evita que se seleccionen fechas pasadas

                            int result = JOptionPane.showConfirmDialog(frameAdquirirVuelo, dateChooser, 
                                "Seleccione la fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                
                            if (result == JOptionPane.OK_OPTION) {
                                Date selectedDate = (Date) dateChooser.getDate();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                String fecha = sdf.format(selectedDate);

                                // Selección de avión
                                Object[] aviones = {"ATR 42", "ATR 72", "Boeing 737"};
                                String avion = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, "Seleccione el avión", "Avión", JOptionPane.QUESTION_MESSAGE, null, aviones, aviones[0]);

                                if (avion != null) {
                                    // Guardar la información en la base de datos
                                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26")) {
                                        // Preparar la consulta para guardar el pasajero
                                        String sqlPasajero = "INSERT INTO Pasajero (nombreCompleto, tipoIdentificacion, identificacion, correoElectronico, telefono, nombreContactoEmergencia, telefonoContactoEmergencia, parentescoContactoEmergencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                                        int idPasajero = 0;
                                        try (PreparedStatement psPasajero = con.prepareStatement(sqlPasajero, Statement.RETURN_GENERATED_KEYS)) {
                                            psPasajero.setString(1, nombreCompletoField.getText());
                                            psPasajero.setString(2, (String) tipoIdentificacionComboBox.getSelectedItem());
                                            psPasajero.setString(3, identificacionField.getText());
                                            psPasajero.setString(4, correoField.getText());
                                            psPasajero.setString(5, telefonoField.getText());
                                            psPasajero.setString(6, contactoEmergenciaField.getText());
                                            psPasajero.setString(7, telefonoEmergenciaField.getText());
                                            psPasajero.setString(8, parentescoEmergenciaField.getText());
                                            psPasajero.executeUpdate(); // Ejecutar la inserción

                                            // Obtener el ID del pasajero insertado
                                            ResultSet rsPasajero = psPasajero.getGeneratedKeys();
                                            if (rsPasajero.next()) {
                                                idPasajero = rsPasajero.getInt(1);
                                            }
                                        }

                                        // Preparar la consulta para guardar el vuelo
                                        String sqlVuelo = "INSERT INTO Vuelo (origen, destino, horasalida, diasalida, aerolinea) VALUES (?, ?, ?, ?, ?)";
                                        int idVuelo = 0;
                                        try (PreparedStatement psVuelo = con.prepareStatement(sqlVuelo, Statement.RETURN_GENERATED_KEYS)) {
                                            psVuelo.setString(1, vueloPartida);
                                            psVuelo.setString(2, vueloDestino);
                                            psVuelo.setString(3, hora);
                                            psVuelo.setString(4, fecha);
                                            psVuelo.setString(5, avion);
                                            psVuelo.executeUpdate(); // Ejecutar la inserción

                                            // Obtener el ID del vuelo insertado
                                            ResultSet rsVuelo = psVuelo.getGeneratedKeys();
                                            if (rsVuelo.next()) {
                                                idVuelo = rsVuelo.getInt(1);
                                            }
                                        }

                                        // Selección de clase y tarifa
                                        Object[] opcionesClase = {"Económica", "Ejecutiva", "Primera Clase"};
                                        String clase = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, "Seleccione la clase del ticket", "Seleccionar Clase", JOptionPane.QUESTION_MESSAGE, null, opcionesClase, opcionesClase[0]);

                                        // Modificar el array de tarifas
                                        Object[] opcionesTarifa = {
                                            "Tarifa I - Bolso 5kg ($50000)",
                                            "Tarifa II - Bolso 10kg ($100000)",
                                            "Tarifa III - Bolso 12.5kg ($150000)",
                                            "Tarifa IV - Bolso 5kg + Maleta 17.5kg ($220000)",
                                            "Tarifa V - Bolso 12.5kg + Maleta 23.5kg ($580000)"
                                        };
                                        String tarifa = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, 
                                            "Seleccione la tarifa del ticket:\n\n" +
                                            "Tarifa I: Bolso pequeño (5kg)\n" +
                                            "Tarifa II: Bolso mediano (10kg)\n" +
                                            "Tarifa III: Bolso grande (12.5kg)\n" +
                                            "Tarifa IV: Bolso pequeño + maleta bodega pequeña (22.5kg)\n" +
                                            "Tarifa V: Bolso grande + maleta bodega grande (36kg)", 
                                            "Seleccionar Tarifa",
                                        JOptionPane.QUESTION_MESSAGE,null,opcionesTarifa,opcionesTarifa[0]
                                    );

                                        // Preparar la consulta para guardar el ticket
                                        String sqlTicket = "INSERT INTO Ticket (numeroVuelo, clase, tarifa, idPasajero, idVuelo) VALUES (?, ?, ?, ?, ?)";
                                        try (PreparedStatement psTicket = con.prepareStatement(sqlTicket)) {
                                            psTicket.setString(1, hora);
                                            psTicket.setString(2, clase);
                                            psTicket.setString(3, tarifa);
                                            psTicket.setInt(4, idPasajero);
                                            psTicket.setInt(5, idVuelo);
                                            psTicket.executeUpdate(); // Ejecutar la inserción
                                        }

                                        // Guardar la información en la tabla Impresion (Boleto de abordaje)
                                        String sqlImpresion = "INSERT INTO Impresion (nombreCompleto, tipoIdentificacion, identificacion, correoElectronico, telefono, nombreContactoEmergencia, telefonoContactoEmergencia, parentescoContactoEmergencia, origen, destino, horaSalida, diaSalida, aerolinea, clase, tarifa) "
                                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                                        try (PreparedStatement psImpresion = con.prepareStatement(sqlImpresion)) {
                                        psImpresion.setString(1, nombreCompletoField.getText());
                                        psImpresion.setString(2, (String) tipoIdentificacionComboBox.getSelectedItem());
                                        psImpresion.setString(3, identificacionField.getText());
                                        psImpresion.setString(4, correoField.getText());
                                        psImpresion.setString(5, telefonoField.getText());
                                        psImpresion.setString(6, contactoEmergenciaField.getText());
                                        psImpresion.setString(7, telefonoEmergenciaField.getText());
                                        psImpresion.setString(8, parentescoEmergenciaField.getText());
                                        psImpresion.setString(9, vueloPartida);
                                        psImpresion.setString(10, vueloDestino);
                                        psImpresion.setString(11, hora);
                                        psImpresion.setString(12, fecha);
                                        psImpresion.setString(13, avion);
                                        psImpresion.setString(14, clase);
                                        psImpresion.setString(15, tarifa);

                                        psImpresion.executeUpdate();
                                        System.out.println("Información guardada correctamente en la tabla Impresion.");
                                        } catch (SQLException ex) {  // Usé 'ex' aquí
                                        System.err.println("Error al guardar la información en la tabla Impresion.");
                                        ex.printStackTrace();
                                        }


                                        JOptionPane.showMessageDialog(frameAdquirirVuelo, "Vuelo adquirido exitosamente.");
                                        frameAdquirirVuelo.dispose();

                                        
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                        JOptionPane.showMessageDialog(frameAdquirirVuelo, "Error al guardar en la base de datos: " + ex.getMessage());
                                    }

                                

                                }
                            }
                        }
                    }
                }
            }
        });

        frameAdquirirVuelo.setVisible(true);
    }

    private void imprimirTicket() {
        JFrame frameImprimirTicket = new JFrame("Imprimir Ticket");
        frameImprimirTicket.setBounds(100, 100, 600, 400);
        frameImprimirTicket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameImprimirTicket.getContentPane().setLayout(null);
    
        JLabel lblTitulo = new JLabel("Ingrese su número de identificación:");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitulo.setBounds(10, 10, 300, 30);
        frameImprimirTicket.add(lblTitulo);
    
        JTextField identificacionField = new JTextField();
        identificacionField.setBounds(10, 50, 200, 25);
        frameImprimirTicket.add(identificacionField);
    
        JButton btnImprimir = new JButton("Imprimir Ticket");
        btnImprimir.setBounds(10, 90, 200, 30);
        frameImprimirTicket.add(btnImprimir);

        JButton btnAtras = new JButton("Atras");
        btnAtras.setBounds(10, 130, 200, 30);
        frameImprimirTicket.add(btnAtras);
        btnAtras.addActionListener(e -> frameImprimirTicket.dispose());
    
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String identificacion = identificacionField.getText();
                
                // Validación de identificación vacía
                if (identificacion.isEmpty()) {
                    JOptionPane.showMessageDialog(frameImprimirTicket, "Debe ingresar un número de identificación.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
    
                String query = "SELECT t.*, p.*, v.* " +
                         "FROM Ticket t " +
                         "JOIN Pasajero p ON t.idPasajero = p.id " +
                         "JOIN Vuelo v ON t.idVuelo = v.id " +
                         "WHERE p.identificacion = ?";
    
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
                     PreparedStatement ps = conn.prepareStatement(query)) {
    
                    ps.setString(1, identificacion);
                    ResultSet rs = ps.executeQuery();
    
                    if (rs.next()) {
                        StringBuilder contenidoTicket = new StringBuilder();
                            contenidoTicket.append("=== TICKET DE VUELO ===\n\n");
                            contenidoTicket.append("DATOS DEL PASAJERO:\n");
                            contenidoTicket.append("Nombre: ").append(rs.getString("nombreCompleto")).append("\n");
                            contenidoTicket.append("Identificación: ").append(rs.getString("identificacion")).append("\n");
                            contenidoTicket.append("Correo: ").append(rs.getString("correoElectronico")).append("\n");
                            contenidoTicket.append("Teléfono: ").append(rs.getString("telefono")).append("\n\n");
                            
                            contenidoTicket.append("DATOS DEL VUELO:\n");
                            contenidoTicket.append("Origen: ").append(rs.getString("origen")).append("\n");
                            contenidoTicket.append("Destino: ").append(rs.getString("destino")).append("\n");
                            contenidoTicket.append("Fecha: ").append(rs.getString("diasalida")).append("\n");
                            contenidoTicket.append("Hora: ").append(rs.getString("horasalida")).append("\n");
                            contenidoTicket.append("Aerolínea: ").append(rs.getString("aerolinea")).append("\n\n");
                            
                            contenidoTicket.append("DETALLES DEL TICKET:\n");
                            contenidoTicket.append("Clase: ").append(rs.getString("clase")).append("\n");
                            contenidoTicket.append("Tarifa: ").append(rs.getString("tarifa")).append("\n");
    
                        // Crear diálogo para mostrar el ticket
                        JDialog dialog = new JDialog(frameImprimirTicket, "Ticket", true);
                        dialog.setBounds(100, 100, 500, 600);
                        dialog.getContentPane().setLayout(new BorderLayout());

                        // Crear área de texto con estilo
                        JTextArea textArea = new JTextArea(contenidoTicket.toString());
                        textArea.setEditable(false);
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textArea.setMargin(new Insets(10, 10, 10, 10));
                        
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        dialog.getContentPane().add(scrollPane, BorderLayout.CENTER);

                        // Botón para cerrar/imprimir
                        JPanel buttonPanel = new JPanel();
                        JButton btnCerrar = new JButton("Cerrar");
                        JButton btnImprimirReal = new JButton("Imprimir");

    
                        btnCerrar.addActionListener(e1 -> dialog.dispose());
                        btnImprimirReal.addActionListener(e1 -> {
                        try {
                            textArea.print();
                        } catch (PrinterException ex) {
                            JOptionPane.showMessageDialog(dialog, 
                                "Error al imprimir: " + ex.getMessage(), 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    });

                    buttonPanel.add(btnImprimirReal);
                    buttonPanel.add(btnCerrar);
                    dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                    dialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frameImprimirTicket,
                        "No se encontró el ticket para la identificación proporcionada.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frameImprimirTicket,
                    "Error al obtener el ticket: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            }
        });
    
        frameImprimirTicket.setVisible(true);
    }
    

    private void modificarTicketYVuelo() {
        JFrame frameModificar = new JFrame("Modificar Ticket y Vuelo");
        frameModificar.setBounds(100, 100, 600, 400);
        frameModificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameModificar.getContentPane().setLayout(null);
        frameModificar.getContentPane().setBackground(Color.decode("#E3F2FD"));
    
        // Panel de búsqueda
        JLabel lblTitulo = new JLabel("Ingrese su número de identificación:");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBounds(10, 10, 300, 30);
        frameModificar.add(lblTitulo);
    
        JTextField identificacionField = new JTextField();
        identificacionField.setBounds(10, 50, 200, 25);
        frameModificar.add(identificacionField);
    
        JButton btnBuscar = new JButton("Buscar Ticket");
        btnBuscar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnBuscar.setBackground(Color.decode("#007BFF"));
        btnBuscar.setBounds(220, 50, 150, 25);
        frameModificar.add(btnBuscar);
    
        // Área de información actual
        JTextArea infoActualArea = new JTextArea();
        infoActualArea.setEditable(false);
        infoActualArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(infoActualArea);
        scrollPane.setBounds(10, 90, 560, 100);
        frameModificar.add(scrollPane);
    
        // Panel de modificación
        JPanel panelModificacion = new JPanel();
        panelModificacion.setLayout(null);
        panelModificacion.setBounds(10, 200, 560, 150);
        panelModificacion.setBackground(Color.decode("#E3F2FD"));
        frameModificar.add(panelModificacion);
    
        // ComboBox para clase
        JLabel lblClase = new JLabel("Nueva Clase:");
        lblClase.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblClase.setBounds(0, 0, 100, 25);
        panelModificacion.add(lblClase);
    
        String[] clases = {"Económica", "Ejecutiva", "Primera Clase"};
        JComboBox<String> claseComboBox = new JComboBox<>(clases);
        claseComboBox.setBounds(110, 0, 200, 25);
        panelModificacion.add(claseComboBox);
    
        // ComboBox para tarifa
        JLabel lblTarifa = new JLabel("Nueva Tarifa:");
        lblTarifa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblTarifa.setBounds(0, 35, 100, 25);
        panelModificacion.add(lblTarifa);
    
        String[] tarifas = {
            "Tarifa I - Bolso 5kg ($50000)",
            "Tarifa II - Bolso 10kg ($100000)",
            "Tarifa III - Bolso 12.5kg ($150000)",
            "Tarifa IV - Bolso 5kg + Maleta 17.5kg ($220000)",
            "Tarifa V - Bolso 12.5kg + Maleta 23.5kg ($580000)"
        };
        JComboBox<String> tarifaComboBox = new JComboBox<>(tarifas);
        tarifaComboBox.setBounds(110, 35, 300, 25);
        panelModificacion.add(tarifaComboBox);
    
        JButton btnModificar = new JButton("Confirmar Modificación");
        btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnModificar.setBackground(Color.decode("#007BFF"));
        btnModificar.setBounds(110, 70, 200, 30);
        btnModificar.setEnabled(false);
        panelModificacion.add(btnModificar);
    
        // Botón para cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnCancelar.setBackground(Color.decode("#DC3545"));
        btnCancelar.setBounds(320, 70, 100, 30);
        panelModificacion.add(btnCancelar);
    
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String identificacion = identificacionField.getText().trim();
                
                if (identificacion.isEmpty()) {
                    JOptionPane.showMessageDialog(frameModificar, 
                        "Por favor ingrese un número de identificación.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
    
                String query = "SELECT t.*, p.*, v.* " +
                             "FROM Ticket t " +
                             "JOIN Pasajero p ON t.idPasajero = p.id " +
                             "JOIN Vuelo v ON t.idVuelo = v.id " +
                             "WHERE p.identificacion = ?";
    
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
                     PreparedStatement ps = conn.prepareStatement(query)) {
                    
                    ps.setString(1, identificacion);
                    ResultSet rs = ps.executeQuery();
    
                    if (rs.next()) {
                        StringBuilder info = new StringBuilder();
                        info.append("Información Actual del Ticket:\n\n");
                        info.append("Pasajero: ").append(rs.getString("nombreCompleto")).append("\n");
                        info.append("Vuelo: ").append(rs.getString("origen")).append(" → ")
                            .append(rs.getString("destino")).append("\n");
                        info.append("Fecha: ").append(rs.getString("diasalida")).append("\n");
                        info.append("Hora: ").append(rs.getString("horasalida")).append("\n");
                        info.append("Clase actual: ").append(rs.getString("clase")).append("\n");
                        info.append("Tarifa actual: ").append(rs.getString("tarifa"));
    
                        infoActualArea.setText(info.toString());
                        btnModificar.setEnabled(true);
    
                        // Establecer valores actuales en los ComboBox
                        claseComboBox.setSelectedItem(rs.getString("clase"));
                        tarifaComboBox.setSelectedItem(rs.getString("tarifa"));
                    } else {
                        infoActualArea.setText("No se encontró ningún ticket para la identificación proporcionada.");
                        btnModificar.setEnabled(false);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameModificar,
                        "Error al buscar el ticket: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nuevaClase = (String) claseComboBox.getSelectedItem();
                String nuevaTarifa = (String) tarifaComboBox.getSelectedItem();
                String identificacion = identificacionField.getText().trim();
    
                int confirmacion = JOptionPane.showConfirmDialog(frameModificar,
                    "¿Está seguro de que desea modificar el ticket?\n\nNueva clase: " + nuevaClase + 
                    "\nNueva tarifa: " + nuevaTarifa,
                    "Confirmar modificación",
                    JOptionPane.YES_NO_OPTION);
    
                if (confirmacion == JOptionPane.YES_OPTION) {
                    String query = "UPDATE Ticket t " +
                                 "JOIN Pasajero p ON t.idPasajero = p.id " +
                                 "SET t.clase = ?, t.tarifa = ? " +
                                 "WHERE p.identificacion = ?";
    
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
                         PreparedStatement ps = conn.prepareStatement(query)) {
                        
                        ps.setString(1, nuevaClase);
                        ps.setString(2, nuevaTarifa);
                        ps.setString(3, identificacion);
    
                        int filasAfectadas = ps.executeUpdate();
                        if (filasAfectadas > 0) {
                            JOptionPane.showMessageDialog(frameModificar,
                                "Ticket modificado exitosamente.",
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                            frameModificar.dispose();
                        } else {
                            JOptionPane.showMessageDialog(frameModificar,
                                "No se pudo modificar el ticket.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frameModificar,
                            "Error al modificar el ticket: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    
        btnCancelar.addActionListener(e -> frameModificar.dispose());
    
        frameModificar.setVisible(true);
    }

    private void adminPanel() {
        // Create login frame for admin
        JFrame loginFrame = new JFrame("Admin Login");
        loginFrame.setBounds(100, 100, 400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.getContentPane().setLayout(new GridBagLayout());
        loginFrame.getContentPane().setBackground(Color.decode("#E3F2FD"));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        // Username field
        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginFrame.add(lblUsername, gbc);
    
        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginFrame.add(usernameField, gbc);
    
        // Password field
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginFrame.add(lblPassword, gbc);
    
        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginFrame.add(passwordField, gbc);
    
        // Login button
        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLogin.setBackground(Color.decode("#007BFF"));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginFrame.add(btnLogin, gbc);
    
        btnLogin.addActionListener(e -> {
            // Simple authentication - in production, use secure authentication
            if (usernameField.getText().equals("admin") && new String(passwordField.getPassword()).equals("admin123")) {
                loginFrame.dispose();
                showAdminPanel();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        loginFrame.setVisible(true);
    }
    
    private void showAdminPanel() {
        JFrame adminFrame = new JFrame("Panel de Administrador");
        adminFrame.setBounds(100, 100, 800, 600);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.getContentPane().setLayout(new BorderLayout());
        adminFrame.getContentPane().setBackground(Color.decode("#E3F2FD"));
    
        // Create main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#E3F2FD"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
    
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(Color.decode("#E3F2FD"));
        
        JLabel lblSearch = new JLabel("Buscar por identificación:");
        lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JTextField searchField = new JTextField(20);
        JButton btnSearch = new JButton("Buscar");
        btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSearch.setBackground(Color.decode("#007BFF"));
    
        searchPanel.add(lblSearch);
        searchPanel.add(searchField);
        searchPanel.add(btnSearch);
    
        // Results area
        JTextArea resultsArea = new JTextArea(15, 50);
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
    
        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.setBackground(Color.decode("#E3F2FD"));
    
        JButton btnDeletePassenger = new JButton("Eliminar Pasajero");
        btnDeletePassenger.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnDeletePassenger.setBackground(Color.decode("#DC3545"));
        
        JButton btnDeleteTicket = new JButton("Eliminar Ticket");
        btnDeleteTicket.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnDeleteTicket.setBackground(Color.decode("#DC3545"));
        
        JButton btnViewAll = new JButton("Ver Todos los Registros");
        btnViewAll.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnViewAll.setBackground(Color.decode("#007BFF"));
    
        buttonsPanel.add(btnDeletePassenger);
        buttonsPanel.add(btnDeleteTicket);
        buttonsPanel.add(btnViewAll);
    
        // Add components to main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(searchPanel, gbc);
    
        gbc.gridy = 1;
        mainPanel.add(scrollPane, gbc);
    
        gbc.gridy = 2;
        mainPanel.add(buttonsPanel, gbc);
    
        adminFrame.add(mainPanel);
    
        // Action Listeners
        btnSearch.addActionListener(e -> {
            String identificacion = searchField.getText().trim();
            if (!identificacion.isEmpty()) {
                searchPassenger(identificacion, resultsArea);
            }
        });
    
        btnDeletePassenger.addActionListener(e -> {
            String identificacion = searchField.getText().trim();
            if (!identificacion.isEmpty()) {
                deletePassenger(identificacion, resultsArea);
            } else {
                JOptionPane.showMessageDialog(adminFrame, "Por favor, ingrese una identificación para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        btnDeleteTicket.addActionListener(e -> {
            String identificacion = searchField.getText().trim();
            if (!identificacion.isEmpty()) {
                deleteTicket(identificacion, resultsArea);
            } else {
                JOptionPane.showMessageDialog(adminFrame, "Por favor, ingrese una identificación para eliminar el ticket", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        btnViewAll.addActionListener(e -> {
            viewAllRecords(resultsArea);
        });
    
        adminFrame.setVisible(true);
    }
    
    private void searchPassenger(String identificacion, JTextArea resultsArea) {
        String query = "SELECT p.*, t.*, v.* FROM Pasajero p " +
                      "LEFT JOIN Ticket t ON p.id = t.idPasajero " +
                      "LEFT JOIN Vuelo v ON t.idVuelo = v.id " +
                      "WHERE p.identificacion = ?";
    
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, identificacion);
            ResultSet rs = ps.executeQuery();
    
            StringBuilder result = new StringBuilder();
            if (rs.next()) {
                result.append("=== INFORMACIÓN DEL PASAJERO ===\n");
                result.append("Nombre: ").append(rs.getString("nombreCompleto")).append("\n");
                result.append("Identificación: ").append(rs.getString("identificacion")).append("\n");
                result.append("Correo: ").append(rs.getString("correoElectronico")).append("\n");
                result.append("Teléfono: ").append(rs.getString("telefono")).append("\n\n");
    
                if (rs.getString("origen") != null) {
                    result.append("=== INFORMACIÓN DEL VUELO ===\n");
                    result.append("Origen: ").append(rs.getString("origen")).append("\n");
                    result.append("Destino: ").append(rs.getString("destino")).append("\n");
                    result.append("Fecha: ").append(rs.getString("diasalida")).append("\n");
                    result.append("Hora: ").append(rs.getString("horasalida")).append("\n");
                    result.append("Clase: ").append(rs.getString("clase")).append("\n");
                    result.append("Tarifa: ").append(rs.getString("tarifa")).append("\n");
                }
            } else {
                result.append("No se encontró información para la identificación proporcionada.");
            }
    
            resultsArea.setText(result.toString());
    
        } catch (SQLException ex) {
            resultsArea.setText("Error al buscar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void deletePassenger(String identificacion, JTextArea resultsArea) {
        int confirm = JOptionPane.showConfirmDialog(null, 
            "¿Está seguro de eliminar todo el registro del pasajero? Esta acción no se puede deshacer.",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
    
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26")) {
                conn.setAutoCommit(false);
    
                // Primero eliminamos los registros relacionados en la tabla Ticket
                String deleteTicketsQuery = "DELETE t FROM Ticket t " +
                                          "JOIN Pasajero p ON t.idPasajero = p.id " +
                                          "WHERE p.identificacion = ?";
                
                try (PreparedStatement psTickets = conn.prepareStatement(deleteTicketsQuery)) {
                    psTickets.setString(1, identificacion);
                    psTickets.executeUpdate();
                }
    
                // Luego eliminamos al pasajero
                String deletePassengerQuery = "DELETE FROM Pasajero WHERE identificacion = ?";
                try (PreparedStatement psPassenger = conn.prepareStatement(deletePassengerQuery)) {
                    psPassenger.setString(1, identificacion);
                    int rowsAffected = psPassenger.executeUpdate();
    
                    if (rowsAffected > 0) {
                        conn.commit();
                        resultsArea.setText("Pasajero y sus registros relacionados eliminados exitosamente.");
                    } else {
                        conn.rollback();
                        resultsArea.setText("No se encontró el pasajero especificado.");
                    }
                }
            } catch (SQLException ex) {
                resultsArea.setText("Error al eliminar: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    private void deleteTicket(String identificacion, JTextArea resultsArea) {
        int confirm = JOptionPane.showConfirmDialog(null, 
            "¿Está seguro de eliminar el ticket del pasajero? Esta acción no se puede deshacer.",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
    
        if (confirm == JOptionPane.YES_OPTION) {
            String deleteQuery = "DELETE t FROM Ticket t " +
                               "JOIN Pasajero p ON t.idPasajero = p.id " +
                               "WHERE p.identificacion = ?";
    
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
                 PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
                
                ps.setString(1, identificacion);
                int rowsAffected = ps.executeUpdate();
    
                if (rowsAffected > 0) {
                    resultsArea.setText("Ticket eliminado exitosamente.");
                } else {
                    resultsArea.setText("No se encontró el ticket para la identificación especificada.");
                }
            } catch (SQLException ex) {
                resultsArea.setText("Error al eliminar el ticket: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    private void viewAllRecords(JTextArea resultsArea) {
        String query = "SELECT p.nombreCompleto, p.identificacion, v.origen, v.destino, " +
                      "v.diasalida, v.horasalida, t.clase, t.tarifa " +
                      "FROM Pasajero p " +
                      "LEFT JOIN Ticket t ON p.id = t.idPasajero " +
                      "LEFT JOIN Vuelo v ON t.idVuelo = v.id " +
                      "ORDER BY p.nombreCompleto";
    
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ResultSet rs = ps.executeQuery();
            StringBuilder result = new StringBuilder();
            result.append("=== TODOS LOS REGISTROS ===\n\n");
    
            while (rs.next()) {
                result.append("Pasajero: ").append(rs.getString("nombreCompleto")).append("\n");
                result.append("Identificación: ").append(rs.getString("identificacion")).append("\n");
                
                String origen = rs.getString("origen");
                if (origen != null) {
                    result.append("Vuelo: ").append(origen).append(" → ")
                          .append(rs.getString("destino")).append("\n");
                    result.append("Fecha: ").append(rs.getString("diasalida")).append("\n");
                    result.append("Hora: ").append(rs.getString("horasalida")).append("\n");
                    result.append("Clase: ").append(rs.getString("clase")).append("\n");
                    result.append("Tarifa: ").append(rs.getString("tarifa")).append("\n");
                } else {
                    result.append("(Sin vuelos registrados)\n");
                }
                result.append("------------------------\n");
            }
    
            resultsArea.setText(result.toString());
    
        } catch (SQLException ex) {
            resultsArea.setText("Error al obtener los registros: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new InterfazGrafica(); // Crear y mostrar la interfaz gráfica
            }
        });
        System.out.println("Conexión exitosa a la base de datos");

    }
}
