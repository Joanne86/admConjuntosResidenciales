package co.edu.uan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.PersonaFactoryLogin.AdminFactory;
import co.edu.uan.PersonaFactoryLogin.PersonaManager;
import co.edu.uan.PersonaFactoryLogin.PropietarioFactory;
import co.edu.uan.cifrar.metodo.Cifrado;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Persona;


public class LoginDAO {
	private IDBAdapter dbAdapter;
	private static Persona persona;
	private static LoginDAO loginDAO=null;

	private LoginDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	public static LoginDAO getInstance() {
		if(loginDAO==null) {
			loginDAO=new LoginDAO();
		}
		return loginDAO;
	}

	public boolean iniciarSesion(String usuario, String contraseña) {

		Connection connection = dbAdapter.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		
		String sql1 = "SELECT contraseña FROM loginpersona WHERE usuario =?";
		String sql = "SELECT * FROM loginpersona WHERE usuario =?"; 
		
		PersonaManager personaManager = new PersonaManager();

		try {
			String contraseñaDecifrada = null;
			ps1 = connection.prepareStatement(sql1);// prepara la consulta
			ps1.setString(1, usuario);// se elvia el valor
			rs1 = ps1.executeQuery();// busca un nombre de usuario en la bd
			if (rs1.next()) {
				String contraseñaCifrada= rs1.getString(1);
				contraseñaDecifrada=Cifrado.claveDecifrada(contraseñaCifrada);	
			}			
			ps = connection.prepareStatement(sql);// prepara la consulta
			ps.setString(1, usuario);// se elvia el valor
			rs = ps.executeQuery();// busca un nombre de usuario en la bd
			if (rs.next()) {

				if (contraseña.equals(contraseñaDecifrada)) {

					String tipo = rs.getString(6);
					Login login = new Login();			
					login.setUsuario(rs.getString(7));
					login.setContraseña(contraseñaDecifrada);
					login.setTipoPersona(tipo);

					if (tipo.equals("administrador")) {

						personaManager.setFactory(new AdminFactory());
						personaManager.crearPersona(rs.getString(1), rs.getString(2),
								 rs.getString(5), login);
						setPersona(personaManager.getPersona());

					} else if (tipo.equals("propietario")) {
						// hace otra consulta para obtener los apartamentos que tiene
						personaManager.setFactory(new PropietarioFactory());// pasa como parametro el resto de info
						personaManager.crearPersona(rs.getString(1), rs.getString(2)
								,rs.getString(5), login);
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

	public void setPersona(Persona persona) {
		LoginDAO.persona = persona;
	}

	public static Persona getInstancePersona() {
		return persona;
	}
}
