package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalPaymentService;

public class Program {

	public static final Scanner sc = new Scanner(System.in);
	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		System.out.println("-- Contract Management Sys --");
		System.out.println();

		System.out.println("Let's register a new contract :");
		System.out.println();

		System.out.print("Contract ID : ");
		String contractID = sc.next();
		sc.nextLine();

		System.out.print("Contract Value ($) : ");
		Double contractValue = sc.nextDouble();
		sc.nextLine();
		
		// Note que para lermos a Data em LocalDate, usamos o método parse e especificamos
		// a forma em que iremos inserir a data com o DateTimeFormatter.
		
		System.out.println("Contract Date (dd/MM/yyyy) : ");
		LocalDate contractDate = LocalDate.parse(sc.next(), dtf); 
		sc.nextLine();
		System.out.println();
		
		// O contrato será instanciado sem as parcelas, pois estas serão 
		// geradas com o ContractService.

		Contract contract = new Contract(contractID, contractDate, contractValue);
		
		// Definir em quantas parcelas pagar.
		
		System.out.print("How many installments ?");
		Integer intallmentsQtd = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		// Informar o contrato e o método de pagamento para o ContractService.
		
		ContractService cs = new ContractService(new PaypalPaymentService ());
		
		// Chamar o método para atribuir as parcelas ao contrato.
		
		cs.processContract(contract, intallmentsQtd);
		
		System.out.println("Installments :");
		System.out.println();
		
		for (Installment i : contract.getInstallments()) {
			System.out.println(dtf.format(i.getDueDate()) + " - $ " + String.format("%.2f", i.getValue()));
		}
		System.out.println();
		
		System.out.println("Contract Final Value : $ " + String.format("%.2f", cs.getContractFinalValue(contract)));
		

	}
}
