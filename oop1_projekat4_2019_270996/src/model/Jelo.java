package model;

import enumeracije.JedinicaMere;
import enumeracije.TipJela;

public class Jelo extends Stavka {
	private TipJela tip;

	public Jelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jelo(String naziv, String kolicina, JedinicaMere jedinicaMere) {
		super(naziv, kolicina, jedinicaMere);
		// TODO Auto-generated constructor stub
	}



	public TipJela getTip() {
		return tip;
	}

	public void setTip(TipJela tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "Jelo [naziv=" + naziv + ", kolicina=" + kolicina + ", jedinicaMere=" + jedinicaMere
				+ ", tip=" + tip + "]";
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
