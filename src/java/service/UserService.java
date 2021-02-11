/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import model.User;
import utils.IConstants;

/**
 *
 * @author be_me
 */
public class UserService {
    
    public User loginUser(String email, String password){
        
       UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(email);
        if (user.getPassword().equals(password)){
            return user;
        }
        else return null;
    }
    
}
