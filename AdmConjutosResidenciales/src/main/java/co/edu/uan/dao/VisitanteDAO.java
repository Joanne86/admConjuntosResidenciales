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
	private IDBAdapter dbAdapter;

	public VisitanteDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
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
				lista.add(new Visitante(rs.getString(2),
						rs.getString(3),
						rs.getString(4)+"-"+rs.getString(5)
						,rs.getString(6)
						, rs.getString(7)));
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
	public boolean createVisitante(Visitante visitante) {
		boolean creado=false;
		
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO visitante(documento, nombre, ntorre, napartamento, entrada, salida) VALUES (?,?,?,?,?,?)";
		
		try {
			 ps = connection.prepareStatement(sql);
		        ps.setString(1, visitante.getDocumento());
		        ps.setString(2, visitante.getNombre());
		        ps.setInt(3, Integer.parseInt(visitante.getTorre()));
		        ps.setInt(4, Integer.parseInt(visitante.getApart()));
		        ps.setString(5, visitante.getEntrada());
		        ps.setString(6, visitante.getSalida());
		        ps.execute();
		        creado=true;
		}catch (SQLException e) {
	    	creado=false;
	    } finally {
	        try {
	        	connection.close();
	        } catch (SQLException e) {

	        }
	    }
		
		
		return creado;
	}
	
}
