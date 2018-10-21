
package co.edu.uan.entidad;

import co.edu.uan.torreBuilder.Apartamento;

public class Propietario extends Persona {

	private int nTorre;
	private Apartamento apartamento;

	public Propietario(String documento, String nombre, String correo, Login login) {
		super(documento, nombre, correo, login);
	}

	public Propietario(String documento, String nombre, String telefono, String nacimiento, String correo, Login login,
			int nTorre, Apartamento apartamento) {
		super(documento, nombre, telefono, nacimiento, correo, login);
		this.nTorre = nTorre;
		this.apartamento = apartamento;
	}

	public Propietario() {
	}

	public int getnTorre() {
		return nTorre;
	}

	public void setnTorre(int nTorre) {
		this.nTorre = nTorre;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	

}
