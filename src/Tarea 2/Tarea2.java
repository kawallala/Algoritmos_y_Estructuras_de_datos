import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Tarea2 {
    private static int min(int a,int b, int c) { return Math.min(a,Math.min(b,c));}

    private static char[] diferenciar(String[] A, String[] B){
        int [][] distancia = new int[B.length+1][A.length+1];
        String [][] operaciones = new String[B.length+1][A.length+1];
        for(int i = 0; i<=B.length;i++){
            for(int j=0; j<=A.length;j++){
                operaciones[i][j]="";
            }
        }
        for(int i=1;i<=B.length;i++){
            distancia[i][0]=i;
            operaciones[i][0]=operaciones[i-1][0].concat("i");
        }
        for(int j=1;j<=A.length;j++){
            distancia[0][j]=j;
            operaciones[0][j]=operaciones[0][j-1].concat("d");
        }
        for(int i=1;i<=B.length;i++){
            for(int j=1;j<=A.length;j++){
                distancia[i][j] = min(distancia[i-1][j]+1,
                        distancia[i][j-1]+1,
                        distancia[i-1][j-1] + ((Objects.equals(B[i - 1], A[j - 1]))?0:1));
                if (B[i - 1].equals(A[j - 1])){
                    if(distancia[i-1][j]+1<=distancia[i-1][j-1]){
                        if(distancia[i-1][j]+1<=distancia[i][j-1]+1){
                            operaciones[i][j]=operaciones[i-1][j].concat("i");
                        }
                        else{
                            if(distancia[i][j-1]+1<=distancia[i-1][j-1]){
                                operaciones[i][j]=operaciones[i][j-1].concat("d");
                            }
                            else{
                                operaciones[i][j]=operaciones[i-1][j-1].concat("n");
                            }
                        }
                    }
                    else{
                        if(distancia[i][j-1]+1<=distancia[i-1][j-1]){
                            operaciones[i][j]=operaciones[i][j-1].concat("d");
                        }
                        else {
                            operaciones[i][j]=operaciones[i-1][j-1].concat("n");
                        }
                    }
                }
                else{
                    if(distancia[i-1][j]+1<=distancia[i-1][j-1]+1){
                        if(distancia[i-1][j]+1<=distancia[i][j-1]+1){
                            operaciones[i][j]=operaciones[i-1][j].concat("i");
                        }
                        else{
                            if(distancia[i][j-1]+1<=distancia[i-1][j-1]+1){
                                operaciones[i][j]=operaciones[i][j-1].concat("d");
                            }
                            else{
                                operaciones[i][j]=operaciones[i-1][j-1].concat("c");
                            }
                        }
                    }
                    else{
                        if(distancia[i][j-1]+1<=distancia[i-1][j-1]+1){
                            operaciones[i][j]=operaciones[i][j-1].concat("d");
                        }
                        else {
                            operaciones[i][j]=operaciones[i-1][j-1].concat("c");
                        }
                    }
                }
            }
        }
        return operaciones[B.length][A.length].toCharArray();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String La;
        String Lb;
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        La = sc.nextLine();
        Lb = sc.nextLine();
        File A = new File("C:\\Users\\Kawallala\\Google Drive\\Universidad\\4to Semestre\\Algoritmos\\"+La+".txt");
        File B = new File("C:\\Users\\Kawallala\\Google Drive\\Universidad\\4to Semestre\\Algoritmos\\"+Lb+".txt");
        sc.close();

        try (Scanner sA = new Scanner(A)) {
            try (Scanner sB = new Scanner(B)) {
                while (sA.hasNextLine()) {
                    s1.add(sA.nextLine());
                }
                while (sB.hasNextLine()) {
                    s2.add(sB.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] alfa = new String[s1.size()];
        String[] beta = new String[s2.size()];

        for(int i =0 ; i<s1.size();i++){
            alfa[i]=s1.get(i);
        }
        for(int j =0; j<s2.size();j++){
            beta[j]=s2.get(j);
        }
        char[] cambios = diferenciar(alfa,beta);
        for(int i = 0;i<cambios.length; i++){
            if (cambios[i]=='c') {
                System.out.println((i + 1) + ",c, " + beta[i]);
            }
            else if(cambios[i]=='i'){
                System.out.println((i+1) + ",i, " + beta[i]);
            }
            else if(cambios[i]=='d'){
                System.out.println((i+1) +",d ");
            }
        }
    }
}
