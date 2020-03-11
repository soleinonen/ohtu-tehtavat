package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento{
	
	public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(tuloskentta, syotekentta, nollaa, undo, sovellus);
	}
	
	@Override
	public void suorita() {
		tuloskentta.setText(String.valueOf(Integer.valueOf(tuloskentta.getText()) - Integer.valueOf(syotekentta.getText())));
		tyhjennaSyotekentta();
		paivitaNollaaTila();
	}
	
	@Override
	public void peru() {
		
	}

}