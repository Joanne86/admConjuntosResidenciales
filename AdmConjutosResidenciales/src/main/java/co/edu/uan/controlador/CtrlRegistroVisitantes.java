package co.edu.uan.controlador;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Text salida;

    @FXML
    private Text fecha;
    
    @FXML
    void capSalida(ActionEvent event) {
    	lbFechaSal.setText(getFecha());
    	lbHoraSal.setText(getHora());
    	
    }

    @FXML
    void capEntrada(ActionEvent event) {
    	lbfechaEnt.setText(getFecha());
    	lbHoraEnt.setText(getHora());
    }
    public String getHora() {
    	Calendar calendario = Calendar.getInstance();
    	int hora, minutos, segundos;
    	hora =calendario.get(Calendar.HOUR_OF_DAY);
    	minutos = calendario.get(Calendar.MINUTE);
    	segundos = calendario.get(Calendar.SECOND);  	
    	return hora+":"+minutos+":"+segundos;
    }

    public String getFecha() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		return fecha;
    }

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void registrarEntrada(ActionEvent event) {
    	if(txtDocumento.getText().isEmpty()||txtNombre.getText().isEmpty()||
    			lbfechaEnt.getText().equals("<fecha>")||lbHoraEnt.getText().equals("<hora>")) {
    		displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");
    	}else {
    		
    	}
    }

    @FXML
    void registrarSalida(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fecha.setVisible(false);
		salida.setVisible(false);
		btnRegistrarSal.setVisible(false);
		btnCaptSal.setVisible(false);
		lbFechaSal.setVisible(false);
		lbHoraSal.setVisible(false);
		// carga combo de la base de datos
		
	}
	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}

