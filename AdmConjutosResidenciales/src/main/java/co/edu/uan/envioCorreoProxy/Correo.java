package co.edu.uan.envioCorreoProxy;

import co.edu.uan.entidad.Propietario;
import co.edu.uan.entidad.Servicio;

public interface Correo {
	/**
	 * metodo para enviar el correo al residente
	 * @param prop
	 * @return
	 * 
	 */
	public boolean enviarCorreoResidente(Propietario prop);
	/**
	 * metodo para eviar el correo al personal de servicio
	 * @param servicio
	 * @return
	 */
	public boolean enviarCorreoPServicio(Servicio servicio);
}
