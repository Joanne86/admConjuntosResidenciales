package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class CtrlGestionApartamentos implements Initializable {

	@FXML
	private JFXTextField txtTorre;

	@FXML
	private TableColumn<?, ?> clCosto;

	@FXML
	private TableColumn<?, ?> clTorre;

	@FXML
	private Label txtCostoMoto;

	@FXML
	private JFXTextField txtApartamento;

	@FXML
	private Label txtCostoAdmin;

	@FXML
	private JFXComboBox<String> cbTipo;

	@FXML
	private TableView<?> tvTabla;

	@FXML
	private Label txtCostoCarro;

	@FXML
	private TableColumn<?, ?> clTipo;

	@FXML
	private JFXButton btnEliminar;

	@FXML
	private TableColumn<?, ?> clApartamento;

	@FXML
	private JFXButton btnMostrarTodo;

	@FXML
	private JFXTextField txtTipoBusqueda;

	@FXML
	private JFXButton btnModificar;

	@FXML
	private JFXButton btnRegistrar;

	@FXML
	private JFXButton btnBuscar;

	@FXML
	void modificar(ActionEvent event) {

	}

	@FXML
	void eliminar(ActionEvent event) {

	}

	@FXML
	void registrar(ActionEvent event) {
		String tipo = null;
		tipo = cbTipo.getValue();
		
		float adminRecargoPark;
		adminRecargoPark=Float.parseFloat(txtCostoAdmin.getText())+Float.parseFloat(txtCostoCarro.getText())+Float.parseFloat(txtCostoMoto.getText());

		if (txtTorre.getText().equals("") || txtApartamento.getText().equals("") || txtCostoAdmin.getText().equals("")|| tipo == null||adminRecargoPark==0) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos del registro llenos");
		} else {
			//valida la existencia del numero de la torre
			
			try {
				
			}catch(NumberFormatException e) {
				
			}
			
		}
	}

	@FXML
	void buscar(ActionEvent event) {
		if(txtTipoBusqueda.getText().equals("")) {
			displayAlert(AlertType.INFORMATION, "CAMPO VACIO", "Debe tener el campo de busqueda lleno");
		}else {
			
		}
	}

	@FXML
	void mostrarTodo(ActionEvent event) {

	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// cargar tabla de la bd y combo box

	}
}
