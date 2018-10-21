package co.edu.uan.entidad;

public class Recibo {
	private String codigo;
	private int torre;
	private int apart;
	private String zona;
	private float costoAdmin;
	private float costoParq;
	private float total;
	private String fecha;
	


	public Recibo() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getTorre() {
		return torre;
	}

	public void setTorre(int torre) {
		this.torre = torre;
	}

	public int getApart() {
		return apart;
	}

	public void setApart(int apart) {
		this.apart = apart;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public float getCostoAdmin() {
		return costoAdmin;
	}

	public void setCostoAdmin(float costoAdmin) {
		this.costoAdmin = costoAdmin;
	}

	public float getCostoParq() {
		return costoParq;
	}

	public void setCostoParq(float costoParq) {
		this.costoParq = costoParq;
	}

	public float getTotal() {
		return this.total = this.costoAdmin+this.costoParq;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
