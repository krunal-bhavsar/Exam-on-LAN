
package controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.Validation;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.stage.Stage;



public class SignupController implements Initializable {

     @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField lastname;
    
    @FXML
    private Label firstlabel;
   
     @FXML
    private JFXTextField email;
     
     DashboardController dc=new DashboardController();
     
     boolean checkemail,checkfirstname,checklastname;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           RequiredFieldValidator firstnameValidator = new RequiredFieldValidator();
           RequiredFieldValidator lastnameValidator = new RequiredFieldValidator();
           RequiredFieldValidator emailValidator = new RequiredFieldValidator();
           
           firstname.getValidators().add(firstnameValidator);
           lastname.getValidators().add(lastnameValidator);
           email.getValidators().add(emailValidator);
           
           firstnameValidator.setMessage("Only Alphabates Allowed");
           lastnameValidator.setMessage("Only Alphabates Allowed");
           emailValidator.setMessage("Email Must Be Charusat Provided");
           Validation v1=new Validation();
           
           firstname.focusedProperty().addListener(new ChangeListener<Boolean>() {
               @Override
               public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                   if(!newValue){
                   checkfirstname=v1.firsttextField(firstname);
                       
                       if(!checkfirstname){
                           firstname.setText("");    
                       }
                        firstname.validate();
                   }
               }
           });
           
           lastname.focusedProperty().addListener(new ChangeListener<Boolean>() {
               @Override
               public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                   if(!newValue){
                     checklastname=v1.firsttextField(lastname);
                       
                       if(!checklastname){
                           lastname.setText("");    
                       }
                        lastname.validate();
                   }
               }
           });
           
           email.focusedProperty().addListener(new ChangeListener<Boolean>() {
               @Override
               public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                   if(!newValue){
                    checkemail=v1.emailCheck(email);
                       
                       if(!checkemail){
                           email.setText("");    
                       }
                        email.validate();
                   }
               }
           });
    }    
     @FXML
    void sign_up(ActionEvent event) throws IOException {
         if(checkemail && checkfirstname && checklastname){
              dc.setmenuButton(firstname.getText());
              Parent dashboard_parent= FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
              Scene dashboard_scene = new Scene(dashboard_parent);
              Stage dashboard_stage= (Stage)((Node) event.getSource()).getScene().getWindow();
              dashboard_stage.setScene(dashboard_scene);
              dashboard_stage.setMaximized(true);
              dashboard_stage.show();
         }
         
    }
    
    
}
