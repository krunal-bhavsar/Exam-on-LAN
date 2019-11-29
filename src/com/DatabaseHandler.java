package com;
import controller.TeacherSignupController;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DatabaseHandler {
    
    private static String DB_URL;
    private static DatabaseHandler handler=null;
    private static Connection conn=null;
    private static Statement stmt = null;
    public String DATABASE_NAME="student";
    
    public void databasename(){
           TeacherSignupController t=new TeacherSignupController();
        DATABASE_NAME=t.teacher();
        System.out.println(DATABASE_NAME);        
    }
    private DatabaseHandler() {
        databasename();
        DB_URL="jdbc:derby:"+DATABASE_NAME+";create=true";
        createConnection(); 
    }
    public static DatabaseHandler getInstance(){
        if(handler==null){
            handler=new DatabaseHandler();
        }
        return handler;
    }

    public void createConnection(){
            try { 
                   Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                   conn = DriverManager.getConnection(DB_URL); 
                   
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                   Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
    }
   public void setupAdmin(String Table_name) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        try {
            stmt =conn.createStatement();
            DatabaseMetaData dbm=conn.getMetaData();
            ResultSet tables =dbm.getTables(null,null, Table_name.toUpperCase(),null);
            if(tables.next()){
                System.out.println("Table "+Table_name+" Already exitsts");
            }else{
                stmt.execute("CREATE TABLE "+Table_name + "("
                        + "          email varchar(30) primary key,\n"
                        + "          password varchar(100)"
                        + " )");
                System.out.println("Table created");
            }       
                
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   public ResultSet execuquery(String sql){
       ResultSet result;
       try{
           stmt =conn.createStatement();
           result=stmt.executeQuery(sql);
           
       } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
       }
       return result;
   }
   public boolean execAction(String sql){
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            
        }
        
   }
}
