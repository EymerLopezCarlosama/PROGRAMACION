package QUEUE;

public class Ejemplo3 {

    int[] cola;
    int inicio, fin, tamaño;

    //constructor clase 
    Ejemplo3(int tamaño){
        //guardo tamaño dado
        this.tamaño= tamaño;
        //inicializo el vector
        cola = new int [tamaño];
        //inicio empiezo en cero
        inicio =0;
        //fin en -1, esto indica que esta vacia
        fin =-1;
    }

    //agregar o insertar en la cola
    void insertar(int valor){
        //verifico si esta llena la pila, si inicio y fin valen lo mismo esta llena
        if(fin == tamaño -1){
            System.out.println("esta llena");
        } else {
            //agrego el valor dado en la posicion que indica fin 
            cola[++fin] = valor;
        }
    }

    int eliminar(){
        //verifico si inicio es mayor a fin la cola no esta llena
        if(inicio>fin){
            System.out.println("cola vacia");
            return -1;
        }else{
            //elimino de acuerdo al valor de inicio
           return cola[inicio++];
        }
    }

    int peek() {
        //verifica si esta vacia
        if(inicio>fin){
            System.out.println("cola vacia");
            return -1;
        }else{
            //retorna simplemente el dato en la posicion inicio
           return cola[inicio];
        }
    }

    //verifica si esta vacia, retorna true y false
    boolean isEmpty(){
        return inicio>fin;
    }
    
    //metodo que permite imprimir los valores de todo el vector
    void imprimirCola(){
        if(isEmpty()){
            System.out.println("cola vacia");
        }else{
            System.out.println("Cola: ");
            for(int i = inicio; i<=fin; i++){
                System.out.println(cola[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        Ejemplo3 cola1 = new Ejemplo3(5);

        cola1.insertar(8);
        cola1.insertar(10);
        cola1.insertar(10);

        cola1.imprimirCola();

        cola1.eliminar();

        System.out.println("despues de eliminar ");

        cola1.imprimirCola();

        System.out.println("Pila vacia? "+cola1.isEmpty());

        System.out.println("Inicio de la cola"+ cola1.peek());



    }

}




