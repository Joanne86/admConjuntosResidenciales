package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.torreBuilder.Apartamento;
import co.edu.uan.torreBuilder.Torre;

public class TorreDAO {
	private IDBAdapter dbAdapter;

	public TorreDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public void createTorre(Torre torre) {
	Connection connection = dbAdapter.getConnection();
	PreparedStatement ps = null;
	String sql = "INSERT INTO torre(numero, idzona) VALUES (?,?)";
	try {
        ps = connection.prepareStatement(sql);

        ps.execute();

    } catch (SQLException e) {

    } finally {
        try {
        	connection.close();
        } catch (SQLException e) {

        }
    }
	}

	public boolean verificarTorre(String numero) {
		boolean encontrado=false;
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT numero FROM torre WHERE numero=?";
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, numero);
			rs = ps.executeQuery();
			while (rs.next()) {
				encontrado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encontrado;
	}
	
	public void updateTorre() {

	}

	public void deleteTorre() {

	}
}
