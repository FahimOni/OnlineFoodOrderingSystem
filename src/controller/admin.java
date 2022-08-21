package controller;

import model.DataConnector;
import view.Admin_Pannel;
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
public class admin {

    public boolean login(String email, String pass) throws SQLException, ClassNotFoundException {
        try {
            DataConnector c = new DataConnector();

            Connection connection = c.Connector();
            String query = "SELECT Password FROM admin1 WHERE Email='" + email + "'";

            Statement statement = connection.createStatement();

            ResultSet result;
            result = statement.executeQuery(query);
            result.next();
            String name = result.getString("Password");
            if (name.equals(pass)) {
                JOptionPane.showMessageDialog(null, "Successfull Login");
                Admin_Pannel admin = new Admin_Pannel();
                admin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
            return true;
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Email does not exist");
        }
        return false;
    }
}
