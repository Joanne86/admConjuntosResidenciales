package co.edu.uan.entidad;

public class Recibo {
	private String codigo;	
	private int torre;
	private int apart;
	private String zona;
	private float costoAdmin;
	private float costoParq;
	private float total;
	private String documento;
	private String nombre;
	private String cancelado;

	public Recibo() {
	}

	public Recibo(String codigo, int torre, int apart, String zona, float costoAdmin, float costoParq, float total,
			String documento, String nombre, String cancelado) {
		super();
		this.codigo = codigo;
		this.torre = torre;
		this.apart = apart;
		this.zona = zona;
		this.costoAdmin = costoAdmin;
		this.costoParq = costoParq;
		this.total = total;
		this.documento = documento;
		this.nombre = nombre;
		this.cancelado = cancelado;
	}

	public String getCancelado() {
		return cancelado;
	}

	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
	
}
