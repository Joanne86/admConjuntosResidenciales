package co.edu.uan.entidad;

public class Recibo {
	private String codigo;	
	private String documento;
	private String nombre;
	private String torre;
	private String apart;
	private String zona;
	private String costoAdmin;
	private String costoParq;
	private String total;
	private String cancelado;

	public Recibo() {
	}
	public Recibo(String codigo, String documento, String nombre, String torre, String apart, String zona,
			String costoAdmin, String costoParq, String total, String cancelado) {
		this.codigo = codigo;
		this.documento = documento;
		this.nombre = nombre;
		this.torre = torre;
		this.apart = apart;
		this.zona = zona;
		this.costoAdmin = costoAdmin;
		this.costoParq = costoParq;
		this.total = total;
		this.cancelado = cancelado;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getCostoAdmin() {
		return costoAdmin;
	}


	public void setCostoAdmin(String costoAdmin) {
		this.costoAdmin = costoAdmin;
	}


	public String getCostoParq() {
		return costoParq;
	}


	public void setCostoParq(String costoParq) {
		this.costoParq = costoParq;
	}


	public String getTotal() {
		return Float.toString(Float.parseFloat(costoAdmin)+Float.parseFloat(costoParq));
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getCancelado() {
		return cancelado;
	}


	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}


	@Override
	public String toString() {
		return "Recibo [codigo=" + codigo + ", documento=" + documento + ", nombre=" + nombre + ", torre=" + torre
				+ ", apart=" + apart + ", zona=" + zona + ", costoAdmin=" + costoAdmin + ", costoParq=" + costoParq
				+ ", total=" + total + ", cancelado=" + cancelado + "]";
	}
	
}
