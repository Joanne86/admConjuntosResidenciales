package co.edu.uan.validatorchainofresponsability;

import co.edu.uan.entidad.Persona;

public abstract class AbstractPersonValidator {
	protected  AbstractPersonValidator validator;
	
	public abstract boolean validate(Persona persona) throws ValidationException;
    
	public void setValidator(AbstractPersonValidator validator){
        this.validator=validator;
    }
}
