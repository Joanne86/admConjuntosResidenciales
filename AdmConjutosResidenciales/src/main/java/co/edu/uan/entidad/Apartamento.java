package co.edu.uan.entidad;

public class Apartamento {
	
	
	private int torre;
	private int apartamento;
	private String reside;
	private  String parqueadero;
	private Zona zona;
	
	

	public Apartamento(int torre, int apartamento, String reside, String parqueadero, Zona zona) {
		super();
		this.torre = torre;
		this.apartamento = apartamento;
		this.reside = reside;
		this.parqueadero = parqueadero;
		this.zona = zona;
	}
	public int getTorre() {
		return torre;
	}
	public void setTorre(int torre) {
		this.torre = torre;
	}
	public int getApartamento() {
		return apartamento;
	}
	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public String getReside() {
		return reside;
	}
	public void setReside(String reside) {
		this.reside = reside;
	}
	public String getParqueadero() {
		return parqueadero;
	}
	public void setParqueadero(String parqueadero) {
		this.parqueadero = parqueadero;
	}
	
}
