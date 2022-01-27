package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

public interface ProfessorDaoInterface {
    public void saveProfessor(Professor professor);

    public Professor getProfessorById(int professorId);

    public int checkCredentials(String email, String password);

    public boolean updateCredentials(String email, String password);

    public void populateCourses(Professor professor);

    public boolean addGrade(int studentId, int courseId, double marks);
}
