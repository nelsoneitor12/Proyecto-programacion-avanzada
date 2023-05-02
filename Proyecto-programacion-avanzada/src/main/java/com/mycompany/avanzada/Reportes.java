package com.mycompany.avanzada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reportes {
	
	private List<OrdenVenta> arrOrdenesVen = new ArrayList<>();
	//getter arregloordenes
        
	public Reportes() {
		// TODO Auto-generated constructor stub
	}
        public List<OrdenVenta> getArrOrdenes(){
            return arrOrdenesVen;
        }
        
	public void agregarOrdenDeCompra(OrdenVenta orden) {
                 System.out.println(orden.nroOrden);
		arrOrdenesVen.add(orden);
	}
	
	public void enlistarOrdenesDeCompra() {
		Iterator<OrdenVenta> it = arrOrdenesVen.iterator();
		OrdenVenta now;
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
