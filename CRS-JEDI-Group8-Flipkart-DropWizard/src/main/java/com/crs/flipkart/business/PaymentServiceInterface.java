package com.crs.flipkart.business;

public interface PaymentServiceInterface {
	/**
	 * Method to initiate payment
	 * @param payment_id
	 * @param invoice
	 * @param studentId
	 * @param amount
	 * @param status
	 * @param mode
	 * @return 
	 */
    public int makePayment(int payment_id, int invoice, int studentId, int amount, String status, String mode);
}
