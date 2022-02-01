package com.crs.flipkart.exceptions;

public class ProfessorNotFoundException extends Exception {

    /*
     * @professorId which is not found
     */
    private final int professorId;

    public ProfessorNotFoundException(int professorId) {
        this.professorId = professorId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "professorId: " + professorId + " not found!";
    }
}
