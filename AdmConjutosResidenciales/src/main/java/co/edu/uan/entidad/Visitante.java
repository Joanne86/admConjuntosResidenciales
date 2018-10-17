package co.edu.uan.entidad;

public class Visitante {
	
	private String documento;
	private String nombre;
	private int torre;
	private int apart;
	private String entrada;
	private String salida;

	public Visitante(String documento, String nombre, int torre, int apart, String entrada, String salida) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.torre = torre;
		this.apart = apart;
		this.entrada = entrada;
		this.salida = salida;
	}

	public int getTorre() {
		return torre;
	}

	public void setTorre(int torre) {
		this.torre = torre;
	}

	public int getApart() {
		return apart;
	}

	public void setApart(int apart) {
		this.apart = apart;
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}

	@Override
	public String toString() {
		return "Visitante [documento=" + documento + ", nombre=" + nombre + ", torre=" + torre + ", apart=" + apart
				+ ", entrada=" + entrada + ", salida=" + salida + "]";
	}
	
	
}
