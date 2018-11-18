package co.edu.uan.validatorchainofresponsability;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ValidationException extends Exception{
	
	public ValidationException(String message1, String message2) throws ValidationException {
        super(message1);
        displayAlert(AlertType.WARNING, message1, message2);
		
    }
	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
