
package co.edu.uan.entidad;

import co.edu.uan.torreBuilder.Apartamento;

public class Propietario extends Persona{

	private int nTorre;
	private Apartamento apartamento;

	public Propietario(int documento, String nombre, String correo, Login login) {
		super(documento, nombre, correo, login);
	}

	public Propietario(int documento, String nombre, String correo, Login login, int nTorre, Apartamento apart) {
		super(documento, nombre, correo, login);
		this.nTorre = nTorre;
		this.apartamento = apart;
	}

	public Propietario() {	
	}

}
	