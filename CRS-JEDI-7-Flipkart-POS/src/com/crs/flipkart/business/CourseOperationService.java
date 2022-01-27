package com.crs.flipkart.business;

import com.crs.flipkart.bean.CourseCatalogue;
import com.crs.flipkart.dao.CourseOperationDAO;

public class CourseOperationService {

    public CourseCatalogue getCourseCatalogue() {
        return new CourseOperationDAO().getCourseCatalogue();
    }
}
