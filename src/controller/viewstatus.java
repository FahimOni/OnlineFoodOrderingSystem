/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DataConnector;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class viewstatus {
    public boolean view(String id){
        try{
        DataConnector c = new DataConnector();
                Connection connection = c.Connector();
            
            String query="SELECT Status FROM orderstatus WHERE OrderID='"+id+"'";
        
            Statement statement = connection.createStatement();
        
            ResultSet result;
            result = statement.executeQuery(query);
            result.next();
            String name = result.getString("Status");
            JOptionPane.showMessageDialog(null,name);
            return true;
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, " Order ID does not exist ");
               } 
            return true;
}
}
