package Solucion_aux_2;

public class MaxSubArreglo{
	
	// Divide and Conquer
	public static int metodo3(int[] arreglo, int low, int high){

		//pasos
		// dividir el arreglo en dos
		// calcular max cada lado
		// calcular max que cruza
		// retornar max entre todos

		// esto quiere decir que ya no podemos seguir dividiendo mas el arreglo
		if (low == high){
			return arreglo[low];
		}

		// obtenemos el punto medio del arreglo
		int mid = (low + high)/2;

		// obtenemos el maximo de cada mitad
		int maxMitades = Math.max(metodo3(arreglo, low, mid), metodo3(arreglo, mid+1, high));

		//obtenemos el maximo subarreglo de la mitad a la izquierda
		int sumaIzq = 0;
		int sumaMaxIzq = Integer.MIN_VALUE;
		for (int i=mid; i>= low; --i) {
			sumaIzq += arreglo[i];

			if(sumaIzq > sumaMaxIzq){
				sumaMaxIzq = sumaIzq;
			}
		}

		//obtenemos el maximo subarreglo de la mitad a la derecha
		int sumaDer = 0;
		int sumaMaxDer = Integer.MIN_VALUE;
		for (int i=mid+1 ; i<=high ; ++i) {
			sumaDer += arreglo[i];

			if(sumaDer > sumaMaxDer){
				sumaMaxDer = sumaDer;
			}
		}

		return Math.max(maxMitades, sumaMaxIzq + sumaMaxDer);

	}

	//Algoritmo de Kadane
	public static int metodo4(int[] arreglo){

		int max_final = Integer.MIN_VALUE; // maximo 
		int max_hasta_i = 0;

		for (int i=0; i < arreglo.length ; ++i ) {
			
			max_hasta_i = max_hasta_i + arreglo[i];

			if(max_hasta_i < 0){
				max_hasta_i = 0;
			}

			if(max_final < max_hasta_i){
				max_final = max_hasta_i;
			}
		}

		return max_final;

		// en que casos fallar este algoritmo?
		// .
		// .
		// .
		// ..... cuando no hay ningun elemento positivo
	}


	public static void main(String[] args){

		int[] arreglo = {2, -4, 1, 9, -6, 7, -3};

		System.out.println(metodo3(arreglo, 0, arreglo.length - 1));

		System.out.println(metodo4(arreglo));
	}
}

