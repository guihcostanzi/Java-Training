package entities;

public abstract class Person {

		protected String name;
		protected Double annualRevenue;
		
		public Person(String name, Double annualRevenue) {
			this.name = name;
			this.annualRevenue = annualRevenue;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getAnnualRevenue() {
			return annualRevenue;
		}

		public void setAnnualRevenue(Double annualRevenue) {
			this.annualRevenue = annualRevenue;
		}

		public abstract Double calculateTax ();
}
