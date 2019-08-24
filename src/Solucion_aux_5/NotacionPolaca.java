package Solucion_aux_5;

public class NotacionPolaca{

	public static String recorrerArbol(Arbol a){

		if(a.izq == null && a.der == null){
			return a.valor;
		}
		else if(a.izq != null && a.der != null){
			
			return recorrerArbol(a.izq) + a.valor + recorrerArbol(a.der);
		}
		else if(a.izq != null && a.der == null){
			return recorrerArbol(a.izq) + a.valor;
		}
		else if(a.izq == null && a.der != null){
			return a.valor + recorrerArbol(a.der);
		}
		return "";
	}

	public static String obtenerString(Arbol a){

		String s = "";

		return recorrerArbol(a);
	}

	public static Arbol parentizarIzq(Arbol a){

		if(a.izq == null){
			return new Arbol(a.valor, new Arbol("(", null, null), a.der);
		}
		else{
			return new Arbol(a.valor, parentizarIzq(a.izq), a.der);
		}
	}

	public static Arbol parentizarDer(Arbol a){

		if(a.der == null){
			return new Arbol(a.valor, a.izq, new Arbol(")", null, null));
		}
		else{
			return new Arbol(a.valor, a.izq, parentizarDer(a.der));
		}
	}

	public static Arbol parentizar(Arbol a){
		
		return new Arbol(a.valor, parentizarIzq(a.izq), parentizarDer(a.der));
	}

	public static String notacionInOrden(String s){

		String[] expr = s.split(" ");
		Stack pila = new Stack();

		for(String e : expr){

			if(!e.equals("*") && !e.equals("-") && !e.equals("+") && !e.equals("/")){

				pila.push(new Arbol(e));
			}
			else{

				if(e.equals("*")){
					Arbol der = pila.pop();
					Arbol izq = pila.pop();

					Arbol nodo = new Arbol(e, izq, der);
					pila.push(parentizar(nodo));
				}
				else if(e.equals("/")){
					Arbol der = pila.pop();
					Arbol izq = pila.pop();

					Arbol nodo = new Arbol(e, izq, der);
					pila.push(parentizar(nodo));
				}
				else if(e.equals("-")){
					Arbol der = pila.pop();
					Arbol izq = pila.pop();

					Arbol nodo = new Arbol(e, izq, der);
					pila.push(parentizar(nodo));
				}
				else if(e.equals("+")){
					Arbol der = pila.pop();
					Arbol izq = pila.pop();

					Arbol nodo = new Arbol(e, izq, der);
					pila.push(parentizar(nodo));
				}
			}
		}

		return obtenerString(pila.pop());
	}
	
	public static void main(String[] args){
		
		String s = "3 4 7 + 5 - *";
		System.out.println(notacionInOrden(s));
	}
}