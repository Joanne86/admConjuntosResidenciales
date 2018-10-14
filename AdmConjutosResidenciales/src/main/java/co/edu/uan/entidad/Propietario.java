
package co.edu.uan.entidad;

import java.util.ArrayList;

public class Propietario extends Persona{


	private Apartamento apartamentos;

	public Propietario(int documento, String nombre, String telefono, String nacimiento, String correo, Login login,
			Apartamento apto ) {
		super(documento, nombre, telefono, nacimiento, correo, login);
		this.setApartamentos(apto);
	}
	
	public Propietario() {
		
	}


	private Apartamento getApartamentos() {
		return apartamentos;
	}



	private void setApartamentos(Apartamento apartamentos) {
		this.apartamentos = apartamentos;
	}

}
	