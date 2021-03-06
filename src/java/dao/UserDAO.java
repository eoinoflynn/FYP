/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;
import utils.IConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;

/**
 *
 * @author bemerson
 */
public class UserDAO {

    public User getUserByEmail(String email) {

        User tempUser = new User();

        if (email == "admin@admin.com") {
            tempUser.setEmail("admin@admin.com");
            tempUser.setId(1);
            tempUser.setFirstName("Admin");
            tempUser.setLastName("Admin");
            tempUser.setPassword("Admin");
            tempUser.setUserType(IConstants.USER_TYPE_ADMIN);
        } else {
            tempUser.setEmail("user@user.com");
            tempUser.setId(2);
            tempUser.setFirstName("Bill");
            tempUser.setLastName("User");
            tempUser.setPassword("password");
            tempUser.setUserType(IConstants.USER_TYPE_GENERAL);
        }
        return tempUser;

    }

    public void insertUser(User newUser) {

    }

}
