package Tarea_4;

public class Arbol23 {
    Nodo raiz;
    public Arbol23(){
        raiz = new Nodo();
    }
    public boolean insertar(int numero){
        if ((buscar(numero))) {
            return false;
        }
        raiz.insertar(numero);
        return true;
    }
    public boolean buscar(int numero){
        return raiz.buscar(numero);
    }
    public void imprimir(){
        raiz.imprimirArbol();
    }
    public static void main(String[] args){
        Arbol23 nuevo = new Arbol23();
        nuevo.insertar(5);
        nuevo.insertar(2);
        nuevo.insertar(1);
        nuevo.imprimir();
    }
}
