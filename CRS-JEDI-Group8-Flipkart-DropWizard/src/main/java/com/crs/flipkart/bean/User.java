/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class User {

    private String name;
    private String password;
    private String emailId;
    private long contactNo;
    private String userType;
    private String address;
    private String gender;

    public User() {
    }

    public User(String name, String password, String emailId, long contactNo, String userType, String address, String gender) {
        this.name = name;
        this.password = password;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.userType = userType;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
