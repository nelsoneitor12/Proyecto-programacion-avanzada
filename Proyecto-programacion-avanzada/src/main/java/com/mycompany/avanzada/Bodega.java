package com.mycompany.avanzada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

public class Bodega {
	private File f = new File("./productos.txt"); //se abre el archivo que contiene la lista de productos
	private File d= new File("./StockDistribuidores.txt"); //se abre el archivo que contiene la lista de productos del distribuidor
	private Map<String,TipoSeccion> bodega; //se crea mapa para acceder mas facilmente al stock
	private Map<String,Distribuidores> stockDistrib;
	private FileClass lecturaTxt = new FileClass();;
	private Reportes reportes = new Reportes();
	 
	 
	public Bodega() throws FileNotFoundException {
		 bodega = lecturaTxt.lecturaProductos(f);
		 stockDistrib = lecturaTxt.lecturaProductos(d,1);
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
	 
	 public void Venta() throws IOException {
		 BufferedReader ln= new BufferedReader(new InputStreamReader(System.in));
		 String now;
		 TipoSeccion seccion;
		 TipoProducto prod, copia;
		 OrdenCompra orden=new OrdenCompra();
		 int flag;
		 
		 do {
			 System.out.println("Ingrese la seccion del producto: ");
			 now=ln.readLine();
			 seccion= bodega.get(now);
		 
			 System.out.println("Ingrese el nombre del Producto: ");
			 now=ln.readLine();
			 prod= seccion.getProducto(now);
			 copia= seccion.getCloneProducto(now);
			 
			 System.out.println("Ingrese la Cantidad a comprar: ");
			 now=ln.readLine();
			 copia.setStock(Integer.parseInt(now));
			 seccion.actualizarStock(prod.getNombre(), Integer.parseInt(now));
			 orden.agregarProducto(copia);
			 orden.actualizarPrecio();
			 do {
				 System.out.println("1.Mostrar Carrito de Compra/////////2.Continuar comprando////////////3.Finalizar Compra");
				 flag=Integer.parseInt(ln.readLine());
				 if (flag==1) orden.MostrarCarrito();
			 }while(flag==1);
			 
			 
		 }while(flag!=3);
		 orden.finalizarVenta();
		 reportes.agregarOrdenDeCompra(orden);
		 
	 }
	 
	 public void emitirReporte() {
		 reportes.enlistarOrdenesDeCompra();
	 }
	 
	 public void eliminarProducto() throws IOException{
		 BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));//se inicializa lector para leer input
		 String seccionAux;
		 System.out.print("Ingrese seccion del producto: ");
	 	 seccionAux = lector.readLine();
	 	 if (bodega.get(seccionAux) == null) {	//verifica que la seccion exista
	 	 	System.out.println("Seccion no encontrada");
	 	 	return;
	 	 }
 		bodega.get(seccionAux).elimProd(); //elimina el objeto de la seccion indicada
	 }
	 public void modificarProducto() throws IOException{
		 BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("Ingrese seccion del producto: ");
		 String[] actual;
		 actual = new String[5];
		 actual[4]= lector.readLine();
		 if (bodega.get(actual[4]) == null) { //verifica que la seccion exista
		 	 	System.out.println("Seccion no encontrada");
		 	 	return;
		 }
		 System.out.print("Ingrese nombre del producto que desea modificar: ");
		 actual[0]= lector.readLine();
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
         opcion=Integer.parseInt(lector.readLine());
        
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
         }while (opcion !=0);
	 }
}
