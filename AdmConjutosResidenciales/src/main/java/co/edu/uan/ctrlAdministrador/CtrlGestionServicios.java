package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.ServicioDAO;
import co.edu.uan.entidad.Servicio;
import co.edu.uan.envioCorreoProxy.Correo;
import co.edu.uan.envioCorreoProxy.ProxyEnvioCorreo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CtrlGestionServicios implements Initializable {

	@FXML
	private JFXButton btnReporte;

	@FXML
	private TableColumn<Servicio, String> clCorreo;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private TableColumn<Servicio, String> clServicio;

	@FXML
	private TableColumn<Servicio, String> clNombre;

	@FXML
	private TableColumn<Servicio, String> clHorario;

	@FXML
	private JFXTextField txtDocumento;

	@FXML
	private JFXTextField txtHorario;

	@FXML
	private JFXTextField txtNombre;

	@FXML
	private TableView<Servicio> tvTabla;

	@FXML
	private JFXTextField txtNdocumento;

	@FXML
	private TableColumn<Servicio, String> clTelefono;

	@FXML
	private JFXButton btnEliminar;

	@FXML
	private TableColumn<Servicio, String> clDocumento;

	@FXML
	private JFXTextField txtTelefono;

	@FXML
	private DatePicker calenFechaNac;

	@FXML
	private JFXComboBox<String> cbServicio;

	@FXML
	private JFXButton btnRegistrar;

	@FXML
	private JFXButton btnModificar;

	@FXML
	private JFXButton btnBuscar;

	@FXML
	private TableColumn<Servicio, String> clFechaNac;

	@FXML
	private JFXButton btnActualizar;

	private ObservableList<Servicio> listaServ;

	@FXML
	void buscar(ActionEvent event) {

	}

	@FXML
	void registrar(ActionEvent event) {

		if (txtDocumento.getText().isEmpty() || txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty()
				|| txtTelefono.getText().isEmpty() || txtHorario.getText().isEmpty() || cbServicio.getValue() == null
				|| calenFechaNac.getValue() == null) {
			displayAlert(AlertType.WARNING, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");
		} else {
			if (ServicioDAO.getInstance().verificarPServicio(txtDocumento.getText())) {
				displayAlert(AlertType.INFORMATION, "PERSONAL DE SERVICIO EXISTENTE",
						"El personal de servicio con el documento " + txtDocumento.getText() + " ya existe");
			} else {
				Servicio servicio = new Servicio(txtDocumento.getText(), txtNombre.getText(), txtTelefono.getText(),
						calenFechaNac.getValue().toString(), txtEmail.getText(), cbServicio.getValue(),
						txtHorario.getText());
				Correo proxyEnvio = new ProxyEnvioCorreo();
				if (proxyEnvio.enviarCorreoPServicio(servicio)) {
					if (ServicioDAO.getInstance().createPServicio(servicio)) {

						displayAlert(AlertType.INFORMATION, "Registro exitoso",
								"Registro del personal de servicio fue exitoso, el cargo y el horario se acaba de enviar al correo electronico del personal");
						listaServ.add(servicio);
						limpiarcampos();
					} else {
						displayAlert(AlertType.ERROR, "Error guardar personal de servicio", "Error al guardar el persona de servicio");
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
		txtTelefono.setText("");
		cbServicio.setValue(null);
		txtHorario.setText("");
	}

	@FXML
	void eliminar(ActionEvent event) {

	}

	@FXML
	void modificar(ActionEvent event) {

	}

	@FXML
	void generarReporte(ActionEvent event) {

	}

	@FXML
	void actualizar(ActionEvent event) {
		inicializarComboServicios();
		inicializarTabla();
	}

	public void inicializarComboServicios() {
		try {
			ObservableList<String> listaServ = FXCollections.observableArrayList();
			ServicioDAO.getInstance().traerServicios(listaServ);
			cbServicio.setItems(listaServ);
		} catch (NullPointerException e) {

		}
	}

	public void inicializarTabla() {
		listaServ = FXCollections.observableArrayList();
		ServicioDAO.getInstance().traerDatosTabla(listaServ);
		
		tvTabla.setItems(listaServ);

		clDocumento.setCellValueFactory(new PropertyValueFactory<Servicio, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombre"));
		clTelefono.setCellValueFactory(new PropertyValueFactory<Servicio, String>("telefono"));
		clFechaNac.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nacimiento"));
		clCorreo.setCellValueFactory(new PropertyValueFactory<Servicio, String>("correo"));
		clServicio.setCellValueFactory(new PropertyValueFactory<Servicio, String>("servicio"));
		clHorario.setCellValueFactory(new PropertyValueFactory<Servicio, String>("horario"));
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		inicializarComboServicios();
		inicializarTabla();
	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
