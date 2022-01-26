/**
 * 
 */
package com.crs.flipkart.application;
import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDao;
import com.crs.flipkart.dao.AdminDaoInterface;
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
        int courseCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Course Name:");
        String courseName = scanner.nextLine();

        boolean isAdded = new AdminDao().addCourse(courseCode, courseName);
        if(isAdded)
            System.out.println("Course added successfully");
        else
            System.out.println("Error while adding course");
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
        int courseCode = scanner.nextInt();

        boolean isDeleted = new AdminDao().deleteCourse(courseCode);
        if(isDeleted)
            System.out.println("Course Removed from catalog");
        else
            System.out.println("Error while removing course from catalog");
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

        Professor professor = new Professor();

        System.out.println("Enter Professor Id:");
        int professorId = scanner.nextInt();
        professor.setProfessorId(professorId);
        scanner.nextLine();

        System.out.println("Enter Professor Name:");
        String professorName = scanner.nextLine();
        professor.setName(professorName);

        System.out.println("Enter Email Id:");
        String emailId = scanner.nextLine();
        professor.setEmailId(emailId);

        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        professor.setPassword(password);

        System.out.println("Enter Phone:");
        long phoneNo = scanner.nextInt();
        professor.setContactNo(phoneNo);
        scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        professor.setAddress(address);

        System.out.println("Please select your Gender:\n1)Male\n2)Female");
        int gen = Integer.valueOf(scanner.nextLine());
        switch (gen){
            case 1:
                professor.setGender("MALE");
                break;
            case 2:
                professor.setGender("FEMALE");
                break;
            default:
                professor.setGender("None");
                break;
        }

        System.out.println("Please select your Branch:\n1)CSE\n2)ICT\n3)Mechanical");
        int br = Integer.valueOf(scanner.nextLine());
        switch (br){
            case 1:
                professor.setDepartment("CSE");
                break;
            case 2:
                professor.setDepartment("ICT");
                break;
            case 3:
                professor.setDepartment("Mechanical");
                break;
            default:
                professor.setDepartment("None");
                break;
        }

        boolean isAdded = new AdminDao().addProfessor(professor);
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


