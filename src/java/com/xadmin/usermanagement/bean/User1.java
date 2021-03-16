/*
 * 
 * Code taken and adapted from https://www.youtube.com/watch?v=-3m2_wHWXf4
 * 
 */
package com.xadmin.usermanagement.bean;


public class User1 {
    private int userid;
    private String name;
    private String pass;

    public User1(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User1(int userid, String name, String pass) {
        this.userid = userid;
        this.name = name;
        this.pass = pass;
    }
    

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

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
