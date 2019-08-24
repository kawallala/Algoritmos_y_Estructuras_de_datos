package Tarea_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int runs(int[] X){
        int aux = X[0];
        int count = 1;
        for(int i =1; i<X.length; i++){
            if(X[i]<aux){
                count++;
            }
            aux = X[i];
        }
        return count;
    }
    private static ArrayList<int[]> getruns(int[] X){
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList <int[]> total = new ArrayList<>();
        int aux = X[0];
        temp.add(X[0]);
        for(int i =1; i<X.length;i++){
            if(X[i]<aux){
                copiar(temp, total);
                temp.clear();
            }
            temp.add(X[i]);
            aux = X[i];
        }
        copiar(temp, total);
        temp.clear();
        return total;
    }

    private static int huffman(ArrayList<int[]> X,int count){
        MinHeapArray heap = new MinHeapArray();
        for (int i =0; i<X.size();i++){
            heap.insert(X.get(i));
        }
        while (heap.size>1){
            int[] a = heap.getMax();
            int[] b = heap.getMax();
            ArrayList<Object> parcial = merge2(a,b,count);
            int[] c = (int[]) parcial.get(0);
            count = (int) parcial.get(1);
            heap.insert(c);
        }
        return count;
    }

    private static int adaptative(ArrayList<int[]> X,int count){
        while(X.size()!=1 && X.size()!=2) {
            int[] cosa1 = X.get(0);
            int[] cosa2 = X.get(1);
            ArrayList<Object> parcial =  merge2(cosa1,cosa2,count);
            int[] cosa3 = (int []) parcial.get(0);
            count = (int) parcial.get(1);
            X.remove(0);
            X.add(X.size() - 1, cosa3);
        }
        if(X.size()==1) {
            return count;
        }
        int[] cosa1 = X.get(0);
        int[] cosa2 = X.get(1);
        ArrayList<Object> parcial =  merge2(cosa1,cosa2,count);
        count = (int) parcial.get(1);
        return count;
    }
    private static void copiar(ArrayList<Integer> temp, ArrayList<int[]> total) {
        Object[] temp2 = temp.toArray();
        int[] temp3 = new int[temp2.length];
        for(int f =0;f<temp2.length;f++){
            temp3[f] = (Integer) temp2[f];
        }
        total.add(temp3);
    }


    private static int mergesort(int[] c, int[] temp){
        int[] x = new int[c.length];
        for(int i=0;i<c.length;i++){
            x[i] = c[i];
        }

        int width;
        int count = 0;
        for(width=1;width<x.length;width = 2*width){
            int i;
            for(i=0;i<x.length;i=i+2*width){
                int left,middle,right;

                left = i;
                middle = i+width;
                right = i+2*width;
                count = merge(x,left,middle,right,temp,count);
            }
            for(i=0;i<x.length;i++) {
                x[i] = temp[i];
            }
        }
        return count;
    }
    private static int merge(int[] x, int left, int middle, int right,int[] temp,int count) {
        int i,j,k;
        i = left;
        j = middle;
        k = left;

        while(i<middle || j< right) {
            if (i < middle && j < right) {
                count ++;
                if (x[i] <= x[j]) {
                    temp[k++] = x[i++];
                } else {
                    temp[k++] = x[j++];
                }
            } else if (i == middle) {
                temp[k++] = x[j++];
            } else if (j == right) {
                temp[k++] = x[i++];
            }
        }
        return count;
    }


    private static ArrayList<Object> merge2(int[] x, int[] y, int count){
        int[] z = new int[x.length+y.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<x.length || j<y.length){
            if(i<x.length && j<y.length){
                count++;
                if(x[i]<y[j]){
                    z[k++] = x[i++];
                } else{
                    z[k++] = y[j++];
                }
            } else if (i==x.length){
                z[k++] = y[j++];
            } else if (j==y.length){
                z[k++] = x[i++];
            }
        }
        ArrayList<Object> resultado = new ArrayList<>();
        resultado.add(z);
        resultado.add(count);
        return resultado;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String[] b = a.split(" ");
            int[] c = new int[b.length];
            for (int i =0; i<b.length; i++) {
                c[i] = Integer.parseInt(b[i]);
            }
            int count = runs(c);
            System.out.print(count + " ");
            int[] temp = new int[c.length];
            System.out.print(mergesort(c,temp)+ " ");
            ArrayList <int[]> prueba = getruns(c);
            System.out.print(adaptative(prueba,c.length-1)+" ");
            System.out.println(huffman(prueba,c.length-1));
        }
    }
}
