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
    
    AnchorPane pane2;
    
    @FXML
    void registrarPropietario(ActionEvent event) throws IOException {
    	if (pane2 == null) {
    		
			pane2 = FXMLLoader.load(getClass().getResource("/view/Registro1.fxml"));
			pane2.setLayoutX(0);
			pane2.setLayoutY(0);
			
			CtrlPanelAdmin.rootP.getChildren().add(pane2);
			pane2.toBack();
			pane2.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
			pane2.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			
		} else {
			pane2.toBack();
			CtrlPanelAdmin.panelMenu.toFront();
		}
    }
}
