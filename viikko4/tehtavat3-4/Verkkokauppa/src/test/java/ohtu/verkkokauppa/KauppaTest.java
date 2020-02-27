package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
	Pankki pankki;
	Viitegeneraattori viite;
	Varasto varasto;
	Kauppa k;
	
	@Before
	public void setUp() {
		// luodaan ensin mock-oliot
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "vesi", 2));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "käsidesi", 10));
        // sitten testattava kauppa 
        k = new Kauppa(varasto, pankki, viite);     
        k.aloitaAsiointi();
	}

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // tehdään ostokset
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {            
        // tehdään ostokset
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
    
    @Test
    public void metodiaTilisiirtoKutsutaanOikeillaArvoillaKahdellaOstoksella() {
    	// tehdään ostokset
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2); 	// ostetaan tuotetta 2 eli vettä
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 7);
    }
    
    @Test
    public void metodiaTilisiirtoKutsutaanOikeillaArvoillaOstettaessaKaksiSamaaTuotetta() {
    	// tehdään ostokset
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);
    }
    
    @Test
    public void metodiaTilisiirtoKutsutaanOikeillaArvoillaOstettaessaTuoteJaTuoteJotaEiVarastossa() {
    	// tehdään ostokset
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(3); 	// ostetaan tuotetta 3 eli käsidesiä koronan varalle
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
    
    @Test
    public void aloitaAsiointiLuoTyhjanAsiointiTapahtuman() {
    	k.lisaaKoriin(1);
    	k.aloitaAsiointi();
    	k.tilimaksu("pekka", "12345");
    	verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 0);
    }
    
    @Test
    public void kauppaPyytaaUudenViitenumeronJokaTapahtumalle() {
    	k.lisaaKoriin(1);
    	k.tilimaksu("pekka", "12345");
    	k.aloitaAsiointi();
    	k.lisaaKoriin(1);
    	k.tilimaksu("pekka", "12345");
    	verify(viite, times(2)).uusi();
    }
    
    @Test
    public void poistaKoristaMetodiPoistaaTuotteenKorista() {
    	k.lisaaKoriin(1);
    	k.poistaKorista(1);
    	verify(varasto).palautaVarastoon(new Tuote(1, "maito", 5));
    	
    }
}

