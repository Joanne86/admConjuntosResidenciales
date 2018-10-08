package co.edu.uan.ctrlAdministrador;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CtrlGestionServicios {

    @FXML
    private JFXButton btnReporte;

    @FXML
    private TableColumn<?, ?> clCorreo;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private TableColumn<?, ?> clServicio;

    @FXML
    private TableColumn<?, ?> clNombre;

    @FXML
    private TableColumn<?, ?> clHorario;

    @FXML
    private JFXTextField txtDocumento;

    @FXML
    private JFXTextField txtHorario;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private TableView<?> tvTabla;

    @FXML
    private JFXTextField txtNdocumento;

    @FXML
    private TableColumn<?, ?> clTelefono;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private TableColumn<?, ?> clDocumento;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private DatePicker calenFechaNac;

    @FXML
    private JFXComboBox<?> cbServicio;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXButton btnModificar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private TableColumn<?, ?> clFechaNac;

    @FXML
    private JFXButton btnActualizar;


    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void registrar(ActionEvent event) {

    	if(txtDocumento.getText().isEmpty()) {
    		System.out.println("mowkmfcoencfo3jrn");
    	}
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

    }

}
