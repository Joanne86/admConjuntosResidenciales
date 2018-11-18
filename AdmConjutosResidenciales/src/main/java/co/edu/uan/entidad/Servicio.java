package co.edu.uan.entidad;

public class Servicio extends Persona{
	
	private String servicio;
	private String horario;
	
	
	public Servicio(String documento, String nombre, String telefono, String nacimiento, String correo, String servicio, String horario) {
		super(documento, nombre, telefono, nacimiento, correo);
		this.servicio=servicio;
		this.horario=horario;
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
