package PROYECTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

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
            // Cambia estos valores a los adecuados para tu configuración
            String url = "jdbc:mysql://localhost:3306/basedatos";
            String user = "root";
            String password = "eymerl26";
            DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
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
        frame.setVisible(true);
    }

    private void adquirirVuelo() {
        JFrame frameAdquirirVuelo = new JFrame("Adquirir Vuelo");
        frameAdquirirVuelo.setBounds(100, 100, 600, 400);
        frameAdquirirVuelo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAdquirirVuelo.getContentPane().setLayout(null);
        frameAdquirirVuelo.getContentPane().setBackground(Color.decode("#E3F2FD"));

        JLabel lblTitulo = new JLabel("Ingrese los datos del pasajero:");
        lblTitulo.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBounds(10, 10, 300, 30);
        frameAdquirirVuelo.add(lblTitulo);

        // Campo para ingresar el nombre completo
        JTextField nombreCompletoField = new JTextField();
        nombreCompletoField.setBounds(145, 50, 200, 25);
        frameAdquirirVuelo.add(nombreCompletoField);

        JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
        lblNombreCompleto.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblNombreCompleto.setForeground(Color.BLACK);
        lblNombreCompleto.setBounds(20, 50, 200, 25);
        frameAdquirirVuelo.add(lblNombreCompleto);

        // ComboBox para seleccionar el tipo de identificación
        JComboBox<String> tipoIdentificacionComboBox = new JComboBox<>(tiposIdentificacion);
        tipoIdentificacionComboBox.setBounds(165, 80, 200, 25);
        frameAdquirirVuelo.add(tipoIdentificacionComboBox);

        JLabel lblTipoIdentificacion = new JLabel("Tipo de Identificación:");
        lblTipoIdentificacion.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblTipoIdentificacion.setForeground(Color.BLACK);
        lblTipoIdentificacion.setBounds(20, 80, 200, 25);
        frameAdquirirVuelo.add(lblTipoIdentificacion);

        // Campo para ingresar el número de identificación
        JTextField identificacionField = new JTextField();
        identificacionField.setBounds(115, 110, 200, 25);
        frameAdquirirVuelo.add(identificacionField);

        JLabel lblIdentificacion = new JLabel("Identificación:");
        lblIdentificacion.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblIdentificacion.setForeground(Color.BLACK);
        lblIdentificacion.setBounds(20, 110, 200, 25);
        frameAdquirirVuelo.add(lblIdentificacion);

        // Campo para ingresar el correo electrónico
        JTextField correoField = new JTextField();
        correoField.setBounds(145, 140, 200, 25);
        frameAdquirirVuelo.add(correoField);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblCorreo.setForeground(Color.BLACK);
        lblCorreo.setBounds(20, 140, 200, 25);
        frameAdquirirVuelo.add(lblCorreo);

        // Campo para ingresar el teléfono
        JTextField telefonoField = new JTextField();
        telefonoField.setBounds(85, 170, 200, 25);
        frameAdquirirVuelo.add(telefonoField);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setBounds(20, 170, 200, 25);
        frameAdquirirVuelo.add(lblTelefono);

        // Campo para ingresar el nombre de contacto de emergencia
        JTextField contactoEmergenciaField = new JTextField();
        contactoEmergenciaField.setBounds(185, 200, 200, 25);
        frameAdquirirVuelo.add(contactoEmergenciaField);

        JLabel lblContactoEmergencia = new JLabel("Nombre Contacto de Emergencia:");
        lblContactoEmergencia.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblContactoEmergencia.setForeground(Color.BLACK);
        lblContactoEmergencia.setBounds(20, 200, 200, 25);
        frameAdquirirVuelo.add(lblContactoEmergencia);

        // Campo para ingresar el teléfono de contacto de emergencia
        JTextField telefonoEmergenciaField = new JTextField();
        telefonoEmergenciaField.setBounds(185, 230, 200, 25);
        frameAdquirirVuelo.add(telefonoEmergenciaField);

        JLabel lblTelefonoEmergencia = new JLabel("Teléfono Emergencia:");
        lblTelefonoEmergencia.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblTelefonoEmergencia.setForeground(Color.BLACK);
        lblTelefonoEmergencia.setBounds(20, 230, 200, 25);
        frameAdquirirVuelo.add(lblTelefonoEmergencia);

        // Campo para ingresar el parentesco del contacto de emergencia
        JTextField parentescoEmergenciaField = new JTextField();
        parentescoEmergenciaField.setBounds(175, 260, 200, 25);
        frameAdquirirVuelo.add(parentescoEmergenciaField);

        JLabel lblParentescoEmergencia = new JLabel("Parentesco Contacto:");
        lblParentescoEmergencia.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        lblParentescoEmergencia.setForeground(Color.BLACK);
        lblParentescoEmergencia.setBounds(20, 260, 200, 25);
        frameAdquirirVuelo.add(lblParentescoEmergencia);

        // Campo para seleccionar el vuelo
        JButton btnSeleccionarVuelo = new JButton("Seleccionar Vuelo");
        btnSeleccionarVuelo.setBounds(10, 290, 200, 30);
        btnSeleccionarVuelo.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
        btnSeleccionarVuelo.setBackground(Color.decode("#007BFF"));
        frameAdquirirVuelo.add(btnSeleccionarVuelo);

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
                            JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
                            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
                            dateSpinner.setEditor(dateEditor);
                            int result = JOptionPane.showConfirmDialog(frameAdquirirVuelo, dateSpinner, "Seleccione la fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                            if (result == JOptionPane.OK_OPTION) {
                                Date selectedDate = (Date) dateSpinner.getValue();
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
                                        String sqlVuelo = "INSERT INTO Vuelo (origen, destino, hora_salida, dia_salida, aerolinea) VALUES (?, ?, ?, ?, ?)";
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

                                        Object[] opcionesTarifa = {
                                            "Tarifa I: Incluye un bolso pequeño de 5 kg con precio $50000",
                                            "Tarifa II: Incluye un bolso mediano de 10 kg con precio $100000",
                                            "Tarifa III: Incluye un bolso grande de 12,5 kg con precio $150000",
                                            "Tarifa IV: Incluye un bolso pequeño de 5 kg + una maleta de bodega pequeña de 17.5 kg, con un precio de $220000",
                                            "Tarifa V: Incluye un bolso grande de 12,5 kg + una maleta de bodega grande de 23,5 kg, con un precio de $580000"
                                        };
                                        String tarifa = (String) JOptionPane.showInputDialog(frameAdquirirVuelo, "Seleccione la tarifa del ticket", "Seleccionar Tarifa", JOptionPane.QUESTION_MESSAGE, null, opcionesTarifa, opcionesTarifa[0]);

                                        // Preparar la consulta para guardar el ticket
                                        String sqlTicket = "INSERT INTO Ticket (Numero_vuelo, clase, tarifa, pasajero_id, vuelo_id) VALUES (?, ?, ?, ?, ?)";
                                        try (PreparedStatement psTicket = con.prepareStatement(sqlTicket)) {
                                            psTicket.setString(1, hora);
                                            psTicket.setString(2, clase);
                                            psTicket.setString(3, tarifa);
                                            psTicket.setInt(4, idPasajero);
                                            psTicket.setInt(5, idVuelo);
                                            psTicket.executeUpdate(); // Ejecutar la inserción
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
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String identificacion = identificacionField.getText();
                String query = "SELECT * FROM Ticket WHERE identificacion = ?";
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
                     PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, identificacion);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        String contenidoTicket = "Clase: " + rs.getString("clase") + "\nTarifa: " + rs.getString("tarifa");

                        JDialog dialog = new JDialog(frameImprimirTicket, "Ticket", true);
                        dialog.setBounds(100, 100, 500, 400);
                        dialog.getContentPane().setLayout(new BorderLayout());

                        JTextArea textArea = new JTextArea(contenidoTicket);
                        textArea.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        dialog.getContentPane().add(scrollPane, BorderLayout.CENTER);

                        JButton btnCerrar = new JButton("Cerrar");
                        btnCerrar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                dialog.dispose();
                            }
                        });
                        JPanel panelBoton = new JPanel();
                        panelBoton.add(btnCerrar);
                        dialog.getContentPane().add(panelBoton, BorderLayout.SOUTH);

                        dialog.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frameImprimirTicket, "No se encontró el ticket para la identificación proporcionada.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frameImprimirTicket, "Error al obtener el ticket: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }        });

        frameImprimirTicket.setVisible(true);
    }

    private void modificarTicketYVuelo() {
        JFrame frameModificar = new JFrame("Modificar Ticket y Vuelo");
        frameModificar.setBounds(100, 100, 600, 400);
        frameModificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameModificar.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Ingrese su número de identificación:");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitulo.setBounds(10, 10, 300, 30);
        frameModificar.add(lblTitulo);

        JTextField identificacionField = new JTextField();
        identificacionField.setBounds(10, 50, 200, 25);
        frameModificar.add(identificacionField);

        JButton btnModificar = new JButton("Modificar Ticket y Vuelo");
        btnModificar.setBounds(10, 90, 200, 30);
        frameModificar.add(btnModificar);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String identificacion = identificacionField.getText();
                JFrame frameModificarDatos = new JFrame("Modificar Datos");
                frameModificarDatos.setBounds(100, 100, 600, 400);
                frameModificarDatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameModificarDatos.getContentPane().setLayout(null);

                JLabel lblTituloDatos = new JLabel("Ingrese los nuevos datos:");
                lblTituloDatos.setFont(new Font("Tahoma", Font.PLAIN, 16));
                lblTituloDatos.setBounds(10, 10, 300, 30);
                frameModificarDatos.add(lblTituloDatos);

                JTextField nuevoClaseField = new JTextField();
                nuevoClaseField.setBounds(150, 50, 200, 25);
                frameModificarDatos.add(nuevoClaseField);

                JLabel lblNuevoClase = new JLabel("Nueva Clase:");
                lblNuevoClase.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblNuevoClase.setBounds(10, 50, 200, 25);
                frameModificarDatos.add(lblNuevoClase);

                JTextField nuevoTarifaField = new JTextField();
                nuevoTarifaField.setBounds(150, 80, 200, 25);
                frameModificarDatos.add(nuevoTarifaField);

                JLabel lblNuevoTarifa = new JLabel("Nueva Tarifa:");
                lblNuevoTarifa.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblNuevoTarifa.setBounds(10, 80, 200, 25);
                frameModificarDatos.add(lblNuevoTarifa);

                JButton btnConfirmarModificar = new JButton("Confirmar Modificación");
                btnConfirmarModificar.setBounds(10, 120, 200, 30);
                frameModificarDatos.add(btnConfirmarModificar);
                btnConfirmarModificar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nuevaClase = nuevoClaseField.getText();
                        String nuevaTarifa = nuevoTarifaField.getText();
                        String query = "UPDATE Ticket SET clase = ?, tarifa = ? WHERE identificacion = ?";
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root", "eymerl26");
                             PreparedStatement ps = conn.prepareStatement(query)) {
                            ps.setString(1, nuevaClase);
                            ps.setString(2, nuevaTarifa);
                            ps.setString(3, identificacion);
                            int filasAfectadas = ps.executeUpdate();
                            if (filasAfectadas > 0) {
                                JOptionPane.showMessageDialog(frameModificarDatos, "Ticket modificado exitosamente.");
                            } else {
                                JOptionPane.showMessageDialog(frameModificarDatos, "No se encontró el ticket para la identificación proporcionada.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(frameModificarDatos, "Error al modificar el ticket: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                        frameModificarDatos.dispose();
                    }                });

                frameModificarDatos.setVisible(true);
            }
        });

        frameModificar.setVisible(true);
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
    }
}
