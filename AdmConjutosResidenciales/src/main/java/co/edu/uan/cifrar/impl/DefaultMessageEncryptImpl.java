package co.edu.uan.cifrar.impl;

import co.edu.uan.cifrar.metodo.IEncryptAlgorithm;

public class DefaultMessageEncryptImpl implements IMessageEncrypt{
    private IEncryptAlgorithm encryptAlgorith;
    
    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorith){
        this.encryptAlgorith = encryptAlgorith;
    }
    
    @Override
    public byte[] encryptMessage(String password)throws Exception {
        return encryptAlgorith.cifrarMensaje(password);
    }

	@Override
	public String decryptMessage(byte[] mensaje) {
		return encryptAlgorith.descifrarMensaje(mensaje);
	}
}
