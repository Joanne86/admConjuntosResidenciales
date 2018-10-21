package co.edu.uan.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import co.edu.uan.dao.LoginDAO;
import co.edu.uan.dao.PagoAdminDAO;
import co.edu.uan.entidad.Recibo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    @FXML
    void impRecivo(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		recibo= new Recibo();
		PagoAdminDAO.getInstance().traerDatosRecibo(LoginDAO.getInstancePersona().getDocumento(), recibo);
		lbTorre.setText(Integer.toString(recibo.getTorre()));
		lbApart.setText(Integer.toString(recibo.getApart()));
		lbZona.setText(recibo.getZona());
		lbAdmin.setText(Float.toString(recibo.getCostoAdmin()));
		lbParq.setText(Float.toString(recibo.getCostoParq()));
		lbTotal.setText(Float.toString(recibo.getTotal()));
		
		
		
		
	}
}