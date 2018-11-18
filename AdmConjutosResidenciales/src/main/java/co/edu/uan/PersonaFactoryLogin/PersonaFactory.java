
package co.edu.uan.PersonaFactoryLogin;



import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;

/**
 * 
 * @author LEIDY RODRIGUEZ
 */
public abstract class PersonaFactory {

	/**
	 * metodo para crear un persona
	 * @param documento
	 * @param nombre
	 * @param correo
	 * @param login
	 * @return
	 */
	public abstract Persona createPersona(String documento, String nombre, String correo,
			Login login);

}
