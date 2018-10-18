package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.entidad.Visitante;
import javafx.collections.ObservableList;

public class VisitanteDAO {
	private static VisitanteDAO visitanteDAO=null;
	private IDBAdapter dbAdapter;

	private VisitanteDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	public static VisitanteDAO getInstance() {
		if(visitanteDAO==null) {
			visitanteDAO = new VisitanteDAO();
		}
		return visitanteDAO;
	}

	public void traerDatosTabla(ObservableList<Visitante> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM visitante";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Visitante(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5),
						rs.getString(6), rs.getString(7)));
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

	public void buscarVisitante(ObservableList<Visitante> lista, String documento) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM visitante WHERE documento=? && salida=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, documento);
			ps.setString(2, "");
			rs = ps.executeQuery();
			while (rs.next()) {
			lista.add(new Visitante(rs.getString(2), rs.getString(3), rs.getInt(4) ,rs.getInt(5),
						rs.getString(6), rs.getString(7)));
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

	public boolean createVisitante(Visitante visitante) {
		boolean creado = false;

		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO visitante(documento, nombre, ntorre, napartamento, entrada, salida) VALUES (?,?,?,?,?,?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, visitante.getDocumento());
			ps.setString(2, visitante.getNombre());
			ps.setInt(3, visitante.getTorre());
			ps.setInt(4, visitante.getApart());
			ps.setString(5, visitante.getEntrada());
			ps.setString(6, visitante.getSalida());
			ps.execute();

			creado = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			creado = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

			}
		}

		return creado;
	}

	public boolean registrarSalida(Visitante visitante) {
		boolean creado = false;

		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		String sql = ("UPDATE visitante SET salida=? WHERE documento=? && nombre=? && ntorre=? && napartamento=? && entrada=?");

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, visitante.getSalida());
			ps.setString(2, visitante.getDocumento());
			ps.setString(3, visitante.getNombre());
			ps.setInt(4, visitante.getTorre());
			ps.setInt(5, visitante.getApart());
			ps.setString(6, visitante.getEntrada());
			ps.execute();
			System.out.println(visitante.toString());
			creado = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			creado = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return creado;
	}

}
