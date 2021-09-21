package model;


import enumeracije.JedinicaMere;
import enumeracije.TipPica;

public class Pice extends Stavka{
	private TipPica tipoviPica;

	public Pice() {
		super();
	}
	
	public Pice(String naziv, String kolicina, JedinicaMere jedinicaMere) {
		super(naziv, kolicina, jedinicaMere);
		// TODO Auto-generated constructor stub
	}



	public Pice(TipPica tipoviPica) {
		super();
		this.tipoviPica = tipoviPica;
	}

	public TipPica getTipoviPica() {
		return tipoviPica;
	}

	public void setTipoviPica(TipPica tipoviPica) {
		this.tipoviPica = tipoviPica;
	}

	@Override
	public String toString() {
		return "Pice [tipoviPica=" + tipoviPica + ", naziv=" + naziv + ", kolicina=" + kolicina + ", jedinicaMere="
				+ jedinicaMere + "]";
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
