package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

import java.util.List;
import java.util.Map;


public class ProfessorDAO {

    public List<Professor> professorList;
    Map<Integer, Integer> gradeMap;

    public void saveProfessor(Professor professor) {
        professorList.add(professor);
    }

}
