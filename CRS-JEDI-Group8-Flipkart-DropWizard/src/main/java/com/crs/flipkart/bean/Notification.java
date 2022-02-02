package com.crs.flipkart.bean;

public class Notification {

    private int notificationId;
    private int studentId;
    private String message;
    private String notificationType;

    public Notification() {
    }

    public Notification(int notificationId, int studentId, String message, String notificationType) {
        this.notificationId = notificationId;
        this.studentId = studentId;
        this.message = message;
        this.notificationType = notificationType;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
