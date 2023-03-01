public class oppg4b {

    public static void main(String[] args) {

        int resultat = sum(10);
        System.out.println(resultat);

    }
    public static int sum(int n) {
        if (n > 1) {
            return (5 * sum (n-1) - 6 * sum (n-2) + 2);
        } else {
            return 0;
        }

    }

}