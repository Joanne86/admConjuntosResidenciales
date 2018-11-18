package co.edu.uan.entidad;

public class Arrendatario extends Persona{
	private String parqueadero;
	private String torreapart;

	public Arrendatario(String documento, String nombre, String telefono, String correo,  String torreapart, String parqueadero) {
		super(documento, nombre, telefono, correo);
		this.parqueadero = parqueadero;
		this.torreapart=torreapart;
	}

	public String getTorreapart() {
		return torreapart;
	}

	public void setTorreapart(String torreapart) {
		this.torreapart = torreapart;
	}

	public String getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(String parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	
}
