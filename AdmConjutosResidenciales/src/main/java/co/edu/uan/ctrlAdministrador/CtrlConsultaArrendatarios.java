package co.edu.uan.ctrlAdministrador;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.ResidenteDAO;
import co.edu.uan.entidad.Arrendatario;
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

public class CtrlConsultaArrendatarios implements Initializable{

    @FXML
    private TableView<Arrendatario> tvTabla;

    @FXML
    private TableColumn<Arrendatario, String> clCorreo;

    @FXML
    private JFXTextField txtNdocumento;

    @FXML
    private TableColumn<Arrendatario, String> clTelefono;

    @FXML
    private TableColumn<Arrendatario, String> clDocumento;

    @FXML
    private JFXButton btnActualizarTv;

    @FXML
    private TableColumn<Arrendatario, String> clTorreApart;

    @FXML
    private TableColumn<Arrendatario, String> clParqueadero;

    @FXML
    private TableColumn<Arrendatario, String> clNombre;

    @FXML
    private JFXButton btnBuscar;

    private ObservableList<Arrendatario> listaArrend;
    
    @FXML
    void actualizarDatos(ActionEvent event) {
    	inicializarTabla();
    }
    @FXML
    void buscar(ActionEvent event) {
    	if (txtNdocumento.getText().isEmpty()) {
			displayAlert(AlertType.INFORMATION, "CAMPO DE BUSQUEDA VACIO", "Debe tener el campo de busqueda lleno");
		} else {
			listaArrend=FXCollections.observableArrayList();
	    	
	    	ResidenteDAO.getInstance().buscarArrendatario(listaArrend, txtNdocumento.getText());
	    	tvTabla.setItems(listaArrend);
	    	if(tvTabla.getItems().isEmpty()) {
	    		displayAlert(AlertType.INFORMATION, "NO ENCONTRADO",
						"El arrendatario con ese documento no existe");
	    	}
	    	txtNdocumento.setText("");
		}
    }
    
    public void inicializarTabla() {
    	listaArrend=FXCollections.observableArrayList();
    	
    	ResidenteDAO.getInstance().traerArrendatrios(listaArrend);
    	
    	tvTabla.setItems(listaArrend);
    	clDocumento.setCellValueFactory(new PropertyValueFactory<Arrendatario, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<Arrendatario, String>("nombre"));
		clTelefono.setCellValueFactory(new PropertyValueFactory<Arrendatario, String>("telefono"));
		clCorreo.setCellValueFactory(new PropertyValueFactory<Arrendatario, String>("correo"));
		clTorreApart.setCellValueFactory(new PropertyValueFactory<Arrendatario, String>("torreapart"));
		clParqueadero.setCellValueFactory(new PropertyValueFactory<Arrendatario, String>("parqueadero"));

    	
    }
    
    private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializarTabla();	
	}
}