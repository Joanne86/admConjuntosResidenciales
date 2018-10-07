package co.edu.uan.ctrlAdministrador;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

public class CtrlRegistro {

    @FXML
    private TableColumn<?, ?> clCorreo;

    @FXML
    private ToggleGroup reside;

    @FXML
    private ToggleGroup parqueadero;

    @FXML
    private TableColumn<?, ?> clTorre;

    @FXML
    private TableColumn<?, ?> clNombre;

    @FXML
    private JFXTextField txtDocumento;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private TableView<?> tvTabla;

    @FXML
    private RadioButton rbNoR;

    @FXML
    private TableColumn<?, ?> clDocumento;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private RadioButton rbSiR;

    @FXML
    private RadioButton rbSiP;

    @FXML
    private TableColumn<?, ?> clFechaNac;

    @FXML
    private TableColumn<?, ?> clParqueadero;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private RadioButton rbNoP;

    @FXML
    private TableColumn<?, ?> clReside;

    @FXML
    private JFXTextField txtNdocumento;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private TableColumn<?, ?> clApart;

    @FXML
    private JFXComboBox<?> cbApart;

    @FXML
    private DatePicker calenFechaNac;

    @FXML
    private JFXComboBox<?> cbTorre;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXButton btnModificar;

    @FXML
    private JFXButton btnBuscar;


    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void registrar(ActionEvent event) {

    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void modificar(ActionEvent event) {

    }

}
