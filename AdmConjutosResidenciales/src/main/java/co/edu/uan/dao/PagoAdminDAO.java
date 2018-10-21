package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.entidad.Recibo;
import co.edu.uan.entidad.Visitante;

public class PagoAdminDAO {
	private IDBAdapter dbAdapter;
	public static PagoAdminDAO pagoAdminDAO = null;

	private PagoAdminDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public static PagoAdminDAO getInstance() {
		if (pagoAdminDAO == null) {
			pagoAdminDAO = new PagoAdminDAO();
		}
		return pagoAdminDAO;
	}

	public void traerDatosRecibo(String documento, Recibo recibo) {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT ntorre, napartamento FROM torreapart WHERE documento=?";

		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		String sql2 = "SELECT * FROM inmueble WHERE ntorre=? && napartamento=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, documento);
			rs = ps.executeQuery();
			if (rs.next()) {
				recibo.setTorre(rs.getInt(1));
				recibo.setApart(rs.getInt(2));
			}
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, recibo.getTorre());
			ps2.setInt(2, recibo.getApart());
			rs2 = ps2.executeQuery();

			if (rs2.next()) {

				String parqueadero;
				parqueadero = rs2.getString(4);
				if (parqueadero.equals("no")) {
					recibo.setCostoParq(0);
					
				}else {
					recibo.setCostoParq(rs2.getFloat(7));
				}
				recibo.setZona(rs2.getString(5));
				recibo.setCostoAdmin(rs2.getFloat(6));				
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

	public boolean guardarRecibo(Recibo recibo) {
		
		return false;
	}

}
