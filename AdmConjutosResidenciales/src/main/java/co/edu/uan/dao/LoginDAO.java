package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.PersonaFactoryLogin.AdminFactory;
import co.edu.uan.PersonaFactoryLogin.PersonaManager;
import co.edu.uan.PersonaFactoryLogin.PropietarioFactory;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;
import co.edu.uan.torreBuilder.Apartamento;
import co.edu.uan.torreBuilder.Zona;

public class LoginDAO {
	private IDBAdapter dbAdapter;
	private static Persona persona;

	public LoginDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public boolean iniciarSesion(String usuario, String contraseña) {
		System.out.println(dbAdapter);

		Connection connection = dbAdapter.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM loginpersona WHERE usuario =?";
		// usar bridge para ciffrar contraseñas
		PersonaManager personaManager = new PersonaManager();

		try {

			ps = connection.prepareStatement(sql);// prepara la consulta
			ps.setString(1, usuario);// se elvia el valor
			rs = ps.executeQuery();// busca un nombre de usuario en la bd
			if (rs.next()) {

				if (contraseña.equals(rs.getString(8))) {

					String tipo = rs.getString(6);
					Login login = new Login();
					login.setUsuario(rs.getString(7));
					login.setContraseña(rs.getString(8));
					login.setTipoPersona(tipo);

					if (tipo.equals("administrador")) {

						personaManager.setFactory(new AdminFactory());
						personaManager.crearPersona(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), login, null);
						setPersona(personaManager.getPersona());

					} else if (tipo.equals("propietario")) {
						// hace otra consulta para obtener los apartamentos que tiene
						personaManager.setFactory(new PropietarioFactory());// pasa como parametro el resto de info
						personaManager.crearPersona(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), login,
								null); // por ahora nul porque
																								// tiene q hacer
						// otra consulta para agregar a la lista
						// de inmuebles
						setPersona(personaManager.getPersona());
					}
					return true;
				} else {
					return false;
				}
			}
			return false;
		} catch (SQLException ex) {

			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
/*
	public ArrayList<Apartamento> listaApartamentos(int documento, Connection connection) {
		ArrayList<Apartamento> apartamentos = new ArrayList<>();
		Apartamento apartamento;

		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		String sql2 = "select * from inmueble where documento =?";
		try {
			// prepara la consulta
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, documento);// se elvia el valor
			rs2 = ps2.executeQuery();// busca un nombre de usuario en la bd
			while (rs2.next()) {
				Zona zona = new Zona(rs2.getString(5), rs2.getFloat(6), rs2.getFloat(7));

				apartamento = new Apartamento(Integer.parseInt(rs2.getString(1)), Integer.parseInt(rs2.getString(2)),
						rs2.getString(3), rs2.getString(4), zona);
				apartamentos.add(apartamento);
			}
		} catch (SQLException ex) {

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return apartamentos;
	}
*/
	public void setPersona(Persona persona) {
		LoginDAO.persona = persona;
	}

	public static Persona getInstancePersona() {
		return persona;
	}
}
