package co.edu.uan.controlador;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class CtrlRegistro {
    @FXML
    private JFXComboBox<Integer> cbAño;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXComboBox<Integer> cbApart;

    @FXML
    private JFXComboBox<Integer> cbMes;

    @FXML
    private JFXComboBox<Integer> cbTorre;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXTextField txtDocumento;

    @FXML
    private JFXComboBox<Integer> cbDia;
}
