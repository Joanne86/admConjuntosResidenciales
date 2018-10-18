package co.edu.uan.controlador;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import co.edu.uan.dao.TorreDAO;
import co.edu.uan.dao.VisitanteDAO;
import co.edu.uan.entidad.Visitante;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
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
	private TableColumn<Visitante, Integer> clTorre;
	@FXML
	private TableColumn<Visitante, Integer> clApart;

	@FXML
	private TableColumn<Visitante, String> clEntrada;

	@FXML
	private JFXButton btnActualizar;
    @FXML
    private Text entrada;

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
	private Label lbDocumento;

	private ObservableList<Visitante> listaVis;

	private int posicionVisitEnTabla;

	private Visitante visi;

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
		if (txtDocumentoBuscar.getText().isEmpty()) {
			displayAlert(AlertType.INFORMATION, "CAMPO DE BUSQUEDA VACIO", "Debe tener el campo de busqueda lleno");
		} else {
			VisitanteDAO visDAO = VisitanteDAO.getInstance();
			listaVis = FXCollections.observableArrayList();
			visDAO.buscarVisitante(listaVis, txtDocumentoBuscar.getText());
			tvVisitantes.setItems(listaVis);
			if(tvVisitantes.getItems().isEmpty()) {
				displayAlert(AlertType.INFORMATION, "NO ENCONTRADO", "La persona con ese documento no existe o ya salio");
			}
			txtDocumentoBuscar.setText("");
		}
	}

	@FXML
	void registrarEntrada(ActionEvent event) {
		if (txtDocumento.getText().isEmpty() || txtNombre.getText().isEmpty() || lbfechaEnt.getText().equals("<fecha>")
				|| lbHoraEnt.getText().equals("<hora>")) {
			displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");
		} else {
			Visitante visitante = new Visitante(txtDocumento.getText(), txtNombre.getText(), cbTorre.getValue(),
					cbApart.getValue(), lbfechaEnt.getText() + "-" + lbHoraEnt.getText(), "");

			VisitanteDAO visDAO = VisitanteDAO.getInstance();
			if (visDAO.createVisitante(visitante)) {
				displayAlert(AlertType.INFORMATION, "REGISTRO EXITOSO", "Registro del visitante exitoso");
				listaVis.add(visitante);
			} else {
				displayAlert(AlertType.ERROR, "ERROR AL REGISTRAR", "ERROR al guardar visitante");
			}
		}
	}

	@FXML
	void registrarSalida(ActionEvent event) {

		if (lbFechaSal.getText().equals("<fecha>") && lbHoraSal.getText().equals("<hora>")) {
			displayAlert(AlertType.WARNING, "SIN REGISTRO DE SALIDA",
					"Debe capturar la fecha y hora de salida del visitante");
		} else {
			VisitanteDAO visDAO = VisitanteDAO.getInstance();
			this.visi.setSalida(lbFechaSal.getText()+"-"+lbHoraSal.getText());
			if(visDAO.registrarSalida(this.visi)) {
				displayAlert(AlertType.INFORMATION, "REGISTRO EXITOSO", "Registro de salidaa regitrado");
			listaVis.set(posicionVisitEnTabla, this.visi);
			mostrarEntrada();
			bloquearSalida();
			}else {
				displayAlert(AlertType.ERROR, "ERROR AL REGISTRAR SALIDA", "ERROR al registrar salida del visitante");
			}
		}

	}

	public void inicializarTorres() {
		ObservableList<Integer> listaTorres = FXCollections.observableArrayList();
		TorreDAO torreDAO = TorreDAO.getInstace();
		torreDAO.traerTorres(listaTorres);
		cbTorre.setItems(listaTorres);
	}

	@FXML
	void seleccionTorre(ActionEvent event) {
		try {
			ObservableList<Integer> listaAptos = FXCollections.observableArrayList();
			TorreDAO torreDAO = TorreDAO.getInstace();

			torreDAO.traerAptosOcupados(listaAptos, cbTorre.getValue());
			cbApart.setItems(listaAptos);
		} catch (NullPointerException e) {

		}
	}

	public void inicializarTabla() {
		listaVis = FXCollections.observableArrayList();

		VisitanteDAO visDAO = VisitanteDAO.getInstance();

		visDAO.traerDatosTabla(listaVis);

		tvVisitantes.setItems(listaVis);
		// agrega el listener a la tabla
		final ObservableList<Visitante> tablaVisitSel = tvVisitantes.getSelectionModel().getSelectedItems();
		tablaVisitSel.addListener(selectorTablaPersonas);

		clDocumento.setCellValueFactory(new PropertyValueFactory<Visitante, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<Visitante, String>("nombre"));
		clTorre.setCellValueFactory(new PropertyValueFactory<Visitante, Integer>("torre"));
		clApart.setCellValueFactory(new PropertyValueFactory<Visitante, Integer>("apart"));
		clEntrada.setCellValueFactory(new PropertyValueFactory<Visitante, String>("entrada"));
		clSalida.setCellValueFactory(new PropertyValueFactory<Visitante, String>("salida"));
	}

	@FXML
	void actualizarDatos(ActionEvent event) {
		inicializarTabla();
		inicializarTorres();
	}
	public void bloquearSalida() {
		salida.setVisible(false);
		btnRegistrarSal.setVisible(false);
		btnCaptSal.setVisible(false);
		lbFechaSal.setVisible(false);
		lbHoraSal.setVisible(false);
		lbFechaSal.setText("<fecha>");
		lbHoraSal.setText("<hora>");
	}
	public void mostrarSalida() {
		salida.setVisible(true);
		btnRegistrarSal.setVisible(true);
		btnCaptSal.setVisible(true);
		lbFechaSal.setVisible(true);
		lbHoraSal.setVisible(true);
	}
	public void bloquearEntrada() {
	    entrada.setVisible(false);
		btnRegistrarEnt.setVisible(false);
		btnCaptEnt.setVisible(false);
		lbfechaEnt.setVisible(false);
		lbHoraEnt.setVisible(false);
		lbfechaEnt.setText("<fecha>");
		lbHoraEnt.setText("<hora>");
	}
	public void mostrarEntrada() {
		entrada.setVisible(true);
		btnRegistrarEnt.setVisible(true);
		btnCaptEnt.setVisible(true);
		lbfechaEnt.setVisible(true);
		lbHoraEnt.setVisible(true);
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bloquearSalida();
		inicializarTorres();
		inicializarTabla();

		// carga combo de la base de datos

	}

	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private final ListChangeListener<Visitante> selectorTablaPersonas = new ListChangeListener<Visitante>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Visitante> c) {
			ponerVisitanteSeleccionado();
		}
	};

	/**
	 * MÃ©todo para poner en los textFields la tupla que selccionemos
	 */

	public void ponerVisitanteSeleccionado() {
		final Visitante visitante = getTablaPersonasSeleccionada();
		posicionVisitEnTabla = listaVis.indexOf(visitante);
		if (visitante != null) {
			this.visi = visitante;
			lbDocumento.setText(visitante.getDocumento());
			bloquearEntrada();
			mostrarSalida();
		}
	}

	/**
	 * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
	 */
	public Visitante getTablaPersonasSeleccionada() {

		if (tvVisitantes != null) {
			List<Visitante> tabla = tvVisitantes.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final Visitante competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;

	}
}
