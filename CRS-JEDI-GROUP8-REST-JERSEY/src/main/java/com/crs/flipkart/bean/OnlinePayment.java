/**
 *
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class OnlinePayment {

    private int transactionId;
    private long amount;
    private String paymentType;     //credit card, debit card, netbanking;

    public OnlinePayment(int transactionId, long amount, String paymentType) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
