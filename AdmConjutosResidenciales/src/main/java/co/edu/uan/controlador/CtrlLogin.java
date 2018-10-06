package co.edu.uan.controlador;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.LoginDAO;
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

	static Stage primaryStage = new Stage();
	Parent root;

	@FXML
	void ingresar(ActionEvent event) throws IOException {

		if (txtPass.getText().equals("") || txtUser.getText().equals("")) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos llenos");
		} else {
			LoginDAO loginDAO = new LoginDAO();

			if (loginDAO.iniciarSesion(txtUser.getText(), txtPass.getText())) {

				root = FXMLLoader.load(getClass().getResource("/view/PrincipalAdmin.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);

				primaryStage.show();
				primaryStage.setMaximized(true);
				
				if(AppAdminConjuntos.stage!=null) {
					AppAdminConjuntos.cerrarVentana();
				}
				if(CtrlPanelMenuAdmin.primaryStage!=null) {
					CtrlPanelMenuAdmin.cerrarVentana();
				}
			} else {
				displayAlert(AlertType.INFORMATION, "Error al ingresar",
						"Usuario y/o contraseña incorrectos" + ", verifique su usuario y contraseña");
			}
		}
	}

	public static void cerrarVentana() {
		primaryStage.close();
	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
