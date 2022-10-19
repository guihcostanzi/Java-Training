package entities;

public class PhysicalPerson extends Person {
	private String CPF;
	private Double yearHealthExpenses;
	
	public PhysicalPerson(String name, Double annualRevenue, String cPF, Double yearHealthExpenses) {
		super(name, annualRevenue);
		CPF = cPF;
		this.yearHealthExpenses = yearHealthExpenses;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Double getYearHealthExpenses() {
		return yearHealthExpenses;
	}

	public void setYearHealthExpenses(Double yearHealthExpenses) {
		this.yearHealthExpenses = yearHealthExpenses;
	}
	
	@Override
	public Double calculateTax () {
		Double tax = 0.0;
		
		if (annualRevenue < 20000) {
			tax = annualRevenue*0.15;
		}
		else {
			tax = annualRevenue*0.25;
		}
		
		return tax - (yearHealthExpenses/2);
	}
	
	
	
	
	
	
	
	
}