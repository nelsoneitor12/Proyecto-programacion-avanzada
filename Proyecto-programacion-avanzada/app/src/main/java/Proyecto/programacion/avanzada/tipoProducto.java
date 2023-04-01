/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.programacion.avanzada;

/**
 *
 * @author Sashi
 */
public class tipoProducto {
        private String nombre;
        private int codigo;
        private int stock;
        private int precio;
        
	    public  tipoProducto() {
		// TODO Auto-generated constructor stub
	    }
        
        //getter y setter de nombre
        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        public String getNombre(){
            return this.nombre;
        }
        //getter y setter de codigo
        public void setCodigo(int codigo){
            this.codigo = codigo;
        }
        public void setCodigo(String codigo){//sobrecarga si el codigo viene en String
            this.codigo = Integer.parseInt(codigo);
        }
        public int getCodigo(){
            return this.codigo;
        }
        //getter y setter de stock
        public void setStock(int stock){
            this.stock = stock;
        }
        public void setStock(String stock){//sobrecarga si el stock viene en String
            this.stock = Integer.parseInt(stock);
        }
        public int getStock(){
            return stock;
        }
        //getter y setter precio
        public void setPrecio(int precio){
            this.precio = precio;
        }
        public void setPrecio(String precio){//sobrecarga si el precio viene en String
            this.precio = Integer.parseInt(precio);
        }
        public int getPrecio(){
            return precio;
        }
        
        public void addStock(int i){
        	stock+=i;
        }
}
