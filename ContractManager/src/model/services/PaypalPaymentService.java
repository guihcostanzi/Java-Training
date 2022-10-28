package model.services;

public class PaypalPaymentService implements OnlinePaymentSys {
	
	public Double paymentFee (Double value) {
		return value*0.02;
	}
	
	public Double interest ( Double value, Integer month) {
		return value*0.01*month;
	}

}
