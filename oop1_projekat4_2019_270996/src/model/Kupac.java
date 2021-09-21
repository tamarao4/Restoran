package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import oop1_projekat4_2019_270996.Aplikacija;

public class Kupac extends Korisnik {
	private float raspolozivo;
	private String kucnaAdresa;
	private Korpa korpa;
	private ArrayList<Porudzbina> porudzbina;
	
	public Kupac() {
		
	}
	
	public Kupac(String ime, String prezime, String korIme, String lozinka) {
		super(ime, prezime, korIme, lozinka);
		// TODO Auto-generated constructor stub
	}

	public float getRaspolozivo() {
		return raspolozivo;
	}

	public void setRaspolozivo(float raspolozivo) {
		this.raspolozivo = raspolozivo;
	}

	public String getKucnaAdresa() {
		return kucnaAdresa;
	}

	public void setKucnaAdresa(String kucnaAdresa) {
		this.kucnaAdresa = kucnaAdresa;
	}

	public Korpa getKorpa() {
		return korpa;
	}

	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}

	public ArrayList<Porudzbina> getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(ArrayList<Porudzbina> porudzbina) {
		this.porudzbina = porudzbina;
	}
	
	@Override
	public String toString() {
		return "Kupac [raspolozivo=" + raspolozivo + ", kucnaAdresa=" + kucnaAdresa + ", korpa=" + korpa
				+ ", porudzbina=" + porudzbina + ", ime=" + ime + ", prezime=" + prezime + ", korIme=" + korIme
				+ ", lozinka=" + lozinka + "]";
	}

	@Override
	public String uCSV() {
		return ime + "," + prezime + "," + korIme + "," + lozinka + ",kupac," + raspolozivo + "," + kucnaAdresa + "," 
				+ korpa + "," + porudzbina + "\n";
		
	}

	@Override
	public Korisnik izCSV(String csv) throws ParseException {
		String[] podaci = csv.split(",");
		if (podaci.length >= 7) {
			Administrator stari = new Administrator(ime, prezime, korIme, lozinka);
			ime = podaci[0];
			prezime = podaci[1];
			korIme = podaci[2];
			lozinka = podaci[3];
			raspolozivo = Float.parseFloat(podaci[4]);
			kucnaAdresa = podaci[5];
			return stari;
		} else {
			throw new ParseException(csv, 0);
		}
	}

	public void prikazFunkcionalnosti() {
		System.out.println("\nIzaberite jednu od ponudjenih opcija: ");
        System.out.println("[1] Prikaz menija ");
        System.out.println("[2] Dodavanje stavke u korpu ");
        System.out.println("[3] Uklanjanje stavke iz korpe ");
        System.out.println("[4] Porucivanje ");
        System.out.println("[5] Potvrda porudzbine ");
        System.out.println("[0] Odjava korisnika ");
	}

	public void odabirFunkcionalnosti(int i) throws ParseException, IOException {
		System.out.println("_________________________________________");
        switch (i){
    	case 1:
    		System.out.println("Odabrali ste: [1] Prikaz menija ");
    		break;
    	case 2:
    		System.out.println("Odabrali ste: [2] Dodavanje stavke u korpu ");
    		break;
    	case 3:
    		System.out.println("Odabrali ste: [3] Uklanjanje stavke iz korpe ");
    		break;
    	case 4:
    		System.out.println("Odabrali ste: [4] Porucivanje ");
    		break;
    	case 5:
    		System.out.println("Odabrali ste: [5] Potvrda porudzbine ");
    		break;
    	case 0:
    		System.out.println("Odabrali ste: [0] Odjava korisnika ");
    		Aplikacija.odajva();
    		break;
    	default:
    		System.out.println("Doslo je do greske.");
    		Aplikacija.prijavaKorisnika();
    		break;
        }	
	}
	
}
