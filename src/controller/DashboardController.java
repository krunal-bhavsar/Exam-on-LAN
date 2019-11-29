
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;


public class DashboardController implements Initializable {

    
    @FXML
    private MenuButton menu;
    
    public static String text;
    @FXML
    private Label examlabel;
    @FXML
    private Label studentlabel;
    @FXML
    private AnchorPane contentArea;
    @FXML
    private JFXButton exam;
    @FXML
    private JFXButton dashboardbutton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menu.setText(text);
        
    }  
   
    public void setmenuButton(String s){
             text=s;
    }
    
    @FXML
    private void Exams(MouseEvent event) throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/Exams.fxml")); 
         contentArea.getChildren().removeAll();
         contentArea.getChildren().setAll(fxml);
    }
    public void exammethod(AnchorPane examcontentarea,String res)throws IOException{
          Parent fxml = FXMLLoader.load(getClass().getResource(res)); 
          examcontentarea.getChildren().removeAll();
          examcontentarea.getChildren().setAll(fxml);
    }
    
    

    
    
    
    
}
