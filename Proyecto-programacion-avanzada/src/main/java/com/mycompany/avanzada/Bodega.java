package com.mycompany.avanzada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

public class Bodega {
	 private File f = new File("./productos.txt"); //se abre el archivo que contiene la lista de productos
	 private Map<String,TipoSeccion> bodega; //se crea mapa para acceder mas facilmente al stock
	 private FileClass lecturaTxt= new FileClass(f);
	 
	 public Bodega() throws FileNotFoundException {
		 bodega= lecturaTxt.lecturaProductos();
	 }
	 
	 public void enlistarSecciones() {
		 for(Entry<String, TipoSeccion> r : bodega.entrySet()) {
 			System.out.println("\nSeccion: "+r.getValue().getNomSeccion());
 			r.getValue().enlistarProductos();
 		}
	 }
         
	 public void agregarProducto() throws IOException{
		 BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));//se inicializa lector para leer input
		 String[] actual;
		 int indice;
		 
		 actual = new String[5];
         
 		System.out.print("Ingrese seccion del producto: ");
 		actual[4] = lector.readLine();
 		System.out.print("Ingrese nombre del producto: ");
 		actual[0] = lector.readLine();
 		indice = bodega.get(actual[4]).esta(actual[0]);
 		if(indice>0) {
 			bodega.get(actual[4]).agregarStock(actual[0]);
 		}
 		else {
 		System.out.print("Ingrese codigo del producto: ");
 		actual[1] = lector.readLine();
 		System.out.print("Ingrese stock del producto: ");
 		actual[2] = lector.readLine();
 		System.out.print("Ingrese precio del producto: ");
 		actual[3] = lector.readLine();
 		bodega.get(actual[4]).agregarProducto(actual);
 		}
	 }
	 
}
