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
public class Newitem {

    public boolean item(String name, String price, String id) throws SQLException, ClassNotFoundException {

        DataConnector c = new DataConnector();
        Connection connection = c.Connector();

        try {
            String query = "SELECT CatalogueID FROM fooditem WHERE CatalogueID= '" + id + "'";

            Statement statement = connection.createStatement();
            ResultSet result;
            result = statement.executeQuery(query);
            result.next();
            String name2 = result.getString("CatalogueID");

            JOptionPane.showMessageDialog(null, name2 + " : Catalogue id alrady exist");
            return true;

        } catch (SQLException e) {
            try {
                String query2 = "SELECT FoodName FROM fooditem WHERE FoodName= '" + name + "'";
                Statement statement = connection.createStatement();
                ResultSet result;
                result = statement.executeQuery(query2);
                result.next();
                String name2 = result.getString("FoodName");

                JOptionPane.showMessageDialog(null, name2 + " : Food name is alrady exist");
            } catch (HeadlessException | SQLException e1) {

                String query = "insert into fooditem (FoodName,Price,CatalogueID) values ('" + name + "','" + price + "','" + id + "')";

                Statement statement = connection.createStatement();

                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successfully added");
            }
        }
        return false;

    }

}

//.

