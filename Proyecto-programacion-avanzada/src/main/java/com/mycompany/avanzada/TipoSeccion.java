/*
s * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanzada;
/**
 *
 * @author Sashi
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TipoSeccion {
    protected String nomSeccion; //nombre seccion
    private Map <String, TipoProducto> mapa = new HashMap<String,TipoProducto>(); 
        
        public TipoSeccion() {   
		// TODO Auto-generated constructor stub
        }

		//setter y getter de nomSeccion
        public void setNomSeccion(String nomSeccion){
            this.nomSeccion = nomSeccion;
        }
        public String getNomSeccion(){
            return this.nomSeccion;
        }
        
        public Map<String, TipoProducto> getMapa(){
            return mapa;
        }
        
        public void agregarProducto(String[] prod) {
        	TipoProducto newPro = new TipoProducto();
        	newPro.setNombre(prod[0]);
        	newPro.setCodigo(Integer.parseInt(prod[1]));
        	newPro.setStock(Integer.parseInt(prod[2]));
        	newPro.setPrecio(Integer.parseInt(prod[3]));
        	newPro.setSeccion(prod[4]);
        	mapa.put(newPro.getNombre(),newPro);
        	
        }
        
        public void enlistarProductos() { 
        	
        }
        
        public int esta(String lote) {//funcion que verifica si el producto ya esta en el arraylist
        	if(mapa.containsKey(lote)) return 1;
			return 0;
        }
        
        public void actualizarStock(String indice, int i) throws IOException,StockAmountException { //suma el stock que el usuario indique si el producto ya esta en el arreglo
        	int stock=i;
        	mapa.get(indice).removeStock(stock);
        }
        
        public TipoProducto getProducto(String name) {
        	return mapa.get(name);
        }
        
        public TipoProducto getCloneProducto(String name) {
        	TipoProducto original,copia;
        	original=mapa.get(name);
        	copia=new TipoProducto();
        	
        	copia.setNombre(original.getNombre());
        	copia.setSeccion(original.getSeccion());
        	copia.setPrecio(original.getPrecio());
        	copia.setStock(original.getStock());
        	copia.setCodigo(original.getCodigo());
        	
        	return copia;
        	
        }
        public void elimProd() throws IOException{
        	BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
        	System.out.print("Ingrese nombre del producto: ");
     		String nomAux = lector.readLine();
     		if (mapa.get(nomAux)==null) {
     			System.out.println("Nombre del producto no encontrado");
    	 	 	return;	
     		}
        	mapa.remove(nomAux,mapa.get(nomAux));
        }
        
        public TipoProducto elimProd(String nombre) {
        	TipoProducto a = mapa.get(nombre); 
        	mapa.remove(nombre,mapa.get(nombre));
        	return a;
        }
        
        public boolean existeProducto(String producto) {
        	if (mapa.get(producto)!=null) return true; // si no lo encuentra retorna false
        	else return false;
        	
        }
        
        public void modificarProducto(int opcion, String[] prod) throws IOException {
        	BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
        	switch(opcion) {// case para cada caso del menu anterior
        	case 3:
        		System.out.println("Seleccione el nuevo codigo para el producto");
        		int codAux = Integer.parseInt(lector.readLine());
        		mapa.get(prod[0]).setCodigo(codAux);
        		break;
        	case 4:
        		System.out.println("Seleccione el nuevo stock para el producto");
        		int auxStock = Integer.parseInt(lector.readLine());
        		mapa.get(prod[0]).setStock(auxStock);
        		break;
        	case 5:
        		System.out.println("Seleccione el nuevo precio para el producto");
        		int auxPrecio = Integer.parseInt(lector.readLine());
        		mapa.get(prod[0]).setPrecio(auxPrecio);
        		break;
        	case 6:
        		System.out.println("Seleccione la nueva marca para el producto");
        		String auxMarca = lector.readLine();
        		mapa.get(prod[0]).setSeccion(auxMarca);
        		break;
        	}

        	
        }
        
        public void agregarProducto(TipoProducto prod) {
        	mapa.put(prod.getNombre(), prod);
        	
        }
        
}