package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Notification;

import java.util.List;

public interface NotificationDaoInterface {
    public void sendNotification(Notification notification);

    public int getLastID(Notification notification);

    List<String> getNotificationById(int studentId);
}
