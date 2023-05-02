package com.mycompany.avanzada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Distribuidores extends TipoSeccion{
	private Map <String,ProdDistrib> mapa = new HashMap<String,ProdDistrib>();
	public Distribuidores() {
		// TODO Auto-generated constructor stub
	}
	public Map<String,ProdDistrib> getMapaD(){
            return mapa;
        }
        
        @Override
	public void agregarProducto(String[] prod) {
    	ProdDistrib newPro = new ProdDistrib();
    	newPro.setNombre(prod[0]);
    	newPro.setCodigo(Integer.parseInt(prod[1]));
    	newPro.setStock(Integer.parseInt(prod[2]));
    	newPro.setPrecio(Integer.parseInt(prod[3]));
    	newPro.setSeccion(prod[4]);
        newPro.setMarca(prod[5]);
    	mapa.put(newPro.getNombre(),newPro);
    	
    }
	
        @Override
	public void enlistarProductos() { 
            
        }
	
	public void actualizarStock(String indice) throws IOException,StockAmountException { //suma el stock que el usuario indique si el producto ya esta en el arreglo
    	int stock;
    	BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("El producto ya se encuentra en bodega, ingrese la cantidad de stock que desea agregar: ");
    	stock=Integer.parseInt(line.readLine());
    	mapa.get(indice).removeStock(stock);
    }
        
        @Override
    public ProdDistrib getCloneProducto(String name) {
        	ProdDistrib original,copia;
        	original=mapa.get(name);
        	copia=new ProdDistrib();
        	
        	copia.setNombre(original.getNombre());
        	copia.setSeccion(original.getSeccion());
        	copia.setPrecio(original.getPrecio());
        	copia.setStock(original.getStock());
        	copia.setCodigo(original.getCodigo());
        	copia.setMarca(original.getMarca());
        	return copia;
        	
        }

}
