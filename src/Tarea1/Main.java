package Tarea1;

import java.util.Scanner;
class Main {
    private static String rot13(String string){
        String referencia = "abcdefghijklmnopqrstuvwxyz";
        String niu = "";
        for (int i = 0; i < string.length(); i++){
            int indice = referencia.indexOf(string.charAt(i));
            if (indice < 13) niu = niu.concat(referencia.substring(indice + 13, indice + 14));
            else niu = niu.concat(referencia.substring(indice - 13, indice - 12));
        }
        return niu;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String cambiar = in.nextLine();
            String resultado = rot13(cambiar);
            System.out.println(resultado);
        }
    }
}
