
package co.edu.uan.dao;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;

import co.edu.uan.cifrar.metodo.Cifrado;
import co.edu.uan.entidad.Arrendatario;
import co.edu.uan.entidad.Novedad;
import co.edu.uan.entidad.Propietario;
import co.edu.uan.entidad.PropietarioTabla;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LEIDY RODRIGUEZ
 */
public class ResidenteDAO {
	private IDBAdapter dbAdapter;
	private static ResidenteDAO residenteDAO = null;

	private ResidenteDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	public static ResidenteDAO getInstance() {
		if(residenteDAO==null) {
			residenteDAO = new ResidenteDAO();
		}
		return residenteDAO;
	}
	/**
	 * metodo para verificar si el propietario existe o no
	 * @param documento
	 * @return
	 */
	public boolean verificarProp(String documento) {
		boolean encontrado=false;
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT documento FROM persona WHERE documento=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, documento);
			rs = ps.executeQuery();
			while (rs.next()) {
				encontrado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return encontrado;
	}
	/**
	 * metodo para filtrar propietario por documento
	 * @param documento
	 * @param lista
	 */
	public void buscarProp( String documento, ObservableList<PropietarioTabla> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM apartprop WHERE documento=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, documento);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new PropietarioTabla(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getString(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
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
			sentencialogin.setString(1, prop.getDocumento());
			sentencialogin.setString(2, Cifrado.claveCifrada(prop.getLogin().getContraseña()));
			sentencialogin.setString(3, prop.getLogin().getTipoPersona());
			sentencialogin.execute();
			
			PreparedStatement sentencia = connection.prepareStatement("INSERT into persona"
					+ "(documento, nombre, telefono, nacimiento, correo, id_sesion) values(?,?,?,?,?,?)");
			sentencia.setString(1, prop.getDocumento());
			sentencia.setString(2, prop.getNombre());
			sentencia.setString(3, prop.getTelefono());
			sentencia.setString(4, prop.getNacimiento());
			sentencia.setString(5, prop.getCorreo());
			
			String sql = "SELECT id FROM sesion WHERE usuario=?";
		
				ps = connection.prepareStatement(sql);
				ps.setString(1,prop.getDocumento());
				rs = ps.executeQuery();
				while (rs.next()) {
					sentencia.setString(6, rs.getString(1));
				}
				sentencia.execute();
			//datos de la propiedad
				PreparedStatement propiedad = connection.prepareStatement("UPDATE torreapart SET "
						+ "reside=?, parqueadero=?, documento=? WHERE ntorre=? && napartamento=?");
						
				propiedad.setString(1, prop.getApartamento().getReside());
				propiedad.setString(2, prop.getApartamento().getParqueadero());
				propiedad.setString(3, prop.getDocumento());
				propiedad.setInt(4, prop.getnTorre());
				propiedad.setInt(5, prop.getApartamento().getNumero());
				propiedad.execute();
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
	public boolean createArrendatario(Arrendatario arrend) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement sentencia = connection.prepareStatement("INSERT into arrendatario"
					+ "(documento, nombre, telefono, correo, torreapart, parqn) values(?,?,?,?,?,?)");
			sentencia.setString(1, arrend.getDocumento());
			sentencia.setString(2, arrend.getNombre());
			sentencia.setString(3, arrend.getTelefono());
			sentencia.setString(4, arrend.getCorreo());
			sentencia.setString(5, arrend.getTorreapart());
			sentencia.setString(6, arrend.getParqueadero());
			sentencia.execute();
			//modificar tabla parqu
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

	public boolean verificarArrend(String documento) {
		boolean encontrado=false;
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT documento FROM arrendatario WHERE documento=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, documento);
			rs = ps.executeQuery();
			while (rs.next()) {
				encontrado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return encontrado;
	}
	/**
	 * metodo para traer todos los dataos de los propuetarios
	 * @param lista
	 */
	public void traerDatosTabla(ObservableList<PropietarioTabla> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM apartprop";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new PropietarioTabla(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getString(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
	/**
	 * metodo para traer los datos de los apartamentos para la novedad
	 * @param novedad
	 * @param documento
	 */
	public void traerApart(Novedad novedad, String documento) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT ntorre, napartamento FROM apartprop WHERE documento=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,documento);
			rs = ps.executeQuery();
			while (rs.next()) {
				novedad.setTorre(rs.getString(1));
				novedad.setApart(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		
	}
	public void traerArrendatrios(ObservableList<Arrendatario> listaArrend) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//hacer una vista 
		String sql = "SELECT * FROM arrendatario";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listaArrend.add(new Arrendatario(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
	public void buscarArrendatario(ObservableList<Arrendatario> listaArrend, String documento) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//hacer una vista 
		String sql = "SELECT * FROM arrendatario WHERE documento=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,documento);
			rs = ps.executeQuery();
			while (rs.next()) {
				listaArrend.add(new Arrendatario(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		
	}
}