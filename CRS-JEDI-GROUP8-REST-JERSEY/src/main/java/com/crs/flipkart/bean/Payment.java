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
    private int invoiceId;
    private boolean paymentStatus;
    private int amount;
    private String mode;

    public Payment(int paymentId, int invoiceId, boolean paymentStatus, int amount, String mode) {
        this.paymentId = paymentId;
        this.invoiceId = invoiceId;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.mode = mode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
}
