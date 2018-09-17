package co.edu.uan.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class CtrlModuloAdmin implements Initializable{

	 @FXML
	    private JFXButton btnRegistroResidente;

	    @FXML
	    private AnchorPane rootPane;
	    @FXML
	    private AnchorPane rootPre;

	    AnchorPane pane2;
    @FXML
    void registrarPropietario(ActionEvent event) throws IOException {
    	if (pane2 == null) {
    		
			pane2 = FXMLLoader.load(getClass().getResource("/view/Registro1.fxml"));
			pane2.setLayoutX(243);
			pane2.setLayoutY(0);
			rootPane.getChildren().remove(rootPre);
			rootPane.getChildren().add(pane2);
			
			pane2.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
			pane2.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width-243);
			
		} else {
			pane2.toFront();
		}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//inicializar combos de torre y apartamento de la base de datos, carga los desocupados		
	}
}
