package co.edu.uan.entidad;

public class Novedad {
	private String torre;
	private String apart;
	private String tipoResidente;
	private String nombreResidente;
	private String tipoNovedad;
	private String detalleNovedad;

	
	public Novedad(String torre, String apart, String tipoResidente, String nombreResidente, String tipoNovedad,
			String detalleNovedad) {
		super();
		this.torre = torre;
		this.apart = apart;
		this.tipoResidente = tipoResidente;
		this.nombreResidente = nombreResidente;
		this.tipoNovedad = tipoNovedad;
		this.detalleNovedad = detalleNovedad;
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

	public String getTipoNovedad() {
		return tipoNovedad;
	}

	public void setTipoNovedad(String tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}

	public String getDetalleNovedad() {
		return detalleNovedad;
	}

	public void setDetalleNovedad(String detalleNovedad) {
		this.detalleNovedad = detalleNovedad;
	}

	
}
