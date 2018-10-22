package co.edu.uan.cifrar.metodo;

import co.edu.uan.cifrar.impl.DefaultMessageEncryptImpl;
import co.edu.uan.cifrar.impl.IMessageEncrypt;

public class Cifrado {
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
