package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

public interface ProfessorDaoInterface {
    public void saveProfessor(Professor professor);
    public Professor getProfessorById(int professorId);
    public int checkCredentials(String email, String password);
    public boolean updateCredentials(String email, String password);
}
