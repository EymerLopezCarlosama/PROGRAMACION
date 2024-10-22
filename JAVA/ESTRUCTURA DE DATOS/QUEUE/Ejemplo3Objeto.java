package QUEUE;

public class Ejemplo3Objeto {

    int cola[];
    int inicio,fin,tamaño;

    Ejemplo3Objeto(int tamaño){
        this.tamaño = tamaño;
        cola = new int[tamaño];
        inicio = -1;
    }

    void insertar(int dato){
        if(fin == tamaño - 1){
            System.out.println("Cola llena");
        }else{
            cola[++fin] = dato; 
            System.out.println("Exito al Agregar");
            if(inicio == -1){
                inicio = 0;
            }   
        }
    }

    int eliminar(){
        if(inicio > fin){
            System.out.println("Cola vacia");
            return -1;
        }else{
            return cola[inicio++];
        }
    }

    int mostrar(){
        if(inicio > fin){
            System.out.println("Cola vacia");
            return -1;
        }else{
            return cola[inicio];
            }
        }

    boolean isEmpty(){
        if(inicio > fin){
            return true;
        }else{
            return false;
        }
    }

    void ImprimirCola(){
        if(inicio > fin){
            System.out.println("Cola vacia");
        }else{
            System.out.println("Elementos de la cola");
            for(int i = inicio; i <= fin; i++){
                System.out.println(cola[i]);
            }
        }
    }
    public static void main(String[] args) {
        Ejemplo3Objeto cola = new Ejemplo3Objeto(5);
        cola.insertar(1);
        cola.insertar(2);
        cola.insertar(3);

        cola.ImprimirCola();

    }

}


