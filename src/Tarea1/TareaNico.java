package Tarea1;

import java.util.Scanner;

class TareaNico{
	public static String rot13(String texto){
		// obtenemos el largo del texto
		int largo= texto.length();

		// texto vacio que se ira llenando
		String texto_modificado="";

		//aplicamos el rot13 para cada letra de nuestro texto
		for (int i = 0; i < largo; i++){
			char letra= texto.charAt(i);
		 	//caso a hasta m
			 if (letra >= 'a' && letra <= 'm'){
			 	letra+= 13;
			 } 
			 // caso m a z
			 else if (letra >= 'n' && letra <= 'z'){
			 	letra-= 13;	
			 } 
			texto_modificado+= letra;			
		}
		return texto_modificado;
	}
	//lectura de texto en consola y llamado a rot13
 	public static void main(String[] args) throws Exception {
 		Scanner scanner = new Scanner(System.in);
 		while(scanner.hasNextLine()){
 			String line = scanner.nextLine();
 			System.out.println(rot13(line));
 		}
 	}
 }
		