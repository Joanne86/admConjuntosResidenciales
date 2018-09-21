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
import javafx.scene.control.Accordion;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class CtrlPanelAdmin implements Initializable{

    @FXML
    private AnchorPane root;

    @FXML
    private JFXDrawer drawer;


    @FXML
    private Accordion acordeon;
    
    @FXML
    private JFXHamburger hamburger;
    
    static JFXDrawer drawer1;
    static JFXHamburger hamburger1;
    public static AnchorPane rootP;
    
    public static AnchorPane panelMenu;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hamburger1=hamburger;
		rootP = root;
		drawer1=drawer;
        try {
        	panelMenu = FXMLLoader.load(getClass().getResource("/view/MenuAdmin.fxml"));
        	panelMenu.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-45);
        	//acordeon.setPrefHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-288);
            drawer.setSidePane(panelMenu);
        } catch (IOException ex) {
            Logger.getLogger(CtrlPanelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(0);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
        	drawer.toFront();
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
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