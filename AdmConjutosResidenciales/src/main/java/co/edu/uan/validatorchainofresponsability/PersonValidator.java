package co.edu.uan.validatorchainofresponsability;

import co.edu.uan.entidad.Persona;

public class PersonValidator extends AbstractPersonValidator{

	@Override
	public boolean validate(Persona persona) throws ValidationException {
		 
		return validator.validate(persona);
	}

}
