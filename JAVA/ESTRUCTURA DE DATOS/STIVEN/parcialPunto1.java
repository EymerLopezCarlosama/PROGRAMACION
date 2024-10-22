package STIVEN;

import java.util.Scanner;

public class parcialPunto1 {
   
    
    String matrizCanciones[][]=new String[3][5];
    Scanner in = new Scanner(System.in);

    void GuardarCanciones(){  // Metodo para guardar las canciones
        String codigo,nombre,genero,artista,puntuacion; // Variables para guardar los datos de las canciones
        for (int i=0;i<matrizCanciones.length;i++){ // Ciclo para guardar los datos de las canciones, va desde i = 0 hasta que i sea menor que el tamaño de las filas de la matriz
            System.out.println("--------Datos de la cancion "+(i+1)+"--------"); // Mensaje para indicar que se esta guardando los datos de la cancion

                System.out.print("Ingrese el codigo de la "+(i+1)+" cancion: "); // Mensaje para indicar que se esta guardando el codigo de la cancion
                codigo=in.nextLine(); // Guarda el codigo de la cancion
                matrizCanciones[i][0]=codigo; // Guarda el codigo de la cancion en la matriz en la posicion [i][0] donde i = 0, para el primer ciclo i = 0, para el segundo ciclo i = 1, para el tercer ciclo i = 2
                
                System.out.print("Ingrese el nombre de la "+(i+1)+" cancion: ");
                nombre=in.nextLine();
                matrizCanciones[i][1]=nombre;
                
                System.out.print("Ingrese el genero de la "+(i+1)+" cancion: ");
                genero=in.nextLine();
                matrizCanciones[i][2]=genero;
                
                System.out.print("Ingrese el artista de la "+(i+1)+" cancion: ");
                artista=in.nextLine();
                matrizCanciones[i][3]=artista;
                
                System.out.print("Ingrese la puntuacion "+(i+1)+" cancion(0 a 100): ");
                puntuacion=in.nextLine();
                matrizCanciones[i][4]=puntuacion;
                System.out.println("");    
        }
        System.out.println("-------Datos capturados exitosamente-------");
        System.out.println("");
    }

    void menu(){
        int opcion=0;     
        do{
            System.out.println("-----Menu de opciones------");
            System.out.println("1.Listar canciones");
            System.out.println("2.Buscar cancion por artista");
            System.out.println("3.Sacar promedio de la puntuacion registrada");
            System.out.println("4.Imprimir la cancion mas votada y menos votada");
            System.out.println("5.Salir");
        
            System.out.print("Ingrese la opcion que requiera acceder: ");
            opcion=in.nextInt();
                switch(opcion){
                   
                    case 1:
                        ListarCanciones();
                        break;
                
                    case 2:
                        BuscarCancionPorArtista();
                        break;
                
                    case 3:
                        SacarPromedio();
                        break;
                
                    case 4:
                        ImprimirCancionVotadaYNoVotada();
                        break;
                
                    case 5:
                        break;
                
                    default:
                        System.out.println("Reingrese la opcion que desea elegir.....");
                        break;
            }
        }while(opcion!=5);
    }
    
    
    
    void ListarCanciones(){ // Metodo para listar las canciones
        System.out.println("Codigo  /  Nombre  /  Genero  /  Artista  /  Puntuacion"); // Mensaje para indicar que se esta listando las canciones
        for(int i=0;i<matrizCanciones.length;i++){ // Ciclo para listar las canciones, va desde i = 0 hasta que i sea menor que el tamaño de las filas de la matriz
            System.out.println(matrizCanciones[i][0]+"  /  "+matrizCanciones[i][1]+"  /  "+matrizCanciones[i][2]+"  /  "+matrizCanciones[i][3]+"  /  "+matrizCanciones[i][4]);
            // Mensaje para indicar que se esta listando las canciones
            // Para el primer ciclo i = 0, para el segundo ciclo i = 1, para el tercer ciclo i = 2
        }  
        
        System.out.println("");
    }
    
    void BuscarCancionPorArtista(){ // Metodo para buscar una cancion por artista
       String artistaABuscar; // Variable para guardar el artista de la cancion que se desea buscar
       System.out.print("Ingrese el artista de la cancion que desee buscar a buscar: "); //  Mensaje para indicar que se esta buscando una cancion por artista
       artistaABuscar=in.next(); // Guarda el artista de la cancion que se desea buscar
       boolean bandera=false; // Variable para verificar si se encontro el artista de la cancion que se desea buscar
       
       
        for (int i=0;i<matrizCanciones.length;i++){ // Ciclo para buscar la cancion por artista, va desde i = 0 hasta que i sea menor que el tamaño de las filas de la matriz
             if(artistaABuscar.equals(matrizCanciones[i][3])){ // Si el artista de la cancion que se desea buscar es igual al artista de la cancion que se encuentra en la matriz
                 System.out.println("Codigo de la cancion: "+matrizCanciones[i][0]);
                 System.out.println("Nombre: "+matrizCanciones[i][1]);
                 System.out.println("Genero: " +matrizCanciones[i][2]);
                 System.out.println("Artista: " +matrizCanciones[i][3]);
                 System.out.println("Puntuacion: " +matrizCanciones[i][4]);
                 System.out.println("");

                 bandera=true; // Bandera para indicar que se encontro el artista de la cancion que se desea buscar
             }
         }
       
       if(bandera==false){
                   System.out.println("No se encontro al artista ingresado....");
                   System.out.println("");
       }
        System.out.println("");
    }
    
    void SacarPromedio(){  //
        float suma=0,promedio; // Variables para guardar la suma de las puntuaciones y el promedio de las puntuaciones
        for(int i=0;i<matrizCanciones.length;i++){ // Ciclo para sacar el promedio de las puntuaciones, va desde i = 0 hasta que i sea menor que el tamaño de las filas de la matriz
            suma=suma+(Float.parseFloat(matrizCanciones[i][4])); // Suma las puntuaciones de las canciones
        }
        promedio=suma/3; // Calcula el promedio de las puntuaciones
        System.out.println("El promedio de las puntuaciones registradas es de: "+promedio);
        System.out.println("");
    }
    
    void ImprimirCancionVotadaYNoVotada(){ // Metodo para imprimir las canciones mas  votadas y las canciones menos votadas
       for(int i=0; i<matrizCanciones.length;i++){
            float puntajeCancion=Float.parseFloat(matrizCanciones[i][4]);
            if(puntajeCancion>70){
                System.out.println("La cancion "+matrizCanciones[i][1]+" del artista "+matrizCanciones[i][3]+" es de las mas votadas con puntaje de "+matrizCanciones[i][4]);
            }    
            if(puntajeCancion<30){
                System.out.println("La cancion "+matrizCanciones[i][1]+" del artista "+matrizCanciones[i][3]+" es de las menos votadas con puntaje de "+matrizCanciones[i][4]);
            }
       }
    }

    
    
}