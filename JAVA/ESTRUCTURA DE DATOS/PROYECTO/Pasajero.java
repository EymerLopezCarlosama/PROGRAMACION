package PROYECTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pasajero {

    // Recolección de datos
    private String nombreCompleto;
    private String tipoIdentificacion;
    private String identificacion;
    private String correoElectronico;
    private String telefono;
    private String nombreContactoEmergencia;
    private String telefonoContactoEmergencia;
    private String parentescoContactoEmergencia;

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/basedatos";
    private static final String USER = "root";
    private static final String PASSWORD = "eymerl26";

    public void guardarInfoPasajeroEnBaseDeDatos(String origen, String destino,
            String horaSalida, String diaSalida, String aerolinea,
            String clase, String tarifa) {

        String sql = "INSERT INTO Pasajero (nombreCompleto, tipoIdentificacion, identificacion, correoElectronico, telefono, nombreContactoEmergencia, telefonoContactoEmergencia, parentescoContactoEmergencia, origen, destino, horaSalida, diaSalida, aerolinea, clase, tarifa) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreCompleto);
            pstmt.setString(2, tipoIdentificacion);
            pstmt.setString(3, identificacion);
            pstmt.setString(4, correoElectronico);
            pstmt.setString(5, telefono);
            pstmt.setString(6, nombreContactoEmergencia);
            pstmt.setString(7, telefonoContactoEmergencia);
            pstmt.setString(8, parentescoContactoEmergencia);
            pstmt.setString(9, origen);
            pstmt.setString(10, destino);
            pstmt.setString(11, horaSalida);
            pstmt.setString(12, diaSalida);
            pstmt.setString(13, aerolinea);
            pstmt.setString(14, clase);
            pstmt.setString(15, tarifa);

            pstmt.executeUpdate();
            System.out.println("Información del pasajero guardada correctamente en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al guardar la información del pasajero en la base de datos.");
            e.printStackTrace();
        }
    }

    // Getters y Setters


    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    public String getParentescoContactoEmergencia() {
        return parentescoContactoEmergencia;
    }

    public void setParentescoContactoEmergencia(String parentescoContactoEmergencia) {
        this.parentescoContactoEmergencia = parentescoContactoEmergencia;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
