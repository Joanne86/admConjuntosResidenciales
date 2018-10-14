package co.edu.uan.torreBuilder;

import java.util.ArrayList;

public class Parqueadero {
	
	
	private ArrayList<Integer> numeros;
	private float costo;
	
	
	
	public Parqueadero() {
	}
	public Parqueadero(ArrayList<Integer> numeros, float costo) {
		super();
		this.numeros = numeros;
		this.costo = costo;
	}
	public ArrayList<Integer> getNumeros() {
		return numeros;
	}
	public void setNumero(ArrayList<Integer> numeros) {
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
