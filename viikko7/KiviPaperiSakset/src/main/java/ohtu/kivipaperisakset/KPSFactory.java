package ohtu.kivipaperisakset;

public class KPSFactory {
	public static KPS luoKPSPelaajaVsPelaaja() {
		return new KPSPelaajaVsPelaaja(new Ihminen(), new Ihminen());
	}
	
	public static KPS luoKPSTekoaly() {
		return new KPSTekoaly(new Ihminen(), new Tekoaly());
	}
	
	public static KPS luoKPSParempiTekoaly() {
		return new KPSParempiTekoaly(new Ihminen(), new TekoalyParannettu(20));
	}

}
