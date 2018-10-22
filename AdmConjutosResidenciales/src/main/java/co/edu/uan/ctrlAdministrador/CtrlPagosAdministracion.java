package co.edu.uan.ctrlAdministrador;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.entidad.PropietarioTabla;
import co.edu.uan.entidad.Recibo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CtrlPagosAdministracion implements Initializable{

    @FXML
    private TableColumn<Recibo, Integer> clTorre;

    @FXML
    private JFXTextField txtCodigo;

    @FXML
    private TableColumn<Recibo, String> clNombre;

    @FXML
    private TableColumn<Recibo, String> clCancelado;

    @FXML
    private TableColumn<Recibo, Float> clAdmin;

    @FXML
    private TableView<Recibo> tvTabla;

    @FXML
    private TableColumn<Recibo, Float> clTotal;

    @FXML
    private TableColumn<Recibo, String> clCodigo;

    @FXML
    private TableColumn<Recibo, String> clDocumento;

    @FXML
    private TableColumn<Recibo, Integer> clApart;

    @FXML
    private JFXButton btnPagar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private TableColumn<Recibo, Float> clParq;
    private ObservableList<Recibo> listaPagos;

    @FXML
    void buscar(ActionEvent event) {
    	if(txtCodigo.getText().isEmpty()) {
    		
    	}else {
    		
    	}
    }

    @FXML
    void realizarPago(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaPagos= FXCollections.observableArrayList();
		clCodigo.setCellValueFactory(new PropertyValueFactory<Recibo, String>("codigo"));
		clDocumento.setCellValueFactory(new PropertyValueFactory<Recibo, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<Recibo, String>("nombre"));
		clTorre.setCellValueFactory(new PropertyValueFactory<Recibo, Integer>("torre"));
		clApart.setCellValueFactory(new PropertyValueFactory<Recibo, Integer>("apart"));
		clAdmin.setCellValueFactory(new PropertyValueFactory<Recibo, Float>("costoAdmin"));
		clParq.setCellValueFactory(new PropertyValueFactory<Recibo, Float>("costoParq"));
		clTotal.setCellValueFactory(new PropertyValueFactory<Recibo, Float>("total"));
		clCancelado.setCellValueFactory(new PropertyValueFactory<Recibo, String>("cancelado"));
		tvTabla.setItems(listaPagos);
	}

}