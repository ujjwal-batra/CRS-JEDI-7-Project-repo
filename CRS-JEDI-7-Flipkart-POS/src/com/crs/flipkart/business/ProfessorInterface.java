/**
 *
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;

import java.util.List;

/**
 * @author adarsh
 *
 */
public interface ProfessorInterface {
    public boolean addGrade(int courseId, int studentId, double marks);

    public void selectCourseToTeach(int courseId, int professorId);

    public List<Integer> getStudentList(int courseId);

    public List<Course> getCourseList();

    public List<String> viewStudentsForAllCourses(int professorId);
}
