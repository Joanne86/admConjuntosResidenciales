package co.edu.uan.validatorchainofresponsability;

public class PersonValidatorBuilder {
	public static final AbstractPersonValidator buildPersonValidator() {
		AbstractPersonValidator validator = new PersonValidator();
		validator.setValidator(new PersonDataValidator());
		return validator;
	}	
}
