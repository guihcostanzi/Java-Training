package entities;

public class JuridicalPerson extends Person {
	
	private String CNPJ;
	private Integer employeeNumber;

	public JuridicalPerson(String name, Double annualRevenue, String cNPJ, Integer employeeNumber) {
		super(name, annualRevenue);
		CNPJ = cNPJ;
		this.employeeNumber = employeeNumber;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	@Override 
	public Double calculateTax () {
		if (employeeNumber <= 10) {
			return getAnnualRevenue()*0.16;
		}
		else {
			return getAnnualRevenue()*0.14;
		}
	}
	
	
	
	
}
