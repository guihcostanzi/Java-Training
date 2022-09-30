package Util;

public class AccountOperations {
	
	public static String generateAccountNumber() {
		int max = 9;
		int min = 0;
	
		int firstDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
		int secondDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
		int thirdDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
		int fourthDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
		int fifthDigit = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		String accountNumber = String.valueOf(firstDigit) + String.valueOf(secondDigit) + String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit) ;
		
		return accountNumber;
	}

}
