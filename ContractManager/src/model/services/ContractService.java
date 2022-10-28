package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentSys paymentSys;

	public ContractService(OnlinePaymentSys paymentSys) {
		this.paymentSys = paymentSys;
	}

	public OnlinePaymentSys getPaymentSys() {
		return paymentSys;
	}

	public void setPaymentSys(OnlinePaymentSys paymentSys) {
		this.paymentSys = paymentSys;
	}

	public void processContract(Contract contract, Integer monthQuantity) {

		for (int i = 0; i < monthQuantity; i++) {

			LocalDate dueDate = contract.getContractDate().plusMonths(i + 1);
			Double installmentBasePrice = contract.getContractValue() / monthQuantity;
			Double installmentWithInterest = installmentBasePrice
					+ getPaymentSys().interest(installmentBasePrice, (i + 1));
			Double installmentFinalValue = installmentWithInterest
					+ getPaymentSys().paymentFee(installmentWithInterest);

			contract.addInstallment(new Installment(dueDate, installmentFinalValue));

		}
	}

	public Double getContractFinalValue(Contract contract) {

		Double total = 0.0;
		for (Installment i : contract.getInstallments()) {
			total += i.getValue();
		}
		return total;

	}

}
