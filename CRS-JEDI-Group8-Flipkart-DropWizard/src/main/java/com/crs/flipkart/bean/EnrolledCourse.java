/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hp
 *
 */
public class EnrolledCourse {
	private int courseId;
    private int studentId;
	
    
    public EnrolledCourse(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }
    
    public EnrolledCourse() {
    }
    
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
