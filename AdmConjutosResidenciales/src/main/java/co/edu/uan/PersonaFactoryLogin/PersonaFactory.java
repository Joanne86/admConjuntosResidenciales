
package co.edu.uan.PersonaFactoryLogin;



import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;


public abstract class PersonaFactory {

	public abstract Persona createPersona(int documento, String nombre, String correo,
			Login login);

	
}
