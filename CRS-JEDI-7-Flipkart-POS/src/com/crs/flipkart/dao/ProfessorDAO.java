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
        professorList.add(new Professor("1", "prof1", "root", "p1@gm.com", 78945612, "Professor", "indore", "male", 1, "CSE", new ArrayList<>()));
        professorList.add(new Professor("2", "prof2", "root", "p2@gm.com", 98765432, "Professor", "bhopal", "male", 2, "CSE", new ArrayList<>()));
        professorList.add(new Professor("3", "prof3", "root", "p3@gm.com", 78945612, "Professor", "indore", "male", 3, "CSE", new ArrayList<>()));
        professorList.add(new Professor("4", "prof4", "root", "p4@gm.com", 98765432, "Professor", "bhopal", "male", 4, "CSE", new ArrayList<>()));
        professorList.add(new Professor("5", "prof5", "root", "p5@gm.com", 78945612, "Professor", "indore", "male", 5, "CSE", new ArrayList<>()));
        professorList.add(new Professor("6", "prof6", "root", "p6@gm.com", 98765432, "Professor", "bhopal", "male", 6, "CSE", new ArrayList<>()));
        professorList.add(new Professor("7", "prof7", "root", "p7@gm.com", 78945612, "Professor", "indore", "male", 7, "CSE", new ArrayList<>()));
    }

    public void getProfessorById(int professorId) {


    }


}
