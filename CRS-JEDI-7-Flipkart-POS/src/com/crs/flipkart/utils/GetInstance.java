package com.crs.flipkart.utils;

import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.dao.CourseCatalogueDAO;
import com.crs.flipkart.dao.ProfessorDAO;

public class GetInstance {

    private ProfessorDAO professorDAO;
    private ProfessorService professorService;
    private CourseCatalogueDAO courseCatalogueDAO;

    public ProfessorDAO getProfessorDAO() {
        return professorDAO == null ? new ProfessorDAO() : professorDAO;
    }

    public ProfessorService getProfessorService() {
        return professorService == null ? new ProfessorService() : professorService;
    }

    public CourseCatalogueDAO getCourseCatalogueDAO() {
        return courseCatalogueDAO == null ? new CourseCatalogueDAO() : courseCatalogueDAO;
    }
}
