package com.crs.flipkart.business;

import com.crs.flipkart.dao.PaymentDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PaymentService implements PaymentServiceInterface {

    private static final Logger logger = LogManager.getLogger(PaymentService.class);

    /**
     * Method to initiate payment
     *
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
        logger.info("Making payment for student id: " + studentId + ", payment id: " + payment_id + ", payment mode: " + mode + ", amount: " + amount);
        return new PaymentDao().makePayment(payment_id, invoice, studentId, amount, status, mode);
    }
}
