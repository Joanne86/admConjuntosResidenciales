package co.edu.uan.entidad;

public class PropietarioTabla {
	private String documento;
	private String nombre;
	private String telefono;
	private String fecha;
	private String correo;
	private String torre;
	private String apart;
	private String reside;
	private String parqueadero;
	
	public PropietarioTabla(String documento, String nombre, String telefono, String fecha, String correo, String torre,
			String apart, String reside, String parqueadero) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fecha = fecha;
		this.correo = correo;
		this.torre = torre;
		this.apart = apart;
		this.reside = reside;
		this.parqueadero = parqueadero;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
