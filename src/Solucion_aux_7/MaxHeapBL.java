package Solucion_aux_7;

class MaxHeapBL{

	BeyLuchador[] heap;
	int size;

	public MaxHeapBL(){
		heap = new BeyLuchador[2];
		size = 0;
	}

	private int izq(int nodo){
		return 2*nodo+1;
	}
	private int der(int nodo){
		return 2*nodo+2; 
	}
	private int padre(int nodo){
		return (nodo-1)/2;
	}

	public boolean empty(){
		return size==0;
	}

	private void resize(){
		BeyLuchador[] nuevo = new BeyLuchador[heap.length*2];
		for (int i = 0; i< size; i++) {
			nuevo[i] = heap[i];
		}
		heap = nuevo;
	}

	public void insertar(BeyLuchador bl){
		if(size >= heap.length){
			resize();
		}
		heap[size] = bl;
		size++;
		bubbleUp(size-1);
	}

	private void swap(int i, int j){
		BeyLuchador aux = heap[i];
		heap[i] = heap[j];
		heap[j] = aux;
	}

	private void bubbleUp(int i){
		while(i>0){
			if(heap[i].beyPoder < heap[padre(i)].beyPoder)
				return;
			swap(i, padre(i));
			i = padre(i);
		}
	}

	public BeyLuchador extraerMax(){
		if(empty()){
			System.out.println("error: heap vacio");
			return null;
		}
		BeyLuchador ans = heap[0];
		size--;
		heap[0] = heap[size];
		bubbleDown(0);
		return ans;
	}

	private void bubbleDown(int i){
		if(izq(i) >= size){
			return;
		}

		int max = izq(i);

		if(der(i) < size){
			if(heap[max].beyPoder < heap[der(i)].beyPoder){
				max = der(i);
			}
		}
		if(heap[max].beyPoder < heap[i].beyPoder){
			return;
		}
		swap(i,max);
		bubbleDown(max);
	}

	public static void main(String[] args) {
		BeyLuchador ricardo = new BeyLuchador(0, "ricardo");
		BeyLuchador benja = new BeyLuchador(-1, "benja");
		BeyLuchador jeremy = new BeyLuchador(10, "jeremy");
		BeyLuchador pato = new BeyLuchador(100, "pato");

		MaxHeapBL heap = new MaxHeapBL();

		heap.insertar(ricardo); heap.insertar(benja); heap.insertar(jeremy); heap.insertar(pato);
		while(!heap.empty()){
			BeyLuchador b = heap.extraerMax();
			System.out.println("luchador " + b.nombre + " tiene beyPoder: " + b.beyPoder);
		}
	}



}