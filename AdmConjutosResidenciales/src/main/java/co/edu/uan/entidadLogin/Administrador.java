
package co.edu.uan.entidadLogin;

public class Administrador extends Persona{


	public Administrador(int documento, String nombre, String telefono, String nacimiento, String correo, Login login) {
		super(documento, nombre, telefono, nacimiento, correo, login);
	}

	@Override
	public Persona getInstrance(int documento, String nombre, String telefono, String nacimiento, String correo,
			Login login) {
		// TODO Auto-generated method stub
		return null;
	}
}
