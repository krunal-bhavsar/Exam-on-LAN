/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.DatabaseHandler;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Future
 */
public class QuestionController implements Initializable {

    @FXML
    private JFXTextField questionfield;
    @FXML
    private JFXTextField choicea;
    @FXML
    private JFXTextField choiceb;
    @FXML
    private JFXTextField choicec;
    @FXML
    private JFXTextField choiced;
    @FXML
    private JFXRadioButton answera;
    @FXML
    private JFXRadioButton answerb;
    @FXML
    private JFXRadioButton answerc;
    @FXML
    private JFXRadioButton answerd;
    DatabaseHandler databasehandler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          databasehandler=DatabaseHandler.getInstance();
          ToggleGroup group = new ToggleGroup();
          
          answera.setToggleGroup(group);
         answerb.setToggleGroup(group);
         answerc.setToggleGroup(group);
         answerd.setToggleGroup(group);
    }    

    @FXML
    private void Next(ActionEvent event) {
           
    }

   

    
}
