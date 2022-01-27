package com.crs.flipkart.business;

public interface PaymentServiceInterface {

    void makePayment(int payment_id, int invoice, int studentId, int amount, String status, String mode);
}
