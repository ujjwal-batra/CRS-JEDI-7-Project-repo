package com.crs.flipkart.business;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

public interface AdminServiceInterface {
    public boolean addCourse(int courseId, String CourseName);

    public boolean deleteCourse(int courseId);

    public int checkCredentials(String email, String password);

    public void approveStudent(Student student);

    public boolean addProfessor(Professor professor);
}
