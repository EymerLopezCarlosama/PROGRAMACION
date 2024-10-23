package QUEUE;

public class Ejemplo3 {

    // Atributos principales: array para la cola, punteros de inicio y fin, y el tamaño máximo de la cola
    int[] cola;  // Array que representa la cola
    int inicio, fin, tamaño;  // inicio y fin para gestionar la cola, tamaño para definir su capacidad

    // Constructor: Inicializa los atributos y crea el array 'cola' del tamaño especificado
    Ejemplo3(int tamaño){
        this.tamaño = tamaño;  // Se define el tamaño máximo de la cola
        cola = new int[tamaño];  // Se crea el array para almacenar los elementos
        inicio = 0;  // Índice de inicio de la cola (donde se elimina)
        fin = -1;  // Índice de fin de la cola (donde se insertan nuevos elementos)
    }

    // Método para insertar un elemento en la cola
    void insertar(int valor){
        // Verifica si la cola está llena
        if(fin == tamaño -1){
            System.out.println("esta llena");  // Mensaje si la cola está llena
        } else {
            // Incrementa el índice 'fin' y añade el valor al final de la cola
            cola[++fin] = valor;
        }
    }


    // Método para eliminar un elemento de la cola
    int eliminar(){
        // Verifica si la cola está vacía
        if(inicio > fin){
            System.out.println("cola vacia");  // Mensaje si la cola está vacía
            return -1;  // Retorna -1 si no hay elementos que eliminar
        } else {
            // Devuelve el primer elemento (según 'inicio') y lo elimina incrementando 'inicio'
           return cola[inicio++];
        }
    }

    // Método para obtener el primer elemento de la cola sin eliminarlo
    int peek() {
        // Verifica si la cola está vacía
        if(inicio > fin){
            System.out.println("cola vacia");  // Mensaje si la cola está vacía
            return -1;  // Retorna -1 si no hay elementos en la cola
        } else {
            // Devuelve el primer elemento (sin eliminarlo)
           return cola[inicio];
        }
    }

    // Método para verificar si la cola está vacía
    boolean isEmpty(){
        return inicio > fin;  // Retorna verdadero si no hay elementos en la cola
    }

    // Método para imprimir todos los elementos de la cola
    void imprimirCola(){
        // Verifica si la cola está vacía
        if(isEmpty()){
            System.out.println("cola vacia");  // Mensaje si la cola está vacía
        } else {
            System.out.println("Cola: ");
            // Recorre e imprime los elementos desde 'inicio' hasta 'fin'
            for(int i = inicio; i <= fin; i++){
                System.out.println(cola[i] + " ");
            }
            System.out.println();
        }
    }

    // Método principal (main): pruebas de los métodos de la cola
    public static void main(String[] args) {
        
        Ejemplo3 cola1 = new Ejemplo3(5);  // Crea una cola con capacidad para 5 elementos

        cola1.insertar(8);  // Inserta el valor 8 en la cola
        cola1.insertar(10); // Inserta el valor 10 en la cola
        cola1.insertar(10); // Inserta otro valor 10 en la cola

        cola1.imprimirCola();  // Imprime la cola

        cola1.eliminar();  // Elimina el primer elemento de la cola

        System.out.println("despues de eliminar ");

        cola1.imprimirCola();  // Imprime la cola después de eliminar un elemento

        System.out.println("Pila vacia? "+ cola1.isEmpty());  // Verifica si la cola está vacía

        System.out.println("Inicio de la cola" + cola1.peek());  // Muestra el primer elemento de la cola sin eliminarlo
    }
}
