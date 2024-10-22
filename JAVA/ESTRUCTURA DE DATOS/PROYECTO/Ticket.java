package PROYECTO;

import java.sql.*;

public class Ticket {

    private String numeroVuelo;
    private String clase;
    private String tarifa;
    private int idPasajero; // Este campo ahora se usa para asociar el ticket con un pasajero

    public Ticket() {
    }

    public Ticket(String numeroVuelo, String clase, String tarifa, int idPasajero) {
        this.numeroVuelo = numeroVuelo;
        this.clase = clase;
        this.tarifa = tarifa;
        this.idPasajero = idPasajero;
    }


    public void guardarEnBaseDeDatos() {
        String url = "jdbc:mysql://localhost:3306/basedatos"; // Cambia esto según tu configuración
        String user = "root";
        String password = "eymerl26"; // Asegúrate de que esta es la contraseña correcta

        String query = "INSERT INTO Ticket (NumeroVuelo, Clase, Tarifa, idPasajero) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, this.numeroVuelo);
            pstmt.setString(2, this.clase);
            pstmt.setString(3, this.tarifa);
            pstmt.setInt(4, this.idPasajero); // Asegúrate de usar el idPasajero aquí

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }
}
