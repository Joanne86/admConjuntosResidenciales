package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.TorreDAO;
import co.edu.uan.dao.ZonaDAO;
import co.edu.uan.torreBuilder.TorreBuilder;
import co.edu.uan.torreBuilder.TorreCom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

public class CtrlGestionApartamentos implements Initializable {

	@FXML
	private JFXTextField txtTorre;
	@FXML
	private JFXButton btnCargar;
	@FXML
	private TableColumn<TorreCom, String> clPuestos;

	@FXML
	private TableColumn<TorreCom, String> clCosto;

	@FXML
	private Label txtCostoParqueadero;

	@FXML
	private TableColumn<TorreCom, String> clTorre;

	@FXML
	private JFXTextField txtApartamento;

	@FXML
	private Label txtCostoAdmin;

	@FXML
	private JFXComboBox<String> cbTipo;

	@FXML
	private TableColumn<TorreCom, String> clTipo;

	@FXML
	private TableColumn<TorreCom, String> clApartamento;

	@FXML
	private JFXTextField txtTipoBusqueda;

	@FXML
	private JFXButton btnRegistrar;

	@FXML
	private JFXButton btnBuscar;
	@FXML
	private JFXTextField txtNumeroParZona;

	@FXML
	private TableView<TorreCom> tvTabla;

	// colecciones
	private ObservableList<TorreCom> listaTorre;

	private String idZona;

	/**
	 * metodo para registrar torres y apartamentos
	 * @param event
	 */
	@FXML
	void registrar(ActionEvent event) {
		String tipo = null;
		tipo = cbTipo.getValue();

		if (txtTorre.getText().equals("") || txtApartamento.getText().equals("") || tipo == null
				|| txtNumeroParZona.getText().isEmpty()) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos del registro llenos");
		} else if (isNumeric(txtTorre.getText()) == false || isNumeric(txtApartamento.getText()) == false
				|| isNumeric(txtNumeroParZona.getText()) == false) {
			displayAlert(AlertType.INFORMATION, "DATOS INVALIDOS",
					"DEBE INGRESAR DATOS NUMERICOS ENTEROS EN EL CAMPO DE TORRE Y APARTAMENTOS");
		
		} else if(Integer.parseInt(txtApartamento.getText())>24||Integer.parseInt(txtApartamento.getText())<=0){
			displayAlert(AlertType.WARNING, "DATOS INVALIDOS",
					"El numero de apartamentos por cada torre no debe de superar los 24 y no puede ser menor o igual a 0");			
		}else{
		

			ArrayList<String> numeroPuestosParq = new ArrayList<>();

			int cuadruple1 = 0;
			int puestos = 100;

			for (int i = 0; i < Integer.parseInt(txtNumeroParZona.getText()); i++) {
				if (cuadruple1 == 4) {
					cuadruple1 = 0;
					puestos = puestos + 100 - 4;
				}
				cuadruple1++;
				puestos++;
				numeroPuestosParq.add(txtTorre.getText() + "-" + puestos);

			}

			TorreBuilder torreBuilder = new TorreBuilder();
			int cuadruple = 0;
			int apt = 100;
			for (int i = 0; i < Integer.parseInt(txtApartamento.getText()); i++) {

				if (cuadruple == 4) {
					cuadruple = 0;
					apt = apt + 100 - 4;
				}
				cuadruple++;
				apt++;
				torreBuilder.addApartamentos(apt, "", "");
			}

			if (TorreDAO.getInstace().verificarTorre(txtTorre.getText())) {
				displayAlert(AlertType.INFORMATION, "TORRE EXISTENTE", "El numero de la torre ya existe");
			} else {
				if (TorreDAO.getInstace().createTorre(torreBuilder.setNumero(Integer.parseInt(txtTorre.getText()))
										.setZona(idZona, tipo, Float.parseFloat(txtCostoAdmin.getText()),
										numeroPuestosParq, Float.parseFloat(txtCostoParqueadero.getText()))
										.build())) {
					displayAlert(AlertType.INFORMATION, "TORRE CREADA", "Torre guardada con exito");

					float suma = Float.parseFloat(txtCostoAdmin.getText())
							+ Float.parseFloat(txtCostoParqueadero.getText());
					//agrega a la tabla
					listaTorre.add(new TorreCom(txtTorre.getText(), txtApartamento.getText(), tipo,
							txtNumeroParZona.getText(), Float.toString(suma)));
					//limpia los campos
					limpiarCampos();
				} else {
					displayAlert(AlertType.ERROR, "ERROR", "ERROR al guardar la torre");
				}
			}

		}

	}

	public void limpiarCampos() {
		txtTorre.setText(null);
		txtApartamento.setText(null);
		txtNumeroParZona.setText(null);
		txtTipoBusqueda.setText(null);
		txtCostoAdmin.setText("0");
		txtCostoParqueadero.setText("0");
		cbTipo.setValue(null);
	}
	/**
	 * metodo para determinar si una cadena es numerico o no
	 * @param cadena evalua la cadena
	 * @return
	 */
	private boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
/**
 * metodo para filtrar las torres por zona
 * @param event
 */
	@FXML
	void buscar(ActionEvent event) {
		if (txtTipoBusqueda.getText().equals("")) {
			displayAlert(AlertType.INFORMATION, "CAMPO VACIO", "Debe tener el campo de busqueda lleno");
		} else {

			
			listaTorre = FXCollections.observableArrayList();

			TorreDAO.getInstace().buscarZona(listaTorre, txtTipoBusqueda.getText());
			tvTabla.setItems(listaTorre);

			clTorre.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("numero"));
			clApartamento.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("naptos"));
			clTipo.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("zona"));
			clPuestos.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("puestos"));
			clCosto.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("costo"));

		}
	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	/**
	 * metodo para cargar datos de la zona segun sea la seleccionada
	 * @param event
	 */
	@FXML
	void cargarDatosZona(ActionEvent event) {
		txtCostoAdmin.setText(ZonaDAO.getInstance().traerDatosDeZonaAdmin(cbTipo.getValue()));
		txtCostoParqueadero.setText(ZonaDAO.getInstance().traerDatosDeZonaParq(cbTipo.getValue()));
		idZona = ZonaDAO.getInstance().traerDatosDeZonaId(cbTipo.getValue());
	}

	public void iniciarlizarLista() {
		listaTorre = FXCollections.observableArrayList();
		TorreDAO torreDAO = TorreDAO.getInstace();

		torreDAO.traerDatosTabla(listaTorre);

		tvTabla.setItems(listaTorre);

		clTorre.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("numero"));
		clApartamento.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("naptos"));
		clTipo.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("zona"));
		clPuestos.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("puestos"));
		clCosto.setCellValueFactory(new PropertyValueFactory<TorreCom, String>("costo"));
	}

	@FXML
	void refresacar(ActionEvent event) {
		iniciarlizarLista();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<String> lista = ZonaDAO.getInstance().listZona();
		cbTipo.setItems(lista);
		iniciarlizarLista();
	}
}
