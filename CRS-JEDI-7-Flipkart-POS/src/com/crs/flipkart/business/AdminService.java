package com.crs.flipkart.business;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDao;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseAlreadyInCatalogException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.validator.AdminValidator;

import org.apache.log4j.Logger;


public class AdminService implements AdminServiceInterface {

    private static final Logger logger = Logger.getLogger(AdminService.class);

    /**
     * Method to add a course by the admin
     *
     * @param courseId
     * @param courseName
     * @return boolean
     */
    @Override
    public boolean addCourse(int courseId, String courseName) throws AddCourseException{
        try {
            if (courseId < 0)
                return false;
            AdminDaoInterface adminDaoInterface = new AdminDao();
            logger.info("In instance of AdminService, adding course with course id: " + courseId + " and course name: " + courseName);
            CourseOperationService courseCatalog = new CourseOperationService();
            boolean valid = AdminValidator.isValidNewCourse(courseId, courseCatalog.getCourseCatalogue().getCourseList());
            if(!valid) throw new AddCourseException(courseId);
            return adminDaoInterface.addCourse(courseId, courseName);
        } catch (Exception ex) {
            throw new AddCourseException(courseId);
        }
    }

    /**
     * Method to delete a course by the admin
     *
     * @param courseId
     * @return boolean
     */
    @Override
    public boolean deleteCourse(int courseId) throws CourseNotDeletedException {
        if (courseId < 0)
            return false;
        try {
            AdminDaoInterface adminDaoInterface = new AdminDao();
            CourseOperationService courseCatalog = new CourseOperationService();
            boolean valid = AdminValidator.isValidDropCourse(courseId, courseCatalog.getCourseCatalogue().getCourseList());
            if(!valid) throw  new CourseNotDeletedException(courseId);
            logger.info("In instance of AdminService, delete course with course id: " + courseId);
            return adminDaoInterface.deleteCourse(courseId);
        }catch (Exception ex){
            throw new CourseNotDeletedException(courseId);
        }
    }

    /**
     * Method to check credentials of admin
     *
     * @param email
     * @param password
     * @return int
     */
    @Override
    public int checkCredentials(String email, String password) {
        if (email == "")
            return -1;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.checkCredentials(email, password);
    }

    /**
     * Method to approve a student by admin
     *
     * @param student
     * @return
     */
    @Override
    public void approveStudent(Student student) {
        AdminDaoInterface adminDaoInterface = new AdminDao();
        CourseOperationService courseCatalog = new CourseOperationService();
        boolean valid = AdminValidator.isValidDropCourse(student.getStudentId(), courseCatalog.getCourseCatalogue().getCourseList());
        if(valid)
        	adminDaoInterface.approveStudent(student);
        else logger.error("student with student id"+ student.getStudentId()+" doesn't exists or is already approved");
    }

    /**
     * Method to add a professor to the system by the admin
     *
     * @param professor
     * @return
     */
    @Override
    public boolean addProfessor(Professor professor) {
        if (professor.getProfessorId() < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        logger.info("In instance of AdminService, adding professor with professor id: " + professor.getProfessorId());
        return adminDaoInterface.addProfessor(professor);
    }

    @Override
    public void updateCredentials(String email, String password) {
        logger.debug("In instance of Professor service updating credentials");
        new AdminDao().updateCredentials(email, password);
    }
}
