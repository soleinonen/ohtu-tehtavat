package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Ihminen implements IPelaaja{
	private static final Scanner scanner = new Scanner(System.in);
	
	@Override
	public void asetaSiirto(String siirto) {
		
	}

	@Override
	public String annaSiirto() {
		String siirto = scanner.nextLine();
		return siirto;
	}
}
