package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import co.edu.uan.dao.NovedadDAO;
import co.edu.uan.entidad.Novedad;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CtrlQuejasSugerencias implements Initializable{

    @FXML
    private TableView<Novedad> tablaQuejasSugerencias;

    @FXML
    private TableColumn<Novedad, String> clTipoResidente;

    @FXML
    private TableColumn<Novedad, String> clDetalleNovedad;

    @FXML
    private TableColumn<Novedad, String> clResidente;

    @FXML
    private JFXTextArea txtAreaDetalles;

    @FXML
    private TableColumn<Novedad, String> clApart;

    @FXML
    private TableColumn<Novedad, String> clTorre;

    @FXML
    private TableColumn<Novedad, String> clTipoNovedad;

    @FXML
    private JFXButton btnActualizar;
    
    private ObservableList<Novedad> listaNovedad;
    private int posicionVisitEnTabla;

    @FXML
    void actualizar(ActionEvent event) {
    	inicializarTabla() ;
    }

    public void inicializarTabla() {
    	listaNovedad =  FXCollections.observableArrayList();
    	
    	NovedadDAO.getInstance().traerDatosTabla(listaNovedad);
    	tablaQuejasSugerencias.setItems(listaNovedad);
    	final ObservableList<Novedad> tablaVisitSel = tablaQuejasSugerencias.getSelectionModel().getSelectedItems();
		tablaVisitSel.addListener(selectorTabla);
    	
    	clTorre.setCellValueFactory(new PropertyValueFactory<Novedad, String>("torre"));
		clApart.setCellValueFactory(new PropertyValueFactory<Novedad, String>("apart"));
		clTipoResidente.setCellValueFactory(new PropertyValueFactory<Novedad, String>("tipoResidente"));
		clResidente.setCellValueFactory(new PropertyValueFactory<Novedad, String>("nombreResidente"));
		clTipoNovedad.setCellValueFactory(new PropertyValueFactory<Novedad, String>("tipoNovedad"));
		clDetalleNovedad.setCellValueFactory(new PropertyValueFactory<Novedad, String>("detalleNovedad"));
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializarTabla();
	}
	
	private final ListChangeListener<Novedad> selectorTabla = new ListChangeListener<Novedad>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Novedad> c) {
			ponerVisitanteSeleccionado();
		}
	};

	/**
	 * Metodo para poner en los textFields la tupla que selccionemos
	 */

	public void ponerVisitanteSeleccionado() {
		final Novedad novedad = getTablaPersonasSeleccionada();
		posicionVisitEnTabla = listaNovedad.indexOf(novedad);
		if (novedad != null) {
			txtAreaDetalles.setText(novedad.getDetalleNovedad());
		}
	}

	/**
	 * PARA SELECCIONAR UNA CELDA DE LA TABLA
	 */
	public Novedad getTablaPersonasSeleccionada() {

		if (tablaQuejasSugerencias != null) {
			List<Novedad> tabla = tablaQuejasSugerencias.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final Novedad competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;

	}
	

}
