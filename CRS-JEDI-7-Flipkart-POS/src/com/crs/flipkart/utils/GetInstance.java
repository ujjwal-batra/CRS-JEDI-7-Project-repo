package com.crs.flipkart.utils;

import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.dao.CourseCatalogueDAO;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.StudentDao;

public class GetInstance {

    public static ProfessorDAO professorDAO = new ProfessorDAO();
    public static ProfessorService professorService = new ProfessorService();
    public static CourseCatalogueDAO courseCatalogueDAO = new CourseCatalogueDAO();
    public static StudentDao studentDao = new StudentDao();

}
