import java.util.Scanner;

// con esto declaramos la clase.
class EjemploIO {

	// esta función suma los numeros de un arreglo
	public static int sumar(int[] numeros){
		
		int suma = 0;

		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}

		return suma;
	}
	
	// esta es la función que se invoca al correr el archivo.
	public static void main(String[] args) {
		
		// creamos el objeto scanner que nos permite leer el input del usuario.
		Scanner in = new Scanner(System.in);
		
		// imprimimos un mensaje en consola.
		System.out.println("Ingrese su nombre:");
		
		// leemos la siguiente linea que escriba.
		String nombre = in.nextLine();
		
		// imprimimos un saludo, en java al sumar strings y números todo se junta en un solo string.
		System.out.println("Hola " + nombre + ", eres el visitante n°" + 30000 + "!");
    
    
    	// ejemplo para obtener varios arreglo de números.
		System.out.println("Ingrese varias secuencia de números separados por espacios. Por ej: '1 2 3'");
    	
    	int secuencia = 1;

    	while(in.hasNextLine()){
    		String linea = in.nextLine(); // obtener la siguiente linea.
	    
		    // separar la linea por espacios.
		    // Por ej: "1 2 3".split(" ") retorna ["1", "2",  "3"].
		    String[] separados = linea.split(" "); 
		    
		    // creamos un arreglo de entero del mismo largo que el arreglo de Strings separados.
		    int[] numeros = new int[separados.length];

		    for (int i = 0; i < separados.length; i++) { // recorremos el arreglo de Strings.
		      numeros[i] = Integer.parseInt(separados[i]); // parseamos todos los Strings a ints.
		    }

		    // para hacer algo con los numeros los sumaremos todos e imprimiremos el resultado.
		    int suma = sumar(numeros);
		    
		    System.out.println("La suma de la secuencia n° " + secuencia + " :" + suma);
		    secuencia++;
    	}
	    
			
		// cerramos el Scanner ahora que no lo vamos a usar mas, esta es una buena práctica
		// para asegurarse de que no se malgasten recursos en un programa, pero no es obligación.
		in.close();
	}
}
