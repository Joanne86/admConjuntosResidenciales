package co.edu.uan.cifrar.metodo;

import co.edu.uan.cifrar.impl.DefaultMessageEncryptImpl;
import co.edu.uan.cifrar.impl.IMessageEncrypt;
/**
 * 
 * @author LEIDY RODRIGUEZ
 *
 */
public class Cifrado {
	/**
	 * metodo para mandar el tipo de cifrado y cifrar
	 * @param mensaje
	 * @return mensaje cifrado
	 */
	public static String claveCifrada(String mensaje) {
		String passwordCifrado = null;
    	
        IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(new AESEncryptAlgorithm());
		try {
			passwordCifrado = aesImpl.encryptMessage(mensaje);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return passwordCifrado;
	}
	/**
	 * metodo para obtener el mensaje decifrado
	 * @param mensaje
	 * @return mensaje desifrado
	 */
	public static String claveDecifrada(String mensaje) {
		String contraseñaDescifrada=null;
		IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(new AESEncryptAlgorithm());
		try {
			
			contraseñaDescifrada =aesImpl.decryptMessage(mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contraseñaDescifrada;
	}
}
