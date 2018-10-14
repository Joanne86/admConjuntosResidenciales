package co.edu.uan.cifrar.impl;

import co.edu.uan.cifrar.encript.IEncryptAlgorithm;
/*
Clase que representa al bridge o puente, la clase implementa IMessageEncrypt y
delega la responsabilidad al m�todo de cifrado asignado durante la creaci�n del
objeto.

*/
public class DefaultMessageEncryptImpl implements IMessageEncrypt{
    private IEncryptAlgorithm encryptAlgorith;
    
    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorith){
        this.encryptAlgorith = encryptAlgorith;
    }
    
    @Override
    public String encryptMessage(String message, String password)throws Exception {
        return encryptAlgorith.encrypt(message, password);
    }
}