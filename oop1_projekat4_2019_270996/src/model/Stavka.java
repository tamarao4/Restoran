package model;

import enumeracije.JedinicaMere;

public abstract class Stavka implements Prikaz {
	public String naziv;
	public String kolicina;
	public JedinicaMere jedinicaMere;
	
	public Stavka() {
		
	}
	
	public Stavka(String naziv, String kolicina, JedinicaMere jedinicaMere) {
		super();
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.jedinicaMere = jedinicaMere;
	}

	@Override
	public String toString() {
		return "Stavka [naziv=" + naziv + ", kolicina=" + kolicina + ", jedinicaMere=" + jedinicaMere + "]";
	}
	
	
	
	
}
