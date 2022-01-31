/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hp
 *
 */
public class CourseSelection {
	private int studentId;
	private int[] primary;
	private int[] secondary;
	
	CourseSelection(){
		
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
	 * @return the primary
	 */
	public int[] getPrimary() {
		return primary;
	}
	/**
	 * @param primary the primary to set
	 */
	public void setPrimary(int[] primary) {
		this.primary = primary;
	}
	/**
	 * @return the secondary
	 */
	public int[] getSecondary() {
		return secondary;
	}
	/**
	 * @param secondary the secondary to set
	 */
	public void setSecondary(int[] secondary) {
		this.secondary = secondary;
	}
}
