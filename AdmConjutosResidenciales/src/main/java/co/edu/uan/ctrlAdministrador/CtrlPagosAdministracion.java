package co.edu.uan.ctrlAdministrador;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class CtrlPagosAdministracion {

    @FXML
    private Text lbTotalPagar;

    @FXML
    private TableColumn<?, ?> clSubTotal;

    @FXML
    private TableView<?> tvTabla;

    @FXML
    private TableColumn<?, ?> clInfoApto;

    @FXML
    private TableColumn<?, ?> clCargoParqueadero;

    @FXML
    private Text lbNombre;

    @FXML
    private TableColumn<?, ?> clTipoApto;

    @FXML
    private JFXTextField txtNdocumentoBuscar;

    @FXML
    private TableColumn<?, ?> clFechaPago;

    @FXML
    private JFXButton btnPagar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    void realizarPago(ActionEvent event) {

    }

    @FXML
    void buscar(ActionEvent event) {

    }

}