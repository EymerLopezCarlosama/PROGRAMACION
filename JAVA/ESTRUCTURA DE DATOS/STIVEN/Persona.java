package STIVEN;

public class Persona {

     String nombre, apellido;
     int cedula;
     
     public String obtenerNombre(){
         return nombre;
     }
     public void establecerNombre(String nuevoNombre){
         nombre = nuevoNombre;
     }
     public String obtenerApellido(){
         return apellido;
     }
     public void establecerApellido(String nuevoApellido){
         apellido = nuevoApellido;
     }
     public int obtenerCedula(){
         return cedula;
     }
     public void establecerCedula(int nuevaCedula){
         cedula = nuevaCedula;
     }
}
