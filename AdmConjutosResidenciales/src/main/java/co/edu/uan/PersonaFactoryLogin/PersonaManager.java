
package co.edu.uan.PersonaFactoryLogin;

import co.edu.uan.entidadLogin.Login;
import co.edu.uan.entidadLogin.Persona;

public class PersonaManager {
	private Persona persona;
	private PersonaFactory personaF;

	public void setFactory(PersonaFactory personaF) {
		this.personaF = personaF;
	}

	public void masAtributosAdmin() {

	}

	public void masAtributosProp() {

	}

	public void crearPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login) {
		this.persona = personaF.createPersona(documento, nombre, telefono, nacimiento, correo, login);
	}

	public Persona getPersona() {
		return persona;
	}
}
