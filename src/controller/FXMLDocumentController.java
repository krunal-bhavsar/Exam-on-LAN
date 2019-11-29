/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane contentArea;
    @FXML
    private Text icon;
    @FXML
    private AnchorPane homepage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Signup(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/Signup.fxml")); 
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
        
    }

    @FXML
    private void TeacherSignup(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/TeacherSignup.fxml")); 
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
          Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/Lan.fxml"));
          homepage.getChildren().setAll(fxml);
    }
    
}
