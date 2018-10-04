
package co.edu.uan.entidadLogin;

import java.util.ArrayList;

public class Propietario extends Persona{


	private ArrayList<Apartamento> apartamentos;

	

	public Propietario(int documento, String nombre, String telefono, String nacimiento, String correo, Login login,
			ArrayList<Apartamento> apartamentos) {
		super(documento, nombre, telefono, nacimiento, correo, login);
		this.apartamentos = apartamentos;
	}



	public ArrayList<Apartamento> getInmuebles() {
		return apartamentos;
	}



	public void setInmuebles(ArrayList<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}



	@Override
	public Persona getInstrance(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
  
}
