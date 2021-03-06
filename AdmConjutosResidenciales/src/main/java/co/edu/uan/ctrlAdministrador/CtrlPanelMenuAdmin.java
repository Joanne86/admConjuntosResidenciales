package co.edu.uan.ctrlAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import co.edu.uan.controlador.CtrlLogin;
import co.edu.uan.controlador.CtrlMenuPrincipal;
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

public class CtrlPanelMenuAdmin implements Initializable {

	@FXML
	private JFXButton btnQuejasSugerencias;

	@FXML
	private JFXButton btnGestionarServicios;

	@FXML
	private JFXButton btnRegistroVisitante;

	@FXML
	private JFXButton btnRegistroResidente;

	@FXML
	private Label lbNombre;

	@FXML
	private Label lbRol;

	@FXML
	private JFXButton btnCerrarSesion;

	@FXML
	private JFXButton btnConsultarArrendatarios;

	@FXML
	private JFXButton btnGestionarApartamentos;

	@FXML
	private JFXButton btnPagoAdmin;


	static AnchorPane pane2;
	static AnchorPane pane3;
	static AnchorPane pane4;
	static AnchorPane pane5;
	static AnchorPane pane6;
	static AnchorPane pane7;
	static AnchorPane pane8;

	public static Stage primaryStage;

	/**
	 * metodo para abrir la vista de registro de propietarios
	 * @param event
	 * @throws IOException
	 */
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

	/**
	 * metodo para abrir la vista de registrar visitante
	 * @param event
	 * @throws IOException
	 */
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

	/**
	 * metodo para abrir la vista de pagos de administracion
	 */
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

	/**
	 * metodo para abrir la vista de gestion de apartamentos
	 * @param event
	 * @throws IOException
	 */
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
	/**
	 * metodo para abrir la vista de consulta de arrendatarios
	 * @param event
	 * @throws IOException
	 */
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
		}
	}

	/**
	 * metodo para abrir la vista de recepcion de quejas y o sigerencias
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void quejasSugerencias(ActionEvent event) throws IOException {
		CtrlMenuPrincipal.drawer1.close();
		if (pane7 == null) {

			pane7 = FXMLLoader.load(getClass().getResource("/view/QuejasSugerencias.fxml"));
			pane7.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane7.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			pane7.setLayoutX(0);
			pane7.setLayoutY(45);
			CtrlMenuPrincipal.rootP.getChildren().add(pane7);

		} else {
			pane7.toFront();
		}
	}
	/**
	 * metodo para abrir la vista de gestion del personal de servicios
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void gestionarServicios(ActionEvent event) throws IOException {
    	CtrlMenuPrincipal.drawer1.close();
		if (pane8 == null) {

			pane8 = FXMLLoader.load(getClass().getResource("/view/GestionServicios.fxml"));
			pane8.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 45);
			pane8.setPrefWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			pane8.setLayoutX(0);
			pane8.setLayoutY(45);
			CtrlMenuPrincipal.rootP.getChildren().add(pane8);

		} else {
			pane8.toFront();
		}
    }

	/**
	 * metodo para cerrar la vista de administracion y volver a la vista principal 
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

		CtrlLogin.cerrarVentana();
	}

	public static void cerrarVentana() {
		primaryStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbRol.setText(LoginDAO.getInstancePersona().getLogin().getTipoPersona());
		lbNombre.setText(LoginDAO.getInstancePersona().getNombre());
	}

}
