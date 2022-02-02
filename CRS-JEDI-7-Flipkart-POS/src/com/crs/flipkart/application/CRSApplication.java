/**
 *
 */
package com.crs.flipkart.application;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.*;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.utils.DBUtils;
import com.mysql.jdbc.Connection;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

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
        /*
         * Main Menu of the project
         *
         * */
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

    /*
     *Student signup function
     *
     * */
    private static void registerStudent() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter your name:");
        student.setName(sc.nextLine());
        System.out.println("Enter your password:");
        student.setPassword(sc.nextLine());
        System.out.println("Please select your Branch:\n1)CSE\n2)ICT\n3)Mechanical");
        int br = Integer.valueOf(sc.nextLine());
        switch (br) {
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
        student.setSemester(-1);
        student.setApproved(false);
        System.out.println("Enter your Address:");
        student.setAddress(sc.nextLine());
        System.out.println("Please select your Gender:\n1)Male\n2)Female");
        int gen = Integer.valueOf(sc.nextLine());
        switch (gen) {
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
        new StudentService().getLastId(student);
        int sid = student.getStudentId();
        sid++;
        student.setStudentId(sid);
        String email = String.valueOf(sid) + "@gm.com";
        student.setStudentId(sid);
        student.setEmailId(email);
        student = new StudentService().saveStudent(student);
        System.out.println("\033[1mYour Student ID:" + student.getStudentId() + "\nYour email ID:" + student.getEmailId() + "\nPlease wait for the admin to approve your profile.\033[0m");
    }
    /*
     *Login function
     *
     * */
    private static void login() {
        Scanner sc = new Scanner(System.in);
        String email, password;
        System.out.println("Email:");
        email = sc.nextLine();
        System.out.println("Password:");
        password = sc.nextLine();

        Boolean loggedIn = false;
        int role = -1;
        int profId = new ProfessorService().checkCredentials(email, password);
        int studentId = new StudentService().checkCredentials(email, password);
        int adminId = new AdminService().checkCredentials(email, password);
        if (studentId != -1) {
            loggedIn = true;
            role = 1;
        } else if (profId != -1) {
            loggedIn = true;
            role = 2;
        } else if (adminId != -1) {
            loggedIn = true;
            role = 3;
        }


        if (loggedIn) {


            switch (role) {
                case 1:
                    boolean isApproved = new StudentService().getStudentById(studentId).isApproved();
                    if (isApproved) {
                        System.out.println("\033[1mLogin Successful!\033[0m");
                        displayLoginTime(studentId,1);
                        CRSStudentMenu studentMenu = new CRSStudentMenu();
                        studentMenu.create_menu(studentId);

                    } else {
                        System.out.println("User not approved. Wait for admin approval");
                        loggedIn = false;
                    }
                    break;
                case 2:
                    System.out.println("\033[1mLogin Successful!\033[0m");
                    displayLoginTime(profId,2);
                    CRSProfessorMenu professorMenu = new CRSProfessorMenu();
                    professorMenu.professorMenu(profId);
                    break;
                case 3:
                    System.out.println("\033[1mLogin Successful!\033[0m");
                    displayLoginTime(adminId,3);
                    CRSAdminMenu adminMenu = new CRSAdminMenu();
                    adminMenu.createMenu();
                    break;

            }
        }
        else{
            System.out.println("invalid Email id or password");
        }
    }

    private static void displayLoginTime(int Id,int role) {
    	String name="";
    	switch(role) {
    		case 1:
    			Student student = new StudentService().getStudentById(Id);
    			name = student.getName();
    			break;
    		case 2: 
    			Professor prof = new ProfessorService().getProfessorById(Id);
    			name = prof.getName();
    			break;
    		case 3:
    			name = "Admin";
    			break;
    			
    	}
    	LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		
    	//System.out.println("------------------------------------------");
    	System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println("Welcome "+ name);
    	System.out.println("Time of Login :- "+ localTime + "on " + localDate);
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    	//System.out.println("------------------------------------------");
    }

    /*
     *Update Password function
     *
     * */
    private static void updatePassword() {
        Scanner sc = new Scanner(System.in);
        String email, password;
        System.out.println("Email:");
        email = sc.nextLine();
        System.out.println("Password:");
        password = sc.nextLine();
        int profId = new ProfessorService().checkCredentials(email, password);
        int studentId = new StudentService().checkCredentials(email, password);
        int adminId = new AdminService().checkCredentials(email, password);
        if (profId != -1) {
            System.out.println("Enter new password:");
            String new_password = sc.nextLine();

            ProfessorInterface professorInterface = new ProfessorService();
            professorInterface.updateCredentials(email, new_password);
            System.out.println("Password Updated Successfully!!!");

        } else if (studentId != -1){
            System.out.println("Enter new password:");
            String new_password = sc.nextLine();

            StudentServiceInterface studentServiceInterface =  new StudentService();
            studentServiceInterface.updateCredentials(email, new_password);
            System.out.println("Password Updated Successfully!!!");

        } else if(adminId != -1){
            System.out.println("Enter new password:");
            String new_password = sc.nextLine();

            AdminServiceInterface adminServiceInterface = new AdminService();
            adminServiceInterface.updateCredentials(email, new_password);
            System.out.println("Password Updated Successfully!!!");

        } else {
            System.out.println("Invalid!!");
        }
    }


}

