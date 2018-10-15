
package co.edu.uan.dao;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;


import co.edu.uan.entidad.Propietario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LEIDY RODRIGUEZ
 */
public class PropietarioDAO {
	private IDBAdapter dbAdapter;
	Connection connection = dbAdapter.getConnection();

	public PropietarioDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	// metodo que crea un nuevo propietario en la BD
	public boolean createPropietario(Propietario prop) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			PreparedStatement sentencia = this.connection.prepareStatement("INSERT into persona"
					+ "(documento, nombre, telefono, nacimiento, correo, id_sesion) values(?,?,?,?,?,?)");
			sentencia.setInt(1, prop.getDocumento());
			sentencia.setString(2, prop.getNombre());
			sentencia.setString(3, prop.getTelefono());
			sentencia.setString(4, prop.getNacimiento());
			sentencia.setString(5, prop.getCorreo());
			sentencia.setString(6, prop.getLogin().getTipoPersona());
			sentencia.execute();

			// encriptar la clave
			//String clave_cifrada = cifarClave(prop.getLogin().getContraseña());

			// se ingresa para inicio de sesion
			PreparedStatement sentencialogin = this.connection
					.prepareStatement("INSERT into sesion" + "(usuario, contraseña, id_tipo) values(?,?,?)");
			sentencialogin.setString(1, Integer.toString(prop.getDocumento()));
			//sentencialogin.setString(2, clave_cifrada);
			sentencialogin.setString(3, prop.getLogin().getTipoPersona());
			sentencialogin.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}

	}
	// metodo que encripta el password para los usuarios
	
}