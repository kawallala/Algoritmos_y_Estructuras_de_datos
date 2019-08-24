package Tarea_4;

public class Tree23Node {
    //La clase contiene un parametro para cada uno de los valores que se pueden guardar en el nodo, ademas de valores
    //auxiliares que nos ayudan en caso de overflow
    private int smallitem;
    private String smallElement;
    private int largeitem;
    private String largeElement;
    private Tree23Node leftChild;
    private Tree23Node midChild;
    private Tree23Node rightChild;

    private int auxItem;
    private String auxElement;
    private Tree23Node auxChild;

    // Constructor de un nodo con un valor aa y un elemento aa
    public Tree23Node(int a, String aa){
        smallitem = a; smallElement = aa;
        largeitem = auxItem = Integer.MAX_VALUE;
        leftChild = midChild = rightChild = null;
    }

    //Constructor de un nodo con dos elementos, elemento aa con valor a y elemento bb con valor b
    public Tree23Node(int a, int b, String aa, String bb){
        smallitem = a; smallElement = aa;
        largeitem = b; largeElement = bb;
        auxItem = Integer.MAX_VALUE;
        leftChild = midChild = rightChild = null;
    }

    //Constructor de un nodo sin elementos
    public Tree23Node(){
        smallitem = largeitem = auxItem = Integer.MAX_VALUE;
        leftChild = rightChild = midChild = null;
    }

    //isLeaf(): metodo que determina si el nodo consultado corresponde a una hoja
    public boolean isLeaf(){
        return (leftChild == null && midChild == null && rightChild == null);
    }

    //nodeCount(): metodo para calcular el numero de nodos hijos pertenecientes al nodo, segun los valores almacenados
    //en el
    public int nodeCount(){
        if (smallitem == Integer.MAX_VALUE){
            return 0;
        }
        if (largeitem == Integer.MAX_VALUE){
            return 1;
        }
        if(auxItem == Integer.MAX_VALUE){
            return 2;
        }
        return  3;
    }

    //metodo para imprimir los valores del nodo sobre el cual se llama el metodo, asumiendo que este es una hoja
    public void printLeaf(){
        System.out.print("[]" + smallitem + "[]");
        if(largeitem != Integer.MAX_VALUE){
            System.out.print(largeitem + "[]");
        }
    }

    //Getters and setters de la clase
    public String getSmallElement() {
        return smallElement;
    }

    public String getLargeElement() {
        return largeElement;
    }

    public String getAuxElement() {
        return auxElement;
    }

    public int getSmallitem() {
        return smallitem;
    }

    public int getLargeitem() {
        return largeitem;
    }

    public Tree23Node getLeftChild() {
        return leftChild;
    }

    public Tree23Node getMidChild() {
        return midChild;
    }

    public Tree23Node getRightChild() {
        return rightChild;
    }

    public int getAuxItem() {
        return auxItem;
    }

    public Tree23Node getAuxChild() {
        return auxChild;
    }

    public void setLeftChild(Tree23Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setMidChild(Tree23Node midChild) {
        this.midChild = midChild;
    }

    public void setRightChild(Tree23Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setAuxChild(Tree23Node auxChild) {
        this.auxChild = auxChild;
    }

    //insertItem(int String): se inserta el elemento xx con valor (o llave) x en el nodo sobre el cual se llama la
    //funcion, teniendo un comportamiento distinto segun el numero de valores que el nodo ya contiene, manteniendo
    //la relacion de valor de los valores dentro del nodo
    public void insertItem(int x, String xx){
        if(smallitem == Integer.MAX_VALUE){
            smallitem = x;
            smallElement = xx;
        }
        else if(largeitem == Integer.MAX_VALUE){
            if(x>smallitem){
                largeitem = x;
                largeElement = xx;
            }
            else {
                largeitem = smallitem;
                largeElement = smallElement;
                smallitem = x;
                smallElement = xx;
            }
        }
        else{
            int[] lista = new int[3];
            String[] lista2 = new String[3];
            if (smallitem<largeitem){
                if(x<smallitem){
                    lista[0] = x;
                    lista2[0] = xx;
                    lista[1] = smallitem;
                    lista2[1] = smallElement;
                    lista[2] = largeitem;
                    lista2[2] = largeElement;
                }
                else{
                    if(x<largeitem) {
                        lista[0] = smallitem;
                        lista2[0] = smallElement;
                        lista[1] = x;
                        lista2[1] = xx;
                        lista[2] = largeitem;
                        lista2[2] = largeElement;
                    }
                    else{
                        lista[0] = smallitem;
                        lista2[0] = smallElement;
                        lista[1] = largeitem;
                        lista2[1] = largeElement;
                        lista[2] = x;
                        lista2[2] = xx;
                    }
                }
            }
            else{
                if(x<largeitem){
                    lista[0] = x;
                    lista2[0] = xx;
                    lista[1] = largeitem;
                    lista2[1] = largeElement;
                    lista[2] = smallitem;
                    lista2[2] = smallElement;
                }
                else{
                    if (x<smallitem) {
                        lista[0] = largeitem;
                        lista2[0] = largeElement;
                        lista[1] = x;
                        lista2[1] = xx;
                        lista[2] = smallitem;
                        lista2[2] = smallElement;
                    }
                    else{
                        lista[0] = largeitem;
                        lista2[0] = largeElement;
                        lista[1] = smallitem;
                        lista2[0] = smallElement;
                        lista[2] = x;
                        lista2[2] = xx;
                    }
                }
            }
            smallitem = lista[0];
            smallElement = lista2[0];
            largeitem = lista[1];
            largeElement = lista2[1];
            auxItem = lista[2];
            auxElement = lista2[2];
        }
    }

    //splitNode(Tree23Node): se divide el nodo sobre el cual se ejecuta el metodo, el comportamiento varia segun la
    //relacion al nodo padre, que se incorpora en los argumentos del metodo
    public void splitNode(Tree23Node p){
        Tree23Node l = new Tree23Node(smallitem, smallElement);
        Tree23Node r = new Tree23Node(auxItem, auxElement);

        if(!this.isLeaf()){
            l.setLeftChild(this.getLeftChild());
            l.setMidChild(this.getMidChild());
            r.setLeftChild(this.getRightChild());
            r.setMidChild(this.getAuxChild());
        }
        if(this == p.getLeftChild()){
            if(p.nodeCount() == 1){
                p.setRightChild(p.getMidChild());
                p.setMidChild(r);
                p.setLeftChild(l);
            }
            else if(p.nodeCount() == 2){
                p.setAuxChild(p.getRightChild());
                p.setRightChild(p.getMidChild());
                p.setMidChild(r);
                p.setLeftChild(l);
            }
        }
        else if(this == p.getMidChild()){
            if(p.nodeCount() == 1){
                p.setRightChild(r);
                p.setMidChild(l);
            }
            else if(p.nodeCount() == 2){
                p.setAuxChild(p.getRightChild());
                p.setRightChild(r);
                p.setMidChild(l);
            }
        }
        else if(this == p.getRightChild()){
            p.setAuxChild(r);
            p.setRightChild(l);
        }
        else{
            p.setLeftChild(l);
            p.setMidChild(r);
        }
    }
}
