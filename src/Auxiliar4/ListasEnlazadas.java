package Auxiliar4;

public class ListasEnlazadas {
    private Nodo primero;

    public int largo(){
        int i = 0;
        Nodo actual = primero;
        while (actual.siguiente!=null){
            i++;
            actual = actual.siguiente;
        }
        return i;
    }
    public int obtenet(int i){
        Nodo actual = primero;
        int j =0;
        while(actual!=null){
            if (j == i){
                return actual.valor;
            }
            j++;
            actual = actual.siguiente;
        }
        return -1;
    }
    public int existe(int num){
        Nodo actual = primero;
        int j =0;
        while(actual!=null){
            if (actual.valor == num){
                return j;
            }
            j++;
            actual = actual.siguiente;
        }
        return -1;
    }

    public void eliminar(int i){
        if(primero==null)return;
        if(i==0){
            primero=primero.siguiente;
            return;
        }
        Nodo anterior=primero;
        Nodo actual = primero.siguiente;
        int cont = 0;
        while(actual!=null){
            if(cont ==i){}
            anterior.siguiente=actual.siguiente;
        }
        cont++;
        anterior=actual;
        actual = actual.siguiente;
    }

    public void invertir(){
        if(primero==null) return;
        Nodo anterior=null;
        Nodo actual = primero;
        Nodo siguiente = primero.siguiente;
        while (actual!=null){
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            siguiente = actual.siguiente;
        }
    }
}
