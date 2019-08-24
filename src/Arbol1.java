public class Arbol1 {
    private Arbol1 izq;
    private Arbol1 der;
    private Object valor;

    public int altura(Arbol1 arbol){
        if (arbol.getValor() == null){
            return 1;
        }
        return Math.max(altura(arbol.getDer()),altura(arbol.getIzq()));
    }
    //Los peores AVL posibles
    public boolean esAVL(Arbol1 arbol){
        return Math.abs(altura(arbol.getIzq())-altura(arbol.getDer())) <= 1;
    }

    public Arbol1 getIzq() {
        return izq;
    }

    public void setIzq(Arbol1 izq) {
        this.izq = izq;
    }

    public Arbol1 getDer() {
        return der;
    }

    public void setDer(Arbol1 der) {
        this.der = der;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
