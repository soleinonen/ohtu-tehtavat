package laskin;

import javafx.event.Event;
import java.util.HashMap;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private Button undo;
    private Map<Button, Komento> komennot;
    private Komento edellinen = null;
    private Sovelluslogiikka sovellus;
    private Muisti muisti;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
    	this.sovellus = new Sovelluslogiikka();
    	this.undo = undo;
    	komennot = new HashMap<>();
    	nollaa.disableProperty().set(true);
    	undo.disableProperty().set(false);
    	komennot.put(plus, new Summa(tuloskentta, syotekentta, nollaa, undo, sovellus));
    	komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, undo, sovellus));
    	komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));
    }
    
    @Override
    public void handle(Event event) {
        if ( event.getTarget() != undo ) {
            Komento komento = komennot.get((Button)event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }  
    }

}
