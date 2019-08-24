import java.util.Scanner;

public class Fraccion2 {
    public int num;
    public int den;
    public Fraccion2(int num, int den){
        this.num = num;
        this.den = den;
    }
    public static int mcd(int a, int b){
        if (b==0){
            return a;
        }
        else {
            return mcd(b, a%b);
        }
    }
    public Fraccion2 simplificar(){
        int x = mcd(this.num, this.den);
        this.num = this.num/x;
        this.den = this.den/x;
        return null;
    }
    public Fraccion2 suma(Fraccion2 other){
        int nden = this.den*other.den;
        int nnum = this.num*other.den + other.num*this.den;
        this.num =nnum;
        this.den = nden;
        return this.simplificar();
    }
    public String toString(){
        return Integer.toString(this.num) + '/' + Integer.toString(this.den);
    }
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("n?");
        int n = reader.nextInt();
        Fraccion2[] fracs = new Fraccion2[n];
        Fraccion2 resultado = new Fraccion2(0,1);
        for(int i = 1; i<=n; i++){
            System.out.println("Fraccion " + i + "?");
            String s = reader.next();
            String[] parts = s.split("/");
            int num = Integer.parseInt(parts[0]);
            int den = Integer.parseInt(parts[1]);
            fracs[i-1]= new Fraccion2(num,den);
        }
        for (Fraccion2 frac : fracs) {
            resultado.suma(frac);
        }
        System.out.println(resultado.toString());
    }
}
