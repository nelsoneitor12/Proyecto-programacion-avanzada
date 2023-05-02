package com.mycompany.avanzada;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
//import ventanas.ventanaVentaSeccion2;

public class Bodega {
        private File f = new File("./productos.txt"); //se abre el archivo que contiene la lista de productos
        private File d = new File("./StockDistribuidores.txt"); //se abre el archivo que contiene la lista de productos del distribuidor
        private Map<String,TipoSeccion> bodega; //se crea mapa para acceder mas facilmente al stock
        private Map<String,Distribuidores> stockDistrib;
	private FileClass lecturaTxt;
	private Reportes reportes;
        private Reportes reportesDistrib;
        OrdenVenta ordenVen;
	OrdenCompra ordenCom;
	public Bodega() throws FileNotFoundException {
            lecturaTxt = new FileClass();
            reportes = new Reportes();
            bodega = lecturaTxt.lecturaProductos(f);
            stockDistrib = lecturaTxt.lecturaProductos(d,1);
            ordenVen = new OrdenVenta();
            ordenCom= new OrdenCompra();
	}
        
        public Reportes getRep(){
            return this.reportes;
        }
        
        public OrdenCompra getOrdenCom(){
            return ordenCom;
        }
        
        public OrdenVenta getOrdenVen(){
            return ordenVen;
        }
	public FileClass getFile(){
            return lecturaTxt;
        }
        public Map<String,TipoSeccion> getMapa(){
            return bodega;
        }
        
        public Map<String,Distribuidores> getMapaDist(){
            return stockDistrib;
        }
        
	public void enlistarSecciones() {
		for(Entry<String, TipoSeccion> r : bodega.entrySet()) {
 			System.out.println("\nSeccion: "+r.getValue().getNomSeccion());
 			r.getValue().enlistarProductos();
 		}
	 }
	public void enlistarDistribuidores() {
		for(Entry<String, Distribuidores> r : stockDistrib.entrySet()) {
 			System.out.println("\nDistribuidor: "+r.getValue().nomSeccion);
 			r.getValue().enlistarProductos();
 		}
	 }
	public Bodega comprarDitrib(String dis, String prod, int cant, Bodega bod) throws IOException,StockAmountException{
            Distribuidores distActual=bod.getMapaDist().get(dis);
            ProdDistrib prodDis= distActual.getMapaD().get(prod);
            System.out.println(prodDis.getMarca());
            TipoSeccion seccion=bod.getMapa().get(prodDis.getSeccion());
            System.out.println(seccion.getNomSeccion());
            TipoProducto prodSecc=seccion.getProducto(prod);
            prodDis.removeStock(cant);
            prodSecc.addStock(cant);
            ProdDistrib copia=distActual.getCloneProducto(prod);
            copia.setStock(cant);
            ordenCom.agregarProducto(copia);
            ordenCom.actualizarPrecio();
            this.getFile().guardarBodega();
            this.getFile().guardarBodegaDist();
            return bod;
	}
	 
	public Bodega Venta(String nomSeccion, String nomProducto, int cantidad, Bodega bod) throws IOException,StockAmountException {
            
		TipoSeccion seccion;
		TipoProducto prod, copia;
		seccion = bodega.get(nomSeccion);
                prod = seccion.getProducto(nomProducto);
                copia = seccion.getCloneProducto(nomProducto);
                copia.setStock(cantidad);
                seccion.actualizarStock(prod.getNombre(), cantidad);
                ordenVen.agregarProducto(copia);
                ordenVen.actualizarPrecio();
                this.getFile().guardarBodega();
                //este return es innecesario hay que borrarlo
		return bod;
	}
	 
	public void emitirReporte() {
		reportes.enlistarOrdenesDeCompra();
	}
        public void finalizarVenta(OrdenVenta orden) throws IOException{
            ordenVen.finalizarVenta();
            reportes.agregarOrdenDeCompra(ordenVen);
            ordenVen = new OrdenVenta();
        }
        
        public void finalizarVenta(OrdenCompra orden) throws IOException{
            ordenCom.finalizarVenta();
            reportes.agregarOrdenDeCompra(ordenCom);
            ordenCom = new OrdenCompra();
        }
	 
	public void eliminarProducto(String seccionAux, String prod) throws IOException{

 		bodega.get(seccionAux).elimProd(prod); //elimina el objeto de la seccion indicada
        }
         
	public void modificarProducto(String s, String p, String opcion,String newValor) throws IOException,InvalidNumberException{
                //actual[4] = s;
                //actual[0] = p;
                //VENTANA PARA ELEGIR
                /*
                bodega.get(s) es  mapa de secciones
                */
		TipoProducto a = bodega.get(s).getProducto(p); // o = bodega.get(s).elimProd(p);
	        switch(opcion) {
	         	case "Seccion": //elimina el producto, y lo agrega en otra seccion
	         		a = bodega.get(s).elimProd(p);
                                a.setSeccion(newValor);
	         		bodega.get(newValor).agregarProducto(a);
	         		break;
	         
	         	case "Nombre": //elimina el producto y lo vuelve a agrega con un nombre(key) distinto
	         		a = bodega.get(s).elimProd(p);
	         		a.setNombre(newValor);
	         		bodega.get(s).agregarProducto(a);
	         		break;
	         	case "Codigo":// modifica el codigo
	         		if (Integer.parseInt(newValor)<1) throw new InvalidNumberException();
	         		bodega.get(s).getProducto(p).setCodigo(Integer.parseInt(newValor));
	         		break;
	         	case "Stock":// modifica el stock
	         		if (Integer.parseInt(newValor)<0) throw new InvalidNumberException();
	         		bodega.get(s).getProducto(p).setStock(Integer.parseInt(newValor));
	         		break;
	         	case "Precio"://modifica el precio
	         		if (Integer.parseInt(newValor)<1) throw new InvalidNumberException();
	         		bodega.get(s).getProducto(p).setPrecio(Integer.parseInt(newValor));
	         		break;
	        }
        this.getFile().guardarBodega();
	}
}
