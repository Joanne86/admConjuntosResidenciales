package co.edu.uan.torreBuilder;

public class Zona {
	private String idzona;
	private String nombre;
	private float administracion;
	private Parqueadero  parqueadero;
	
	
	public Zona(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Zona(String idzona, String nombre, float administracion, Parqueadero parqueadero) {
		super();
		this.idzona=idzona;
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
	public Parqueadero getParqueadero() {
		return parqueadero;
	}
	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public String getIdzona() {
		return idzona;
	}

	public void setIdzona(String idzona) {
		this.idzona = idzona;
	}

	@Override
	public String toString() {
		return "Zona [nombre=" + nombre + ", administracion=" + administracion + ", parqueadero=" + parqueadero + "]";
	}
	
}
