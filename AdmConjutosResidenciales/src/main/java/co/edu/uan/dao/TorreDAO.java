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

	public boolean createTorre(Torre torre) {
	boolean creada=false;
		
	Connection connection = dbAdapter.getConnection();
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	String sql = "INSERT INTO torre(numero, idzona) VALUES (?,?)";
	String sql2 = "INSERT INTO torreapart(ntorre, napartamento, reside, parqueadero, documento) VALUES (?,?,?,?,?)";
	try { 
        ps = connection.prepareStatement(sql);
        ps.setInt(1, torre.getNumero());
        ps.setInt(2, Integer.parseInt(torre.getZona().getIdzona()));
        ps.execute();
        //datos de apartamento
        ps2 = connection.prepareStatement(sql2);
        for(int i=0; i<torre.getApartamentos().size(); i++) {
        	 ps2.setInt(1, torre.getNumero());            
             ps2.setInt(2, torre.getApartamentos().get(i).getNumero());
             ps2.setString(3, torre.getApartamentos().get(i).getReside());
             ps2.setString(4, torre.getApartamentos().get(i).getParqueadero());
             ps2.setString(5, null);
             ps2.execute();
        }  
        creada=true;
    } catch (SQLException e) {
    	creada=false;
    } finally {
        try {
        	connection.close();
        } catch (SQLException e) {

        }
    }
	return creada;
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
