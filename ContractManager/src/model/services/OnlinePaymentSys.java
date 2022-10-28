package model.services;

public interface OnlinePaymentSys {
	
	Double paymentFee(Double value);
	Double interest (Double value, Integer month);

}
