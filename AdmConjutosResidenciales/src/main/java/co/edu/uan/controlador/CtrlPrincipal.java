package co.edu.uan.controlador;

import java.io.IOException;

import co.edu.uan.cifrar.metodo.Cifrado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;


public class CtrlPrincipal {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private TitledPane acmenu;

	@FXML
	private Button btnIniciarSesion;
	AnchorPane pane2;
	
	

	@FXML
	void iniciarSesion(ActionEvent event) throws IOException {
		if (pane2 == null) {
			pane2 = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			pane2.setLayoutX(243);
			pane2.setLayoutY(0);

			rootPane.getChildren().add(pane2);
			pane2.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
			pane2.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width-243);
		
		
		} else {
			pane2.toFront();
		}

	}
	
	
}
