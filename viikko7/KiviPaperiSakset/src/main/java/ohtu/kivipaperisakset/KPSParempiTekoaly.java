package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends AbstractKPS{
	
	public KPSParempiTekoaly(IPelaaja pelaaja1, IPelaaja pelaaja2) {
		super(pelaaja1, pelaaja2);
	}

	@Override
	protected String toisenSiirto() {
        String tokanSiirto = pelaaja2.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        pelaaja2.asetaSiirto(ekanSiirto);
        return tokanSiirto;
	}
}
