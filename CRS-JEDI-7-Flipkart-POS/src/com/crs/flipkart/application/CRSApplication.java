/**
 *
 */
package com.crs.flipkart.application;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.StudentDao;
import com.crs.flipkart.utils.DBUtils;
import com.mysql.jdbc.Connection;
import sun.security.jca.GetInstance;

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
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter your name:");
        student.setName(sc.nextLine());
        System.out.println("Enter your password:");
        student.setPassword(sc.nextLine());
        System.out.println("Please select your Branch:\n1)CSE\n2)ICT\n3)Mechanical");
        int br = Integer.valueOf(sc.nextLine());
        switch (br){
            case 1:
                student.setBranch("CSE");
                break;
            case 2:
                student.setBranch("ICT");
                break;
            case 3:
                student.setBranch("Mechanical");
                break;
            default:
                student.setBranch("None");
                break;
        }
        student.setSemester(1);
        student.setApproved(false);
        System.out.println("Enter your Address:");
        student.setAddress(sc.nextLine());
        System.out.println("Please select your Branch:\n1)Male\n2)Female");
        int gen = Integer.valueOf(sc.nextLine());
        switch (gen){
            case 1:
                student.setGender("MALE");
                break;
            case 2:
                student.setGender("FEMALE");
                break;
            default:
                student.setGender("None");
                break;
        }
        System.out.println("Enter your Contact No.:");
        student.setContactNo(Integer.valueOf(sc.nextLine()));
        new StudentDao().getLastId(student);
        int sid = student.getStudentId();
        sid++;
        student.setStudentId(sid);
        String email = String.valueOf(sid) + "@gm.com";
        student.setStudentId(sid);
        student.setEmailId(email);
        student = new StudentDao().saveStudent(student);
        System.out.println("Your Student ID:" + student.getStudentId() + "\n Your email ID:" + student.getEmailId() + "\n Please wait for the admin to approve your profile.");
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

