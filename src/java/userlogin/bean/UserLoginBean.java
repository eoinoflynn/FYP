/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userlogin.bean;

/**
 *
 * @author eoinp
 */
/* Below code taken and adapted from https://www.javaguides.net/2019/03/login-form-using-jsp-servlet-jdbc-mysql-example.html*/

import java.io.Serializable;

public class UserLoginBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
