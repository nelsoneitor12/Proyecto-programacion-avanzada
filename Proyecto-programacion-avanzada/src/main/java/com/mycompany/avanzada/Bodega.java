package com.mycompany.avanzada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
        OrdenCompra orden;
	 
	public Bodega() throws FileNotFoundException {
            lecturaTxt = new FileClass();
            reportes = new Reportes();
            bodega = lecturaTxt.lecturaProductos(f);
            stockDistrib = lecturaTxt.lecturaProductos(d,1);
            orden = new OrdenCompra();
	}
        
        public Reportes getRep(){
            return this.reportes;
        }

        
        public OrdenCompra getOrden(){
            return orden;
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
	public void agregarProducto() throws IOException{
	 
	}
	 
	public Bodega Venta(String nomSeccion, String nomProducto, int cantidad, Bodega bod) throws IOException {
            
		TipoSeccion seccion;
		TipoProducto prod, copia;
		

		seccion = bodega.get(nomSeccion);
                prod = seccion.getProducto(nomProducto);
                copia = seccion.getCloneProducto(nomProducto);
                copia.setStock(cantidad);
                seccion.actualizarStock(prod.getNombre(), cantidad);
                orden.agregarProducto(copia);
                orden.actualizarPrecio();
                this.getFile().guardarBodega();
                //este return es innecesario hay que borrarlo
		return bod;
	}
	 
	public void emitirReporte() {
		reportes.enlistarOrdenesDeCompra();
	}
        public void finalizarVenta() throws IOException{
            orden.finalizarVenta();
            reportes.agregarOrdenDeCompra(orden);
            orden = new OrdenCompra();
        }
	 
	public void eliminarProducto(String seccionAux, String prod) throws IOException{

 		bodega.get(seccionAux).elimProd(prod); //elimina el objeto de la seccion indicada
        }
         
	public void modificarProducto() throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese seccion del producto: ");
		String[] actual;
		actual = new String[5];
		actual[4] = lector.readLine();
		if (bodega.get(actual[4]) == null) { //verifica que la seccion exista
                    System.out.println("Seccion no encontrada");
                    return;
		}
		System.out.print("Ingrese nombre del producto que desea modificar: ");
		actual[0] = lector.readLine();
		if (bodega.get(actual[4]).existeProducto(actual[0])== false) { //verifica que el producto exista en la seccion
		 	 	System.out.println("Producto no encontrado");
		 	 	return;
		}
		int opcion;
		do {
		System.out.println("Seleccione que desea modificar");
                System.out.println("[1] SECCION");
                System.out.println("[2] NOMBRE");
                System.out.println("[3] CODIGO");
                System.out.println("[4] STOCK");
                System.out.println("[5] PRECIO");
                System.out.println("[0] SALIR");
                opcion = Integer.parseInt(lector.readLine());
        
	        switch(opcion) {
	         	case 1: //elimina el producto, y lo agrega en otra seccion
	         		TipoProducto a = bodega.get(actual[4]).elimProd(actual[0]);
	         		System.out.println("Seleccione la nueva seccion para el producto");
	         		String aux = lector.readLine();
	         		bodega.get(aux).agregarProducto(a);
	         		break;
	         
	         	case 2: //elimina el producto y lo vuelve a agrega con un nombre(key) distinto
	         		TipoProducto aa = bodega.get(actual[4]).elimProd(actual[0]);
	         		System.out.println("Seleccione el nuevo nombre para el producto");
	         		actual[0] = lector.readLine();
	         		aa.setNombre(actual[0]);
	         		bodega.get(actual[4]).agregarProducto(aa);
	         		break;
	         	case 3:// modifica el codigo
	         		bodega.get(actual[4]).modificarProducto(opcion,actual);
	         		break;
	         	case 4:// modifica el stock
	         		bodega.get(actual[4]).modificarProducto(opcion,actual);
	         		break;
	         	case 5://modifica el precio
	         		bodega.get(actual[4]).modificarProducto(opcion,actual);
	         		break;
	         	case 6://modifica marca
	         		bodega.get(actual[4]).modificarProducto(opcion,actual);
	         		break;
	         	default:
	         		break;
	         }
         }while (opcion != 0);
	 }
}
