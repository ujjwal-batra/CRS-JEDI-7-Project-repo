package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class ProfessorDAO {

    public List<Professor> professorList = new ArrayList<>(
            Arrays.asList(
                    new Professor("1", "prof1", "root", "p1@gm.com", 78945612, "Professor", "indore", "male", 1, "CSE", new ArrayList<>()),
                    new Professor("2", "prof2", "root", "p2@gm.com", 98765432, "Professor", "bhopal", "male", 2, "CSE", new ArrayList<>()),
                    new Professor("3", "prof3", "root", "p3@gm.com", 78945612, "Professor", "indore", "male", 3, "CSE", new ArrayList<>()),
                    new Professor("4", "prof4", "root", "p4@gm.com", 98765432, "Professor", "bhopal", "male", 4, "CSE", new ArrayList<>()),
                    new Professor("5", "prof5", "root", "p5@gm.com", 78945612, "Professor", "indore", "male", 5, "CSE", new ArrayList<>()),
                    new Professor("6", "prof6", "root", "p6@gm.com", 98765432, "Professor", "bhopal", "male", 6, "CSE", new ArrayList<>()),
                    new Professor("7", "prof7", "root", "p7@gm.com", 78945612, "Professor", "indore", "male", 7, "CSE", new ArrayList<>())
            )
    );


    public void saveProfessor(Professor professor) {

    }

    public Professor getProfessorById(int professorId) {
        for (Professor professor : professorList) {
            if (professor.getProfessorId() == professorId) return professor;
        }
        return null;
    }

    public int checkCredentials(String email, String password){
        for(Professor professor: professorList){
            if(Objects.equals(professor.getEmailId(), email) && Objects.equals(professor.getPassword(), password))
                return professor.getProfessorId();
        }
        return -1;

    }

    public int updateCredentials(String email, String password){
        for(Professor professor: professorList){
            if(Objects.equals(professor.getEmailId(), email))
                professor.setPassword(password);

        }
        return -1;

    }

}
