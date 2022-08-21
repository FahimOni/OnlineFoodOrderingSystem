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
public class delete {

    public boolean del(String id) {
        try {
            DataConnector c = new DataConnector();
            Connection connection = c.Connector();
            String query = "SELECT CatalogueID FROM fooditem WHERE CatalogueID= '" + id + "'";

            Statement statement = connection.createStatement();

            ResultSet result;
            result = statement.executeQuery(query);
            result.next();
            String name = result.getString("CatalogueID");
            if (name.equals(id)) {

                String query2 = "DELETE FROM fooditem WHERE CatalogueID= '" + id + "'";
                statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            }
            return true;
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "CatalogueID does not exist");
        }
        return false;
    }
}
