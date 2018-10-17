package co.edu.uan.controlador;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.TorreDAO;
import co.edu.uan.dao.VisitanteDAO;
import co.edu.uan.entidad.Visitante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class CtrlRegistroVisitantes implements Initializable {


    @FXML
    private TableColumn<Visitante, String> clNombre;

    @FXML
    private TableColumn<Visitante, String> clSalida;
    @FXML
    private TableView<Visitante> tvVisitantes;

    @FXML
    private TableColumn<Visitante, String> clDocumento;
    @FXML
    private TableColumn<Visitante, String> clDestino;

    @FXML
    private TableColumn<Visitante, String> clEntrada;
	
	@FXML
	private Text lbHoraSal;

	@FXML
	private JFXButton btnRegistrarEnt;

	@FXML
	private JFXButton btnCaptEnt;

	@FXML
	private JFXButton btnCaptSal;

	@FXML
	private JFXTextField txtDocumento;

	@FXML
	private Text lbHoraEnt;

	@FXML
	private JFXTextField txtNombre;

	@FXML
	private Text lbfechaEnt;

	@FXML
	private JFXButton btnRegistrarSal;

	@FXML
	private JFXComboBox<Integer> cbApart;

	@FXML
	private Text lbFechaSal;

	@FXML
	private JFXComboBox<Integer> cbTorre;

	@FXML
	private JFXTextField txtDocumentoBuscar;

	@FXML
	private JFXButton btnBuscar;

	@FXML
	private Text salida;

	@FXML
	private Text fecha;
	
	private ObservableList<Visitante> listaVis;

	@FXML
	void capSalida(ActionEvent event) {
		lbFechaSal.setText(getFecha());
		lbHoraSal.setText(getHora());

	}

	@FXML
	void capEntrada(ActionEvent event) {
		lbfechaEnt.setText(getFecha());
		lbHoraEnt.setText(getHora());
	}

	public String getHora() {
		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos;
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		return hora + ":" + minutos + ":" + segundos;
	}

	public String getFecha() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		return fecha;
	}

	@FXML
	void buscar(ActionEvent event) {

	}

	@FXML
	void registrarEntrada(ActionEvent event) {
		if (txtDocumento.getText().isEmpty() || txtNombre.getText().isEmpty() || lbfechaEnt.getText().equals("<fecha>")
				|| lbHoraEnt.getText().equals("<hora>")) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");
		} else {
			Visitante visitante = new Visitante(txtDocumento.getText(), txtNombre.getText(),
					Integer.toString(cbTorre.getValue())+"-"+Integer.toString(cbApart.getValue()), 
					lbfechaEnt.getText()+"-"+lbHoraEnt.getText(), "");
			visitante.setTorre(Integer.toString(cbTorre.getValue()));
			visitante.setApart(Integer.toString(cbApart.getValue()));
			
			VisitanteDAO visDAO = new VisitanteDAO();
			if(visDAO.createVisitante(visitante)) {
				displayAlert(AlertType.INFORMATION, "REGISTRO EXITOSO", "Registro del visitante exitoso");
			listaVis.add(visitante);
			}else {
				displayAlert(AlertType.ERROR, "ERROR AL REGISTRAR","ERROR al guardar visitante");
			}
		}
	}

	@FXML
	void registrarSalida(ActionEvent event) {

	}

	public void inicializarTorres() {
		ObservableList<Integer> listaTorres = FXCollections.observableArrayList();
		TorreDAO torreDAO = new TorreDAO();
		torreDAO.traerTorres(listaTorres);
		cbTorre.setItems(listaTorres);
	}

	@FXML
	void seleccionTorre(ActionEvent event) {
		try {
			ObservableList<Integer> listaAptos = FXCollections.observableArrayList();
			TorreDAO torreDAO = new TorreDAO();

			torreDAO.traerAptosOcupados(listaAptos, cbTorre.getValue());
			cbApart.setItems(listaAptos);
		} catch (NullPointerException e) {

		}
	}
	public void inicializarTabla() {
		 listaVis = FXCollections.observableArrayList();

		VisitanteDAO visDAO = new VisitanteDAO();

		visDAO.traerDatosTabla(listaVis);

		tvVisitantes.setItems(listaVis);

		clDocumento.setCellValueFactory(new PropertyValueFactory<Visitante, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<Visitante, String>("nombre"));
		clDestino.setCellValueFactory(new PropertyValueFactory<Visitante, String>("destino"));
		clEntrada.setCellValueFactory(new PropertyValueFactory<Visitante, String>("entrada"));
		clSalida.setCellValueFactory(new PropertyValueFactory<Visitante, String>("salida"));
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fecha.setVisible(false);
		salida.setVisible(false);
		btnRegistrarSal.setVisible(false);
		btnCaptSal.setVisible(false);
		lbFechaSal.setVisible(false);
		lbHoraSal.setVisible(false);
		inicializarTorres();
		// carga combo de la base de datos

	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
