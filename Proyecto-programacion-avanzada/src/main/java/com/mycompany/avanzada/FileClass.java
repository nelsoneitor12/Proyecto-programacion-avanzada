package com.mycompany.avanzada;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileClass {
	private String linea;// linea almacena las lineas leidas del archivo .txt
	private String[] actual;
	private File texto; 
	private Map<String, TipoSeccion> bodega = new HashMap<String, TipoSeccion>();
	private Map<String, Distribuidores> distribuidors = new HashMap<String, Distribuidores>();
	public FileClass() {
		
	}
	
	public Map<String,TipoSeccion> lecturaProductos(File txt) throws FileNotFoundException {
		texto=txt;
		Scanner s = new Scanner(texto);
		while(s.hasNext()){ 
	         linea = s.nextLine();
	         actual = linea.split(",");
	         if (bodega.containsKey(actual[4])) { //se comprueba que esta seccion ya se encuentre en el mapa
	        	 bodega.get(actual[4]).agregarProducto(actual);
	         }
	         else { //si no se encuentra se crea la seccion
	        	 TipoSeccion newS = new TipoSeccion();
	        	 newS.setNomSeccion(actual[4]);
	        	 newS.agregarProducto(actual);
	        	 bodega.put(actual[4], newS);
	         }
	    }
		s.close();
		return bodega;
	}
	public Map<String,Distribuidores> lecturaProductos(File txt, int i) throws FileNotFoundException {
		texto=txt;
		Scanner s = new Scanner(texto);
		while(s.hasNext()){ 
	         linea = s.nextLine();
	         actual = linea.split(",");
	         if (distribuidors.containsKey(actual[5])) { //se comprueba que esta seccion ya se encuentre en el mapa
	        	 distribuidors.get(actual[5]).agregarProducto(actual);
	         }
	         else { //si no se encuentra se crea la seccion
	        	 Distribuidores newS = new Distribuidores();
	        	 newS.setNomSeccion(actual[5]);
	        	 newS.agregarProducto(actual);
	        	 distribuidors.put(actual[5], newS);
	         }
	    }
		s.close();
		return distribuidors;
	}
}
