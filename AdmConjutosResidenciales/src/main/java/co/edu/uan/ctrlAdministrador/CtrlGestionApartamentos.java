package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.ZonaDAO;
import co.edu.uan.torreBuilder.TorreBuilder;
import javafx.collections.ObservableList;
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
	private Label txtCostoParqueadero;

	@FXML
	private TableColumn<?, ?> clTorre;

	@FXML
	private JFXTextField txtApartamento;

	@FXML
	private Label txtCostoAdmin;

	@FXML
	private JFXComboBox<String> cbTipo;

	@FXML
	private TableView<?> tvTabla;

	@FXML
	private TableColumn<?, ?> clTipo;

	@FXML
	private JFXButton btnEliminar;

	@FXML
	private TableColumn<?, ?> clApartamento;

	@FXML
	private JFXTextField txtTipoBusqueda;

	@FXML
	private JFXButton btnModificar;

	@FXML
	private JFXButton btnRegistrar;

	@FXML
	private JFXButton btnBuscar;
	@FXML
    private JFXTextField txtNumeroParZona;

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

		if (txtTorre.getText().equals("") || txtApartamento.getText().equals("") || tipo == null||txtNumeroParZona.getText().isEmpty()) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos del registro llenos");
		} else if (isNumeric(txtTorre.getText()) == false || isNumeric(txtApartamento.getText()) == false||isNumeric(txtNumeroParZona.getText())==false) {
			displayAlert(AlertType.INFORMATION, "DATOS INVALIDOS", "DEBE INGRESAR DATOS NUMERICOS ENTEROS EN EL CAMPO DE TORRE Y APARTAMENTOS");
		}else {
			
			ArrayList<Integer> numeroPuestosParq = new ArrayList<>();
			
			for(int i=1; i<=Integer.parseInt(txtNumeroParZona.getText()); i++) {
				numeroPuestosParq.add(i);
				
			}
			
			TorreBuilder torreBuilder = new TorreBuilder();
			int cuadruple=0;
			int apt=100;
			for(int i=0; i<Integer.parseInt(txtApartamento.getText()); i++) {
				cuadruple++;				
				apt++;
				if(cuadruple==5) {
					cuadruple=0;
					apt=apt+100-4;
				}
				torreBuilder.addApartamentos(apt, "", "");			
			}
			System.out.println(torreBuilder.setNumero(Integer.parseInt(txtTorre.getText()))
					.setZona(tipo, Float.parseFloat(txtCostoAdmin.getText()), numeroPuestosParq, Float.parseFloat(txtCostoParqueadero.getText()))
					.build().toString());	
			//ese build se pasa al dao de torre
			
		}

	}

	private boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	@FXML
	void buscar(ActionEvent event) {
		if (txtTipoBusqueda.getText().equals("")) {
			displayAlert(AlertType.INFORMATION, "CAMPO VACIO", "Debe tener el campo de busqueda lleno");
		} else {

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

	@FXML
	void cargarDatosZona(ActionEvent event) {
		// se pasa a un zonaDAO que devuelva los datos de esa zona
		ZonaDAO zonaDAO = new ZonaDAO();

		txtCostoAdmin.setText(zonaDAO.traerDatosDeZonaAdmin(cbTipo.getValue()));
		txtCostoParqueadero.setText(zonaDAO.traerDatosDeZonaParq(cbTipo.getValue()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ZonaDAO zonaDAO = new ZonaDAO();

		ObservableList<String> lista = zonaDAO.listZona();

		cbTipo.setItems(lista);
	}
}
