public class oppg4 {

    public static int fibo(int n) {
        if ( n == 0) {
            return 0;
        }
        if(n== 1) {
            return 1;

        }
        int n1 = fibo(n-1);
        int n2 = fibo(n-2);
        return n1+n2;

    }
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(i + "=" + fibo(i));
        }



    }

}