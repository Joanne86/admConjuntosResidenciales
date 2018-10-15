package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;

import co.edu.uan.torreBuilder.Apartamento;
import co.edu.uan.torreBuilder.Torre;
import co.edu.uan.torreBuilder.TorreCom;
import co.edu.uan.torreBuilder.Zona;
import javafx.collections.ObservableList;

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
	PreparedStatement ps3 = null;
	
	String sql = "INSERT INTO torre(numero, naptos, npuestos, idzona) VALUES (?,?,?,?)";
	String sql2 = "INSERT INTO torreapart(ntorre, napartamento, reside, parqueadero, documento) VALUES (?,?,?,?,?)";
	String sql3 = "INSERT INTO parqueadero(numero) VALUES (?)";
	try { 
        ps = connection.prepareStatement(sql);
        ps.setInt(1, torre.getNumero());
        ps.setInt(2, torre.getApartamentos().size());
        ps.setInt(3, torre.getZona().getParqueadero().getNumeros().size());
        ps.setInt(4, Integer.parseInt(torre.getZona().getIdzona()));
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
        ps3 = connection.prepareStatement(sql3);
        for(int i=0; i<torre.getZona().getParqueadero().getNumeros().size(); i++) {
        	ps3.setString(1, torre.getZona().getParqueadero().getNumeros().get(i));
        	ps3.execute();
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
	
	public void traerDatosTabla(ObservableList<TorreCom> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT numero, naptos,  zona, puestos, costo FROM totaltorre";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new TorreCom(rs.getString("numero"), rs.getString("naptos"), rs.getString("zona"), rs.getString("puestos"), rs.getString("costo")));
				//lista.add(new TorreCom(Integer.toString(rs.getInt("numero")), Integer.toString(rs.getInt("naptos")), rs.getString("zona"), Float.toString(rs.getFloat("costo"))));
				
			
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
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return encontrado;
	}
	
	public void updateTorre() {

	}

	public void deleteTorre() {

	}
}
