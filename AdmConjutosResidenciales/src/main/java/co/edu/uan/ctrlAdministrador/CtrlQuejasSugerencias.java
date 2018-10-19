package co.edu.uan.ctrlAdministrador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import co.edu.uan.entidad.Novedad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CtrlQuejasSugerencias implements Initializable{

    @FXML
    private TableView<Novedad> tablaQuejasSugerencias;

    @FXML
    private TableColumn<Novedad, String> clTipoResidente;

    @FXML
    private TableColumn<Novedad, String> clAsunto;

    @FXML
    private TableColumn<Novedad, String> clResidente;

    @FXML
    private JFXTextArea txtAreaDetalles;

    @FXML
    private TableColumn<Novedad, String> clApart;

    @FXML
    private TableColumn<Novedad, String> clTorre;

    @FXML
    private TableColumn<Novedad, String> clNotificacion;

    @FXML
    private JFXButton btnActualizar;
    
    private ObservableList<Novedad> listaNovedad;

    @FXML
    void actualizar(ActionEvent event) {

    }

    public void inicializarTabla() {
    	listaNovedad =  FXCollections.observableArrayList();
    	
    	//dao
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
