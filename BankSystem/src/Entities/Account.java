package Entities;

public class Account {
	
	private final String accountNumber;
	private String name;
	private double balance;
	
	public Account(String accountNumber, String name, double initialDeposit) {	
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance += initialDeposit;
	}
	
	public Account(String accountNumber, String name) {	
		this.accountNumber = accountNumber;
		this.name = name;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void addBalance(double value) {
		this.balance += value;
	}
	
	public void removeBalance(double value) {
		this.balance -= value;
	}
	
	public String toString() {
		return "\nYour new account data: \nName : " + name + "\nBalance : $" + String.format("%.2f", balance) + "\nID : " + accountNumber;
	}
	
}
