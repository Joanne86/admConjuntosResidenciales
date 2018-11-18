package co.edu.uan.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.LoginDAO;
import co.edu.uan.dao.ResidenteDAO;
import co.edu.uan.dao.TorreDAO;
import co.edu.uan.entidad.Arrendatario;
import co.edu.uan.torreBuilder.TorreApart;
import co.edu.uan.validatorchainofresponsability.AbstractPersonValidator;
import co.edu.uan.validatorchainofresponsability.PersonValidatorBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class CtrlRegistroArrendatario {

	@FXML
	private JFXTextField txtNombre;

	@FXML
	private JFXTextField txtTelefono;

	@FXML
	private ToggleGroup parqueadero;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private RadioButton rbNoP;

	@FXML
	private JFXTextField txtDocumento;

	@FXML
	private JFXButton btnRegistrar;

	@FXML
	private RadioButton rbSiP;

	/**
	 * metodo para registrar un arrendatario
	 * 
	 * @param event
	 */
	@FXML
	void registrar(ActionEvent event) {
		if (txtEmail.getText().isEmpty() || txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty()
				|| txtTelefono.getText().isEmpty() || (!rbSiP.isSelected() && !rbNoP.isSelected())) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");
		} else {
			guardarArrend();
		}
	}

	public void guardarArrend() {
		String parqueadero = "";
		String torreapart = "";

		TorreApart torreApart = new TorreApart();
		TorreDAO.getInstace().traerTorreApart(LoginDAO.getInstancePersona().getDocumento(), torreApart);

		if (rbSiP.isSelected()) {
			parqueadero = torreApart.getTorre() + "-" + torreApart.getApart();
			torreapart = parqueadero;
		} else if (rbNoP.isSelected()) {
			parqueadero = "No";
			torreapart = torreApart.getTorre() + "-" + torreApart.getApart();
		}
		if (ResidenteDAO.getInstance().verificarArrend(txtDocumento.getText())) {
			displayAlert(AlertType.INFORMATION, "ARRENDATARIO YA EXISTE",
					"El arrendatario con el documento " + txtDocumento.getText() + " ya existe");
		} else {

			Arrendatario arrendatario = new Arrendatario(txtDocumento.getText(), txtNombre.getText(),
					txtTelefono.getText(), txtEmail.getText(), parqueadero, torreapart);
			if(validarDatos(arrendatario)) {
				if (ResidenteDAO.getInstance().createArrendatario(arrendatario)) {
					displayAlert(AlertType.INFORMATION, "Registro exitoso", "Registro del arrendatario exitoso");
					limpiarCampos();
				} else {
					displayAlert(AlertType.ERROR, "ERROR AL REGISTRAR", "Error al registrar arrendatario");
				}
			}	
		}
	}

	public boolean validarDatos(Arrendatario arrendatario)  {
		boolean validado=false;
		AbstractPersonValidator validator = PersonValidatorBuilder.buildPersonValidator();
		try {
			if (validator.validate(arrendatario)) {
				validado=true;
			}
		} catch (Exception e) {
			validado=false;			
		}
		return validado;
	}

	public void limpiarCampos() {
		txtDocumento.setText("");
		txtEmail.setText("");
		txtNombre.setText("");
		txtDocumento.setText("");
		txtTelefono.setText("");
		rbSiP.setSelected(false);
		rbNoP.setSelected(false);
	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
