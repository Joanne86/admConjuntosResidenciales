
package co.edu.uan.PersonaFactoryLogin;


import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;
import co.edu.uan.entidad.Propietario;


public class PropietarioFactory extends PersonaFactory{

	@Override
    public Persona createPersona(int documento, String nombre, String correo,
			Login login) {
    	return new Propietario(documento, nombre, correo, login);
    }

    
}
