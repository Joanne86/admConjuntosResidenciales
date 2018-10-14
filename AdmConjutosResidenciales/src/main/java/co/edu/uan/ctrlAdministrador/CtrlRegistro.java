package co.edu.uan.ctrlAdministrador;


import java.util.UUID;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.AdminConjuntos.AppAdminConjuntos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import co.edu.uan.dao.LoginDAO;
import co.edu.uan.dao.PropietarioDAO;
import co.edu.uan.entidad.Apartamento;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Propietario;

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
	static Stage primaryStage = new Stage();
	public static Parent root;

    @FXML
    void registrar(ActionEvent event) {
    	Propietario propietario = new Propietario();
    	PropietarioDAO newPropietario = new PropietarioDAO();
    	if(txtDocumento.getText().isEmpty()
    			||calenFechaNac.getValue()==null
    			||txtEmail.getText().isEmpty()
    			||txtNombre.getText().isEmpty()
    			||txtDocumento.getText().isEmpty()
    			||cbApart.getValue().equals("")
    			||cbTorre.getValue().equals("")
    			||txtTelefono.getText().isEmpty()
    			||(!rbSiP.isSelected()&&!rbNoP.isSelected())
    			||(!rbSiR.isSelected()&&!rbNoR.isSelected())) {
    		displayAlert(AlertType.INFORMATION, "CAMPOS VACIOS", "Debe tener los campos de registro llenos");  		
    	}else {
    		//Generacion de clave aleatoria para el nuevo propietario 
    		String clave =UUID.randomUUID().toString().toUpperCase().substring(0, 6);   		
    		Login login = new Login();
			login.setUsuario(txtDocumento.getText());
			login.setContraseña(clave);
			login.setTipoPersona("2");
			
			//OBJETO APARTAMENTO
			Apartamento apto = new Apartamento();
			apto.setTorre(Integer.parseInt(String.valueOf(cbTorre.getValue())));
			apto.setApartamento(Integer.parseInt(String.valueOf(cbApart.getValue())));
			apto.setReside(rbSiR.getText());
			apto.setParqueadero(rbSiP.getText());
			
			propietario.Propietario(Integer.parseInt(txtDocumento.getText()),txtNombre.getText(),txtTelefono.getText(),
    				String.valueOf(calenFechaNac.getValue()),txtEmail.getText(),login,apto);
    		if(newPropietario.createPropietario(propietario)) {
    			
    			root = FXMLLoader.load(getClass().getResource("/view/GestionPropietarios.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);

				primaryStage.show();
				primaryStage.setMaximized(true);
				
				if(AppAdminConjuntos.stage!=null) {
					AppAdminConjuntos.cerrarVentana();
				}
				if(CtrlPanelMenuAdmin.primaryStage!=null) {
					CtrlPanelMenuAdmin.cerrarVentana();
				}
			} else {
				
				displayAlert(AlertType.ERROR, "Error Grabar Propietario",
						"Error al grabar el Propietario. Conatacte con el Administrador");
			}   			

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
    
    public static void cerrarVentana() {
		primaryStage.close();
	}

    private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
