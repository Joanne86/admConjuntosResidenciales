package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import co.edu.uan.dao.PropietarioDAO;
import co.edu.uan.dao.TorreDAO;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Propietario;
import co.edu.uan.entidad.PropietarioTabla;
import co.edu.uan.envioCorreoProxy.Correo;
import co.edu.uan.envioCorreoProxy.ProxyEnvioCorreo;
import co.edu.uan.torreBuilder.Apartamento;

public class CtrlRegistro implements Initializable {

	@FXML
	private JFXButton btnActualizarTv;

	@FXML
	private TableColumn<PropietarioTabla, String> clCorreo;

	@FXML
	private ToggleGroup reside;

	@FXML
	private ToggleGroup parqueadero;

	@FXML
	private TableColumn<PropietarioTabla, String> clTorre;

	@FXML
	private TableColumn<PropietarioTabla, String> clNombre;

	@FXML
	private JFXTextField txtDocumento;

	@FXML
	private JFXTextField txtNombre;

	@FXML
	private TableView<PropietarioTabla> tvTabla;

	@FXML
	private RadioButton rbNoR;

	@FXML
	private TableColumn<PropietarioTabla, String> clDocumento;

	@FXML
	private JFXTextField txtTelefono;

	@FXML
	private RadioButton rbSiR;

	@FXML
	private RadioButton rbSiP;

	@FXML
	private TableColumn<PropietarioTabla, String> clFechaNac;

	@FXML
	private TableColumn<PropietarioTabla, String> clParqueadero;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private RadioButton rbNoP;

	@FXML
	private TableColumn<PropietarioTabla, String> clReside;

	@FXML
	private JFXTextField txtNdocumento;

	@FXML
	private JFXButton btnEliminar;

	@FXML
	private TableColumn<PropietarioTabla, String> clApart;

	@FXML
	private TableColumn<PropietarioTabla, String> clTelefono;

	@FXML
	private JFXComboBox<Integer> cbApart;

	@FXML
	private DatePicker calenFechaNac;

	@FXML
	private JFXComboBox<Integer> cbTorre;

	@FXML
	private JFXButton btnRegistrar;

	@FXML
	private JFXButton btnModificar;

	@FXML
	private JFXButton btnBuscar;

	// colecciones
	private ObservableList<PropietarioTabla> listaProp;

