package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void createApartamento(Torre torre) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement instruccion = connection
					.prepareStatement("INSERT INTO estudiante (codigo, nombre, genero, edad, fecha, carrera) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateApartamento() {

	}

	public void deleteApartamento() {

	}
}
