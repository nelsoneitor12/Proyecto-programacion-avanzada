/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Proyecto.programacion.avanzada;
import java.io.*;

public class App {
   public static void main(String arg[]) throws IOException {
	int opcion;
        String a;
	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	do {
            System.out.println("Seleccione la operacion a realizar");
            System.out.println("[1] POR DEFINIR");
            System.out.println("[0] SALIR");
            a = lector.readLine();
            opcion = Integer.parseInt(a);
	}while(opcion!=0);
    }
}