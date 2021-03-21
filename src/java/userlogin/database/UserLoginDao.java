/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userlogin.database;

/* Below code taken and adapted from https://www.codejava.net/coding/how-to-code-login-and-logout-with-java-servlet-jsp-and-mysql*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import userlogin.bean.UserLoginBean;

public class UserLoginDao {

    public UserLoginBean checkLogin(String name, String pass) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String dbUser = "root";
        String dbPassword = "Eventide1";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM user WHERE name = ? and pass = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, pass);
 
        ResultSet result = statement.executeQuery();
 
        UserLoginBean user = null;
 
        if (result.next()) {
            user = new UserLoginBean();
            user.setName(result.getString("name"));
            user.setPass(pass); //email?
        }
 
        connection.close();
 
        return user;
    }
}