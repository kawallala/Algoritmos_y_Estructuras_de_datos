package Solucion_aux_7;

class Huffman{

	static AB codificar(String[] caracteres, double[] prioridades){
		int n = caracteres.length;
		MaxHeapAB heap = new MaxHeapAB();
		for (int i = 0; i<n; ++i) {
			heap.insert(new AB(-prioridades[i], caracteres[i]));
		}
		while(heap.size>1){
			AB a = heap.getMax();
			AB b = heap.getMax();
			heap.insert(new AB(a.priority + b.priority, "nodo", a, b));
		}
		return heap.getMax();
	}

	static void mostrarCodigo(AB raiz, String codigo){
		if(raiz==null)return;
		if(!raiz.caracter.equals("nodo")){
			System.out.println(raiz.caracter + ": " + codigo);
		}
		mostrarCodigo(raiz.izq, codigo + "0");
		mostrarCodigo(raiz.der, codigo + "1");
	}

	public static void main(String[] args) {
		double[] pr = {0.1, 0.2, 0.15, 0.15, 0.2, 0.3, 0.4, 0.66, 0.78};
		String[] ch = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		AB codigo = codificar(ch, pr);
		mostrarCodigo(codigo, "");
	}
}