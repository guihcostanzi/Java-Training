package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private Contract contract;
	private OnlinePaymentSys paymentSys;

	public ContractService(Contract contract, OnlinePaymentSys paymentSys) {
		this.contract = contract;
		this.paymentSys = paymentSys;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
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

	public Double getContractFinalValue() {

		Double total = 0.0;
		for (Installment i : contract.getInstallments()) {
			total += i.getValue();
		}
		return total;

	}

}
