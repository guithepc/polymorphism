package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<>();
		
		System.out.println("Enter the number of Products:");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.println("Common, used or imported? (c/u/i)");
			char c = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			
			if (c == 'c') {
				products.add(new Product(name, price));
			} else if (c == 'i') {
				System.out.println("Custom fee:");
				double customFee = sc.nextDouble();
				
				products.add(new ImportedProduct(name, price, customFee));
			} else if (c == 'u'){
				System.out.println("Manufacture date: (DD/MM/YYYY)");
				Date date = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, date));
			}
		}
		
		System.out.println("PRICE TAGS:");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
