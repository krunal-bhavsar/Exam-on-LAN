/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.DatabaseHandler;
import com.Validation;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class TeacherSignupController implements Initializable {

    @FXML
    private JFXTextField teacheremail;
    @FXML
    private JFXPasswordField teacherpassword;

    Validation v1=new Validation();
    DatabaseHandler databasehandler;
    boolean checkemail,checkfirstname;
    DashboardController dc=new DashboardController();
    
    @FXML
    private JFXTextField teacherfirst;
    @FXML
    private JFXTextField teacherlast;
    
    public static String t=null;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
      RequiredFieldValidator emailValidator = new RequiredFieldValidator();
      
      teacheremail.getValidators().add(emailValidator);
      
      emailValidator.setMessage("Incorrect Email");
     
      teacherfirst.focusedProperty().addListener(new ChangeListener<Boolean>() {
               @Override
               public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                   t=teacherfirst.getText();
                   if(!newValue){
                   checkfirstname=v1.firsttextField(teacherfirst);
                       
                       if(!checkfirstname){
                           teacherfirst.setText("");    
                       }
                        teacherfirst.validate();
                   }
                   }
           });
      
      teacheremail.focusedProperty().addListener(new ChangeListener<Boolean>() {
               @Override
               public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                   
                   if(!newValue){
                      checkemail=v1.teacheremailCheck(teacheremail);
                       
                       if(!checkemail){
                           teacheremail.setText("");    
                       }
                        teacheremail.validate();
                   }
               }
           });
        
        
    }
    @FXML
    void signup(ActionEvent event) throws IOException ,ClassNotFoundException ,IllegalAccessException,InstantiationException{
        
        if(checkemail){
              dc.setmenuButton(teacherfirst.getText());
              
              new Thread(() -> {
                databasehandler = DatabaseHandler.getInstance(); 
              }).start(); 
              
              
              Parent dashboard_parent= FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
              Scene dashboard_scene = new Scene(dashboard_parent);
              Stage dashboard_stage= (Stage)((Node) event.getSource()).getScene().getWindow();
              dashboard_stage.setScene(dashboard_scene);
              dashboard_stage.setMaximized(true);
              dashboard_stage.show();
              
         }
              
    }
    public String teacher(){ 
        return t;
    }
    
    
}
