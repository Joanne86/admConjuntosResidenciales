package co.edu.uan.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import co.edu.uan.dao.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CtrlPanelMenuAdmin implements Initializable {

	@FXML
	private JFXButton btnQuejasSugerencias;

	@FXML
	private JFXButton btnRegistroVisitante;

	@FXML
	private JFXButton btnRegistroResidente;

	@FXML
	private Label lbNombre;

	@FXML
	private Label lbRol;

	@FXML
	private JFXButton btnConsultarArrendatarios;

	@FXML
	private JFXButton btnGestionarApartamentos;

	@FXML
	private JFXButton btnPagoAdmin;

	@FXML
	private JFXButton btnAsambleas;

	static AnchorPane pane2;

	static AnchorPane pane3;
	static AnchorPane pane4;
	static AnchorPane pane5;
	static AnchorPane pane6;

	@FXML
	void registrarPropietario(ActionEvent event) throws IOException {
		CtrlMenuPrincipal.drawer1.close();
		if (pane2 == null) {

			pane2 = FXMLLoader.load(getClass().getResource("/view/GestionPropietarios.fxml"));
			pane2.setLayoutX(0);
			pane2.setLayoutY(45);

			CtrlMenuPrincipal.rootP.getChildren().add(pane2);
			pane2.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane2.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane2.toFront();
		}
	}

	@FXML
	void registrarVisitante(ActionEvent event) throws IOException {

		CtrlMenuPrincipal.drawer1.close();
		if (pane3 == null) {

			pane3 = FXMLLoader.load(getClass().getResource("/view/RegistroVisitantes.fxml"));
			pane3.setLayoutX(0);
			pane3.setLayoutY(45);
			CtrlMenuPrincipal.rootP.getChildren().add(pane3);
			pane3.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane3.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane3.toFront();
			// actualizar tabla de bases de datos.
		}
	}

	@FXML
	void pagosAdmin(ActionEvent event) throws IOException {
		CtrlMenuPrincipal.drawer1.close();
		if (pane4 == null) {

			pane4 = FXMLLoader.load(getClass().getResource("/view/PagosAdmin.fxml"));
			pane4.setLayoutX(0);
			pane4.setLayoutY(45);
			CtrlMenuPrincipal.rootP.getChildren().add(pane4);
			pane4.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane4.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane4.toFront();
			// actualizar tabla de bases de datos.
		}
	}

	@FXML
	void gestionarApartamentos(ActionEvent event) throws IOException {
		CtrlMenuPrincipal.drawer1.close();
		if (pane5 == null) {

			pane5 = FXMLLoader.load(getClass().getResource("/view/GestionApartamentos.fxml"));
			pane5.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane5.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			pane5.setLayoutX(0);
			pane5.setLayoutY(45);
			CtrlMenuPrincipal.rootP.getChildren().add(pane5);

		} else {
			pane5.toFront();
			// actualizar tabla de bases de datos.
		}
	}

	@FXML
	void consultarArrendatarios(ActionEvent event) throws IOException {
		CtrlMenuPrincipal.drawer1.close();
		if (pane6 == null) {

			pane6 = FXMLLoader.load(getClass().getResource("/view/ConsultaArrendatarios.fxml"));
			pane6.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane6.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			pane6.setLayoutX(0);
			pane6.setLayoutY(45);
			CtrlMenuPrincipal.rootP.getChildren().add(pane6);

		} else {
			pane6.toFront();
			// actualizar tabla de bases de datos.
		}
	}

	@FXML
	void quejasSugerencias(ActionEvent event) {

	}

	@FXML
	void setAsamblea(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbRol.setText(LoginDAO.getInstancePersona().getLogin().getTipoPersona());
		lbNombre.setText(LoginDAO.getInstancePersona().getNombre());
	}

}
