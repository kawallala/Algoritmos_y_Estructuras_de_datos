import java.util.Scanner;

public class Main1 {
    // Variables para usar en la implementacion de un stack, dentro de la misma clase para el uso de afeed//
    private int[] arreglo;
    private int tope;
    private int MAX_ELEM = 100;
    // Constructor de un stack
    private Main1(){
        arreglo = new int[MAX_ELEM];
        tope = -1;
    }
    // Metodo para apilar elementos en el stack, chequeando que este no este completo
    private void apilar(int x) {
        if (tope + 1 < MAX_ELEM) {
            this.tope++;
            arreglo[tope] = x;
        }
    }
    // Metodo para retornar el ultimo elemento agregado al stack, eliminandolo de este
    private int desapilar() {
        if (estaVacia()) {
            int x = arreglo[tope];
            this.tope--;
            return x;
        }
        return Integer.parseInt(null);//Esta linea retorna error, sin embargo, solo se correrá si se requiere un numero mayor de operandos que los que se han ingresado al stack, por ende es provocar el error a proposito//
    }
    // Metodo para determinar si el stack esta vacio
    private boolean estaVacia() {return tope != -1;}
    //Metodo que retorna el ultimo elemento del stack, sin eleminarlo del mismo
    private int tope() {
        if (estaVacia()){
            return arreglo[tope];
        }
        return Integer.parseInt(null); //Esta linea retorna error, sin embargo, solo se correrá si se requiere un numero mayor de operandos que los que se han ingresado al stack, por ende es provocar el error a proposito//
    }
    //Metodo para reiniciar el tope del stack a su posicion inicial, reiniciando el stack
    private void reiniciar(){
        this.tope = -1;
    }
    //Metodo para calcular el factorial de un numero
    private static int factorial(int x){
        int out = 1;
        for(int i=x; i>0 ; i--){
            out*=i;
        }
        return out;
    }
    //Metodo para calcular las operaciones segun la notacion polaca inversa, reiniciando el stack creado cada vez
    private static void calculo(String[] op, Main1 pila){
        pila.reiniciar();
        for (int i = 0; i<op .length; i++) {
            if (!op[i].equals("+") && !op[i].equals("-") && !op[i].equals("*") && !op[i].equals("/") &&
                    !op[i].equals("_") && !op[i].equals("!") && !op[i].equals("=")){
                pila.apilar(Integer.parseInt(op[i]));
            }
            else {
                if(op[i].equals("+")){
                    int a = pila.desapilar();
                    int b = pila.desapilar();
                    pila.apilar(a+b);
                }
                if(op[i].equals("-")){
                    int a = pila.desapilar();
                    int b = pila.desapilar();
                    pila.apilar(b-a);
                }
                if(op[i].equals("*")){
                    int a = pila.desapilar();
                    int b = pila.desapilar();
                    pila.apilar(a*b);
                }
                if(op[i].equals("/")){
                    int a = pila.desapilar();
                    int b = pila.desapilar();
                    pila.apilar(b/a);
                }
                if(op[i].equals("_")){
                    int a = pila.desapilar();
                    pila.apilar((-1)*a);
                }
                if(op[i].equals("!")){
                    int a = pila.desapilar();
                    pila.apilar(factorial(a));
                }
                if(op[i].equals("=")){
                    if(i<op.length-1) {
                        System.out.print(pila.tope() + " ");
                    }
                    else {
                        System.out.println(pila.tope());
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Main1 pila = new Main1();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");
            calculo(input,pila);
        }
    }
}