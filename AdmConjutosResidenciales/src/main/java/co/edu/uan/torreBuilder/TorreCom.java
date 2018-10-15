package co.edu.uan.torreBuilder;


public class TorreCom {
	
	private String numero;
	private String naptos;
	private String zona;
	private String puestos;
	private String costo;
	
	
	
	public TorreCom(String numero, String naptos, String zona, String puestos, String costo) {
		this.numero = numero;
		this.naptos = naptos;
		this.zona = zona;
		this.puestos=puestos;
		this.costo = costo;
	}
	
	public String getPuestos() {
		return puestos;
	}

	public void setPuestos(String puestos) {
		this.puestos = puestos;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNaptos() {
		return naptos;
	}
	public void setNaptos(String naptos) {
		this.naptos = naptos;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	
}
