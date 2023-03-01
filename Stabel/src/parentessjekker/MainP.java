package parentessjekker;

public class MainP {

	public static void main(String[] args) {
		Parentessjekk sjekker = new Parentessjekk();
		
		String par = "{[]}()([}){[()]}";
		boolean svar = sjekker.erBalansert(par);
		
		System.out.println(svar);
	}

}
