package controller;

import model.DataConnector;
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
public class upstatus {
    public String nam(String id){
        try{
            DataConnector c = new DataConnector();
                    Connection connection = c.Connector();
                    String query="SELECT OrderID FROM orderstatus WHERE OrderID='"+id+"'";

                    Statement statement = connection.createStatement();

                    ResultSet result;
                    
                    result = statement.executeQuery(query);
                    
                    result.next();
                    
                    String name = result.getString("OrderID");
                    return name;
        }
       catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Order Id does not exist");
       }
        return null;
    }
    public boolean up(String sta, String id){
        try{
            DataConnector c = new DataConnector();
            Connection connection = c.Connector();
            String query2="UPDATE orderstatus SET Status = '"+sta+"' WHERE OrderID= '"+id+"'";
            Statement statement = connection.createStatement();
                    statement.executeUpdate(query2); 
                    JOptionPane.showMessageDialog(null, "Successfully updated");
            return true;
        } 
        
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Order Id does not exist");
       }
        return false;
       
    }
    
    }

