package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public void traerDatosTabla(ObservableList<Novedad> lista) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//hacer una vista 
		String sql = "SELECT * FROM apartprop";
	}
	public void guardarNovedad(Novedad novedad) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//hacer una vista 
		String sql = "SELECT * FROM apartprop";
	}
}
