package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.dao.CourseCatalogueDAO;
import com.crs.flipkart.dao.ProfessorDAO;

import java.util.List;
import java.util.Scanner;

public class CRSProfessorMenu {


    public void professorMenu(int professorId) {
        Scanner sc = new Scanner(System.in);

        int in = 1;
        while (in != 6) {
            System.out.println("\n\n----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------PROFESSOR MENU---------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------\n");

            System.out.println("1. View Course Catalogue");
            System.out.println("2. Show my courses");
            System.out.println("3. View Enrolled Students");
            System.out.println("4. Add grade");
            System.out.println("5. Select Course to teach");
            System.out.println("6. Logout");

            System.out.println("---------------------------------------------------------------------------");
            System.out.print("ENTER YOUR CHOICE--->:\t");
            System.out.println();

            in = sc.nextInt();

            switch (in) {
                case 1:
                    //show course catalogue
                    showCourseCatalogue();
                    break;
                case 2:
                    //view all the courses taught by the professor
                    showMyCourses(professorId);
                    break;
                case 3:
                    //view all the enrolled students for the course
                    viewStudents(professorId);
                    break;

                case 4:
                    //add grade for a student
                    addGrade();
                    break;
                case 5:
                    //select course to teach
                    selectCourseToTeach(professorId);
                    break;
                case 6:
                    //logout from the system
                    return;
                default:
                    System.out.println("Select right option.");
            }

        }
        sc.close();


    }

    private void selectCourseToTeach(int professorId) {
        showCourseCatalogue();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course id: ");
        int courseId = sc.nextInt();
        new ProfessorService().selectCourseToTeach(courseId, professorId);
    }

    private void showMyCourses(int professorId) {

        Professor professor = new ProfessorDAO().getProfessorById(professorId);
        if (professor.getCourseList().isEmpty()) System.out.println("Not yet registered for any course");
        else System.out.println("Course details: ");
        for (Course course : professor.getCourseList()) {
            System.out.println("CourseId: " + course.getCourseId() +
                    ", CourseName: " + course.getCourseName() +
                    ", Professor: " + course.getProfessor().getName());
        }
    }

    private void showCourseCatalogue() {
        for (Course course : new CourseCatalogueDAO().getCourseCatalogue().getCourseList()) {
            System.out.println("CourseId: " + course.getCourseId() +
                    ", CourseName: " + course.getCourseName() +
                    ", Professor: " + (course.getProfessor() == null ? "Not yet assigned" : course.getProfessor().getName()));
        }
    }

    private void viewStudents(int professorId) {

        List<Student> studentList = new ProfessorService().viewStudentsForAllCourses(professorId);
        if (studentList.isEmpty()) System.out.println("No Students enrolled");
        else System.out.println("Student details: ");

        for (Student student : studentList) {
            System.out.println(
                    "Name: " + student.getName() +
                            ", contactNo: " + student.getContactNo() +
                            ", branch: " + student.getBranch()
            );
        }
    }

    private void addGrade() {
        Scanner scanner = new Scanner(System.in);
        int courseId, studentId, semester;
        double marks;

        System.out.print("Enter courseId: ");
        courseId = scanner.nextInt();
        System.out.print("Enter studentId: ");
        studentId = scanner.nextInt();
        System.out.print("Enter semester: ");
        semester = scanner.nextInt();
        System.out.print("Enter marks: ");
        marks = scanner.nextDouble();
        new ProfessorService().addGrade(courseId, studentId, semester, marks);
    }


}
