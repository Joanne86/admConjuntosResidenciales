package co.edu.uan.cifrar.encript;

//hereda de la interface IEncryptAlgorithm

public class NoEncryptAlgorithm implements IEncryptAlgorithm {
	// la clase �nicamente regresa el mensajerecibido sin realizar ning�n tipo de cifrado.
	 @Override
	    public String encrypt(String message, String password) throws Exception {
	        return message;
	    }
	 	
}
