/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.programacion.avanzada;
/**
 *
 * @author Sashi
 */

import java.util.*;

public class tipoSeccion {
	private String nomSeccion; //nombre seccion
    //private String desSeccion; //descripcion seccion
	private ArrayList <tipoProducto> arr = new ArrayList<tipoProducto>();  
        
        
        public tipoSeccion() {
		// TODO Auto-generated constructor stub
	}

		//setter y getter de nomSeccion
        public void setNomSeccion(String nomSeccion){
            this.nomSeccion = nomSeccion;
        }
        public String getNomSeccion(){  
            return this.nomSeccion;
        }
        //setter y getter de desSeccion
        /*public void setDesSeccion(String desSeccion){
            this.desSeccion = desSeccion;
        }
        public String getDesSeccion(){
            return this.desSeccion;
        }*/
        
        public void agregarProducto(String[] prod) {
        	tipoProducto newPro = new tipoProducto();
        	newPro.setNombre(prod[0]);
        	newPro.setCodigo(Integer.parseInt(prod[1]));
        	newPro.setStock(Integer.parseInt(prod[2]));
        	newPro.setPrecio(Integer.parseInt(prod[3]));
        	arr.add(newPro);
        }
        
        public void enlistarProductos() { 
        	Iterator<tipoProducto> i = arr.iterator();
        	tipoProducto now = new tipoProducto();//producto auxiliar para almacenar temporalmente cada producto que contiene la seccion
        	while(i.hasNext()) {//se itera para imprimir productos de la seccion
        		now = i.next();
        	    System.out.println(now.getNombre()+", Codigo: "+now.getCodigo()+", Stock:"+now.getStock()+", $"+now.getPrecio());
        	}
        }
        
}