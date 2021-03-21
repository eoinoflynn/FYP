/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadmin.usermanagement.bean;

/**
 *
 * @author eoinp
 */
public class Application {
    private int appid;
    private String activity;
    private String location;
    private String payment;
    private String sdate;
    private String edate;
    private String length;
    private String dname;
    private String dbreed;
    private String dage;
    private String additional;
    private String name;

    public Application(int appid, String activity, String location, String payment, String sdate, String edate, String length, String dname, String dbreed, String dage, String additional, String name) {
        this.appid = appid;
        this.activity = activity;
        this.location = location;
        this.payment = payment;
        this.sdate = sdate;
        this.edate = edate;
        this.length = length;
        this.dname = dname;
        this.dbreed = dbreed;
        this.dage = dage;
        this.additional = additional;
        this.name = name;
    }

    public Application(String activity, String location, String payment, String sdate, String edate, String length, String dname, String dbreed, String dage, String additional, String name) {
        this.activity = activity;
        this.location = location;
        this.payment = payment;
        this.sdate = sdate;
        this.edate = edate;
        this.length = length;
        this.dname = dname;
        this.dbreed = dbreed;
        this.dage = dage;
        this.additional = additional;
        this.name = name;
    }
    
    


    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbreed() {
        return dbreed;
    }

    public void setDbreed(String dbreed) {
        this.dbreed = dbreed;
    }

    public String getDage() {
        return dage;
    }

    public void setDage(String dage) {
        this.dage = dage;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
