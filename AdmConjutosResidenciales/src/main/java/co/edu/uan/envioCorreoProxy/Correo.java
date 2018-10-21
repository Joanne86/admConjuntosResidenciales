package co.edu.uan.envioCorreoProxy;

import co.edu.uan.entidad.Propietario;
import co.edu.uan.entidad.Servicio;

public interface Correo {
	public boolean enviarCorreoResidente(Propietario prop);
	public boolean enviarCorreoPServicio(Servicio servicio);
}
