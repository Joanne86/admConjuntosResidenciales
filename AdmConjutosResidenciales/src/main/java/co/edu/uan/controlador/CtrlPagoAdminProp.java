package co.edu.uan.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import co.edu.uan.dao.LoginDAO;
import co.edu.uan.dao.PagoAdminDAO;
import co.edu.uan.entidad.Recibo;
import co.edu.uan.reciboPropFacade.IReporteFacade;
import co.edu.uan.reciboPropFacade.ReciboFacadeImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class CtrlPagoAdminProp implements Initializable{

    @FXML
    private Label lbParq;

    @FXML
    private Label lbTotal;

    @FXML
    private Label lbZona;

    @FXML
    private Label lbAdmin;

    @FXML
    private Label lbApart;

    @FXML
    private Label lbTorre;

    @FXML
    private JFXButton btnImpRecibo;
    private Recibo recibo;

    /**
     * metodo para imprimir recibo
     * @param event
     */
    @FXML
    void impRecivo(ActionEvent event) {
    	int numeroAleatorio = (int) (Math.random() * 999999 + 1);
    	recibo.setCodigo(Integer.toString(numeroAleatorio));
    	recibo.setCancelado("no");
    	if(PagoAdminDAO.getInstance().guardarRecibo(recibo)) {
    		IReporteFacade reporteRecibo = new ReciboFacadeImpl();
    		reporteRecibo.generarReporte(Integer.parseInt(recibo.getCodigo()));   		
                btnImpRecibo.setDisable(true);  
        }else {
    		displayAlert(AlertType.ERROR, "ERROR", "A ocurrido un error");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		recibo= new Recibo();
		recibo.setDocumento(LoginDAO.getInstancePersona().getDocumento());
		recibo.setNombre(LoginDAO.getInstancePersona().getNombre());
		PagoAdminDAO.getInstance().traerDatosRecibo(recibo.getDocumento(), recibo);
		lbTorre.setText(recibo.getTorre());
		lbApart.setText(recibo.getApart());
		lbZona.setText(recibo.getZona());
		lbAdmin.setText(recibo.getCostoAdmin());
		lbParq.setText(recibo.getCostoParq());
		lbTotal.setText(recibo.getTotal());
	
	}
	private void displayAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
}