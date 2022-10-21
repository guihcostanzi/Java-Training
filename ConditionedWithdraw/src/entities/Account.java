package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import exceptions.CustomLogicalException;

public class Account {
	private String accountId;
	private String holder;
	private Date holderBirthDate;
	private Double balance;
	private Double withdrawLimit;

	private static Random idGen = new Random();
	
	public Account(String ownerName, Date ownerBirthDate, Double withdrawLimit) {
		
		
		long diff = System.currentTimeMillis() - ownerBirthDate.getTime();
		
		if ( (TimeUnit.DAYS.convert( diff, TimeUnit.MILLISECONDS) / 365) < 18) {
			throw new CustomLogicalException("Account Owner must be at least 18 years old.");
		}
		
		this.accountId = String.valueOf(idGen.nextInt(50000, 59999)); 
		this.holder = ownerName;
		this.holderBirthDate = ownerBirthDate;
		this.withdrawLimit = withdrawLimit;
		this.balance = 0.0;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Date getHolderBirthDate() {
		return holderBirthDate;
	}

	public void setHolderBirthDate(Date holderBirthDate) {
		this.holderBirthDate = holderBirthDate;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void depositMoney(Double value) {
		this.balance += value;
	}

	public void withdrawMoney(Double value) {
		if (value > balance) {
			throw new CustomLogicalException("Account doesn't have enought balance.");
		}
		if (value > withdrawLimit) {
			throw new CustomLogicalException("Withdraw surpasses account's withdraw limit.");
		}

		this.balance -= value;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		
		sb.append("---------------------------------------\n");
		sb.append("Account #" + accountId + " data :\n\n");
		sb.append("Holder : " + holder);
		sb.append("\n");
		sb.append("Holder's Birthdate : " + sdf.format(holderBirthDate));
		sb.append("\n");
		sb.append("Account's Withdraw Limit : $ " + String.format("%.2f", withdrawLimit));
		sb.append("\n");
		sb.append("Balance : $ " + String.format("%.2f", balance));
		sb.append("\n");
		sb.append("---------------------------------------\n");
		
		return sb.toString();
	}

}
