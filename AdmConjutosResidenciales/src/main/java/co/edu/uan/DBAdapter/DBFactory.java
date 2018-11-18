
package co.edu.uan.DBAdapter;

import java.util.Properties;

import co.edu.uan.conectorBD.MySQLDBAdapter;
import co.edu.uan.util.PropertiesUtil;

/**
 * 
 * @author LEIDY RODRIGUEZ
 */
public class DBFactory {

    private static final String DB_FACTORY_PROPERTY_URL = "DBFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    public static IDBAdapter getDBadapter(DBType dbType) {
        switch (dbType) {
            case MySQL:
                return new MySQLDBAdapter();
            case Oracle:
                //return new OracleDBAdapter();
            default:
                throw new IllegalArgumentException("Not supported");
        }
    }
/**
 * Metodo para saber que clase de base de datos se va a implementar de acuerdo a los parametros del archivo de propiedades
 * @return nombre la clase a implementar
 */
    public static IDBAdapter getDefaultDBAdapter() {
        try {
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            
           
            return (IDBAdapter)Class.forName(defaultDBClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}