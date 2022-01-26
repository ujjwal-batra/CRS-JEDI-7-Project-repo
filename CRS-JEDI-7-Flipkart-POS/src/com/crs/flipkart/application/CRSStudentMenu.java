/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

/**
 * @author Tushar
 *
 */
public class CRSStudentMenu {
    Scanner sc = new Scanner(System.in);

    private int semester = 1;

    private boolean is_registered=true;


    /**
     * Method to generate Student Menu for course registration, addition, removal
     * and fee payment
     *
     * @param studentId student id
     */
    public void create_menu(int studentId) {

        while (is_registered) {
            System.out.println("\n\n----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------STUDENT MENU--------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------\n");

            System.out.println("1. Semester Registration");
            System.out.println("2. Add Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Course");
            System.out.println("5. View Registered Courses");
            System.out.println("6. View grade card");
            System.out.println("7. Make Payment");
            System.out.println("8. Logout");
            System.out.println("------------------------------------------");
            System.out.print("ENTER YOUR CHOICE---->:\t");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    semesterRegistraion(studentId);
                    break;

                case 2:
                    addCourse(studentId);
                    break;

                case 3:

                    dropCourse(studentId);
                    break;

                case 4:
                    viewCourse(studentId);
                    break;

                case 5:
                    viewRegisteredCourse(studentId);
                    break;

                case 6:
                    viewGradeCard(studentId);
                    break;

                case 7:
                    make_payment(studentId);
                    break;

                case 8:
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }


    /**
     * Select course for registration
     *
     * @param studentId
     */
    private void semesterRegistraion(int studentId) {
        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------SEMESTER REGISTERATION-------------------------");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("Enter Semester : ");
        semester = sc.nextInt();
        sc.nextLine();

        //TODO : Implement Semester Registration


        System.out.println("Registration Successful");
        System.out.println("-----------------------------------------------------------------------------------------\n\n");
        is_registered = true;

    }


    /**
     * Add course for registration
     *
     * @param studentId

     */
    private void addCourse(int studentId) {
        if (is_registered) {

            //TODO : Implement Course Addition

        } else {
            System.out.println("Please complete registration");
        }

    }


    private void dropCourse(int studentId) {
        if (is_registered) {

            //TODO : Implement Course Dropping

        } else {
            System.out.println("Please complete registration");
        }

    }

    private void viewCourse(int studentId) {


            //TODO : Implement View Course


    }


    private void viewRegisteredCourse(int studentId) {
        if (is_registered) {

            //TODO : Implement View Registered Course

        } else {
            System.out.println("Please complete registration");
        }

    }

    private void viewGradeCard(int studentId) {


        //TODO : Implement View Grade Card Addition

    }


    private void make_payment(int studentId) {
        if (is_registered) {

            //TODO : Implement Make Payment

        } else {
            System.out.println("Please complete registration");
        }

    }








}
