package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Product> listProduct = new ArrayList<>();
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.printf("Product #%d data:\n", i);
			System.out.print("Common, used or imported (c/u/i)?");
			char category = sc.next().charAt(0);
			sc.nextLine();
			String name = sc.nextLine();
			double price = sc.nextDouble();
			if(category == 'i') {
				double customsFee = sc.nextDouble();
				listProduct.add(new ImportedProduct(name, price, customsFee));
			}
			else if(category == 'u'){
				System.out.println("Manufacture date (DD/MM/YYYY):");
				Date date = sdf.parse(sc.next());
				listProduct.add(new UsedProduct(name, price, date));
			}
			else {
				listProduct.add(new Product(name, price));
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product product: listProduct) {
			System.out.println(product.priceTag());
		}
		sc.close();

	}

}
