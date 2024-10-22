package PILAS_Y_OBJETOS;

public class Inventario {

    private String nombre;
    private int codigo;
    private int stock;

    public Inventario() {
        this.nombre = "";
        this.codigo = 0;
        this.stock = 0;
    }

    public Inventario(String nombre, int codigo, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }


}
