package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento{
	
	public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(tuloskentta, syotekentta, nollaa, undo, sovellus);
	}
	
	@Override
	public void suorita() {
		edellinen = Integer.valueOf(tuloskentta.getText());
		sovellus.nollaa();
		paivitaNakyma();
	}
	
	@Override
	public void peru() {
		sovellus.setTulos(edellinen);
		paivitaNakyma();
	}

}