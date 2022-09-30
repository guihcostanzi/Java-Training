package Util;

public class IdGenerator {
	
		public static String generateEmployeeID() {
			int max = 9;
			int min = 0;
		
			int firstDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
			int secondDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
			int thirdDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
			
			String accountNumber = String.valueOf(firstDigit) + String.valueOf(secondDigit) + String.valueOf(thirdDigit);
			
			return accountNumber;
		}

	}


