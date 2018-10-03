
package co.edu.uan.PersonaFactoryLogin;

import co.edu.uan.entidadLogin.Login;
import co.edu.uan.entidadLogin.Persona;

public abstract class PersonaFactory {

	public abstract Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login);
	
}
