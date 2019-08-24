public class HelloSample {
    public static void main(String[] args){
        for (int i=0; i<100000;++i) {
            int n = i;
            int t = 0;
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
                ++t;
            }
            System.out.println("numero de iteraciones de "+ i + " fue " + t);
        }
    }
}