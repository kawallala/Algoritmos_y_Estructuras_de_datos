
public class MergeSort{

	public static int min(int a, int b){
		if(a < b){
			return a;
		}
		else{
			return b;
		}
	}
	public static void mergeSort(int[] arr, int n){

		int size;
		int ini;

		for(size = 1; size < n; size = size*2){

			for(ini = 0; ini < n-1; ini += 2*size){

				int fin_primero = ini + size - 1;
				int fin_segundo = Math.min(n-1, ini + 2*size-1);

				merge(arr, ini, fin_primero, fin_segundo);
			}
		}
	}

	public static void merge(int[] arr, int ini, int fin_primero, int fin_segundo){

		int n1 = fin_primero - ini + 1;
		int n2 = fin_segundo - fin_primero;

		int[] aux1 = new int[n1];
		int[] aux2 = new int[n2];

		for (int i=0; i < n1; i++ ) {
			aux1[i] = arr[i+ini];
		}

		for (int i=0; i < n2; i++ ) {
			aux2[i] = arr[fin_primero+1+i];
		}

		int i=0, j=0, k = ini;

		while(i < n1 && j < n2){

			if(aux1[i]< aux2[j]){
				arr[k] = aux1[i];
				i++;
			}
			else{
				arr[k] = aux2[j];
				j++;
			}

			k++;
		}

		while(i < n1){
			arr[k] = aux1[i];
			i++;
			k++;
		}

		while(j < n2){
			arr[k] = aux2[j];
			j++;
			k++;
		}

	}

	public static void main(String[] args){

		int[] elementos = {12, 11, 13, 5, 6, 7, 8, 1};

		mergeSort(elementos, 8);

		for (int elemento : elementos ) {
			System.out.println(elemento);
		}

	}
}