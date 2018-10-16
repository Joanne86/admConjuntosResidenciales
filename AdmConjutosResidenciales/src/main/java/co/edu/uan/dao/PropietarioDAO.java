
package co.edu.uan.dao;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.cifrar.impl.DefaultMessageEncryptImpl;
import co.edu.uan.cifrar.impl.IMessageEncrypt;
import co.edu.uan.cifrar.metodo.AESEncryptAlgorithm;
import co.edu.uan.cifrar.metodo.Cifrado;
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
	

	public PropietarioDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	/**
	 *  metodo que crea un nuevo propietario en la BD
	 * @param prop
	 * @return
	 */
	public boolean createPropietario(Propietario prop) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			PreparedStatement sentencialogin = connection
					.prepareStatement("INSERT into sesion" + "(usuario, contraseña, id_tipo) values(?,?,?)");
			sentencialogin.setString(1, Integer.toString(prop.getDocumento()));
			sentencialogin.setBytes(2, Cifrado.claveCifrada(prop.getLogin().getContraseña()));
			sentencialogin.setString(3, prop.getLogin().getTipoPersona());
			sentencialogin.execute();
			
			PreparedStatement sentencia = connection.prepareStatement("INSERT into persona"
					+ "(documento, nombre, telefono, nacimiento, correo, id_sesion) values(?,?,?,?,?,?)");
			sentencia.setInt(1, prop.getDocumento());
			sentencia.setString(2, prop.getNombre());
			sentencia.setString(3, prop.getTelefono());
			sentencia.setString(4, prop.getNacimiento());
			sentencia.setString(5, prop.getCorreo());
			
			String sql = "SELECT id FROM sesion WHERE usuario=?";
		
				ps = connection.prepareStatement(sql);
				ps.setString(1, Integer.toString(prop.getDocumento()));
				rs = ps.executeQuery();
				while (rs.next()) {
					sentencia.setString(6, rs.getString(1));
				}
				sentencia.execute();
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

}