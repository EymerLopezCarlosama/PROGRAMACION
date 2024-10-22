package PROYECTO;

public class Vuelo {
    private String origen;
    private String destino;
    private String horaSalida;
    private String diaSalida;
    private String aerolinea;

    public Vuelo() {
    }

    public Vuelo(String origen, String destino, String horaSalida, String diaSalida, String aerolinea) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.diaSalida = diaSalida;
        this.aerolinea = aerolinea;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", diaSalida='" + diaSalida + '\'' +
                ", aerolinea='" + aerolinea + '\'' +
                '}';
    }
}
