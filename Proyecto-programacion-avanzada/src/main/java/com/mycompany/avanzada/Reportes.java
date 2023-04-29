package com.mycompany.avanzada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reportes {
	
	private List<OrdenCompra> arrOrdenes= new ArrayList<>();
	
	public Reportes() {
		// TODO Auto-generated constructor stub
	}
	public void agregarOrdenDeCompra(OrdenCompra orden) {
		arrOrdenes.add(orden);
	}
	
	public void enlistarOrdenesDeCompra() {
		Iterator<OrdenCompra> it= arrOrdenes.iterator();
		OrdenCompra now;
		while(it.hasNext()) {
			now=it.next();
			System.out.println("//////////////////////////////////////////////////////////////////////////////");
			System.out.println("nro_Orden:"+now.getNroOrden()+"           Fecha Emitida:"+now.getFechaEmision_text());
			System.out.println("Compra: \n");
			now.MostrarCarrito();
			System.out.println("//////////////////////////////////////////////////////////////////////////////\n");
		}
		
	}

}
