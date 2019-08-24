package Solucion_aux_7;

public class MaxHeapAB{

	//lo programamos con arboles para que sirva en p2
	AB[] heap;
	int size;

	public MaxHeapAB(){
		heap = new AB[3];
		int size = 0;
	}

	private int izq(int i){
		return 2*i+1;
	}
	private int der(int i){
		return 2*i+2;
	}
	private int padre(int i){
		return (i-1)/2;
	}

	public boolean empty(){
		return size==0;
	}

	private void swap(int i, int j){
		AB aux = heap[i];
		heap[i] = heap[j];
		heap[j] = aux;
	}

	private void resize(){
		AB[] nuevo = new AB[heap.length*2];
		for (int i = 0; i<size; i++ ){
			nuevo[i] = heap[i];
		}
		heap = nuevo;
	}

	private void bubbleDown(int i){
		if(izq(i) > size){
			return;
		}
		int max = izq(i);
    	if (der(i) < size) {
     		if (heap[max].priority < heap[der(i)].priority) {
    	   		max = der(i);
    		}

	    }
	    // heap ordenado, termina.
	    if (heap[i].priority > heap[max].priority) {
	     	return;
	    }

	    swap(i,max);
	    bubbleDown(max);
	}

	private void bubbleUp(int i){
		while(i>0){
			if(heap[i].priority < heap[padre(i)].priority){
				return;
			}
			swap(i,padre(i));
			i = padre(i);
		}
	}

	public AB getMax(){
		if(size == 0){
			System.out.print("Error, no hay elementos");
			return null;
		}
		AB m = heap[0];
		heap[0] = heap[size-1];
		size--;
		bubbleDown(0);
		return m;
	}

	public void insert(AB ab){
		size++;
		if(size >= heap.length){
			resize();
		}
		heap[size-1] = ab;
		bubbleUp(size-1);
	}


}