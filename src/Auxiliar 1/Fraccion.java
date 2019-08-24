import java.util.Scanner;

public class Fraccion {

	// variables de la clase
	int num;
	int den;

	//constructor, se llama cuando uno hace Fraccion f = new Fraccion(3,4); por ejemplo
	public Fraccion(int num, int den) {
		this.num = num;
		this.den = den;
	}

	//otro constructor, este se llama cuando uno hace Fraccion f = new Fraccion("3/4")
	//no esta en el enunciado
	public Fraccion(String frac) {
		// separa "3/4" en ["3", "4"]
		String[] partes = frac.split("/");
		
		// pasar el string "3" al int 3
		this.num = Integer.parseInt(partes[0]);
		this.den = Integer.parseInt(partes[1]);
	}

	/**
	 *  funcion de euclides para calcular el maximo comun divisor
	 */
	public static int mcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return mcd(b, a % b);
	}

	/**
	 *  simplificar la fraccion que llama a esta funcion
	 */
	public void simplificar() {
		// calcular mcd
		int m = mcd(this.num, this.den);
		
		// simplificar las variables
		this.den = den / m;
		this.num /= m;
	}

	/**
	 *  sumar 2 fracciones y devolverlas en un nuevo objeto
	 */
	public Fraccion suma(Fraccion other) {
    // sumamos las fracciones
    Fraccion resultado = new Fraccion(this.num * other.den + other.num * this.den, this.den * other.den);
    resultado.simplificar(); // simplificamos para que de fracciones bonitas *^*
		return resultado;
	}
	
	@Override
	/**
	 *  traspasar la fraccion a string
	 */
	public String toString() {
		return num + "/" + den;
	}

	/**
	 * funcion que se ejecuta al correr el programa, pregunta un numero n 
	 * y despues recibe n fracciones, las suma e imprime el resultado 
	 */
	public static void main(String[] args) {
		
		// objeto para recibir entrada a traves de la consola
		Scanner in = new Scanner(System.in);
		
		// imprimir la pregunta
		System.out.println("n?");
		
		// recibir una linea y parsearla a int
		int n = Integer.parseInt(in.nextLine());
		
		// variable para calcular la suma
		Fraccion acumulado = new Fraccion(0, 1);
		
		// for i = 1:n
		for (int i = 0; i < n; i++) {
			System.out.println("Fraccion " + (i+1) + "?");
			
			// recibir y separar la fraccion
      
      // separa "3/4" en ["3", "4"]
      String frac = in.nextLine();
      String[] partes = frac.split("/");
      
      // pasar el string "3" al int 3
      int num = Integer.parseInt(partes[0]);
      int den = Integer.parseInt(partes[1]);
      
      // crear fraccion y sumar al acumulado
			Fraccion f = new Fraccion(num, den);
			acumulado = acumulado.suma(f);
		}
		
		// simplificar e imprimir la fraccion acumulado
		acumulado.simplificar();
		System.out.println("La suma total es: " + acumulado);
		
		in.close();
	}
}
