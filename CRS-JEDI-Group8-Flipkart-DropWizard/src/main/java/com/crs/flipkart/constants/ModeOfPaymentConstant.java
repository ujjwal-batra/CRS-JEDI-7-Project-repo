package com.crs.flipkart.constants;

public enum ModeOfPaymentConstants {
    ONLINE_PAYMENT, OFFLINE_PAYMENT;

    /**
     * Method to get ModeOfPayment from int
     * @param value
     * @return
     */
    public static ModeOfPaymentConstants getModeofPayment(int value)
    {
        switch(value)
        {
            case 1:
                return ModeOfPaymentConstants.ONLINE_PAYMENT;
            case 2:
                return ModeOfPaymentConstants.OFFLINE_PAYMENT;
            default:
                return null;

        }

    }
}
