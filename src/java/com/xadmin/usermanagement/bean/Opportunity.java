
package com.xadmin.usermanagement.bean;

/**
 *
 * Code taken and adapted from https://www.youtube.com/watch?v=-3m2_wHWXf4
 */
public class Opportunity {
    private int id;
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
    
    
     public Opportunity(String activity, String location, String payment, String sdate, String edate, String length, String dname, String dbreed, String dage, String additional) {
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
    }
  
    public Opportunity(int id, String activity, String location, String payment, String sdate, String edate, String length, String dname, String dbreed, String dage, String additional) {
        this.id = id;
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
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
   
}
