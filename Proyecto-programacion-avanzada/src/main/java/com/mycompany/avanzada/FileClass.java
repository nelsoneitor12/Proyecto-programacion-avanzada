package com.mycompany.avanzada;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileClass {
	private String linea;
	private String[] actual;
	private File texto; 
	private Map<String,TipoSeccion> bodega = new HashMap<String, TipoSeccion>();
	public FileClass(File txt) {
		texto= txt;
	}
	
	public Map<String,TipoSeccion> lecturaProductos() throws FileNotFoundException {
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
		return bodega;
	}
}
