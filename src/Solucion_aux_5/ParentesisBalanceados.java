package Solucion_aux_5;

public class ParentesisBalanceados{
	
	public static boolean stringBalanceado1(String s){

		int count = 0;
		for (int i=0; i < s.length(); i++) {
			
			if(s.charAt(i) == '('){
				count++;
			}
			else if(s.charAt(i) == ')'){
				if(count <= 0){
					return false;
				}
				else{
					count --;
				}
			}
		}
		if(count == 0){
			return true;
		}
		return false;
	}

	public static boolean stringBalanceado2(String s){
		Stack pila = new Stack();
		for (int i=0;i<s.length();++i) {
			if(s.charAt(i)!= '(' && s.charAt(i)!= ')' && 
				s.charAt(i)!= '[' && s.charAt(i)!= ']' && 
				s.charAt(i)!= '{' && s.charAt(i)!= '}'){
				continue;
			}
			else{
				if(s.charAt(i) == '('){
					pila.push(s.charAt(i));
				}
				else if(s.charAt(i) == '['){
					pila.push(s.charAt(i));
				}
				else if(s.charAt(i) == '{'){
					pila.push(s.charAt(i));
				}
				else if(s.charAt(i) == ')'){
					char c = pila.pop();
					if(c != '('){
						return false;
					}
				}
				else if(s.charAt(i) == ']'){
					char c = pila.pop();
					if(c != '['){
						return false;
					}
				}
				else if(s.charAt(i) == '}'){
					char c = pila.pop();
					if(c != '{'){
						return false;
					}
				}
			}
		}

		if(pila.estaVacio()){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args){

		String s = "(){[]}";
		System.out.println(stringBalanceado2(s));
	}
}