package com.mycompany.avanzada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reportes {
	
	private List<OrdenCompra> arrOrdenes = new ArrayList<>();
	//getter arregloordenes
        
	public Reportes() {
		// TODO Auto-generated constructor stub
	}
        public List<OrdenCompra> getArrOrdenes(){
            return arrOrdenes;
        }
        
	public void agregarOrdenDeCompra(OrdenCompra orden) {
		arrOrdenes.add(orden);
	}
	
	public void enlistarOrdenesDeCompra() {
		Iterator<OrdenCompra> it = arrOrdenes.iterator();
		OrdenCompra now;
		while(it.hasNext()) {
			now = it.next();
			System.out.println("//////////////////////////////////////////////////////////////////////////////");
			System.out.println("nro_Orden:"+now.getNroOrden()+"           Fecha Emitida:"+now.getFechaEmision_text());
			System.out.println("Compra: \n");
			now.MostrarCarrito();
			System.out.println("//////////////////////////////////////////////////////////////////////////////\n");
		}
		
	}

}
