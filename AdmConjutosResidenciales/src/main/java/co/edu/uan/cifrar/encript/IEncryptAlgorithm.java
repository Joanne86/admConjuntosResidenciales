package co.edu.uan.cifrar.encript;

public interface IEncryptAlgorithm {
	//La interface �nicamente define el m�todo encrypt el cual se utilizar� para cifrar	los mensajes
	public String encrypt(String message, String password) throws Exception;

	
}
