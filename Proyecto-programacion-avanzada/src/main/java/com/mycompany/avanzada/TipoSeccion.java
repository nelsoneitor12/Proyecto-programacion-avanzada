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
import java.util.Map.Entry;

public class TipoSeccion {
	private String nomSeccion; //nombre seccion
	private ArrayList <TipoProducto> arr = new ArrayList<TipoProducto>();  
    private Map <Integer, TipoProducto> mapa= new HashMap<Integer,TipoProducto>(); 
        
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
        
        
        public void agregarProducto(String[] prod) {
        	TipoProducto newPro = new TipoProducto();
        	newPro.setNombre(prod[0]);
        	newPro.setCodigo(Integer.parseInt(prod[1]));
        	newPro.setStock(Integer.parseInt(prod[2]));
        	newPro.setPrecio(Integer.parseInt(prod[3]));
        	newPro.setLote(Integer.parseInt(prod[5]));
        	mapa.put(newPro.getLote(),newPro);
        	
        }
        
        /*public void agregarProducto(String nombre,String codigo,String stock,String precio) { //sobrecarga por si los datos vienen separados en vez de ir en arreglo
        	TipoProducto newPro = new TipoProducto();
        	newPro.setNombre(nombre);
        	newPro.setCodigo(Integer.parseInt(codigo));
        	newPro.setStock(Integer.parseInt(stock));
        	newPro.setPrecio(Integer.parseInt(precio));
        	arr.add(newPro);
        }*/
        
        public void enlistarProductos() { 
        	Iterator<TipoProducto> i = arr.iterator();
        	TipoProducto now = new TipoProducto();//producto auxiliar para almacenar temporalmente cada producto que contiene la seccion
        	for(Entry<Integer, TipoProducto> r : mapa.entrySet()) {
        		now=r.getValue();
    			System.out.println("Producto: "+now.getNombre()+",Precio:"+now.getPrecio()+",Codigo:"+now.getCodigo()+", Stock:"+now.getStock()+",Lote:"+now.getLote());
    		}
        }
        
        public int esta(int lote) {//funcion que verifica si el producto ya esta en el arraylist
        	if(mapa.containsKey(lote)) return lote;
			return -1;
        }
        
        public void agregarStock(int indice) throws IOException { //suma el stock que el usuario indique si el producto ya esta en el arreglo
        	int stock;
        	BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
        	System.out.println("El producto ya se encuentra en bodega, ingrese la cantidad de stock que desea agregar: ");
        	stock=Integer.parseInt(line.readLine());
        	mapa.get(indice).addStock(stock);
        }
        
}