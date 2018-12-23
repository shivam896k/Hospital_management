package Gui;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connectdb {

    Connection con = null;

    public static Connection ConnectDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "helloshivam");
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
