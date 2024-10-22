package VECTORES_OBJETOS;

public class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private String puesto;
    private double salario;
    private Empresa empresa;

    // Constructor simplificado
    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.puesto = "";  // Asignar un valor predeterminado si es necesario
        this.empresa = null;  // Asignar un valor predeterminado si es necesario
    }

    // Constructor completo
    public Empleado(String nombre, String apellido, int edad, String puesto, double salario, Empresa empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}
