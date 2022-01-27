package com.crs.flipkart.business;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDao;
import com.crs.flipkart.dao.AdminDaoInterface;

public class AdminService implements AdminServiceInterface{
    @Override
    public boolean addCourse(int courseId, String courseName) {
        if(courseId < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.addCourse(courseId, courseName);
    }

    @Override
    public boolean deleteCourse(int courseId) {
        if(courseId < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.deleteCourse(courseId);
    }

    @Override
    public int checkCredentials(String email, String password) {
        if(email == "")
            return -1;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.checkCredentials(email, password);
    }

    @Override
    public boolean addProfessor(Professor professor) {
        if(professor.getProfessorId() < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.addProfessor(professor);
    }

    @Override
    public void approveStudent(Student student) {
        AdminDaoInterface adminDaoInterface = new AdminDao();
        adminDaoInterface.approveStudent(student);
    }
}
