package ohtu.kivipaperisakset;


public class KPSPelaajaVsPelaaja extends AbstractKPS{
	
	public KPSPelaajaVsPelaaja(IPelaaja pelaaja1, IPelaaja pelaaja2) {
		super(pelaaja1, pelaaja2);
	}
	
	@Override
	protected String toisenSiirto() {
		System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = pelaaja2.annaSiirto();
        return tokanSiirto;
	}
}