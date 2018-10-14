
package co.edu.uan.PersonaFactoryLogin;

import java.util.ArrayList;

import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;
import co.edu.uan.torreBuilder.Apartamento;

public abstract class PersonaFactory {

	public abstract Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login, ArrayList<Apartamento> apartamentos);

	
}
