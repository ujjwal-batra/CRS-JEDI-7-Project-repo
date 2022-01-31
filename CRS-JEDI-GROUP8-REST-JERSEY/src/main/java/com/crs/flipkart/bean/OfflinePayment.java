/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class OfflinePayment {

    private int transactionId;
    private long amount;

    public OfflinePayment(int transactionId, long amount) {
        this.transactionId = transactionId;
        this.amount = amount;
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
}
