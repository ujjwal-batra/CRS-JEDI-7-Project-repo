package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Notification;

public interface NotificationDaoInterface {
    public void sendNotification(Notification notification);

    public int getLastID(Notification notification);
}
