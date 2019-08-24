public class heap{



	static void subir(int[] h, int i){

		while( i > 1 && (h[i] > h[i/2])){

			int temp = h[i];
			h[i] = h[i/2];
			h[i/2] = temp;
			i = i/2;
		}
	}

	static void bajar(int[] h, int i){

		if(2*i < h.length && 2*i+1 < h.length){

			if(h[i] < h[2*i]){

				int temp = h[i];
				h[i] = h[2*i];
				h[2*i] = temp;
				bajar(h, 2*i); // puede que el padre tenga que seguir bajando
				bajar(h, i); // puede que el hijo izquierdo sea menor que el derecho
			}
			else if(h[i] < h[2*i+1]){
				int temp = h[i];
				h[i] = h[2*i+1];
				h[2*i+1] = temp;
				bajar(h, 2*i+1); // puede que padre tenga que seguir bajando
				bajar(h, i);// puede que el hijo derecho sea menor que el izquierdo
			}
		}
		else if(2*i < h.length){
			if(h[i] < h[2*i]){

				int temp = h[i];
				h[i] = h[2*i];
				h[2*i] = temp;
				bajar(h, 2*i); // puede que el padre tenga que seguir bajando
			}
		}
	}
	

	//Hijos del nodo j = {2*j, 2*j+1} 
	//Padre del nodo k = floor(k/2)
	static void modify(int[] h, int old_val, int new_val){

		// encontramos valor que queremos modificar
		int ind = -1;
		for(int i=1; i < h.length; i++){
			if(h[i]== old_val){
				ind = i;
				break;
			}
		}

		if(new_val > old_val){ // corregir para arriba
			h[ind] = new_val;
			subir(h, ind);
		}
		else{ // corregir para abajo
			h[ind] = new_val;
			bajar(h, ind);
		}
	}
	
	public static void main(String[] args){
		//en el indice 0 no habra nada
		int[] h = {-1, 30, 25, 29, 9, 20, 28, 0};

		//h = modify(h, 29, 40);
		modify(h, 30, 2);
		for(int i : h){
			System.out.println(i);
		}

	}
}