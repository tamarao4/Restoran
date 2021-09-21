package model;

import java.text.ParseException;

import csv.PodaciCSV;

public abstract class Korisnik implements PodaciCSV<Korisnik>{
	public String ime;
	public String prezime;
	public String korIme;
	public String lozinka;
	
	
	public Korisnik() {

	}

	public Korisnik(String ime, String prezime, String korIme, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korIme = korIme;
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", korIme=" + korIme + ", lozinka=" + lozinka + "]";
	}

	public abstract String uCSV();

	public abstract Korisnik izCSV(String csv) throws ParseException;
	
	
}
