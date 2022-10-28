package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	private String contractID;
	private LocalDate contractDate;
	private Double contractValue;
	
	private List<Installment> installments = new ArrayList<>();

	public Contract(String contractID, LocalDate contractDate, Double contractValue) {
		this.contractID = contractID;
		this.contractDate = contractDate;
		this.contractValue = contractValue;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public LocalDate getContractDate() {
		return contractDate;
	}

	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}

	public Double getContractValue() {
		return contractValue;
	}

	public void setContractValue(Double contractValue) {
		this.contractValue = contractValue;
	}
	
	public List<Installment> getInstallments (){
		return this.installments;
	}

	public void addInstallment(Installment installment) {
		installments.add(installment);
	}

	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
	

	
	
	
	
	

}
