/**
 *
 */
package com.crs.flipkart.application;

import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.utils.DBUtils;
import com.mysql.jdbc.Connection;

import java.util.Scanner;

/**
 * @author Tushar
 *
 */
public class CRSApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = (Connection) DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================================");
        System.out.println("********************WELCOME to Course Registration System!!!********************");
        System.out.println("================================================================================");

        printMenu();
        int Input = sc.nextInt();

        while (Input != 4) {
            switch (Input) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    updatePassword();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter a valid input");
            }
            printMenu();
            Input = sc.nextInt();
        }
        System.out.println("*******************************Thank you for using our Application.*********************************");
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("------------------------------------MAIN MENU-----------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.println("1. Student Signup");
        System.out.println("2. Login ");
        System.out.println("3. UpdatePassword");
        System.out.println("4. Exit");
        System.out.println("------------------------------------------");
        System.out.print("ENTER YOUR CHOICE----->:\t");

    }


    private static void registerStudent() {

    }

    private static void login() {
        Scanner sc = new Scanner(System.in);
        String email, password;
        System.out.println("Email:");
        email = sc.nextLine();
        System.out.println("Password:");
        password = sc.nextLine();

        Boolean loggedIn = true;  //Authentication

        if (loggedIn) {
            int role = 2; //after authorization

            switch (role) {
                case 1:
                    int isApproved = 1; //check approval
                    if (isApproved == 1) {
                        System.out.println("Login Successful!");
                        CRSStudentMenu studentMenu = new CRSStudentMenu();

                    } else {
                        System.out.println("You have not been approved by the admin!");
                        loggedIn = false;
                    }
                    break;
                case 2:
                    int profId = new ProfessorDAO().checkCredentials(email, password);
                    System.out.println(profId);
                    if (profId != -1) {
                        CRSProfessorMenu professorMenu = new CRSProfessorMenu();
                        professorMenu.professorMenu(profId);
                    } else {
                        System.out.println("Invalid!!");
                    }
                    break;
                case 3:
                    System.out.println("Login Successful!");
                    CRSAdminMenu studentMenu = new CRSAdminMenu();

                    break;

            }
        }

    }


    private static void updatePassword() {
        Scanner sc = new Scanner(System.in);
        String email, password;
        System.out.println("Email:");
        email = sc.nextLine();
        System.out.println("Password:");
        password = sc.nextLine();
        int profId = new ProfessorDAO().checkCredentials(email, password);
        if (profId != -1) {
            System.out.println("Enter new password:");
            String new_password = sc.nextLine();
            new ProfessorDAO().updateCredentials(email, new_password);
            System.out.println("Password Updated Successfully!!!");
        } else {
            System.out.println("Invalid!!");
        }
    }


}

