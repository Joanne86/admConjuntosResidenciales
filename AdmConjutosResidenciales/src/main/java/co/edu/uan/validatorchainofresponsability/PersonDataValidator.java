package co.edu.uan.validatorchainofresponsability;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.uan.entidad.Arrendatario;
import co.edu.uan.entidad.Persona;

public class PersonDataValidator extends AbstractPersonValidator {

	@Override
	public boolean validate(Persona persona) throws ValidationException {
		boolean validado = false;

		if (isNumeric(persona.getDocumento())) {
			if (isNumeric(persona.getTelefono())) {
				if (isEmail(persona.getCorreo())) {
					if (!(persona instanceof Arrendatario)) {
						if (mayorEdad(persona.getNacimiento())) {
							validado = true;
						} else {
							throw new ValidationException("Menor de edad",
									"la persona tiene que ser mayor de edad");
						}
					}else {
						validado = true;
					}
				} else {
					throw new ValidationException("correo electronico invalido", "Correo electronico invalido");
				}
			} else {
				throw new ValidationException("Numero telefono invalido", "Numero de telefono invalido");
			}
		} else {
			throw new ValidationException("Numero documento invalido", "Numero de documento invalido");
		}
		return validado;
	}

	private boolean isNumeric(String cadena) {
		int i = 0;
		if (cadena.charAt(0) == '-') {
			if (cadena.length() > 1) {
				i++;
			} else {
				return false;
			}
		}
		for (; i < cadena.length(); i++) {
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean isEmail(String email) {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	private boolean mayorEdad(String fecha) {
		boolean mayor = false;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		if (periodo.getYears() >= 18) {
			mayor = true;
		}

		return mayor;
	}
}
