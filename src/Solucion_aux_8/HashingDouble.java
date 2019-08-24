package Solucion_aux_8;

public class HashingDouble{
	
	int table_size = 10;

	int[] table;

	public HashingDouble(){
		table = new int[table_size];
	}

	public int fun_ho(int x){
		return x%10;
	}

	public int fun_s(int x){
		return x/10;
	}

	public void insert(int x){

		if(table[fun_ho(x)] == 0){
			table[fun_ho(x)] = x;
		}
		else{
			int val = fun_ho(x) + fun_s(x);
			while(table[val%table_size] != 0){
				val += fun_s(x);
			}
			table[val] = x;
		}

	}

	public static void main(String[] args){

		HashingDouble h = new HashingDouble();

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