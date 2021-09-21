package model;

import enumeracije.JedinicaMere;

public class StavkaUKorpi {
	private Korpa korpa;
	private Stavka stavka;
	private float kolicina;
	private float cena;
	private JedinicaMere jedinicaMere;
	
	public StavkaUKorpi() {
		
	}

	public StavkaUKorpi(Korpa korpa, Stavka stavka, float kolicina, float cena, JedinicaMere jedinicaMere) {
		super();
		this.korpa = korpa;
		this.stavka = stavka;
		this.kolicina = kolicina;
		this.cena = cena;
		this.jedinicaMere = jedinicaMere;
	}

	public Korpa getKorpa() {
		return korpa;
	}

	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}

	public Stavka getStavka() {
		return stavka;
	}

	public void setStavka(Stavka stavka) {
		this.stavka = stavka;
	}

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	@Override
	public String toString() {
		return "StavkaUKorpi [korpa=" + korpa + ", stavka=" + stavka + ", kolicina=" + kolicina + ", cena=" + cena
				+ ", jedinicaMere=" + jedinicaMere + "]";
	}

}
