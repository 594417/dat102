public class oppg4d {

    public static int fibo(int n) {

        int n1 = 0;
        int n2 = 1;
        int teller = 0;
        int h;
        while (teller < n) {
            if (teller > 0) {
                h = n1 + n2;
                n1 = n2;
                n2 = h;
            }
            teller ++;
        }
        return n2;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(i + "=" + fibo(i));
        }

    }
}