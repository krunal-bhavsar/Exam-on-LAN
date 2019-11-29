
package com;

import javafx.scene.control.TextField;

public class Validation {
  
    public boolean firsttextField(TextField nametext){
        boolean check=false;
        //String validationWrong="Welcome "+t1.getText();
       if(nametext.getText().matches("[A-Za-z]*") && !nametext.getText().isEmpty()) {
           check=true;
       } 
        return check;
    }
    public boolean emailCheck(TextField emailtext){
        boolean check=false;
        if(emailtext.getText().matches("[d]*[1-7]+[a-zA-z]+[0-9]+@charusat.edu.in") && !emailtext.getText().isEmpty())
        {
            check=true;
        }
            return check;
    }
    public boolean teacheremailCheck(TextField emailtext){
        boolean check=false;
        if(emailtext.getText().matches("[a-zA-z_.0-9]*@[a-zA-Z]*[.]+[a-zA-Z]*") && !emailtext.getText().isEmpty())
        {
            check=true;
        }
            return check;
    }
    
}
