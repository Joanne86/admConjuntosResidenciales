
package co.edu.uan.entidad;

import co.edu.uan.torreBuilder.Apartamento;

public class Propietario extends Persona{
	
	private Apartamento apartamento;

	public Propietario(int documento, String nombre, String correo, Login login) {
		super(documento, nombre, correo, login);
		
	}

	public Propietario() {
		
	}

	public Propietario(int documento, String nombre, String correo, Login login, Apartamento apartamento) {
		super(documento, nombre, correo, login);
		this.apartamento = apartamento;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}  
	
	
}
