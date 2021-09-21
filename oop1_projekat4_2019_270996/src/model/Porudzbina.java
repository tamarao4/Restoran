package model;

import java.util.ArrayList;

import enumeracije.TipDostave;

public class Porudzbina implements Prikaz {
	private Kupac kupac;
	private String adresaIsporuke;
	private TipDostave tipDostave;
	private ArrayList<StavkaUKorpi> stavke;
	
	public Porudzbina() {
		
	}
		
	public Porudzbina(Kupac kupac, String adresaIsporuke, TipDostave tipDostave, ArrayList<StavkaUKorpi> stavke) {
		super();
		this.kupac = kupac;
		this.adresaIsporuke = adresaIsporuke;
		this.tipDostave = tipDostave;
		this.stavke = stavke;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public String getAdresaIsporuke() {
		return adresaIsporuke;
	}

	public void setAdresaIsporuke(String adresaIsporuke) {
		this.adresaIsporuke = adresaIsporuke;
	}

	public TipDostave getTipDostave() {
		return tipDostave;
	}

	public void setTipDostave(TipDostave tipDostave) {
		this.tipDostave = tipDostave;
	}

	public ArrayList<StavkaUKorpi> getStavke() {
		return stavke;
	}

	public void setStavke(ArrayList<StavkaUKorpi> stavke) {
		this.stavke = stavke;
	}
	
	@Override
	public String toString() {
		return "Porudzbina [kupac=" + kupac + ", adresaIsporuke=" + adresaIsporuke + ", tipDostave=" + tipDostave
				+ ", stavke=" + stavke + "]";
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
