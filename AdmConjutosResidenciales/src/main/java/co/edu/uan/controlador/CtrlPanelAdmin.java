package co.edu.uan.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class CtrlPanelAdmin implements Initializable{

    @FXML
    private AnchorPane root;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    public static AnchorPane rootP;
    
    public static AnchorPane panelMenu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rootP = root;
        
        try {
        	panelMenu = FXMLLoader.load(getClass().getResource("/view/MenuAdmin.fxml"));
            drawer.setSidePane(panelMenu);
        } catch (IOException ex) {
            Logger.getLogger(CtrlPanelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-2);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            drawer.toFront();
            if(drawer.isOpened())
            {
                drawer.close();        
                drawer.toBack();                 
                
            }else {
            	drawer.toFront();
            	drawer.open(); 
            }
                
        });
		
	}

}