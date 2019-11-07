package pgv.comunicar.procesos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
	    	
	    	String texto = null;    	
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.println("Introduce un texto");
	    	texto = scanner.nextLine(); //Capturamos la entrada de teclado
	    	texto = texto.trim(); //Borramos los espacios
	    	
	    	while (!texto.equals("salir")) { //Bucle de introduccion de texto
	    		
	    		 try {
	    	        	// 1. Preparar el ejecutable
	    	        	File ejecutable = new File("RandomC/random.exe");
	    	            // 2. Ejecutar el proceso
	    	            Process proc = new ProcessBuilder(ejecutable.getAbsolutePath()).start();
	    	            // 3. Abrir canal de entrada
	    	            InputStream is = proc.getInputStream();
	    	            // 4. Abrir canal de salida
	    	            OutputStream out = proc.getOutputStream();
	    	            // 5.Escribir en el proceso
	    	            writeToProc(out, texto);
	    	            // 6. Leer respuesta del proceso    	            
	    	            readFromProc(is);	
	    	            // 7. Destriimos el proceso
	    	            proc.destroy();//Destruimos el proceso
	    	            // 8. Leemos otra vez
	    	            System.out.println("Introduce un texto");
	    	        	texto = scanner.nextLine(); //Capturamos entrada de teclado	    	        	
	    	        	texto = texto.trim(); // Borramos los espacios
	    	        		
	    	        } catch(Exception e) {
	    	            e.printStackTrace();
	    	        }    		    		
	    	}
	    	System.out.println("Se ha salido del bucle");
	       
	    }
	
	
	   // Escribir en el proceso
    public static void writeToProc(OutputStream out, String msg) throws IOException {
    	OutputStreamWriter osw = new OutputStreamWriter(out);
    	BufferedWriter buffw = new BufferedWriter(osw);
    	buffw.write(msg); 	
    	buffw.close();
        //out.flush();
        System.out.println("Se ha escrito: " + msg);
    }
	
	
	
    // Leer Entrada Estandar
    public static void readFromProc(InputStream is) throws IOException {
    	InputStreamReader isr = new InputStreamReader(is);
    	BufferedReader buffr = new BufferedReader(isr);
    	String line = null; 
    	line = buffr.readLine();
    	int aux = 0;
    	while(line!=null) {
    		System.out.println("Entrada:" + line);
    		line = buffr.readLine();
    		///Le añadimos un contador para salir del bucle infinito
    		aux++;
    		if (aux==1) { 
    			break;
    		}
    	}
    	
    	buffr.close();
        
        }
	
	
	
}
