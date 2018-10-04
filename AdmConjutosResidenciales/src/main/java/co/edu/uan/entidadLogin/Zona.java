package co.edu.uan.entidadLogin;

public class Zona {
	private String nombre;
	private float administracion;
	private float  parqueadero;
	public Zona(String nombre, float administracion, float parqueadero) {
		super();
		this.nombre = nombre;
		this.administracion = administracion;
		this.parqueadero = parqueadero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getAdministracion() {
		return administracion;
	}
	public void setAdministracion(float administracion) {
		this.administracion = administracion;
	}
	public float getParqueadero() {
		return parqueadero;
	}
	public void setParqueadero(float parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	
}
