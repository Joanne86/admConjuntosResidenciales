

package co.edu.uan.PersonaFactoryLogin;

import co.edu.uan.entidad.Administrador;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;
/**
 * 
 * @author LEIDY RODRIGUEZ
 */
public class AdminFactory extends PersonaFactory{
/**
 * Metodo para crear un administrador
 * @param documento
 * @param nombre
 * @param correo
 * @param login
 * @return El tipo de persona que se logeo, es este caso un administrador
 */
    @Override
    public Persona createPersona(String documento, String nombre, String correo,
			Login login) {
    	
        return new Administrador(documento, nombre, correo, login);
       
    }

    
}
