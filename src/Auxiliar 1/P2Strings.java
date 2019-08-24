
public class P2Strings {
  
	//pruebas
	public static void main(String[] args) {
    
		System.out.println(esRotacionCircular("algoritmo", "ritmoalgo")); // true
    
		System.out.println(esPalindrome("anilina")); // true
    
		System.out.println(esOracionPalindrome("anita lava la tina")); // true

		System.out.println(esOracionPalindrome("anita lava la tinas")); //false

		System.out.println(esPalindrome("anita lava la tina")); // true


	}

	/**
	 * version corta y haxxor, la version mas larga es recorer todas las rotaciones
	 * posibles de r y comprobar si alguna es igual a w.
	 */
	static boolean esRotacionCircular(String r, String w) {
    boolean largos = r.length() == w.length(); // chequear que los largos sean iguales
    
    // s1.contains(s2) retorna true si el String s2 se encuentra dentro de s1.
    
    boolean contiene = (r + r).contains(w); 
    // si al concatenar un string consigo mismo contiene al otro y adem�s son del mismo largo
    // entonces s� es rotaci�n circular.
    // Ejemplo: ritmoalgoritmoalgo si contiene a algoritmo.
		return largos && contiene;
	}

	static boolean esPalindrome(String palabra) {
		int largo = palabra.length();

    // s.charAt(i) retorna el i-esimo caracter en s.
    // los caracteres s� se pueden comparar con == por lo que es m�s f�cil (y seguro) usarlos.
    
		for (int i = 0; i < largo / 2; i++) { // solo es necesario recorrer la mitad de la palabra.
			// comparar cada letra con su opuesto en la palabra, si son distintas no es palindromo.
			if (palabra.charAt(i) != palabra.charAt(largo - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	static boolean esOracionPalindrome(String oracion) {
    // s.replaceAll(objetivo, reemplazo) reemplaza todas las ocurrencias de objetivo por reemplazo.
    
		// quitarle todos los espacios a la oracion (reemplazarlos por String vac�o
		String oracionSinEspacios = oracion.replaceAll(" ", "");
		// chequear si es palindrome
		return esPalindrome(oracionSinEspacios);
	}
}
