package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.entidad.Servicio;
import javafx.collections.ObservableList;

public class ServicioDAO {
	private IDBAdapter dbAdapter;
	private static ServicioDAO servicioDAO = null;

	private ServicioDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public static ServicioDAO getInstance() {
		if (servicioDAO == null) {
			servicioDAO = new ServicioDAO();
		}
		return servicioDAO;
	}

	public void traerServicios(ObservableList<String> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT nombre FROM tipo_usuario WHERE id=? || id=? || id=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 4);
			ps.setInt(2, 5);
			ps.setInt(3, 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(rs.getString(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}

	}

	public void traerDatosTabla(ObservableList<Servicio> listaServ) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM personalServicio";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				 listaServ.add(new Servicio(rs.getString(1),
						 rs.getString(2),
						 rs.getString(3),
						 rs.getString(4),
						 rs.getString(5),
						 rs.getString(6),
						 rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	public boolean verificarPServicio(String documento) {
		boolean encontrado=false;
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT documento FROM servicio WHERE documento=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, documento);
			rs = ps.executeQuery();
			while (rs.next()) {
				encontrado=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return encontrado;
	}

	public boolean createPServicio(Servicio servicio) {
		Connection connection = dbAdapter.getConnection();

		try {
			PreparedStatement sentencia;
			sentencia = connection.prepareStatement(
					"INSERT into persona" + "(documento, nombre, telefono, nacimiento, correo) values(?,?,?,?,?)");
			sentencia.setString(1, servicio.getDocumento());
			sentencia.setString(2, servicio.getNombre());
			sentencia.setString(3, servicio.getTelefono());
			sentencia.setString(4, servicio.getNacimiento());
			sentencia.setString(5, servicio.getCorreo());
			sentencia.execute();

			PreparedStatement sentenciaServicio = connection
					.prepareStatement("INSERT into servicio" + "(nombreserv, horario, documento) values(?,?,?)");
			sentenciaServicio.setString(1, servicio.getServicio());
			sentenciaServicio.setString(2, servicio.getHorario());
			sentenciaServicio.setString(3, servicio.getDocumento());
			sentenciaServicio.execute();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
