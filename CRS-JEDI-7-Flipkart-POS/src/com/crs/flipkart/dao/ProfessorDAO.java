package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

import java.util.ArrayList;
import java.util.List;


public class ProfessorDAO {

    public List<Professor> professorList;


    public void saveProfessor(Professor professor) {
        professorList.add(professor);
    }

    public void createDummy() {
        professorList.add(new Professor("1", "John", "root", "j@gm.com", 123l,
                "Professor", "address", "male", 1, "CSE", new ArrayList<>()));
    }

    public void getProfessorById(int professorId) {


    }


}
