package co.edu.uan.cifrar.impl;

public interface IMessageEncrypt {
	/**
	 * metodo para dar la orden de cifrar al metodo de cifrado
	 * @param password para crifrarlo
	 * @return un string del mensaje cifrado 
	 * @throws Exception
	 */
	public String encryptMessage(String password) throws Exception;	

	/**
	 *  metodo para dar orden de decifrar al metodo de cifrado
	 * @param mensaje
	 * @return el estring del mensaje decifrado
	 */
	public String decryptMessage(String mensaje);
}
