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

	@FXML
	void registrarPropietario(ActionEvent event) throws IOException {
		CtrlPanelAdmin.drawer1.close();
		if (pane2 == null) {

			pane2 = FXMLLoader.load(getClass().getResource("/view/Registro1.fxml"));
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
		}
	}

}
