


import java.io.*;
public class menu {

	public static void main(String arg[]) throws IOException {
		int opcion;
		BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Seleccione la operacion a realizar");
			opcion=Integer.parseInt(lector.readLine());
		}while(opcion!=0);
	}

}
