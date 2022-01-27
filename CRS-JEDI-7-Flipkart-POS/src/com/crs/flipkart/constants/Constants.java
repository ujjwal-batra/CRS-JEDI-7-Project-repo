package com.crs.flipkart.constants;

public class Constants {

    /**
     * Admin Constants
     */
    public static final String SELECT_ADMIN_BY_EMAIL = "select * from admin where email = '";
    public static final String APPROVE_STUDENT = "update student SET is_approved = 1  WHERE student_id = ";
    public static final String ADD_NEW_COURSE = "insert into course values(?, ?, ?)";
    public static final String DELETE_COURSE = "delete from course where course_id = ";

    /**
     * Professor Constants
     */
    public static final String ADD_PROFESSOR = "insert into professor values(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_PROFESSOR_BY_ID = "select * from professor where professor_id = ";
    public static final String CHECK_CREDENTIALS_PROFESSOR = "select * from professor where email = '";
    public static final String SELECT_PROFESSOR_BY_EMAIL = "select * from professor where email = ";
    public static final String UPDATE_PROFESSOR_PASSWORD = "update professor set password = ";
    public static final String ADD_GRADE_BY_PROFESSOR = "update enrolled_course set grade = ";

    /**
     * Student Constants
     */
    public static final String ADD_STUDENT = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_STUDENTS = "select * from student";
    public static final String SELECT_STUDENT_BY_ID = "select * from student where student_id = ";
    public static final String CHECK_CREDENTIALS_STUDENT = "select * from student where email = '";
    public static final String SET_STUDENT_SEMESTER = "update student set semester = ";
    public static final String STUDENT_ENROLL_COURSE = "insert into enrolled_course values(?, ?, ?)";
    public static final String STUDENT_DROP_COURSE = "delete from enrolled_course where student_id = ";
    public static final String VIEW_ENROLLED_COURSES = "select * from enrolled_course where student_id = ";

    /**
     * Course Constants
     */
    public static final String SELECT_ALL_COURSES = "select * from course";
    public static final String SELECT_COURSE_BY_ID = "select * from course where course_id = ";
    public static final String ASSIGN_PROFESSOR_TO_COURSE = "update course set professor_id = ";
    public static final String GET_ENROLLED_STUDENT_COUNT = "select count(*) from enrolled_course where course_id = ";
    public static final String GET_STUDENT_LIST_BY_COURSE_ID = "select * from enrolled_course where course_id = ";

}
