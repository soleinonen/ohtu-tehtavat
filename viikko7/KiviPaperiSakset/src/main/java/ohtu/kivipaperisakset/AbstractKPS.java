package ohtu.kivipaperisakset;

public abstract class AbstractKPS implements KPS{

	IPelaaja pelaaja1;
	IPelaaja pelaaja2;
	String ekanSiirto;
	String tokanSiirto;
	
	public AbstractKPS(IPelaaja pelaaja1, IPelaaja pelaaja2) {
		this.pelaaja1 = pelaaja1;
		this.pelaaja2 = pelaaja2;
	}
	
	public void pelaa()  {
        Tuomari tuomari = new Tuomari();

        ekanSiirto = ensimmaisenSiirto();
        tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
	}
	
	private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
	
	private String ensimmaisenSiirto() {
		System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = pelaaja1.annaSiirto();
        return ekanSiirto;
	}
	
	protected abstract String toisenSiirto();
	
}
