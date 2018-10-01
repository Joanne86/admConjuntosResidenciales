package co.edu.uan.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class CtrlGestionApartamentos implements Initializable{

    @FXML
    private JFXTextField txtTipoBusqueda;

    @FXML
    private JFXTextField txtTorre;

    @FXML
    private TableColumn<?, ?> clCosto;

    @FXML
    private TableView<?> tvTabla;

    @FXML
    private TableColumn<?, ?> clTipo;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private TableColumn<?, ?> clApartamento;

    @FXML
    private TableColumn<?, ?> clTorre;

    @FXML
    private JFXTextField txtApartamento;

    @FXML
    private Text lblCostoAdmin;
    
    @FXML
    private JFXButton btnBuscar;

    @FXML
    private JFXButton btnModificar;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXComboBox<String> cbTipo;
    
    @FXML
    void modificar(ActionEvent event) {

    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void registrar(ActionEvent event) {

    }
    @FXML
    void buscar(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//cargar tabla de la bd y combo box
		
	}
}
