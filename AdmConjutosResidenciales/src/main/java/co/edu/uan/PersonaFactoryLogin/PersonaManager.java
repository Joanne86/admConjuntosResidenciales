
package co.edu.uan.PersonaFactoryLogin;


import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;


public class PersonaManager {
	private Persona persona;
	private PersonaFactory personaF;

	public void setFactory(PersonaFactory personaF) {
		this.personaF = personaF;
	}

	public void crearPersona(String documento, String nombre, String correo,
			Login login) {
		this.persona = personaF.createPersona(documento, nombre, correo, login);
	}

	public Persona getPersona() {
		return persona;
	}
}
