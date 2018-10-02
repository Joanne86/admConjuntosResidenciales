package co.edu.uan.controlador;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class CtrlRegistroVisitantes implements Initializable{

    @FXML
    private Text lbHoraSal;

    @FXML
    private JFXButton btnRegistrarEnt;

    @FXML
    private JFXButton btnCaptEnt;

    @FXML
    private JFXButton btnCaptSal;

    @FXML
    private JFXTextField txtDocumento;

    @FXML
    private Text lbHoraEnt;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private Text lbfechaEnt;

    @FXML
    private JFXButton btnRegistrarSal;

    @FXML
    private JFXComboBox<?> cbApart;

    @FXML
    private Text lbFechaSal;

    @FXML
    private JFXComboBox<?> cbTorre;

    @FXML
    private JFXTextField txtDocumentoBuscar;

    @FXML
    private JFXButton btnBuscar;
    
    @FXML
    void capSalida(ActionEvent event) {

    }

    @FXML
    void capEntrada(ActionEvent event) {

    }


    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void registrarEntrada(ActionEvent event) {

    }

    @FXML
    void registrarSalida(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// carga combo de la base de datos
		
	}

}

