package co.edu.uan.ctrlAdministrador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CtrlQuejasSugerencias {

    @FXML
    private TableView<?> tablaQuejasSugerencias;

    @FXML
    private TableColumn<?, ?> clTipoResidente;

    @FXML
    private TableColumn<?, ?> clAsunto;

    @FXML
    private TableColumn<?, ?> clResidente;

    @FXML
    private JFXTextArea txtAreaDetalles;

    @FXML
    private TableColumn<?, ?> clApart;

    @FXML
    private TableColumn<?, ?> clTorre;

    @FXML
    private TableColumn<?, ?> clNotificacion;

    @FXML
    private JFXButton btnActualizar;

    @FXML
    void actualizar(ActionEvent event) {

    }

}
