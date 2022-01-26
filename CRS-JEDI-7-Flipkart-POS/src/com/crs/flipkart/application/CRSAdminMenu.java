/**
 * 
 */
package com.crs.flipkart.application;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDao;
import com.crs.flipkart.dao.StudentDao;

import java.util.Scanner;
/**
 * @author Tushar
 *
 */
public class CRSAdminMenu {
    Scanner scanner = new Scanner(System.in);

    public void createMenu(){

        int in=0;
        while(in!=6) {
            System.out.println("\n\n----------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------ADMIN MENU---------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------\n");

            System.out.println("1. Add Course to catalog");
            System.out.println("2. Delete Course from catalog");
            System.out.println("3. Approve Students");
            System.out.println("4. Add Professor");
            System.out.println("5. Generate Report Card");

            System.out.println("6. Exit Admin Menu");

            System.out.println("------------------------------------------");
            System.out.print("ENTER YOUR CHOICE--->:\t");


            in=scanner.nextInt();
            scanner.nextLine();
            switch(in) {
                case 1:
                    addCourse();
                    break;

                case 2:
                    deleteCourse();
                    break;

                case 3:
                    approveStudent();
                    break;

                case 4:
                    addProfessor();
                    break;

                case 5:
                    generateReport();
                    break;


                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    /**
     * Method to add course to DB
     */
    private void addCourse()
    {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------ADD COURSE TO CATALOG--------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------\n");

        System.out.println("Enter Course Code:");
        String courseCode = scanner.nextLine();

        System.out.println("Enter Course Name:");
        String courseName = scanner.nextLine();

        //TODO : Implement course addtion

        System.out.println("---------------------------------------------------------------------------------------------\n");

    }


    /**
     * Method to delete course from DB
     */
    private void deleteCourse()
    {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------DELETE COURSE FROM CATALOG--------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------\n");

        System.out.println("Enter Course Code:");
        String courseCode = scanner.next();

        //TODO : Implement Course Deletion

        System.out.println("---------------------------------------------------------------------------------------------\n");

    }


    /**
     * Method to approve studentId
     */
    private boolean approveStudent()
    {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------APPROVE STUDENT--------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------\n");

        System.out.println("Enter Student's ID:");
        int studentUserIdApproval = scanner.nextInt();

        Student student = new StudentDao().getStudentById(studentUserIdApproval);
        System.out.println(student.getStudentId());
        if(student == null){
            System.out.println("Student doesn't exist");
        }
        else if (student.isApproved()){
            System.out.println("Student already approved");
        }
        else {
            new AdminDao().approveStudent(student);
            System.out.println("Student Approved");
        }

        System.out.println("---------------------------------------------------------------------------------------------\n");

        return false;
    }


    /**
     * Method to add Professor from DB
     */
    private void addProfessor()
    {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------ADD PROFESOR----------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------\n");

        System.out.println("Enter Professor Id:");
        String professorId = scanner.next();

        System.out.println("Enter Professor Name:");
        String professorName = scanner.next();

        System.out.println("Enter Email Id:");
        String emailId = scanner.next();

        System.out.println("Enter Password:");
        String password = scanner.next();

        System.out.println("Enter Phone:");
        String phoneNo = scanner.next();

        System.out.println("Enter Address:");
        String address = scanner.next();

        //TODO : Implement Professor addition

        System.out.println("---------------------------------------------------------------------------------------------\n");

    }




    /**
     * Function to generate report
     */
    private void generateReport()
    {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------GENERATE PROFESOR----------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------\n");

        System.out.println("Enter student Id:");
        String studentId = scanner.nextLine();

        System.out.println("Enter student Semester:");
        int studentSem = scanner.nextInt();

        //TODO : Generate Report Card

        System.out.println("---------------------------------------------------------------------------------------------\n");

    }
}


