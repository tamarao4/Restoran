package oop1_projekat4_2019_270996;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Administrator;
import model.Korisnik;
import model.Kupac;
import model.Restoran;
import model.VlasnikRestorana;
 
 
public class Aplikacija {
 
    static ArrayList<Korisnik> korisnici = new ArrayList<>();
    static ArrayList<VlasnikRestorana> vlasnici = new ArrayList<>();
    static ArrayList<Restoran> restorani = new ArrayList<>();
    static Kupac kupac;
    static VlasnikRestorana vlasnik;
    static Administrator adiministrator;
    static String tipPrijavljenogKor = null;
    
    public static void main(String[] args) throws IOException, ParseException {
    	System.out.println("=======================================================");
    	System.out.println("========== Narucivanje iz restorana za dostavu ========\n\n");
    	prijavaKorisnika();
    	
    }
 
    public static void prijavaKorisnika() throws ParseException, IOException {
        ucitavaneKorisnika();
        boolean unos = true;
        Korisnik prijavljen = null;
        Scanner sc = new Scanner(System.in);
        while(unos) {
            System.out.println("\n==== Prijava korisnika: \n");
            System.out.println("Unesite korisnicko ime >>");
            String korIme = sc.nextLine();
            System.out.println("Unesite lozinku >>");
            String lozinka = sc.nextLine();
            for(int i = 0; i < korisnici.size(); i++) {            
                if((korIme.contentEquals(korisnici.get(i).korIme)) && (lozinka.contentEquals(korisnici.get(i).lozinka))) {
                    unos = false;
                    prijavljen = korisnici.get(i);
                    //System.out.println(true);
                }
            }
            if(unos) {
            	System.out.println("____________________________________________________________");
                System.out.println("Korisnicko ime i lozinka se nepodudaraju pokusajte ponovo!\n");
            }
        }
//      /\
//        sc.close();					- ako zatvorim sc dolazi do greske prilikom sledeceg poziva
//      samo radi provere sta ispisuje iz prijavljen treba je izbrisati jer je nepotrebna
//		System.out.println(prijavljen);
        funkcionalnosti(prijavljen);        

         
    }
    
    // funkcija koja na osnovu tipa prijavljnog korisnika nudi meni za dalji rad
    public static void funkcionalnosti(Object prijavljen) throws ParseException, IOException {
        if (prijavljen instanceof Administrator) {
        	System.out.println("Prijavljeni ste kao administrator.");
        	adiministrator.prikazFunkcionalnosti();        	
        }
        if (prijavljen instanceof Kupac) {
        	System.out.println("Prijavljeni ste kao kupac.");
        	kupac.prikazFunkcionalnosti();
        	//int opicja = unosOpcije();
        }
        if (prijavljen instanceof VlasnikRestorana) {
        	System.out.println("Prijavljeni ste kao vlasnik restorana.");
        	vlasnik.prikazFunkcionalnosti();
        	//int opcija = unosOpcije();
        }
    	
    }
    
    public static void ucitavaneKorisnika() throws ParseException {
        String csvFile = "data/korisnici.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
       
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] korisnik = line.split(cvsSplitBy);
                if (korisnik[4].contentEquals("administrator")) {
                	adiministrator = new Administrator(korisnik[0], korisnik[1], korisnik[2], korisnik[3]);
                    korisnici.add(adiministrator);
                }
                else if (korisnik[4].contentEquals("kupac")){
                	kupac = new Kupac(korisnik[0], korisnik[1], korisnik[2], korisnik[3]);
                	korisnici.add(kupac);
                }
                else if (korisnik[4].contentEquals("vlasnik")) {
                	vlasnik = new VlasnikRestorana(korisnik[0], korisnik[1], korisnik[2], korisnik[3]);
                	korisnici.add(vlasnik);
                	vlasnici.add(vlasnik);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }      
   }
    
    public static int odabirOpcije(){
    	System.out.println(">>");
    	try {
	    	Scanner sc = new Scanner(System.in);
	    	int opcija = sc.nextInt();
	    	return opcija;
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
		return -1;
    }
    
    public static void odajva() throws ParseException, IOException{
    	System.out.println("Odjava. \nIzaberite neku od sledecih ocpija: \n");
    	System.out.println("[1] Ponovna prijava");
    	System.out.println("[2] Izlazak iz programa");
    	
    	int opcija = odabirOpcije();
    	if (opcija == 1) {
    		prijavaKorisnika();
    	}
    	else if (opcija == 2) {
    		System.out.println("Dovidjenja!");
    		System.exit(0);
    	}
    	else {
    		System.out.println("Doslo je do greske");
    		System.exit(0);
    	}
    }
    
    public static String unos(){
    	System.out.print(">>");
    	try {
	    	Scanner sc = new Scanner(System.in);
	    	String unos = sc.nextLine();
	    	return unos;
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
		return "";
    }
    
    public static ArrayList<VlasnikRestorana> listaVlasnika(){
    	return vlasnici;
    }
    
    public static void prikazVlasnika() {
    	for (int i = 0; i < vlasnici.size(); i++) {
			System.out.println(" [" + (i+1) + "] " + vlasnici.get(i).toString());
		}
    }
    
    public static void ucitajRestorane() {
    	// ucitaj restorane
		String csvFile = "data/restoran.txt";
		BufferedReader br = null;
        String line = "";
       
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String restoran = line;
                Restoran r = new Restoran();
                r.izCSV(restoran);
                restorani.add(r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        

 }
    
	public static void prikazRestorna() throws ParseException {
    	ucitajRestorane();
        System.out.println();
		for (int i = 0; i < restorani.size(); i++) {
			System.out.println(" [" + (i+1) + "] " + restorani.get(i).toString());
		}
	}

	public static ArrayList<Restoran> listaRestorana() throws ParseException {
		return restorani;
	}
    
}
