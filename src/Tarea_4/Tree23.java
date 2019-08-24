package Tarea_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree23 {
    //la clase contiene 2 parametros, la raiz del arbol Root, que corresponde a un nodo y el ArrayLista parentList que
    //permite recopilar los padres de un nodo especifico
    private Tree23Node Root;
    private ArrayList<Tree23Node> parentList = new ArrayList<>();

    //constructor crea un arbol con raiz null, al cual se le aplicaran las funciones
    private Tree23(){
        Root = null;
    }

    //heihgt(): calcula la altura del arbol consultado, a partir de su raiz, ya que una propiedad de los arboles 2-3 es
    //que todos sus hijos tienen la misma altura, se recorren solo los hijos del lado izquierdo
    private void height(){
        if (this.Root == null){
            System.out.print(0 + " ");
            return;
        }
        Tree23Node aux = this.Root;
        int i = 1;
        while(true) {
            if (aux.isLeaf()) {
                System.out.print(i + " ");
                return;
            }
            i++;
            aux = aux.getLeftChild();
        }
    }

    //inorder(Tree23Node): imprime el arbol en la notacion infix, con los parentesis correspondientes, si el nodo con-
    //sultado es una hoja, se llama al metodo para imprimir los valores de la hoja, en caso contrario, se recorren los
    //hijos y valores de forma ascendente, en el caso de que el nodo sea nulo, se imprime un arbol vacio
    private void inorder(Tree23Node root){
        if (root == null){
            System.out.print("([][])");
            return;
        }
        System.out.print("(");
        if(root.isLeaf()){
            root.printLeaf();
            System.out.print(")");
            return;
        }
        inorder(root.getLeftChild());
        System.out.print(root.getSmallitem());
        inorder(root.getMidChild());
        if(root.nodeCount() == 2){
            System.out.print(root.getLargeitem());
            inorder(root.getRightChild());
        }
        System.out.print(") ");
    }

    //getLeafNode(Tree23Node int): retorna el nodo que corresponderia al elemento de valor (o llave) x, agregando los
    //nodos recorridos a la lista de padres
    private Tree23Node getLeafNode(Tree23Node root, int x){
        if(root == null || root.isLeaf()){
            return root;
        }
        parentList.add(root);
        if(x<root.getSmallitem()){
            return getLeafNode(root.getLeftChild(),x);
        }
        if(root.getLargeitem() == Integer.MAX_VALUE || x<root.getLargeitem()) {
            return getLeafNode(root.getMidChild(), x);
        }
        return getLeafNode(root.getRightChild(),x);
    }

    //findItem(tree23Node, int): retorna el nodo donde esta el elemento de valor(o llave) x, recorriendo el arbol desde
    //los valores menores a los mayores, pasando por los hijos
    private Tree23Node findItem(Tree23Node root, int x){
        if(root == null){
            return null;
        }
        if (root.isLeaf()){
            if(x==root.getSmallitem() || (root.nodeCount() == 2 && x == root.getLargeitem())){
                return root;
            }
            return null;
        }
        if(x<root.getSmallitem()){
            return findItem(root.getLeftChild(),x);
        }
        if(x == root.getSmallitem()){
            return root;
        }
        if(root.nodeCount() == 1 || x<root.getLargeitem()){
            return findItem(root.getMidChild(),x);
        }
        if(x == root.getLargeitem()){
            return root;
        }
        return findItem(root.getRightChild(),x);
    }

    //printItem(tree23Node, int): Imprime el elemento correspondiente al valor (o llave) x, siempre que el elemento ya
    //este en el arbol, en caso contrario, imprime "Error"
    private void printItem(Tree23Node root, int x){
        Tree23Node nodo = findItem(root,x);
        if(nodo == null){
            System.out.print("Error ");return;
        }
        if(x == nodo.getSmallitem()){
            System.out.print(nodo.getSmallElement()+ " ");return;
        }
        if(nodo.nodeCount() == 2 && x==root.getLargeitem()){
            System.out.print(nodo.getLargeElement()+ " ");
        }
    }

    //insert(int, String): inserta el elemento xx con el valor (o llave) x, si la llave ya existe en el arbol, se
    //imprime "Error"
    private void insert(int x,String xx){
        if(findItem(Root,x) != null){
            System.out.print("Error ");
            return;
        }
        if(Root == null){
            Root = new Tree23Node(x,xx);
            return;
        }
        parentList.clear();
        Tree23Node leaf = getLeafNode(Root,x);
        leaf.insertItem(x,xx);
        if(leaf.nodeCount() == 3){
            splitNode(leaf);
        }
    }

    //splitNode(Tree23Node): se divide el nodo root, calculando el nodo padre de este
    private void splitNode(Tree23Node root){
        Tree23Node p;
        if(root == this.Root){
            this.Root = p = new Tree23Node();
        }
        else{
            p = parentList.get(parentList.size()-1);
            parentList.remove(parentList.size()-1);
        }
        root.splitNode(p);
        p.insertItem(root.getLargeitem(),root.getLargeElement());
        if(p.nodeCount() == 3){
            splitNode(p);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Tree23 tree = new Tree23();
        while(sc.hasNext()){
            String a = sc.nextLine();
            String[] b = a.split(" ");
            for(int i =0; i<b.length;i++){
                if (b[i].charAt(0) == 'h'){
                    tree.height();
                    System.out.print(" ");
                }
                else if (b[i].charAt(0) == 'p'){
                    tree.inorder(tree.Root);
                }
                else if (b[i].charAt(0) == '+'){
                    int x = Integer.parseInt(b[i].substring(1,b[i].length()-1));
                    String xx = b[i].substring(b[i].length()-1);
                    tree.insert(x,xx);
                }
                else if (b[i].charAt(0) == '?'){
                    int x = Integer.parseInt(b[i].substring(1));
                    tree.printItem(tree.Root,x);
                }
            }
            System.out.println();
        }
    }
}
