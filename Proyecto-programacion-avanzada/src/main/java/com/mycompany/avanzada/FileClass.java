package com.mycompany.avanzada;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.String;

public class FileClass {
	private String linea;// linea almacena las lineas leidas del archivo .txt
	private String[] actual;
	private File texto; 
	private Map<String, TipoSeccion> bodega = new HashMap<String, TipoSeccion>();
	private Map<String, Distribuidores> distribuidores = new HashMap<String, Distribuidores>();
	public FileClass() {
	}
	
        public void guardarBodega() throws IOException{
            try (FileWriter writerObj = new FileWriter("./productos.txt", false)) {
                TipoProducto now;
                for(Map.Entry<String, TipoSeccion> r : bodega.entrySet()) {
                    for(Map.Entry<String, TipoProducto> o : r.getValue().getMapa().entrySet()) {
                        now = o.getValue();
                        writerObj.write(now.getNombre()+","+Integer.toString(now.getCodigo())+","+Integer.toString(now.getStock())+","+Integer.toString(now.getPrecio())+","+now.getSeccion()+"\n");
                    }
                }
                writerObj.close();
            }
            
            
        }
        public void guardarBodegaDist() throws IOException{
            try (FileWriter writerObj = new FileWriter("./StockDistribuidores.txt", false)) {
                ProdDistrib now;
                for(Map.Entry<String, Distribuidores> r : distribuidores.entrySet()) {
                    for(Map.Entry<String, ProdDistrib> o : r.getValue().getMapaD().entrySet()) {
                        now = o.getValue();
                        writerObj.write(now.getNombre()+","+Integer.toString(now.getCodigo())+","+Integer.toString(now.getStock())+","+Integer.toString(now.getPrecio())+","+now.getSeccion()+","+now.getMarca()+"\n");
                    }
                }
            }
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
	         if (distribuidores.containsKey(actual[5])) { //se comprueba que esta seccion ya se encuentre en el mapa
	        	 distribuidores.get(actual[5]).agregarProducto(actual);
	         }
	         else { //si no se encuentra se crea la seccion
	        	 Distribuidores newS = new Distribuidores();
	        	 newS.setNomSeccion(actual[5]);
	        	 newS.agregarProducto(actual);
	        	 distribuidores.put(actual[5], newS);
	         }
	    }
		s.close();
		return distribuidores;
	}
}
