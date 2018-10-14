

package co.edu.uan.PersonaFactoryLogin;

import co.edu.uan.entidad.Administrador;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;

public class AdminFactory extends PersonaFactory{

    @Override
    public Persona createPersona(int documento, String nombre, String correo,
			Login login) {
    	
        System.out.println("creando admin");
        return new Administrador(documento, nombre, correo, login);
       
    }

    
}
