package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import enumeracije.JedinicaMere;
import enumeracije.TipDostave;
import enumeracije.TipJela;
import enumeracije.TipPica;
import oop1_projekat4_2019_270996.Aplikacija;

public class VlasnikRestorana extends Korisnik {
	private ArrayList<Restoran> restorani;
	
	public VlasnikRestorana() {
		
	}
	
	public VlasnikRestorana(String ime, String prezime, String korIme, String lozinka) {
		super(ime, prezime, korIme, lozinka);
		// TODO Auto-generated constructor stub
	}

	public VlasnikRestorana(ArrayList<Restoran> restorani) {
		super();
		this.restorani = restorani;
	}
	
	public ArrayList<Restoran> getRestorani() {
		return restorani;
	}

	public void setRestorani(ArrayList<Restoran> restorani) {
		this.restorani = restorani;
	}

	@Override
	public String toString() {
		return "" + ime + " " + prezime + " | " + korIme + "|" + restorani;
	}

	@Override
	public String uCSV() {
		return ime + "," + prezime + "," + korIme + "," + lozinka + ",vlasnik," + restorani + "\n";
		
	}

	@Override
	public Korisnik izCSV(String csv) throws ParseException {
		String[] podaci = csv.split(",");
		if (podaci.length == 6) {
			Administrator stari = new Administrator(ime, prezime, korIme, lozinka);
			ime = podaci[0];
			prezime = podaci[1];
			korIme = podaci[2];
			lozinka = podaci[3];
			return stari;
		} else {
			return null;
		}
	}
	
	public void prikazFunkcionalnosti() throws ParseException, IOException {
		System.out.println("\nIzaberite jednu od ponudjenih opcija: ");
        System.out.println("[1] Kreiranje menija ");
        System.out.println("[2] Dodavanje stavki u meni ");
        System.out.println("[3] Brisanje stavki iz menija ");
        System.out.println("[4] Prikaz menija ");
        System.out.println("[5] Izmena cene stavke iz restorana ");
        System.out.println("[0] Odjava korisnika ");
    	int opcija = Aplikacija.odabirOpcije();							
    	odabirFunkcionalnosti(opcija);
	}

	public void odabirFunkcionalnosti(int i) throws ParseException, IOException {
		System.out.println("_________________________________________");
        switch (i){
    	case 1:
    		System.out.println("Odabrali ste: [1] Kreiranje menija ");
    		kreiranjeMenija();
    		prikazFunkcionalnosti();
    		break;
    	case 2:
    		System.out.println("Odabrali ste: [2] Dodavanje stavki u meni ");
    		prikazFunkcionalnosti();
    		break;
    	case 3:
    		System.out.println("Odabrali ste: [3] Brisanje stavki iz menija ");
    		prikazFunkcionalnosti();
    		break;
    	case 4:
    		System.out.println("Odabrali ste: [4] Prikaz menija ");
    		prikazFunkcionalnosti();
    		break;
    	case 5:
    		System.out.println("Odabrali ste: [5] Izmena cene stavke iz restorana ");
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

	private void kreiranjeMenija() {
		System.out.println("Odaberite opciju sta unosite: \n [1] JELO \n [2] PICE");
		int u = Aplikacija.odabirOpcije();
		if (u > 2) {
			System.out.println("Neposojeca opcija.");
			return;
		}
		
		System.out.println("Unesite naziv");
		String naziv = Aplikacija.unos();
		System.out.println("Unesite kolicinu");
		String kolicina = Aplikacija.unos();
		System.out.println("Unesite jedinicu mere, odaberite opciju: ");
		System.out.println(" [1] KOMAD \n [2] LITAR \n [3] MILILITAR \n [4] KILOGRAM \n [5] GRAM");
		int jm = Aplikacija.odabirOpcije();
		if (jm > 5) {
			System.out.println("Neposojeca opcija za kolicinu.");
			return;
		}
		JedinicaMere jedMere = JedinicaMere.intToJedinicaMere(jm);
		if (u == 1) {
			// kreira objekat jela
			System.out.println("Unesite opciju tipa jela: ");
			System.out.println(" [1] GLAVNO \n [2] PREDJELO \n [3] SALATA \n [4] DEZERT");
			int tj = Aplikacija.odabirOpcije();
			if (tj > 4) {
				System.out.println("Neposojeca opcija za tip jela.");
				return;
			}
			TipJela tipJela = TipJela.intToTipJela(tj);
			Jelo jelo = new Jelo(naziv,kolicina, jedMere);
			jelo.setTip(tipJela);
			System.out.println("Uspesno dodato jelo.");
			Meni m = new Meni();
			ArrayList<Stavka> s = new ArrayList<>();
			s.add(jelo);
			m.setStavke(s);
			System.out.println(m.toString());
			return;
		}
		if (u == 2) {
			// kreira objekat picaa
			System.out.println("Unesite opciju tipa pica: ");
			System.out.println(" [1] GAZIRANO \n [2] NEGAZIRANO \n [3] ALKOHOLNO \n [4] HLADJENO \n [5] NEHLADJENO");
			int tj = Aplikacija.odabirOpcije();
			if (tj > 5) {
				System.out.println("Neposojeca opcija za tip pica.");
				return;
			}
			TipPica tipPica = TipPica.intToTipPica(tj);
			Pice pice = new Pice(naziv,kolicina, jedMere);
			pice.setTipoviPica(tipPica);
			System.out.println("Uspesno dodato pice.");
			ArrayList<Stavka> s = new ArrayList<>();
			s.add(pice);
			Meni m = new Meni();
			m.setStavke(s);
			System.out.println(m.toString());
			return;
		}
		
	}

	
}
