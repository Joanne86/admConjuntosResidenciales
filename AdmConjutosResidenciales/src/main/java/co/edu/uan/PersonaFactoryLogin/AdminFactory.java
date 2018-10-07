

package co.edu.uan.PersonaFactoryLogin;

import java.util.ArrayList;

import co.edu.uan.entidad.Administrador;
import co.edu.uan.entidad.Apartamento;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;

public class AdminFactory extends PersonaFactory{

    @Override
    public Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login, ArrayList<Apartamento> apartamentos) {
    	
        System.out.println("creando admin");
        return new Administrador(documento, nombre, telefono, nacimiento, correo, login);
       
    }

    
}
