package model;

import java.util.ArrayList;

public class Meni implements Prikaz{
	private ArrayList<Stavka> stavke;

	public Meni() {
		
	}
	
	public Meni(ArrayList<Stavka> stavke) {
		super();
		this.stavke = stavke;
	}
	
	public ArrayList<Stavka> getStavke() {
		return stavke;
	}

	public void setStavke(ArrayList<Stavka> stavke) {
		this.stavke = stavke;
	}

	@Override
	public String toString() {
		return "Meni [stavke=" + stavke + "]";
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
