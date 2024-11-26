public class NodoArbol {

     private int valor;
     private NodoArbol nodIzq;
     private NodoArbol nodDer;

     public NodoArbol(int valor){
         this.valor = valor;
         this.nodIzq = null;
         this.nodDer = null;
     }

     public int getValor() {
          return valor;
     }

     public void setValor(int valor) {
          this.valor = valor;
     }

     public NodoArbol getNodIzq() {
          return nodIzq;
     }

     public NodoArbol getNodDer() {
          return nodDer;
     }

     public void insertar(int valor){
          if (valor < this.valor){
               //Insertar lado izquierdo
               if (this.nodIzq == null){
                    this.nodIzq = new NodoArbol(valor);
               }else{
                    this.nodIzq.insertar(valor);
               }
          }else{
               //Insertar lado derecho
               if (this.nodDer == null){
                    this.nodDer = new NodoArbol(valor);
               }else{
                    this.nodDer.insertar(valor);
               }
          }
     }
     

}
