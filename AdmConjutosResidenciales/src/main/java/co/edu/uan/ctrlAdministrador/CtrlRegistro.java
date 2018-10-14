package co.edu.uan.ctrlAdministrador;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class CtrlRegistro {

    @FXML
    private JFXButton btnActualizarTv;
    
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

    	if(txtNdocumento.getText().isEmpty()) {
    		displayAlert(AlertType.INFORMATION, "CAMPO DE BUSQUEDA VACIO", "Debe tener el campo de busqueda lleno");
    	}else {
    		//se va al dao
    	}
    }

    @FXML
    void registrar(ActionEvent event) {
    	
    	if(txtDocumento.getText().isEmpty()
    			||calenFechaNac.getValue()==null
    			||txtEmail.getText().isEmpty()
    			||txtNombre.getText().isEmpty()
    			||txtDocumento.getText().isEmpty()
    			||cbApart.getValue().equals("")
    			||cbTorre.getValue().equals("")
    			||(!rbSiP.isSelected()&&!rbNoP.isSelected())
    			||(!rbSiR.isSelected()&&!rbNoR.isSelected())) {
    		displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");  		
    	}else {
    		
    	}
    	
    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void modificar(ActionEvent event) {

    }
    @FXML
    void actualizarTabla(ActionEvent event) {

    }
    private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
