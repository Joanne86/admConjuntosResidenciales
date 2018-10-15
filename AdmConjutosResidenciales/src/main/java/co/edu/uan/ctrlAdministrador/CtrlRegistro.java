package co.edu.uan.ctrlAdministrador;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.AdminConjuntos.AppAdminConjuntos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import co.edu.uan.dao.TorreDAO;
import co.edu.uan.entidad.Login;
import co.edu.uan.entidad.Propietario;
import co.edu.uan.entidad.PropietarioTabla;
import co.edu.uan.torreBuilder.Apartamento;
import co.edu.uan.torreBuilder.TorreCom;

public class CtrlRegistro implements Initializable{

    @FXML
    private JFXButton btnActualizarTv;
    
    @FXML
    private TableColumn<PropietarioTabla, String> clCorreo;

    @FXML
    private ToggleGroup reside;

    @FXML
    private ToggleGroup parqueadero;

    @FXML
    private TableColumn<PropietarioTabla, String> clTorre;

    @FXML
    private TableColumn<PropietarioTabla, String> clNombre;

    @FXML
    private JFXTextField txtDocumento;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private TableView<PropietarioTabla> tvTabla;

    @FXML
    private RadioButton rbNoR;

    @FXML
    private TableColumn<PropietarioTabla, String> clDocumento;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private RadioButton rbSiR;

    @FXML
    private RadioButton rbSiP;

    @FXML
    private TableColumn<PropietarioTabla, String> clFechaNac;

    @FXML
    private TableColumn<PropietarioTabla, String> clParqueadero;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private RadioButton rbNoP;

    @FXML
    private TableColumn<PropietarioTabla, String> clReside;

    @FXML
    private JFXTextField txtNdocumento;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private TableColumn<PropietarioTabla, String> clApart;

    @FXML
    private JFXComboBox<Integer> cbApart;

    @FXML
    private DatePicker calenFechaNac;

    @FXML
    private JFXComboBox<Integer> cbTorre;

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
			String reside="";
			String parqueadero="";
			if(rbSiR.isSelected()) {
				reside="si";
			}else {
				reside="no";
			}
			if(rbSiP.isSelected()) {
				parqueadero="si";
			}else {
				parqueadero="No";
			}
			int torre =cbTorre.getValue();
			Apartamento apart= new Apartamento(cbApart.getValue(),reside, parqueadero);
			//OBJETO PROPIETARIO
			
			Propietario propietario = new Propietario(Integer.parseInt(txtDocumento.getText())
					,txtNombre.getText(),txtEmail.getText(),login, torre, apart);
    	
			PropietarioDAO propDAO = new PropietarioDAO();
			if(propDAO.createPropietario(propietario)) {
				
			}else {
				displayAlert(AlertType.ERROR, "Error guardar Propietario",
						"Error al guardar el Propietario");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// carga los combos
		ObservableList<Integer> listaTorres = FXCollections.observableArrayList();
		ObservableList<Integer> listaAptos = FXCollections.observableArrayList();
		TorreDAO torreDAO = new TorreDAO();
		torreDAO.traerTorresAptos(listaTorres, listaAptos);
		
		cbTorre.setItems(listaTorres);
		cbApart.setItems(listaAptos);
	}

}
