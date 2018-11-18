package co.edu.uan.cifrar.metodo;

public interface IEncryptAlgorithm {
	/**
	 * metodo para cifrar el mensaje
	 * @param mensaje
	 * @return mensaje cifrado
	 */
	public String cifrarMensaje(String mensaje);
	/**
	 * metodo para decifrar el mensaje
	 * @param mensaje
	 * @return mensaje decifrado
	 */
	public String descifrarMensaje(String mensaje);
}
