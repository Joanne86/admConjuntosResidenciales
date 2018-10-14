
package co.edu.uan.PersonaFactoryLogin;


import java.util.ArrayList;

import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;
import co.edu.uan.entidad.Propietario;
import co.edu.uan.torreBuilder.Apartamento;

public class PropietarioFactory extends PersonaFactory{

	@Override
    public Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login, ArrayList<Apartamento> apartamentos) {
    	return new Propietario(documento, nombre, telefono, nacimiento, correo, login, apartamentos);
    }

    
}
