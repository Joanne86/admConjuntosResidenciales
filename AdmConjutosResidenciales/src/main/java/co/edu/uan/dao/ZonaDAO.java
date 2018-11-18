package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ZonaDAO {
	private IDBAdapter dbAdapter;
	public static ZonaDAO zonaDAO=null;

	private ZonaDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	
	public static ZonaDAO getInstance() {
		if(zonaDAO==null) {
			return new ZonaDAO();
		}
		return zonaDAO;
	}
	

	/**
	 * metodo para listar las zonas para el registro de las torres
	 * @return
	 */
	public ObservableList<String> listZona() {
		ObservableList<String> listaZonas = FXCollections.observableArrayList();
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT nombre FROM tipozona";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nombreZona;
				nombreZona = rs.getString(1);
				listaZonas.add(nombreZona);
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
		return listaZonas;
	}

	/**
	 * metodo para obtener los datos de la zona seleccionada
	 * @param zona
	 * @return
	 */
	public String traerDatosDeZonaAdmin(String zona) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String admin = null;
		String sql = "SELECT costoadmin FROM tipozona WHERE nombre=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, zona);
			rs = ps.executeQuery();
			while (rs.next()) {
				admin = rs.getString(1);
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
		return admin;
	}
	/**
	 * metodo para traer los datos de cada zona
	 * @param zona
	 * @return
	 */
	public String traerDatosDeZonaId(String zona) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = null;
		String sql = "SELECT id FROM tipozona WHERE nombre=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, zona);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString(1);
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
		return id;
	}
	/**
	 * metodo para obtener el costo del parqueadero de acuerdo a la zona
	 * @param zona
	 * @return
	 */
	public String traerDatosDeZonaParq(String zona) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String parq = null;
		String sql = "SELECT costoparq FROM tipozona WHERE nombre=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, zona);
			rs = ps.executeQuery();
			while (rs.next()) {
				parq = rs.getString(1);
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
		return parq;
	}
}
