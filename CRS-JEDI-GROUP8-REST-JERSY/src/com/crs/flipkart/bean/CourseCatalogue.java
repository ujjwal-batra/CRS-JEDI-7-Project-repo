package com.crs.flipkart.bean;

import java.util.List;

public class CourseCatalogue {

    private int catalogueId;
    private String catalogueName;
    private List<Course> courseList;

    public CourseCatalogue(int catalogueId, String catalogueName, List<Course> courseList) {
        this.catalogueId = catalogueId;
        this.catalogueName = catalogueName;
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public int getCatalogueId() {
        return catalogueId;
    }

    public void setCatalogueId(int catalogueId) {
        this.catalogueId = catalogueId;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }
}
