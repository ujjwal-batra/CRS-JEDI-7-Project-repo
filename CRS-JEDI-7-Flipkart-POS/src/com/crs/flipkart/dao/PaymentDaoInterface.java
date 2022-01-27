package com.crs.flipkart.dao;

public interface PaymentDaoInterface {
    public void makePayment(int payment_id,int invoice,int studentId,int amount,String status, String mode);
    public void sendPaymentNotification();
}
