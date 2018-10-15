package co.edu.uan.cifrar.metodo;

import co.edu.uan.cifrar.impl.DefaultMessageEncryptImpl;
import co.edu.uan.cifrar.impl.IMessageEncrypt;

public class Cifrado {

    public void cifrarClave() {

    	String mensaje = "Siempre es bueno prevenir la musica antes de que empiece el baile";
        byte[] mensajeCifrado;
        String mensajeDescifrado;
    	
        IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(new AESEncryptAlgorithm());
        //byte[] messageAES;
		try {
			mensajeCifrado = aesImpl.encryptMessage(mensaje);
			mensajeDescifrado =aesImpl.decryptMessage(mensajeCifrado);
			System.out.println("mensaje >"+mensaje+"\n");
			System.out.println("mensaje cifrado > " + mensajeCifrado + "\n");
			System.out.println("mensaje decifrado > " + mensajeDescifrado + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
