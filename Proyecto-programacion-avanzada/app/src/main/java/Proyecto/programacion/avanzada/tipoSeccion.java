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
    private String desSeccion; //descripcion seccion
	private ArrayList <tipoProducto> arr = new ArrayList<tipoProducto>();  
        
	public tipoSeccion(String nombre, String descripcion) {
        this.nomSeccion = nombre;
        this.desSeccion = descripcion;
	}
        
        //setter y getter de nomSeccion
        public void setNomSeccion(String nomSeccion){
            this.nomSeccion = nomSeccion;
        }
        public String getNomSeccion(){  
            return this.nomSeccion;
        }
        //setter y getter de desSeccion
        public void setDesSeccion(String desSeccion){
            this.desSeccion = desSeccion;
        }
        public String getDesSeccion(){
            return this.desSeccion;
        }
        
}