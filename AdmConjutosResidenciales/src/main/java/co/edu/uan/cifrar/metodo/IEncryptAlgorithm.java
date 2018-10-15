package co.edu.uan.cifrar.metodo;

public interface IEncryptAlgorithm {
	public byte[] cifrarMensaje(String mensaje);
	public String descifrarMensaje(byte[] mensaje);
}
