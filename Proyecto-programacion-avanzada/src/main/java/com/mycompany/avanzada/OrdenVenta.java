package com.mycompany.avanzada;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.temporal.ChronoUnit;

public class OrdenVenta {
	
	protected int fechaEmision_num;
	protected String fechaEmision_text;
	protected int total;
	protected int nroOrden;
        protected String tipoOrden;
	protected List<TipoProducto> carro = new ArrayList<>();
	//getter lista productos (carro)
	public OrdenVenta() {
		// TODO Auto-generated constructor stub
	}
	public List<TipoProducto> getCarro() {
		return carro;
	}
        
        public void setTipoOrden(){
            tipoOrden="Orden de Venta";
        }
        
        public String getTipoOrden(){
            return tipoOrden;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int tot) {
		total = tot;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	
	public void agregarProducto(TipoProducto pro) {
                System.out.println("pase por aqui con el prod: "+pro.getNombre());
		carro.add(pro);
	}
	
	public void finalizarVenta() {
		Date date = new Date();
                Random rand= new Random();
                LocalDateTime now= LocalDateTime.now();
                long seconds = ChronoUnit.SECONDS.between(LocalDateTime.of(2021, 1, 1, 0, 0), now);
		fechaEmision_num = (date.getYear()-100)*10000 + date.getMonth()*100 + date.getDate();
		fechaEmision_text = (Integer.toString(date.getDate())+"/"+Integer.toString(date.getMonth())+"/"+Integer.toString(date.getYear()-100+2000));
		nroOrden = rand.nextInt((int) seconds);
                setTipoOrden();
		MostrarCarrito();
                
	}
	
	public void actualizarPrecio() {
		Iterator<TipoProducto> it = carro.iterator();
		TipoProducto now;
		int sum = 0;
		int mult = 0;
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
