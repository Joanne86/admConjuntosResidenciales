package co.edu.uan.torreBuilder;

import java.util.ArrayList;

public class Parqueadero {
	
	
	private ArrayList<String> numeros;
	private float costo;
	
	
	
	public Parqueadero() {
	}
	public Parqueadero(ArrayList<String> numeros, float costo) {
		super();
		this.numeros = numeros;
		this.costo = costo;
	}
	public ArrayList<String> getNumeros() {
		return numeros;
	}
	public void setNumero(ArrayList<String> numeros) {
		this.numeros = numeros;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Parqueadero [numeros=" + numeros + ", costo=" + costo + "]";
	}
	
}
