package co.edu.uan.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import co.edu.uan.dao.LoginDAO;
import co.edu.uan.dao.NovedadDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;

public class CtrlQuejasSugerenciasProp {

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXTextArea txtAreaDetalles;

    @FXML
    private RadioButton rbQueja;

    @FXML
    private RadioButton rbSugerencia;

    /**
     * metodo para enviar las quejas y/o sugerencias
     * @param event
     */
    @FXML
    void enviar(ActionEvent event) {
    	if(txtAreaDetalles.getText().isEmpty()||(!rbQueja.isSelected()&&!rbSugerencia.isSelected())) {
    		displayAlert(AlertType.WARNING, "CAMPOS VACIOS", "Debe tener los campos llenos");
    	}else {
    		String tipoNovedad=null;
    		if(rbQueja.isSelected()) {
    			tipoNovedad="Queja";
    		}
    		if(rbSugerencia.isSelected()){
    			tipoNovedad="Sugerencia";
    		}

    		if(NovedadDAO.getInstance().guardarNovedad(tipoNovedad,txtAreaDetalles.getText(), LoginDAO.getInstancePersona().getDocumento())) {
    			displayAlert(AlertType.INFORMATION, "NOVEDAD ENVIADA", "Su novedad acaba de ser enviada al administrador");
    			txtAreaDetalles.setText("");
    			rbQueja.setSelected(false);
    			rbSugerencia.setSelected(false);
    		}else{
    			displayAlert(AlertType.ERROR, "ERROR AL ENVIAR", "Ocurrio un error al enviar la novedad");
    		}		
    	}
    } 
    private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
