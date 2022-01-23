/**
 *
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class Admin extends User {

    private int adminId;

    public Admin() {
    }

    public Admin(String userId, String name, String password, String emailId, long contactNo, String userType, String address, String gender, int adminId) {
        super(userId, name, password, emailId, contactNo, userType, address, gender);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
