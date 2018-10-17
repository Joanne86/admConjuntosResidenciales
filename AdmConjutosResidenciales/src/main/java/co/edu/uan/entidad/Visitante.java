package co.edu.uan.entidad;

public class Visitante {
	private String documento;
	private String nombre;
	private String destino;
	private String entrada;
	private String salida;
	private String torre;
	private String apart;
	
	public Visitante(String documento, String nombre, String destino, String entrada, String salida) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.destino = destino;
		this.entrada = entrada;
		this.salida = salida;
	}
	
	
	public String getTorre() {
		return torre;
	}


	public void setTorre(String torre) {
		this.torre = torre;
	}


	public String getApart() {
		return apart;
	}


	public void setApart(String apart) {
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
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
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
	
}
