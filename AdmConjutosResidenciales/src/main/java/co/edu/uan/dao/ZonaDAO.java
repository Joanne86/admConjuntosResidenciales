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

	public ZonaDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

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
