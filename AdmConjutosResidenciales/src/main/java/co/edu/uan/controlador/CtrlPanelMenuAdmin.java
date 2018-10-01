package co.edu.uan.controlador;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class CtrlPanelMenuAdmin {

	@FXML
	private JFXButton btnRegistroResidente;

	static AnchorPane pane2;

	static AnchorPane pane3;
	static AnchorPane pane4;
	static AnchorPane pane5;
	
	@FXML
	void registrarPropietario(ActionEvent event) throws IOException {
		CtrlPanelAdmin.drawer1.close();
		if (pane2 == null) {

			pane2 = FXMLLoader.load(getClass().getResource("/view/GestionPropietarios.fxml"));
			pane2.setLayoutX(0);
			pane2.setLayoutY(45);

			CtrlPanelAdmin.rootP.getChildren().add(pane2);
			pane2.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane2.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane2.toFront();
		}
	}

	@FXML
	void registrarVisitante(ActionEvent event) throws IOException {

		CtrlPanelAdmin.drawer1.close();
		if (pane3 == null) {

			pane3 = FXMLLoader.load(getClass().getResource("/view/RegistroVisitantes.fxml"));
			pane3.setLayoutX(0);
			pane3.setLayoutY(45);
			CtrlPanelAdmin.rootP.getChildren().add(pane3);
			pane3.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane3.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane3.toFront();
			// actualizar tabla de bases de datos.
		}
	}

	@FXML
	void pagosAdmin(ActionEvent event) throws IOException {
		CtrlPanelAdmin.drawer1.close();
		if (pane4 == null) {

			pane4 = FXMLLoader.load(getClass().getResource("/view/PagosAdmin.fxml"));
			pane4.setLayoutX(0);
			pane4.setLayoutY(45);
			CtrlPanelAdmin.rootP.getChildren().add(pane4);
			pane4.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane4.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane4.toFront();
			// actualizar tabla de bases de datos.
		}
	}

	@FXML
	void gestionarApartamentos(ActionEvent event) throws IOException {
		CtrlPanelAdmin.drawer1.close();
		if (pane5 == null) {

			pane5 = FXMLLoader.load(getClass().getResource("/view/GestionApartamentos.fxml"));
			pane5.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane5.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			pane5.setLayoutX(0);
			pane5.setLayoutY(45);
			CtrlPanelAdmin.rootP.getChildren().add(pane5);
			
		} else {
			pane5.toFront();
			// actualizar tabla de bases de datos.
		}
	}
}
