package Solucion_aux_8;

public class HashingLinear{
	
	int table_size = 10;

	int[] table;

	public HashingLinear(){
		table = new int[table_size];
	}

	public int fun_ho(int x){
		return x%10;
	}

	public void insert(int x){

		if(table[fun_ho(x)] == 0){
			table[fun_ho(x)] = x;
		}
		else{
			int val = fun_ho(x);
			while(table[val%table_size] != 0){
				val++;
			}
			table[val] = x;
		}

	}

	public static void main(String[] args){

		HashingLinear h = new HashingLinear();

		int[] elementos = {123, 467, 24, 23, 126, 38, 33, 11};

		for(int elemento : elementos){
			h.insert(elemento);
		}

		for (int i : h.table) {
			if(i != 0){
				System.out.println(i);
			}
			else{
				System.out.println(i);
			}
			
		}

	}
}