
package co.edu.uan.PersonaFactoryLogin;

import co.edu.uan.entidadLogin.Login;
import co.edu.uan.entidadLogin.Persona;
import co.edu.uan.entidadLogin.Propietario;

public class PropietarioFactory extends PersonaFactory{

    @Override
    public Persona createPersona(int documento, String nombre, String telefono, String nacimiento, String correo, Login login) {
        System.out.println("creando propietario");
        return new Propietario(documento, nombre, telefono, nacimiento, correo, login);
        //con los parametro que le pasa, crrea el propietario
    }
    
}
