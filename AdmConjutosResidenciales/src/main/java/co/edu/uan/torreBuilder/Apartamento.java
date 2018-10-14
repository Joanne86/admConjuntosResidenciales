package co.edu.uan.torreBuilder;

public class Apartamento {
	
	private int numero;
	private String reside;
	private String parqueadero;
	
	public Apartamento(int numero, String reside, String parqueadero) {
		super();
		this.numero = numero;
		this.reside = reside;
		this.parqueadero = parqueadero;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	@Override
	public String toString() {
		return "Apartamento [numero=" + numero + ", reside=" + reside + ", parqueadero=" + parqueadero + "]";
	}
	
	
}
