package co.edu.uan.torreBuilder;

import java.util.ArrayList;

public class Torre {
	private int numero;
	private Zona zona;
	private ArrayList<Apartamento> apartamentos;
	
	
	public Torre(int numero, Zona zona, ArrayList<Apartamento> apartamentos) {
		super();
		this.numero = numero;
		this.zona = zona;
		this.apartamentos = apartamentos;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Zona getZona() {
		return zona;
	}


	public void setZona(Zona zona) {
		this.zona = zona;
	}


	public ArrayList<Apartamento> getApartamentos() {
		return apartamentos;
	}


	public void setApartamentos(ArrayList<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}


	@Override
	public String toString() {
		return "Torre [numero=" + numero + ", zona=" + zona + ", apartamentos=" + apartamentos.toString() + "]";
	}
	
	
}
