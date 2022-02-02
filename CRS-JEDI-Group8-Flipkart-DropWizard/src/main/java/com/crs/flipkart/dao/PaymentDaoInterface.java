package com.crs.flipkart.dao;

public interface PaymentDaoInterface {
	/**
   	 * Method to insert payment info tothe Database
   	 * @param payment_id
   	 * @param invoice
   	 * @param studentId
   	 * @param amount
   	 * @param status
   	 * @param mode
   	 * @return 
   	 */
    
	public int makePayment(int payment_id,int invoice,int studentId,int amount,String status, String mode);
    
	/**
   	 * Method to send payment notifications to student
   	 * @param 
   	 * @return 
   	 */
    public void sendPaymentNotification();
}
