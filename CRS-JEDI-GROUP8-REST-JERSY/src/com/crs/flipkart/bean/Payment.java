/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class Payment {

    private int paymentId;
    private String invoiceId;
    private boolean paymentStatus;
    private long amount;

    public Payment(int paymentId, String invoiceId, boolean paymentStatus, long amount) {
        this.paymentId = paymentId;
        this.invoiceId = invoiceId;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
