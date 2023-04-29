package com.mycompany.avanzada;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrdenCompra {
	
	private int fechaEmision_num;
	private String fechaEmision_text;
	private double total;
	private int nroOrden;
	private List<TipoProducto> carro = new ArrayList<>();
	
	public OrdenCompra() {
		// TODO Auto-generated constructor stub
	}
	
	public int getFechaEmision_num() {
		return fechaEmision_num;
	}

	public void setFechaEmision_num(int fechaEmision) {
		this.fechaEmision_num = fechaEmision;
	}
	
	public String getFechaEmision_text() {
		return fechaEmision_text;
	}

	public void setFechaEmision_text(String fechaEmision) {
		this.fechaEmision_text = fechaEmision;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double tot) {
		total = tot;
	}

	public double getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	
	public void agregarProducto(TipoProducto pro) {
		carro.add(pro);
	}
	
	public void finalizarVenta() {
		Date date = new Date();

		fechaEmision_num = (date.getYear()-100)*10000 + date.getMonth()*100 + date.getDate();
		fechaEmision_text = (Integer.toString(date.getDate())+"/"+Integer.toString(date.getMonth())+"/"+Integer.toString(date.getYear()-100));
		nroOrden = (int)(Math.random()*10+1);
		MostrarCarrito();
	}
	
	public void actualizarPrecio() {
		Iterator<TipoProducto> it = carro.iterator();
		TipoProducto now;
		double sum = 0;
		double mult = 0;
		while(it.hasNext()) {
			now = it.next();
			mult = now.getPrecio()*now.getStock();
			sum += mult;
		}
		total = sum;
	}
	
	public void MostrarCarrito() {
		Iterator<TipoProducto> it = carro.iterator();
		TipoProducto now;
		while(it.hasNext()) {
			now = it.next();
			System.out.println("Producto="+now.getNombre()+" "+now.getSeccion()+",Cantidad="+now.getStock()+",Precio Unitario=$"+now.getPrecio());
		}
		System.out.println("Precio Final: $"+total);
	}

}
