package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

import java.util.List;

public interface ProfessorDaoInterface {
    public void saveProfessor(Professor professor);
    public Professor getProfessorById(int professorId);
    public int checkCredentials(String email, String password);
    public int updateCredentials(String email, String password);
}
