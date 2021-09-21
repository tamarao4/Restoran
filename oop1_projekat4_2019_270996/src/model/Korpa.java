package model;

import java.util.ArrayList;

public class Korpa implements Prikaz{
	private Kupac kupac;
	private  ArrayList<StavkaUKorpi> stavkeUKorpi;
	
	public Korpa() {
	}
	
	public Korpa(Kupac kupac, ArrayList<StavkaUKorpi> stavkeUKorpi) {
		super();
		this.kupac = kupac;
		this.stavkeUKorpi = stavkeUKorpi;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public ArrayList<StavkaUKorpi> getStavkeUKorpi() {
		return stavkeUKorpi;
	}

	public void setStavkeUKorpi(ArrayList<StavkaUKorpi> stavkeUKorpi) {
		this.stavkeUKorpi = stavkeUKorpi;
	}

	@Override
	public String toString() {
		return "Korpa [kupac=" + kupac + ", stavkeUKorpi=" + stavkeUKorpi + "]";
	}

	@Override
	public String detaljniPrikaz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String jenostavnaPrikaz() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
