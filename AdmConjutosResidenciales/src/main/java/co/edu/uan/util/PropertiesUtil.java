package co.edu.uan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties loadProperty(String arc){
       /* try {
            Properties properties = new Properties();
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesURL);
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
		
		
		Properties prop = null;
	    try {
	        CodeSource codeSource = PropertiesUtil.class.getProtectionDomain().getCodeSource();
	        File jarFile = new File(codeSource.getLocation().toURI().getPath());
	        File jarDir = jarFile.getParentFile();
	 
	        if (jarDir != null && jarDir.isDirectory()) {
	            File propFile = new File(jarDir, arc);
	            prop = new Properties();
	            prop.load(new BufferedReader(new FileReader(propFile.getAbsoluteFile())));
	        }
	    } catch (URISyntaxException ex) {
	        //Logger.getLogger(funcionesUtilidad.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (FileNotFoundException ex) {
	        //System.err.println("No se encuentra el archivo: " + ex.getMessage());
	       // throw new FileNotFoundException("No se econtró el archivo de propiedades...");
	    } catch (IOException ex) {
	       // Logger.getLogger(funcionesUtilidad.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    return prop;
            
    }
}
