package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.entidad.Novedad;
import javafx.collections.ObservableList;

public class NovedadDAO {
	private IDBAdapter dbAdapter;
	private static NovedadDAO novedadDAO=null;
	
	private NovedadDAO(){
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	public static NovedadDAO getInstance() {
		if(novedadDAO==null) {
			novedadDAO = new NovedadDAO();
		}
		return novedadDAO;
	}
	/**
	 * metodo para traer los datos a la tabla de novedades
	 * @param lista
	 */
	public void traerDatosTabla(ObservableList<Novedad> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//hacer una vista 
		String sql = "SELECT * FROM novedadresid";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Novedad(rs.getString(1)
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
	/**
	 * metodo para guardar una novedad por parte del propietario
	 * @param tipoNovedad
	 * @param detalleNovedad
	 * @param documento
	 * @return
	 */
	public boolean guardarNovedad(String tipoNovedad, String detalleNovedad, String documento) {
		boolean guardado=false;
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO novedad (tiponovedad, detallenovedad, documento) VALUES (?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, tipoNovedad);
			ps.setString(2, detalleNovedad);
			ps.setString(3, documento);
			ps.execute();
			guardado=true;
		} catch (SQLException e) {
			guardado=false;
			e.printStackTrace();
		}
		
	return guardado;
	
	}
}
