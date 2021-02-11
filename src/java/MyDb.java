
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eoinp
 */

/* Code taken and adapted from Java Database connectivity "https://www.youtube.com/watch?v=akW6bzoRcZo&app=desktop" */
/* Creating user */
public class MyDb {
    Connection con;

    public Connection getCon()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","Eventide1");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
            
}
