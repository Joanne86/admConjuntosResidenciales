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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CtrlMenuProp implements Initializable{
	

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbRol;

    @FXML
    private JFXButton btnQuejasSugerencias;

    @FXML
    private JFXButton btnGestionarArrendatarios;

    @FXML
    private JFXButton btnCerrarSesion;
    @FXML
    private JFXButton btnPagoAdmin;


    static AnchorPane pane2;
	static AnchorPane pane3;
	static AnchorPane pane4;

	public static Stage primaryStage;

	/**
	 * metodo para abrir la vista pricipal al cerrar sesion
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
    	primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.show();
		primaryStage.setMaximized(true);
		pane2=null;
		pane3=null;
		pane4=null;
		CtrlLogin.cerrarVentana();
    }
    
    public static void cerrarVentana() {
		primaryStage.close();
	}

    @FXML
    void gestionarArrendatarios(ActionEvent event) throws IOException {
    	CtrlMenuPrincipal.drawer1.close();
		if (pane4 == null) {

			pane4 = FXMLLoader.load(getClass().getResource("/view/RegistroArrendatario.fxml"));
			pane4.setLayoutX(0);
			pane4.setLayoutY(45);

			CtrlMenuPrincipal.rootP.getChildren().add(pane4);
			pane4.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane4.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane4.toFront();
		}
    }
    /**
     * metodo para abrir la vista se pago de administracion por parte del propietario
     * @param event
     * @throws IOException
     */
    @FXML
    void pagarAdministracion(ActionEvent event) throws IOException {
    	CtrlMenuPrincipal.drawer1.close();
		if (pane3 == null) {

			pane3 = FXMLLoader.load(getClass().getResource("/view/PagoAdminProp.fxml"));
			pane3.setLayoutX(0);
			pane3.setLayoutY(45);

			CtrlMenuPrincipal.rootP.getChildren().add(pane3);
			pane3.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane3.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane3.toFront();
		}
    }

    /**
     * metodo para abrir la vista de quejas y sigerencias por parte del propietario
     * @param event
     * @throws IOException
     */
    @FXML
    void quejasSugerencias(ActionEvent event) throws IOException {
    	CtrlMenuPrincipal.drawer1.close();
		if (pane2 == null) {

			pane2 = FXMLLoader.load(getClass().getResource("/view/QuejasSugerenciasProp.fxml"));
			pane2.setLayoutX(0);
			pane2.setLayoutY(45);

			CtrlMenuPrincipal.rootP.getChildren().add(pane2);
			pane2.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane2.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		} else {
			pane2.toFront();
		}
    }  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbRol.setText(LoginDAO.getInstancePersona().getLogin().getTipoPersona());
		lbNombre.setText(LoginDAO.getInstancePersona().getNombre());
	
	}


}