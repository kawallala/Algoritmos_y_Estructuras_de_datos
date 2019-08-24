package Tarea_5;

import java.util.ArrayList;

public class MinHeapArray {
    ArrayList<int[]> heap;
    int size;

    public MinHeapArray(){
        heap = new ArrayList<int[]>();
        int size = 0;
    }

    private int izq(int i){
        return 2*i+1;
    }
    private int der(int i){
        return 2*i+2;
    }
    private int padre(int i){
        return (i-1)/2;
    }

    private void swap(int i, int j){
        int[] aux = heap.get(i);
        int[] aux1 = heap.get(j);
        heap.remove(i);
        heap.remove(j);
        heap.add(j,aux);
        heap.add(i,aux1);
    }

    private void BubbleDown(int i){
        if (size == 1){
            return;
        }
        if(izq(i)>size){
            return;
        }
        int max = izq(i);
        if(der(i)<size){
            if(heap.get(max).length > heap.get(der(i)).length){
                max = der(i);
            }
        }
        if(heap.get(i).length>heap.get(max).length){
            return;
        }
        swap(i,max);
        BubbleDown(max);
    }

    private void BubbleUp(int i){
        while(i>0){
            if(heap.get(i).length >= heap.get(padre(i)).length){
                return;
            }
            swap(i,padre(i));
            i = padre(i);
        }
    }
    public int[] getMax(){
        if(size==0){
            return null;
        }
        int[] m = heap.get(0);
        heap.remove(0);
        size--;
        BubbleDown(0);
        return m;
    }
    public void insert(int[] X){
        size++;
        heap.add(X);
        BubbleUp(size-1);
    }
}
