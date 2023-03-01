package parentessjekker;

public class MainP {

	public static void main(String[] args) {
		Parentessjekker sjekker = new Parentessjekker();
		
		String par = "{[]}()([}){[()]}";
		boolean svar = sjekker.erBalansert(par);
		
		System.out.println(svar);
	}

}
