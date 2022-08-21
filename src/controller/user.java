package controller;

import model.DataConnector;
import view.User_pannel;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class user {
    public boolean signIn(String userID, String pass){
        try{
        DataConnector c = new DataConnector();
                Connection connection = c.Connector();
                String query="SELECT Password FROM user1 WHERE UserID='"+userID+"'";
        
            Statement statement = connection.createStatement();
        
            ResultSet result;
            result = statement.executeQuery(query);
            result.next();
            String name = result.getString("Password");
           if(name.equals(pass)){
               JOptionPane.showMessageDialog(null, "SignIn Successful");
                User_pannel admin= new User_pannel();
                admin.setVisible(true);
           }
           else{
               JOptionPane.showMessageDialog(null, "Incorrect Password");
           }
           return true;
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
           JOptionPane.showMessageDialog(null, "UserId does not exist");
       }
        return false;
    }
    
    
    public boolean signup(String UserId,String fName,String lName,String email,String address,String pass, String conpass){
       try{
            DataConnector c = new DataConnector();
                Connection connection = c.Connector();
             
            try{
                String query="SELECT UserID FROM user1 WHERE UserID= '"+UserId+"'";
        
                Statement statement = connection.createStatement();
                 ResultSet result;
                result = statement.executeQuery(query);
                result.next();
                String name2 = result.getString("UserID");
            
                JOptionPane.showMessageDialog(null, name2+" : User id alrady exist");
            
                
            }
            catch (SQLException e){
                
                if(pass.equals(conpass)){
                    String query="insert into user1 (UserID,FName,LName,Email,Address,Password) values ('"+UserId+"','"+fName+"','"+lName+"','"+email+"','"+address+"','"+pass+"')";
                        
                    Statement statement = connection.createStatement();
                    
            
                    statement.executeUpdate(query); 
                    JOptionPane.showMessageDialog(null, "SignUp Successfull");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password did not match");
                }
       }
            return true;
       
    }
       catch(HeadlessException | ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, "Somethnig went wrong");
               }
            return false;
    }
}
