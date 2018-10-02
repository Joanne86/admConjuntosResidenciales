package co.edu.uan.dao;

import java.sql.Connection;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.entidad.Persona;

public class LoginDAO {
	private IDBAdapter dbAdapter;
	
	public LoginDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public void iniciarSesion(Persona persona) {//por aahora void
		 Connection connection = dbAdapter.getConnection();
	}
}
