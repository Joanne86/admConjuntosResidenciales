package co.edu.uan.cifrar.impl;

public interface IMessageEncrypt {
	public byte[] encryptMessage(String password) throws Exception;	
	public String decryptMessage(byte[] mensaje);
}
