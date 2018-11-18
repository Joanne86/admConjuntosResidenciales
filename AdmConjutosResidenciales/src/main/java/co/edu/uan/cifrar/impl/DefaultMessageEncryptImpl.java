package co.edu.uan.cifrar.impl;

import co.edu.uan.cifrar.metodo.IEncryptAlgorithm;
/**
 * 
 * @author LEIDY RODRIGUEZ
 *
 */

public class DefaultMessageEncryptImpl implements IMessageEncrypt{
    private IEncryptAlgorithm encryptAlgorith;
    /**
     * Metodo para recibir el metodo de cifrado
     * @param encryptAlgorith
     */
    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorith){
        this.encryptAlgorith = encryptAlgorith;
    }

    @Override
    public String encryptMessage(String password)throws Exception {
        return encryptAlgorith.cifrarMensaje(password);
    }
   
	@Override
	public String decryptMessage(String mensaje) {
		return encryptAlgorith.descifrarMensaje(mensaje);
	}
}
