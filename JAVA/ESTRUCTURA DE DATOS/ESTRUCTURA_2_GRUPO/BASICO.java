public class BASICO {

    String nombres[] = {"Eymer", "Paola", "Tatiana", "Camila"};
    int numeros[] = new int[4];
    int numbs [] = {3,6,5,9};
    
    void escribirNumeros(){
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i * i + 4;
        }
    }

    void LeerNumeros(){
        for (int n : numbs) {
            System.out.println(n+"-");
        }
    }

    void LeerNombres(){
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
    }

}
