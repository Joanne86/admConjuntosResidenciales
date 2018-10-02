
package co.edu.uan.dao;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import co.edu.uan.entidad.Propietario;
import java.sql.Connection;

/**
 *
 * @author LEIDY RODRIGUEZ
 */
public class PropietarioDAO {
    private IDBAdapter dbAdapter;

    public PropietarioDAO() {
        dbAdapter = DBFactory.getDefaultDBAdapter();
    }
    public void createPropietario(Propietario prop){ //por ahora void
        Connection connection = dbAdapter.getConnection();
        //lo que sigue
    }
    
}
