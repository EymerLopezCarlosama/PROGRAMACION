public class Arbol {

     NodoArbol inicial;
 
     public Arbol() {
         this.inicial = null;
     }
 
     public void insertar(int valor) {
         if (this.inicial == null) {
             this.inicial = new NodoArbol(valor);
         } else {
             this.inicial.insertar(valor);
         }
     }
 
     public String dispararPreorden() {
         StringBuilder resultadoPreorden = new StringBuilder();
         this.preorden(this.inicial, resultadoPreorden);
         return resultadoPreorden.toString().trim();
     }
 
     private void preorden(NodoArbol nodo, StringBuilder resultadoPreorden) {
         if (nodo == null) {
             return;
         }
         resultadoPreorden.append(nodo.getValor()).append(" ");
         preorden(nodo.getNodIzq(), resultadoPreorden);
         preorden(nodo.getNodDer(), resultadoPreorden);
     }
 
     public String dispararInorden() {
         StringBuilder resultadoInorden = new StringBuilder();
         this.inorden(this.inicial, resultadoInorden);
         return resultadoInorden.toString().trim();
     }
 
     private void inorden(NodoArbol nodo, StringBuilder resultadoInorden) {
         if (nodo == null) {
             return;
         }
         inorden(nodo.getNodIzq(), resultadoInorden);
         resultadoInorden.append(nodo.getValor()).append(" ");
         inorden(nodo.getNodDer(), resultadoInorden);
     }
 
     public String dispararPostorden() {
         StringBuilder resultadoPostorden = new StringBuilder();
         this.postorden(this.inicial, resultadoPostorden);
         return resultadoPostorden.toString().trim();
     }
 
     private void postorden(NodoArbol nodo, StringBuilder resultadoPostorden) {
         if (nodo == null) {
             return;
         }
         postorden(nodo.getNodIzq(), resultadoPostorden);
         postorden(nodo.getNodDer(), resultadoPostorden);
         resultadoPostorden.append(nodo.getValor()).append(" ");
     }
 }
 