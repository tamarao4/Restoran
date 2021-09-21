package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import oop1_projekat4_2019_270996.Aplikacija;

public class Administrator extends Korisnik {
	
	public Administrator() {
		super();
	}

	public Administrator(String ime, String prezime, String korIme, String lozinka) {
		super(ime, prezime, korIme, lozinka);
	}	
	
	@Override
	public String toString() {
		return "Administrator [ime=" + ime + ", prezime=" + prezime + ", korIme=" + korIme + ", lozinka=" + lozinka
				+ "]";
	}

	@Override
	public String uCSV() {
		return ime + "," + prezime + "," + korIme + "," + lozinka + ",administrator" + "\n";
	}

	@Override
	public Korisnik izCSV(String csv) throws ParseException {
		String[] podaci = csv.split(",");
		if (podaci.length == 4) {
			Administrator stari = new Administrator(ime, prezime, korIme, lozinka);
			ime = podaci[0];
			prezime = podaci[1];
			korIme = podaci[2];
			lozinka = podaci[3];
			return stari;
		} else {
			throw new ParseException(csv, 0);
		}
	}

	public void prikazFunkcionalnosti() throws ParseException, IOException {
		System.out.println("\nIzaberite jednu od ponudjenih opcija: ");
        System.out.println("[1] Dodavanje restorana ");
        System.out.println("[2] Kreiranje korisnika ");
        System.out.println("[3] Dodavanje vlasnika resotrana ");
        System.out.println("[0] Odjava korisnika ");
    	int opcija = Aplikacija.odabirOpcije();							
    	odabirFunkcionalnosti(opcija);
	}
	
	public void odabirFunkcionalnosti(int i) throws ParseException, IOException {
		System.out.println("_________________________________________");
        switch (i){
    	case 1:
    		System.out.println("Odabrali ste: [1] Dodavanje restorana ");
    		dodajRestoran();
    		prikazFunkcionalnosti();
    		break;
    	case 2:
    		System.out.println("Odabrali ste: [2] Kreiranje korisnika ");
    		kreirajKupca();
    		prikazFunkcionalnosti();
    		break;
    	case 3:
    		System.out.println("Odabrali ste: [3] Dodavanje vlasnika resotrana ");
    		ucitajVlasnike();
    		prikazFunkcionalnosti();
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
	
	public void dodajRestoran() throws IOException, ParseException {
		Restoran r = new Restoran();
		System.out.println("Unesite naziv restorana ");
		String naziv = Aplikacija.unos();
		System.out.println("Unesite preko kog iznosa je besplatna dostava");
		String raspolozivaSredstva = Aplikacija.unos();
		r.setNaziv(naziv);
		r.setIznBesplDostave(Float.parseFloat(raspolozivaSredstva));
		
		//ucitavanje podataka
		File podaciRestorana = new File("data/restoran.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(podaciRestorana));
		String ucitano2 = new String(bis.readAllBytes());
		bis.close();
		
		//zapisivanje podataka o objektu
		podaciRestorana.createNewFile();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(podaciRestorana));
		bos.write(r.uCSV().getBytes());
		bos.write(ucitano2.getBytes());
		bos.flush();
		bos.hashCode();
		bos.close();
		
		//
		System.out.println("Dodat je restoran.\n_________________________________________");
		
	}
	
	public void kreirajKupca() throws IOException {
		System.out.println("Odaberite tip korisnika koga kreirate: ");
		System.out.println("[1] administrator");
		System.out.println("[2] kupac");
		System.out.println("[3] vlasnik resorana");
		int tipKorisnika = Aplikacija.odabirOpcije();
		System.out.println("Unesite ime korisnika");
		String ime = Aplikacija.unos();
		System.out.println("Unesite prezime korinika");
		String prezime = Aplikacija.unos();
		System.out.println("Unesite korisnicko ime");
		String korIme = Aplikacija.unos();
		System.out.println("Unesite lozinku");
		String lozinka = Aplikacija.unos();
		
		//ucitavanje podataka
		File podaci = new File("data/korisnici.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(podaci));
		String ucitano = new String(bis.readAllBytes());
		bis.close();
	
		//zapisivanje podataka o objektu
		podaci.createNewFile();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(podaci));
		bos.write(ucitano.getBytes());
		
		if (tipKorisnika == 1) {
			Administrator a = new Administrator(ime, prezime, korIme, lozinka);
			bos.write(a.uCSV().getBytes());
		}
		else if (tipKorisnika == 2) {
			System.out.println("Unesite adresu kupca");
			String adresa = Aplikacija.unos();
			Kupac k = new Kupac(ime, prezime, korIme, lozinka);
			k.setKucnaAdresa(adresa);
			k.setRaspolozivo(10000);
			bos.write(k.uCSV().getBytes());
		}
		else if (tipKorisnika == 3) {
			VlasnikRestorana v = new VlasnikRestorana(ime, prezime, korIme, lozinka);
			bos.write(v.uCSV().getBytes());
		}
		else {
			System.out.println("Doslo je do greske.");
		}
		bos.flush();
		bos.hashCode();
		System.out.println("Uspesno kreiran korisnik.\n_________________________________________");
		bos.close();
		
	}

	public void ucitajVlasnike() {
		// 
		System.out.println();
		Aplikacija.prikazVlasnika();
		try {
			Aplikacija.prikazRestorna();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("\nUnesite opciju ispred vlasnika kome zelite da dodate restoran.");
		int vlasnikBr = Aplikacija.odabirOpcije();
		System.out.println("\nUnesite opciju ispred restorana koi zelite da dodate odabranom vlasniku.");
		int restoranBr = Aplikacija.odabirOpcije();	
		ArrayList<VlasnikRestorana> vlasnici = Aplikacija.listaVlasnika();
		ArrayList<Restoran> restorani = null;
		try {
			restorani = Aplikacija.listaRestorana();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (vlasnikBr > vlasnici.size() || restoranBr > restorani.size()) {
			System.out.println("Uneta opcija za vlasnika ili restoran ne postoji");
			return;
		}
		VlasnikRestorana vlasnik = new VlasnikRestorana();
		vlasnik = vlasnici.get(restoranBr - 1);

		Restoran r = new Restoran();
		r = restorani.get(restoranBr - 1);
		// r.setVlasnik(vlasnik);
		ArrayList<Restoran> noviRestorani = new ArrayList<>();
		noviRestorani.add(r);
		
		
		vlasnik.setRestorani(noviRestorani);
		
		System.out.println("\nRestoran je dodat vlasniku.");
		System.out.println(vlasnik.toString());
		
		// ne upisuje iznemne ni u jedan fajl i ne dodaje u restoran vlasnika
	}
	


}
