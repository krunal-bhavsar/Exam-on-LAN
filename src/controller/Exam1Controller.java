/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Future
 */
public class Exam1Controller implements Initializable {

    @FXML
    private AnchorPane anchorexam;
    @FXML
    private JFXButton examsubmitbutton;
    TeacherSignupController t=new TeacherSignupController();
    DashboardController d=new DashboardController();
    DatabaseHandler databaseHandler;
    @FXML
    private JFXTextField examname;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 
          new Thread(() -> {
                        databaseHandler=DatabaseHandler.getInstance();      
                  }).start();
          
    }    

    @FXML
    private void examsubmitmethod(ActionEvent event)throws IOException {
        d.exammethod(anchorexam,"/fxml/Question.fxml");
     
        try {
            databaseHandler.setupAdmin(examname.getText());
        } catch (ClassNotFoundException |InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Exam1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
    
    }
    
}
