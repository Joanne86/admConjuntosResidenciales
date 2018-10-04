

package co.edu.uan.PersonaFactoryLogin;

import java.util.ArrayList;

import co.edu.uan.entidadLogin.Administrador;
import co.edu.uan.entidadLogin.Apartamento;
import co.edu.uan.entidadLogin.Login;
import co.edu.uan.entidadLogin.Persona;

public class AdminFactory extends PersonaFactory{

    @Override
    public Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login, ArrayList<Apartamento> apartamentos) {
    	
        System.out.println("creando admin");
        return new Administrador(documento, nombre, telefono, nacimiento, correo, login);
       
    }

    
}
