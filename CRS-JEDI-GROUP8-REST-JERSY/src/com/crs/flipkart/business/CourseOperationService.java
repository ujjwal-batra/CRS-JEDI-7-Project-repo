package com.crs.flipkart.business;

import com.crs.flipkart.bean.CourseCatalogue;
import com.crs.flipkart.dao.CourseOperationDAO;

public class CourseOperationService {
	/**
   	 * Method to retrieve entire course catalogue
   	 * @param payment_id
   	 * @return CourseCatalogue
   	 */
    public CourseCatalogue getCourseCatalogue() {
        return new CourseOperationDAO().getCourseCatalogue();
    }
}
