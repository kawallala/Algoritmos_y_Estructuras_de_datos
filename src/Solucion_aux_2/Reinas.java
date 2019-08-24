package Solucion_aux_2;

public class Reinas{
	
	// queremos chequear que la posicion en donde queremos poner a la reina es segura
	public static boolean esSeguro(int[][] tablero, int x, int y){

		// revisamos si hay alguna otra reina en esta fila
		for (int i=0; i < y ; i++) {
			
			if(tablero[x][i]==1){
				return false;
			}
		}

		// revisamos si hay alguna otra reina en la diagonal superior
		for (int i=x, j=y ; i>=0 && j>=0 ; --i, --j ) {
			
			if(tablero[i][j]==1){
				return false;
			}
		}

		// revisamos si hay alguna otra reina en la diagonal inferior
		for(int i=x, j=y ; i<tablero.length && j>=0 ; ++i, --j){
			if(tablero[i][j]==1){
				return false;
			}
		}

		// cualquier otro caso es seguro poner a la reina en x,y
		return true;
	}

	// funcion recursiva que ubica a las reinas o retorna false si no se pueden ubicar
	public static boolean ubicarReinas(int[][] tablero, int col){

		//si col es igual a N quiere decir que ya hemos cubierto todo el tablero
		if(col == tablero.length){
			return true;
		}

		// chequeamos si podemos poner a la reina en esta cada fila de col
		for (int i=0; i < tablero.length ; ++i ) {
			
			//primero debemos ver si el lugar que queremos ocupar es seguro
			if(esSeguro(tablero, i, col)){

				// de serlo ubicamos a la reina en esta posicion
				tablero[i][col] = 1;

				// si podemos ubicar todas las otras reinas retornamos true
				if(ubicarReinas(tablero, col+1)){
					return true;
				}

				// si no, debemos cambiar la ubicacion de esta reina
				tablero[i][col] = 0;
			}
		}

		// si llegamos a este punto quiere decir que no se puede
		return false;
	}

	public static void main(String[] args){

		// el tamano de nuestra matriz
		int N = 100;

		// creamos la matriz, se llena solita de 0s
		int[][] tablero = new int[N][N];



		// iniciamos la recursion partiendo de la primera columna
		// si ubicarReinas retorna false quiere decir que las reinas no se pueden ubicar
		if(!ubicarReinas(tablero, 0)){

			System.out.println("No se pueden ubicar las reinas");
		}
		else{

			// si se pueden ubicar entonces mostramos como quedan ubicadas
			for (int i=0; i<N ; ++i) {
				for (int j=0; j<N ; ++j) {
					
					System.out.print(tablero[i][j]);

				}
				System.out.println();
			}
		}

	}

}