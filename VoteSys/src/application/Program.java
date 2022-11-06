package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Vote Calculator Sys :");

		// File with the votes registry.
		System.out.print("Enter file path :");
		String path = sc.nextLine();
		System.out.println();
		
		Map<String, Integer> votePolling = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] vet = line.split(",");
				
				if (votePolling.containsKey(vet[0])) {
					votePolling.put(vet[0], Integer.valueOf(votePolling.get(vet[0]) + Integer.valueOf(vet[1])));
				}
				else {
					votePolling.put(vet[0], Integer.valueOf(vet[1]));
				}
		
				line = br.readLine();
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}		
		
		for ( String key : votePolling.keySet()) {
			System.out.println(key + " : " + votePolling.get(key));
		}
		
		sc.close();

	}

}
