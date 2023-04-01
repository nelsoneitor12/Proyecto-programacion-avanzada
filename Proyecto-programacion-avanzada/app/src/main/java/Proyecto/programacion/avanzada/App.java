/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Proyecto.programacion.avanzada;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {
   public static void main(String arg[]) throws IOException {
    int opcion; //variable para que el usuario escoja en el menu
    int indice; //variable para almacenar el indice que retorna el metodo que compreuba si un producto ya esta en la lista
    String a, linea; // a: almacena lo que el usuario ingrese antes de transformarlo a int, linea almacena las lineas leidas del archivo .txt
    String[] actual; //almacena los parametros que contiene una linea, pero por separado
    File f = new File("productos.txt"); //se abre el archivo que contiene la lista de productos
    Scanner s = new Scanner(f);//se inicializa un scanner para trabajar con el archivo
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));//se inicializa lector para leer input
    Map<String,tipoSeccion> bodega = new HashMap<String, tipoSeccion>(); //se crea mapa para acceder mas facilmente al stock
    
    while(s.hasNext()){ //mientras queden lineas sin leer se agregaran los contenidos de cada una en el mapa usando como key la seccion
         linea = s.nextLine();
         actual = linea.split(",");
         if (bodega.containsKey(actual[4])) { //se comprueba que esta seccion ya se encuentre en el mapa
        	 bodega.get(actual[4]).agregarProducto(actual);
        	 //bodega.get(actual[4]).enlistarProductos();
         }
         else { //si no se encuentra se crea la seccion
        	 tipoSeccion newS = new tipoSeccion();
        	 newS.setNomSeccion(actual[4]);
        	 newS.agregarProducto(actual);
        	 bodega.put(actual[4], newS);
        	 //bodega.get(actual[4]).enlistarProductos();
         }
    }
    //menu
	do {
            System.out.println("Seleccione la operacion a realizar");
            System.out.println("[1] ENLISTAR PRODUCTOS");
            System.out.println("[2] AGREGAR PRODUCTO");
            System.out.println("[0] SALIR");
            a = lector.readLine();
            opcion = Integer.parseInt(a);
            
            if(opcion==1) {
            	for(Entry<String, tipoSeccion> r : bodega.entrySet()) {
            		System.out.println("\nSeccion: "+r.getValue().getNomSeccion());
            		r.getValue().enlistarProductos();
            	}
            }else if(opcion==2){
                actual = new String[5];
                System.out.print("Ingrese seccion del producto: ");
                actual[4] = lector.readLine();
                System.out.print("Ingrese nombre del producto: ");
                actual[0] = lector.readLine();
                indice=bodega.get(actual[4]).esta(actual[0]);
                //System.out.println("indice retornado:"+indice);
                if(indice>=0) {
                	//System.out.println("pase aqui");
                	bodega.get(actual[4]).agregarStock(indice);
                	continue;
                }
                System.out.print("Ingrese codigo del producto: ");
                actual[1] = lector.readLine();
                System.out.print("Ingrese stock del producto: ");
                actual[2] = lector.readLine();
                System.out.print("Ingrese precio del producto: ");
                actual[3] = lector.readLine();
                
                
                if (bodega.containsKey(actual[4])) { //se comprueba que esta seccion ya se encuentre en el mapa
                    bodega.get(actual[4]).agregarProducto(actual);
                }else { //si no se encuentra se crea la seccion
                    tipoSeccion newS = new tipoSeccion();
                    newS.setNomSeccion(actual[4]);
                    newS.agregarProducto(actual);
                    bodega.put(actual[4], newS);
                }
            }
	}while(opcion!=0);
        //se cierra archivo
	s.close();
    }


   
}