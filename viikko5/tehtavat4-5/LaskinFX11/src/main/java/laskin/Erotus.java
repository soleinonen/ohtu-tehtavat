package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento{
	
	public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(tuloskentta, syotekentta, nollaa, undo, sovellus);
	}
	
	@Override
	public void suorita() {
		sovellus.miinus(Integer.valueOf(syotekentta.getText()));
		edellinen = Integer.valueOf(syotekentta.getText());
		paivitaNakyma();
	}
	
	@Override
	public void peru() {
		sovellus.plus(edellinen);
		paivitaNakyma();
		
	}

}