
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Future
 */
public class ExamsController implements Initializable {

    @FXML
    private JFXButton newExambutton;
    @FXML
    private AnchorPane examcontentarea;

    DashboardController d=new DashboardController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newExammethod(ActionEvent event)throws IOException {
           d.exammethod(examcontentarea,"/fxml/Exam1.fxml");
    }
    
}
