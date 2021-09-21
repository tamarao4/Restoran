package model;

import java.text.ParseException;

import csv.PodaciCSV;

public class Restoran implements PodaciCSV<Restoran>{
	private String naziv;
	private float iznBesplDostave;
	private Meni meni;
	private VlasnikRestorana vlasnik;
	
	public Restoran() {
		
	}
	
	public Restoran(String naziv, float iznBesplDostave, Meni meni, VlasnikRestorana vlasnik) {
		super();
		this.naziv = naziv;
		this.iznBesplDostave = iznBesplDostave;
		this.meni = meni;
		this.vlasnik = vlasnik;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public float getIznBesplDostave() {
		return iznBesplDostave;
	}

	public void setIznBesplDostave(float iznBesplDostave) {
		this.iznBesplDostave = iznBesplDostave;
	}

	public Meni getMeni() {
		return meni;
	}

	public void setMeni(Meni meni) {
		this.meni = meni;
	}

	public VlasnikRestorana getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(VlasnikRestorana vlasnik) {
		this.vlasnik = vlasnik;
	}

	@Override
	public String toString() {
		return "" + naziv + " | besplatna dostava iznad: " + iznBesplDostave + " meni: " + meni + ", vlasnik:"
				+ vlasnik;
	}

	@Override
	public String uCSV() {
		return Restoran.class.getName() + "," + naziv + "," + iznBesplDostave + "," + meni + "," + vlasnik + "\n";
	}

	@Override
	public Restoran izCSV(String csv) throws ParseException {
		String[] podaci = csv.split(",");
		if (podaci.length == 5 && podaci[0].equals(Restoran.class.getName())) {
			Restoran stari = new Restoran(naziv, iznBesplDostave, meni, vlasnik);
			naziv = podaci[1];
			iznBesplDostave = Float.parseFloat(podaci[2]);
			return stari;
		}
		else {
			throw new ParseException(csv, 0);
		}
		
	}
	
	
	
	
}
