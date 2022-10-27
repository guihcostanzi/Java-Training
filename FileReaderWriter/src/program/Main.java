package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Main {

	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
			.withZone(ZoneId.systemDefault());

	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("-- Working with Files --");
		System.out.println();

		System.out.println("Enter the path to the file you are going to read :");
		System.out.print("Path : ");
		String path = sc.nextLine();
		System.out.println();

		File file = new File(path);

		List<Product> productList = new ArrayList<>();

		// Lendo as linhas de um arquivo, armazenando em uma lista de arrays, já que a
		// função split
		// retorna um array, e depois usando seus indices para instanciar um objeto
		// Product, que
		// está sendo armazenado na lista de produtos "productList" criada acima.

		try (BufferedReader br = new BufferedReader(new FileReader(file));) {

			List<String[]> fileLines = new ArrayList<>();
			String line = br.readLine();

			while (line != null) {
				fileLines.add(line.split(","));
				line = br.readLine();
			}

			for (String[] productArray : fileLines) {
				productList.add(new Product(productArray[0], Double.parseDouble(productArray[1]),
						Integer.parseInt(productArray[2])));
			}

		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}

		// Criando uma subpasta Summary,
		// que será gerada dentro do mesmo local em que o arquivo lido está -->
		// getParent().

		if (file.canRead() && file.canWrite()) {
			try {
				boolean subFolder = new File(file.getParent() + "\\Summary").mkdir();

				if (subFolder) {
					System.out.println("A new summary folder was generated.");
					System.out.println("Path : " + file.getParent() + "\\Summary\n");
				} else {
					System.out.println("\nThe summary folder was either not generated, or already exists.\n");
					System.out.println("Path : " + file.getParent() + "\\Summary\n");
				}
			} catch (RuntimeException e) {
				System.out.println("Error : " + e.getMessage());
			}
		}

		// Está sendo criado um arquivo SalesSummary-yyyy-MM-dd.txt (na criação do File Writer),
		// em que estão sendo escritos, um em cada linha, os produtos armazenados
		// dentro da Lisa de Produtos, gerada acima.

		// Note que o true, no objeto FileWriter, possibilita a permanência do conteúdo
		// já armazenado no arquivo, sem que seja sobrescrito.
		// O bw.newLine() acrescenta uma quebra de linha.

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				file.getParent() + "\\Summary\\SalesSummary-" + LocalDate.now() + ".txt",
				true))) {

			bw.write("--------------" + dtf.format(Instant.now()) + "--------------");
			bw.newLine();

			for (Product p : productList) {
				bw.write("Product : " + p.getName() + ", Total Sales : $ "
						+ String.format("%.2f", p.calculateTotalPrice()));
				bw.newLine();
			}

			bw.write("--------------------------------------------");
			bw.newLine();
			bw.newLine();

		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}

		// Lendo o arquivo gerado, mostrando seu conteúdo, já formatado com o resumo
		// dos produtos.

		try (BufferedReader br = new BufferedReader(new FileReader(file.getParent() + "\\Summary\\SalesSummary-"
				+ LocalDate.now() + ".txt"));) {

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}

}
