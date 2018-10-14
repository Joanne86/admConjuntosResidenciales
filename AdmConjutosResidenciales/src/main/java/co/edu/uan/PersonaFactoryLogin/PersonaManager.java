
package co.edu.uan.PersonaFactoryLogin;

import java.util.ArrayList;

import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;
import co.edu.uan.torreBuilder.Apartamento;

public class PersonaManager {
	private Persona persona;
	private PersonaFactory personaF;

	public void setFactory(PersonaFactory personaF) {
		this.personaF = personaF;
	}

	public void crearPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login, ArrayList<Apartamento> apartamentos) {
		this.persona = personaF.createPersona(documento, nombre, telefono, nacimiento, correo, login, apartamentos);
	}

	public Persona getPersona() {
		return persona;
	}
}
