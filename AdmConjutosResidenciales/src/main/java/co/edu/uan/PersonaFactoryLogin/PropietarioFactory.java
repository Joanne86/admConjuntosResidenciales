
package co.edu.uan.PersonaFactoryLogin;


import java.util.ArrayList;

import co.edu.uan.entidadLogin.Apartamento;
import co.edu.uan.entidadLogin.Login;
import co.edu.uan.entidadLogin.Persona;
import co.edu.uan.entidadLogin.Propietario;

public class PropietarioFactory extends PersonaFactory{

	@Override
    public Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login, ArrayList<Apartamento> apartamentos) {
    	return new Propietario(documento, nombre, telefono, nacimiento, correo, login, apartamentos);
    }

    
}
