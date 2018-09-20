package co.edu.uan.controlador;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CtrlLogin {

	@FXML
	private JFXPasswordField txtPass;

	@FXML
	private JFXTextField txtUser;

	@FXML
	private JFXButton btnIngresar;
	
	static Stage stage1;

	@FXML
	void ingresar(ActionEvent event) throws IOException {
		if (txtPass.getText().equals("") || txtUser.getText().equals("")) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos llenos");
		} else {
			//se va al dao de sesion
			
			//si es admin
			Stage primaryStage = new Stage();			
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/view/PrincipalAdmin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);

			primaryStage.show();
			primaryStage.setMaximized(true);
			//primaryStage.resizableProperty().setValue(Boolean.FALSE);
			stage1=primaryStage;
			AppAdminConjuntos.cerrarVentana();
		}
	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
