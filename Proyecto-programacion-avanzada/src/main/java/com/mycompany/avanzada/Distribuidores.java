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
	
	public void agregarProducto(String[] prod) {
    	ProdDistrib newPro = new ProdDistrib();
    	newPro.setNombre(prod[0]);
    	newPro.setCodigo(Integer.parseInt(prod[1]));
    	newPro.setStock(Integer.parseInt(prod[2]));
    	newPro.setPrecio(Integer.parseInt(prod[3]));
    	newPro.setCategoria(prod[4]);
    	mapa.put(newPro.getNombre(),newPro);
    	
    }
	
	public void enlistarProductos() { 
    	ProdDistrib now = new ProdDistrib();//producto auxiliar para almacenar temporalmente cada producto que contiene la seccion
    	for(Entry<String, ProdDistrib> r : mapa.entrySet()) {
    		now=r.getValue();
			System.out.println("Producto: "+now.getNombre()+",Precio unitario:$"+now.getPrecio()+",Stock Disponible:"+now.getStock()+",Categoria:"+now.getCategoria());
		}
    }
	
	public void actualizarStock(String indice) throws IOException { //suma el stock que el usuario indique si el producto ya esta en el arreglo
    	int stock;
    	BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("El producto ya se encuentra en bodega, ingrese la cantidad de stock que desea agregar: ");
    	stock=Integer.parseInt(line.readLine());
    	mapa.get(indice).removeStock(stock);
    }

}
