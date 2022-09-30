package Application;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println("Bidimensional Array Program :");
		System.out.println();

		System.out.println("How many lines and colums will the matrix have ?");
		int n = sc.nextInt();

		Integer[][] matrix = new Integer[n][n];

		for (int i = 0; i < matrix.length; i++) {
			System.out.println("Let's fill the line #" + (i + 1) + ":");
			System.out.print("Insert " + matrix[i].length + " numbers :");
			for (int j = 0; j < matrix[i].length; j++) {
				int number = sc.nextInt();
				matrix[i][j] = number;
			}
		}
		System.out.println();

		System.out.println("Here's the matrix you just created :");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Insert a value and I'll show you what lies next to its ocurrences :");
		int number = sc.nextInt();
		
		int ocurrences = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == number) {
					
					ocurrences++;
				
					System.out.println("Line : " + i + ", Column : " + j);
					System.out.println();

					if (j - 1 >= 0) {
						System.out.println("Left : " + matrix[i][j - 1]);
					} else {
						System.out.println("Left : Inexistent");
					}
					if (j + 1 >= 0 && j + 1 < matrix[i].length) {
						System.out.println("Right : " + matrix[i][j + 1]);
					} else {
						System.out.println("Right : Inexistent");
					}

					if (i + 1 >= 0 && i + 1 < matrix.length) {
						System.out.println("Under : " + matrix[i + 1][j]);
					} else {
						System.out.println("Under : Inexistent");
					}
					if (i - 1 >= 0) {
						System.out.println("Above : " + matrix[i - 1][j]);
					} else {
						System.out.println("Above : Inexistent");
					}
					System.out.println("----------");
				}

			}
		}
		System.out.println();
		System.out.printf("The value you inserted appeared %d times.", ocurrences);
	

		sc.close();

	}

}
