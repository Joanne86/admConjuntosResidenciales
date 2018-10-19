package co.edu.uan.entidad;

public class Novedad {
	private String torre;
	private String apart;
	private String tipoResidente;
	private String nombreResidente;
	private String notificacion;
	private String asunto;
	public Novedad(String torre, String apart, String tipoResidente, String nombreResidente, String notificacion,
			String asunto) {
		super();
		this.torre = torre;
		this.apart = apart;
		this.tipoResidente = tipoResidente;
		this.nombreResidente = nombreResidente;
		this.notificacion = notificacion;
		this.asunto = asunto;
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
	public String getTipoResidente() {
		return tipoResidente;
	}
	public void setTipoResidente(String tipoResidente) {
		this.tipoResidente = tipoResidente;
	}
	public String getNombreResidente() {
		return nombreResidente;
	}
	public void setNombreResidente(String nombreResidente) {
		this.nombreResidente = nombreResidente;
	}
	public String getNotificacion() {
		return notificacion;
	}
	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
}
