package ohtu.kivipaperisakset;

public class KPSTekoaly extends AbstractKPS{
	
	public KPSTekoaly(IPelaaja pelaaja1, IPelaaja pelaaja2) {
		super(pelaaja1, pelaaja2);
	}
	
	@Override
	protected String toisenSiirto() {
		String tokanSiirto = pelaaja2.annaSiirto();
		System.out.println("Tietokone valitsi: " + tokanSiirto);
		return tokanSiirto;
	}
}