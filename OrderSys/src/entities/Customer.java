package entities;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Customer {
	
	private String name;
	private Date birthDate;
	private String email;
	private Integer age ;
	private char gender;
	
	public Customer(String name, Date birthDate, String email, char gender) {
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.gender = gender;
		calculateAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Integer getAge () {
		return age;
	}
	
	private void calculateAge () {
		Instant now = Instant.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = dtf.format(now);
		
		int day = Integer.parseInt(date.substring(0,2));
		int month = Integer.parseInt(date.substring(3, 5));
		int year = Integer.parseInt(date.substring(6));
		
		int currentTotalDays = day + month*30 + year*365;
		
		date = sdf.format(birthDate);
		
		day = Integer.parseInt(date.substring(0,2));
		month = Integer.parseInt(date.substring(3,5));
		year = Integer.parseInt(date.substring(6));
		
		int customerTotalDays = day + month*30 + year*365;
		
		int daysDifference = currentTotalDays - customerTotalDays;
		
		this.age = daysDifference/365;
		
		
		
		
	}

}
