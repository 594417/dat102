public class oppg4a {

	public static void main(String[] args) {
		int resultat = sum(100);
		System.out.println(resultat);

	}
    public static int sum(int n) {
    	if (n > 0) {
    		return (sum (n-1) + n);
    		} else {
    			return 0;
    		}
    }
}