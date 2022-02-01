package com.crs.flipkart.exceptions;

public class InvalidCredentialsException extends Exception {

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "Invalid Credentials";
    }

}
