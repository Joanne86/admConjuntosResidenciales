package co.edu.uan.entidad;

public class Servicio{
	private String documento;
	private String nombre;
	private String telefono;
	private String nacimiento;
	private String correo;
	private String servicio;
	private String horario;
	public Servicio(String documento, String nombre, String telefono, String nacimiento, String correo, String servicio,
			String horario) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.nacimiento = nacimiento;
		this.correo = correo;
		this.servicio = servicio;
		this.horario = horario;
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
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
