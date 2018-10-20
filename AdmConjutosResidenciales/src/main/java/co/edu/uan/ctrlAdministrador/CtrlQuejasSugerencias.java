package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import co.edu.uan.dao.NovedadDAO;
import co.edu.uan.entidad.Novedad;
import javafx.collections.FXCollections;
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

    @FXML
    void actualizar(ActionEvent event) {

    }

    public void inicializarTabla() {
    	listaNovedad =  FXCollections.observableArrayList();
    	NovedadDAO novedadDAO = NovedadDAO.getInstance();
    	novedadDAO.traerDatosTabla(listaNovedad);
    	tablaQuejasSugerencias.setItems(listaNovedad);
    	
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

}
