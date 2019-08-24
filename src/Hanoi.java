public class Hanoi{
    static void TorresdeHanoi( int n, int a, int b, int c ){
        if (n>0){
            TorresdeHanoi( n-1, a, c, b );
            System.out.println( a + " --> " + c );
            TorresdeHanoi( n-1, b, a, c );
        }
    }
    public static void main(String[] args){
        TorresdeHanoi(10, 1, 2, 3);
    }
}