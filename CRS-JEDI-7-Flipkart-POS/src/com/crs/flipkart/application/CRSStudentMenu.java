/**
 *
 */
package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tushar
 *
 */
public class CRSStudentMenu {
    Scanner sc = new Scanner(System.in);

    private int semester = 1;

    private boolean is_registered = true;


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
            System.out.println("2. Show Course Catalogue");
            System.out.println("3. Course Registration");
            System.out.println("4. Add or Drop Course");
            System.out.println("5. View Registered Courses");
            System.out.println("6. View grade card");
            System.out.println("7. Make Payment");
            System.out.println("8. View Notification");
            System.out.println("9. Logout");
            System.out.println("------------------------------------------");
            System.out.print("ENTER YOUR CHOICE---->:\t");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    semesterRegistraion(studentId);
                    break;
                case 2:
                    showCourseCatalogue();
                    break;
                case 3:
                    courseRegistration(studentId);
                    break;
                case 4: {
                    addOrDrop(studentId);
                    break;
                }
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
                    showNotification(studentId);
                    return;

                case 9:
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }

    private void showNotification(int studentId) {
        PaymentNotificationInterface paymentNotificationInterface = new PaymentNotificationService();
        List<String> notificationsList = paymentNotificationInterface.getNotificationById(studentId);
        System.out.println(notificationsList);
    }

    private void addOrDrop(int studentId) {
        if (is_registered) {
            List<String> courseNames = new StudentService().viewRegisteredCourse(studentId);
            if (courseNames.size() == 0) {
                System.out.println("Kindly complete the course registration process before add or drop");
                return;
            }

            System.out.println("1. Add a new course");
            System.out.println("2. Drop existing course");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addCourse(studentId);
                    break;
                case 2:
                    dropCourse(studentId);
                    break;
            }
        } else {
            System.out.println("Please complete registration");
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

        boolean status = new StudentService().semesterRegistration(studentId, semester);

        if (status) {
            System.out.println("Registration Successful");
            is_registered = true;
        } else {
            System.out.println("Registration Failure");
        }
        System.out.println("-----------------------------------------------------------------------------------------\n\n");
    }


    /**
     * Add course for registration
     *
     * @param studentId

     */
    private void courseRegistration(int studentId) {
        if (is_registered) {
            showCourseCatalogue();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1st primary course");
            int pc1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter 2nd primary course");
            int pc2 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter 3rd primary course");
            int pc3 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter 4th primary course");
            int pc4 = Integer.parseInt(sc.nextLine());

            System.out.println("Enter 1st secondary course");
            int sc1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter 2nd secondary course");
            int sc2 = Integer.parseInt(sc.nextLine());

            ArrayList<Integer> registeredCourse = new StudentService().courseRegistration(studentId,
                    new int[]{pc1, pc2, pc3, pc4},
                    new int[]{sc1, sc2}
            );
            if (registeredCourse.size() == 4) {
                System.out.println("Registration Successful ::: Assigned courses = " + registeredCourse);
            } else {
                System.out.println("Registration Failure");
            }
            System.out.println("-----------------------------------------------------------------------------------------\n\n");
        } else {
            System.out.println("Please complete registration");
        }
    }

    private void showCourseCatalogue() {
        for (Course course : new CourseOperationService().getCourseCatalogue().getCourseList()) {
            System.out.println("CourseId: " + course.getCourseId() +
                    ", CourseName: " + course.getCourseName() +
                    ", Professor: " + (course.getProfessorId() == -1 || course.getProfessorId() == 0 ? "Not yet assigned" : course.getProfessorId()));
        }
    }

    private void addCourse(int studentId) {
        if (is_registered) {
            showCourseCatalogue();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter course you want to add");
            int courseId = Integer.parseInt(sc.nextLine());

            int status = new StudentService().addCourse(studentId, courseId);
            if (status == 1) {
                System.out.println("Add Successful");
            } else if (status == -1) {
                System.out.println("Course Already registered, please select another course.\n");
                addCourse(studentId);
            } else if (status == -2) {
                System.out.println("Cannot enroll for more than 4 courses, please drop an existing course.\n");
            } else {
                System.out.println("Add Failure");
            }
            System.out.println("-----------------------------------------------------------------------------------------\n\n");
        } else {
            System.out.println("Please complete registration");
        }
    }

    private void dropCourse(int studentId) {
        if (is_registered) {
            viewRegisteredCourse(studentId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter course you want to drop");
            int courseId = Integer.parseInt(sc.nextLine());

            boolean status = new StudentService().dropCourse(studentId, courseId);
            if (status) {
                System.out.println("Drop Successful");
            } else {
                System.out.println("Drop Failure");
            }
            System.out.println("-----------------------------------------------------------------------------------------\n\n");
        } else {
            System.out.println("Please complete registration");
        }
    }

    private void viewRegisteredCourse(int studentId) {
        if (is_registered) {
            List<String> courseNames = new StudentService().viewRegisteredCourse(studentId);
            System.out.println("Registered course: " + courseNames);
        } else {
            System.out.println("Please complete registration");
        }

    }

    private void viewGradeCard(int studentId) {
        if (is_registered) {
            List<String> gradeCard = new StudentService().getGradeCard(studentId);
            System.out.println("Grade Card: " + gradeCard);
        } else {
            System.out.println("Please complete registration");
        }

    }


    private void make_payment(int studentId) {
        if (is_registered) {


            System.out.println("------------------------------------------");
            System.out.println("              Payment Option");
            System.out.println("------------------------------------------");
            System.out.println("1. Online");
            System.out.println("2. Offline");

            System.out.println("Choose any option from the above:\n");

            int choice = sc.nextInt();
            sc.nextLine();


            int invoice;
            String BankName;
            String ifsc;
            int amount = 1000;
            String status = "success";
            System.out.print("Amount to be Paid :\t\tRs. " + amount);
            System.out.println("");
            String mode = "";
            System.out.print("Enter Payment ID:\t");
            int payment_id = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:


                    System.out.print("Enter Invoice Number:\t");
                    invoice = sc.nextInt();
                    System.out.println("");
                    mode = "ONLINE";
                    System.out.println("Payment Successful");
                    break;
                case 2:
                    System.out.print("Enter Depositor's Name:\t");
                    BankName = sc.nextLine();
                    System.out.println("");
                    System.out.print("Enter Invoice Number:\t");
                    invoice = sc.nextInt();
                    System.out.println("Payment Successful");
                    mode = "OFFLINE";
                    break;

                default:
                    System.out.println("Payment Denied\nTry Again!");
                    return;

            }

            PaymentServiceInterface payment = new PaymentService();
            int payment_id1 = payment.makePayment(payment_id, invoice, studentId, amount, status, mode);

            StudentServiceInterface studentServiceInterface = new StudentService();
            Student student = studentServiceInterface.getStudentById(studentId);

            PaymentNotificationInterface paymentNotificationInterface = new PaymentNotificationService();
            paymentNotificationInterface.sendNotification(student, payment_id1);

        } else {
            System.out.println("Please complete registration");
        }

    }


}
