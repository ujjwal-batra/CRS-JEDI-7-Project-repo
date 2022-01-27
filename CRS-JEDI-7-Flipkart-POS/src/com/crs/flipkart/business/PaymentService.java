package com.crs.flipkart.business;

import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.dao.PaymentDao;

public class PaymentService implements PaymentServiceInterface {
	
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
    @Override
    public int makePayment(int payment_id, int invoice, int studentId, int amount, String status, String mode) {
        return new PaymentDao().makePayment(payment_id, invoice, studentId, amount, status, mode);
    }
}
