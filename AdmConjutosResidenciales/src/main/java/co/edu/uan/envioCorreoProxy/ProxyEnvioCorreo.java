package co.edu.uan.envioCorreoProxy;


import co.edu.uan.entidad.Propietario;
import co.edu.uan.entidad.Servicio;
import co.edu.uan.validatorchainofresponsability.AbstractPersonValidator;
import co.edu.uan.validatorchainofresponsability.PersonValidatorBuilder;

public class ProxyEnvioCorreo implements Correo{

	@Override
	public boolean enviarCorreoResidente(Propietario prop) {
		boolean envio=false;
		try {            
			AbstractPersonValidator validator
                    = PersonValidatorBuilder.buildPersonValidator();
            if(validator.validate(prop)) {
            	Correo envioCorreo = new EnvioCorreo();
				envio= envioCorreo.enviarCorreoResidente(prop);			
            }         
        } catch (Exception e) {
             }
		return envio;
	}
	
	@Override
	public boolean enviarCorreoPServicio(Servicio servicio) {
		boolean envio=false;
		
		try {            
			AbstractPersonValidator validator
                    = PersonValidatorBuilder.buildPersonValidator();
            if(validator.validate(servicio)) {
            	Correo envioCorreo = new EnvioCorreo();
				envio= envioCorreo.enviarCorreoPServicio(servicio);		
            }         
        } catch (Exception e) {
             }
		return envio;
	}	
}
