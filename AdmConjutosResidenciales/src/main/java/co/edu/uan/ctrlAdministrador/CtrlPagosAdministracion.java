package co.edu.uan.ctrlAdministrador;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uan.dao.PagoAdminDAO;
import co.edu.uan.entidad.Recibo;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CtrlPagosAdministracion implements Initializable{

    @FXML
    private TableColumn<Recibo, String> clTorre;

    @FXML
    private JFXTextField txtCodigo;

    @FXML
    private TableColumn<Recibo, String> clNombre;

    @FXML
    private TableColumn<Recibo, String> clCancelado;

    @FXML
    private TableColumn<Recibo, String> clAdmin;

    @FXML
    private TableView<Recibo> tvTabla;

    @FXML
    private TableColumn<Recibo, String> clTotal;

    @FXML
    private TableColumn<Recibo, String> clCodigo;

    @FXML
    private TableColumn<Recibo, String> clDocumento;

    @FXML
    private TableColumn<Recibo, String> clApart;

    @FXML
    private JFXButton btnPagar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private TableColumn<Recibo, String> clParq;

    @FXML
    private TableColumn<Recibo, String> clZona;
    
    
    private ObservableList<Recibo> listaPagos;
    
    private int posicionVisitEnTabla;
    
    private Recibo recib;

    /**
     * metodo para buscar el codigo de recibo de pago 
     * @param event
     */
    @FXML
    void buscar(ActionEvent event) {
    	if(txtCodigo.getText().isEmpty()) {
    		displayAlert(AlertType.WARNING, "CAMPO VACIO", "Tiene que llenar el campo de busqueda");
    	}else {
    		listaPagos = FXCollections.observableArrayList();
    		PagoAdminDAO.getInstance().traerPago(txtCodigo.getText(), listaPagos);
    		tvTabla.setItems(listaPagos);
    		if(tvTabla.getItems().isEmpty()) {
				displayAlert(AlertType.INFORMATION, "NO ENCONTRADO", "El codigo de la factura no existe");
			}
    		txtCodigo.setText("");
    	}
    }

    /**
     * metodo para cancelar o dar por hecho el pago de administracion por parte del propietario
     * @param event
     */
    @FXML
    void realizarPago(ActionEvent event) {
    	if(this.recib==null) {
    		displayAlert(AlertType.WARNING, "SELECCIONE UN RECIBO", "Debe seleccionar un recibo de pago");
    	}else if(this.recib.getCancelado().equals("si")) {
    		displayAlert(AlertType.WARNING, "RECIBO PAGADO", "Debe seleccionar un recibo de pago que NO este cancelado");
    	}else {
    		recib.setCancelado("si");
    		if(PagoAdminDAO.getInstance().cancelarRecibo(recib)) {
    			displayAlert(AlertType.INFORMATION, "RECIBO CANCELADO", "Recibo cancelado");
    			listaPagos.set(posicionVisitEnTabla, this.recib);
    		}else {
    			displayAlert(AlertType.ERROR, "ERROR", "Error al cancelar recibo");
    		}
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		PagoAdminDAO pagoDAO = PagoAdminDAO.getInstance();
		listaPagos= FXCollections.observableArrayList();
		
		pagoDAO.traerLista(listaPagos);
		tvTabla.setItems(listaPagos);
		
		final ObservableList<Recibo> tablaRecSel = tvTabla.getSelectionModel().getSelectedItems();
		tablaRecSel.addListener(selectorTablaRecibo);

		
		clCodigo.setCellValueFactory(new PropertyValueFactory<Recibo, String>("codigo"));
		clDocumento.setCellValueFactory(new PropertyValueFactory<Recibo, String>("documento"));
		clNombre.setCellValueFactory(new PropertyValueFactory<Recibo, String>("nombre"));
		clTorre.setCellValueFactory(new PropertyValueFactory<Recibo, String>("torre"));
		clApart.setCellValueFactory(new PropertyValueFactory<Recibo, String>("apart"));
		clZona.setCellValueFactory(new PropertyValueFactory<Recibo, String>("zona"));
		clAdmin.setCellValueFactory(new PropertyValueFactory<Recibo, String>("costoAdmin"));
		clParq.setCellValueFactory(new PropertyValueFactory<Recibo, String>("costoParq"));
		clTotal.setCellValueFactory(new PropertyValueFactory<Recibo,String>("total"));
		clCancelado.setCellValueFactory(new PropertyValueFactory<Recibo, String>("cancelado"));
		
	}
	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	
	private final ListChangeListener<Recibo> selectorTablaRecibo = new ListChangeListener<Recibo>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Recibo> c) {
			ponerReciboSeleccionado();
		}
	};

	/**
	 * Metodo para poner en los textFields la tupla que selccionemos
	 */

	public void ponerReciboSeleccionado() {
		final Recibo recibo = getTablaReciboSeleccionado();
		posicionVisitEnTabla = listaPagos.indexOf(recibo);
		if (recibo != null) {
			this.recib = recibo;
			
		}
	}

	/**
	 * PARA SELECCIONAR UNA CELDA DE LA TABLA
	 */
	public Recibo getTablaReciboSeleccionado() {

		if (tvTabla != null) {
			List<Recibo> tabla = tvTabla.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final Recibo competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;

	}

}