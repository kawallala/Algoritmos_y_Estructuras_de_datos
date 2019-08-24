package Solucion_aux_5;

public class Cola{
	
	ListaAB ini;
	ListaAB fin;

	public Cola(){
		this.ini = null;
		this.fin = null;
	}

	public boolean estaVacio(){
		return this.ini== null;
	}

	public void enqueue(AB ab){
		ListaAB new_el = new ListaAB(ab);
		if(estaVacio()){
			ini = new_el;
			fin = new_el;
		}
		else{
			fin.sgte = new_el;
			fin = new_el;
		}
	}

	public AB dequeue(){

		if(estaVacio()){
			return null;
		}
		else{
			AB a = ini.val;
			ini = ini.sgte;
			return a;
		}
	}

	public static void buscarGatito(AB ab){
		Cola c = new Cola();

		c.enqueue(ab);

		while(!c.estaVacio()){
			
			AB actual = c.dequeue();
			if(actual!=null){
				System.out.println(actual.valor);

				if(actual.gatito){
					System.out.println("encontramos al gatito");
					break;
				}
				else{
					c.enqueue(actual.izq);
					c.enqueue(actual.der);
				}

			}
		}
	}

	public static void main(String[] args) {

		AB a = new AB(15, false, new AB(4, true), null);
		AB b = new AB(21, false, a, new AB(27, false));
		AB c = new AB(49, false, null, new AB(57, false));
		AB d = new AB(78, false, c, null);
		AB total = new AB(42, false, b, d);
		buscarGatito(total);
	}
}