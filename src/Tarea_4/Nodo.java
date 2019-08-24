package Tarea_4;

public class Nodo {
    int[] valoresNodo;
    Object[] cosas;
    Nodo padre;
    Nodo[] hijos;
    int numvalores;

    public Nodo(){
        setValoresNodo(new int[3]); //eventualmente podemos tener 3 elementos
        setCosas(new Object[3]); //eventualmente tendremos 3 valores guardados
        setPadre(null);
        setHijos(new Nodo[3]);
        setNumvalores(0);
    }
    public void insertar(int numero){
        if (this.getHijos()[0]==null){
            if (getNumvalores()==0){
                this.valoresNodo[0]=numero;
                setNumvalores(getNumvalores()+1);
                this.mantener();
                return;
            }
            for (int i = 0; i<numvalores; i++){
                if(numero<this.valoresNodo[i]){
                    for(int k = getNumvalores(); k>i; k--){
                        this.valoresNodo[k] = this.valoresNodo[k-1];
                    }
                    this.valoresNodo[i]= numero;
                    setNumvalores(getNumvalores()+1);
                    this.mantener();
                    return;
                }
            }
        }
        for (int j=0; j< this.getNumvalores();j++){
            if (numero < this.valoresNodo[j]){
                hijos[j].insertar(numero);
                return;
            }
            hijos[this.getNumvalores()].insertar(numero);
            return;
        }
    }
    public void mantener(){
        if(this.getNumvalores()!=3){
            return;
        }
        if(this.padre == null){
            Nodo auxiliar = new Nodo();
            auxiliar.hijos[0] = this;
            this.padre = auxiliar;
        }
        Nodo auxiliar = new Nodo();
        Nodo auxiliar2 = new Nodo();
        Nodo auxiliar3 = new Nodo();
        auxiliar.insertar(this.valoresNodo[0]);
        auxiliar2.insertar(this.valoresNodo[2]);
        auxiliar3.insertar(this.valoresNodo[1]);
        this.hijos[0]=auxiliar;
        this.hijos[1]=auxiliar2;
        this.valoresNodo=auxiliar3.getValoresNodo();
    }
    public boolean buscar(int numero){
        for (int i =0; i< this.numvalores; i++){
            if (numero == this.valoresNodo[i]){
                return true;
            }
        }
        if (numero<this.valoresNodo[1]){
            if (this.hijos[0]== null){
                return false;
            }
            return this.hijos[0].buscar(numero);
        }
        if (numero<this.valoresNodo[2]){
            if (this.hijos[1]==null){
                return false;
            }
            return this.hijos[1].buscar(numero);
        }
        if(this.hijos[2]==null){
            return false;
        }
        return this.hijos[2].buscar(numero);
    }

    public void imprimirArbol(){
        System.out.print("(");
        for (int i =0; i<getNumvalores() ; i++){
            if (this.hijos[i]==null){
                System.out.print("[ ]");
            }
            System.out.print(getValoresNodo()[i]);
        }
        if (this.hijos[getNumvalores()-1]==null){
            System.out.print("[ ]");
        }
        System.out.print(")");
    }

    public int[] getValoresNodo() {
        return valoresNodo;
    }

    public void setValoresNodo(int[] valoresNodo) {
        this.valoresNodo = valoresNodo;
    }

    public Object[] getCosas() {
        return cosas;
    }

    public void setCosas(Object[] cosas) {
        this.cosas = cosas;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo[] getHijos() {
        return hijos;
    }

    public void setHijos(Nodo[] hijos) {
        this.hijos = hijos;
    }

    public int getNumvalores() {
        return numvalores;
    }

    public void setNumvalores(int numvalores) {
        this.numvalores = numvalores;
    }
}
