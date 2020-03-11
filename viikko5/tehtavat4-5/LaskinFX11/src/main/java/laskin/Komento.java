package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
	protected TextField tuloskentta;
	protected TextField syotekentta;
	protected Button nollaa;
	protected Button undo;
	protected Sovelluslogiikka sovellus;
	
	public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		this.undo = undo;
		this.nollaa = nollaa;
		this.sovellus = sovellus;
	}
	
	protected void tyhjennaSyotekentta() {
		syotekentta.setText("");
	}
	
	protected void paivitaNollaaTila() {
		if ( Integer.parseInt(tuloskentta.getText())==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
	}
	
	public abstract void suorita();
	
	public abstract void peru();

}