	@FXML
	void buscar(ActionEvent event) {

		if (txtNdocumento.getText().isEmpty()) {
			displayAlert(AlertType.INFORMATION, "CAMPO DE BUSQUEDA VACIO", "Debe tener el campo de busqueda lleno");
		} else {
			PropietarioDAO propDAO = new PropietarioDAO();
			listaProp = FXCollections.observableArrayList();
			propDAO.buscarProp(txtNdocumento.getText(), listaProp);
			tvTabla.setItems(listaProp);
			clDocumento.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("documento"));
			clNombre.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("nombre"));
			clTelefono.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("telefono"));
			clFechaNac.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("fecha"));
			clCorreo.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("correo"));
			clTorre.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("torre"));
			clApart.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("apart"));
			clReside.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("reside"));
			clParqueadero.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("reside"));

		}
	}

	@FXML
	void registrar(ActionEvent event) {

		if (txtDocumento.getText().isEmpty() || calenFechaNac.getValue() == null || txtEmail.getText().isEmpty()
				|| txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || cbTorre.getValue() == null
				|| cbApart.getValue() == null || txtTelefono.getText().isEmpty()
				|| (!rbSiP.isSelected() && !rbNoP.isSelected()) || (!rbSiR.isSelected() && !rbNoR.isSelected())) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");
		} else {
			// Generacion de clave aleatoria para el nuevo propietario
			String clave = UUID.randomUUID().toString().toUpperCase().substring(0, 6);
			Login login = new Login();
			login.setUsuario(txtDocumento.getText());
			login.setContraseña(clave);
			login.setTipoPersona("2");
			// OBJETO APARTAMENTO
			String reside = "";
			String parqueadero = "";
			if (rbSiR.isSelected()) {
				reside = "si";
			} else if (rbNoR.isSelected()) {
				reside = "no";
			}
			if (rbSiP.isSelected()) {
				parqueadero = "si";
			} else if (rbNoP.isSelected()) {
				System.out.println("entra aqui");
				parqueadero = "no";
			}
			int torre = cbTorre.getValue();
			Apartamento apart = new Apartamento(cbApart.getValue(), reside, parqueadero);
			// OBJETO PROPIETARIO

			Propietario propietario = new Propietario(Integer.parseInt(txtDocumento.getText()), txtNombre.getText(),
					txtTelefono.getText(), calenFechaNac.getValue().toString(), txtEmail.getText(), login, torre,
					apart);
			PropietarioDAO propDAO = new PropietarioDAO();
			if (propDAO.verificarProp(txtDocumento.getText())) {
				displayAlert(AlertType.INFORMATION, "PROPIETARIO YA EXISTE",
						"El propietario con el documento " + txtDocumento.getText() + " ya existe");
			} else {
				Correo proxyEnvio = new ProxyEnvioCorreo();
				if (proxyEnvio.enviarCorreo(propietario)) {

					if (propDAO.createPropietario(propietario)) {

						displayAlert(AlertType.INFORMATION, "Registro exitoso",
								"Registro del propietario exitoso, el usuario y la contraseña se acaba de enviar al correo electronico del propietario");
						listaProp.add(new PropietarioTabla(txtDocumento.getText(), txtNombre.getText(),
								txtTelefono.getText(), calenFechaNac.getValue().toString(), txtEmail.getText(),
								Integer.toString(torre), cbApart.getValue().toString(), reside, parqueadero));
						limpiarcampos();
					} else {
						displayAlert(AlertType.ERROR, "Error guardar Propietario", "Error al guardar el Propietario");
					}
				}
			}
		}
	}

	public void limpiarcampos() {
		txtDocumento.setText("");
		calenFechaNac.setValue(null);
		txtEmail.setText("");
		txtNombre.setText("");
		txtDocumento.setText("");
		cbTorre.getSelectionModel().clearSelection();
		cbApart.getSelectionModel().clearSelection();
		txtTelefono.setText("");
		rbSiP.setSelected(false);
		rbNoP.setSelected(false);
		rbSiR.setSelected(false);
		rbNoR.setSelected(false);
		// inicializarTorres();

	}

	@FXML
	void eliminar(ActionEvent event) {

	}

	@FXML
	void modificar(ActionEvent event) {

	}

	@FXML
	void actualizarDatos(ActionEvent event) {
		inicializarTorres();
		inicializarTabla();
	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	void seleccionTorre(ActionEvent event) {
		try {
			ObservableList<Integer> listaAptos = FXCollections.observableArrayList();
			TorreDAO torreDAO = new TorreDAO();

			torreDAO.traerAptos(listaAptos, cbTorre.getValue());
			cbApart.setItems(listaAptos);
		} catch (NullPointerException e) {

		}
	}

	@FXML
	void seleccionApart(ActionEvent event) {

		if (cbApart.getItems().size() == 0) {
			displayAlert(AlertType.ERROR, "SELECCIONE UNA TORRE", "SELECCIONE UNA TORRE PRIMER");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializarTorres();
		inicializarTabla();
	}

	public void inicializarTabla() {
		listaProp = FXCollections.observableArrayList();

		PropietarioDAO propDAO = new PropietarioDAO();

		propDAO.traerDatosTabla(listaProp);

		tvTabla.setItems(listaProp);

		clDocumento.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("nombre"));
		clTelefono.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("telefono"));
		clFechaNac.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("fecha"));
		clCorreo.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("correo"));
		clTorre.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("torre"));
		clApart.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("apart"));
		clReside.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("reside"));
		clParqueadero.setCellValueFactory(new PropertyValueFactory<PropietarioTabla, String>("parqueadero"));

	}

	public void inicializarTorres() {
		try {

			ObservableList<Integer> listaTorres = FXCollections.observableArrayList();

			TorreDAO torreDAO = new TorreDAO();
			torreDAO.traerTorres(listaTorres);

			cbTorre.setItems(listaTorres);
		} catch (NullPointerException e) {

		}
	}

}
