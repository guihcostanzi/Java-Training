package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import services.CourseAnalytics;

public class Program {

	public static void main(String[] args) {

		System.out.println("Student Manager Sys :");
		System.out.println();

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Set<Integer>> setList = new ArrayList<>();

		System.out.println("How many courses do the professor has ?");
		int coursesQtd = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < coursesQtd; i++) {
			
			Set<Integer> set = new HashSet<>();
			
			System.out.print("How many students for course #" + (i + 1) + "?");
			int studentsQtd = sc.nextInt();
			sc.nextLine();

			for (int j = 0; j < studentsQtd; j++) {
				System.out.print("Student #" + (j + 1) + " ID:");
				set.add(sc.nextInt());
				sc.nextLine();

			}
			
			setList.add(set);
			
			System.out.println();

		}

		System.out.println("The professor has " + CourseAnalytics.studentsTotal(setList).size() + " students.");
		sc.close();

	}

}
