package Solucion_aux_8;

public class HashingEncadenamiento{
	
	int table_size = 10;

	Lista[] table;

	public HashingEncadenamiento(){
		table = new Lista[table_size];
	}

	public int fun_ho(int x){
		return x%10;
	}

	public void insert(int x){

		if(table[fun_ho(x)] == null){
			table[fun_ho(x)] = new Lista(x);
		} 
		else{

			Lista l = table[fun_ho(x)];
			while(l.sgte != null){
				l = l.sgte;
			}

			l.sgte = new Lista(x);
		}

	}

	public static void main(String[] args){

		HashingEncadenamiento h = new HashingEncadenamiento();

		int[] elementos = {123, 467, 24, 23, 126, 38, 33, 11};

		for(int elemento : elementos){
			h.insert(elemento);
		}

		for (Lista i : h.table) {
			if(i != null){
				while(i!= null){
					System.out.print(i.val + " ");
					i = i.sgte;
				}
				System.out.println();
			}
			else{
				System.out.println(i);
			}
			
		}
	}
}