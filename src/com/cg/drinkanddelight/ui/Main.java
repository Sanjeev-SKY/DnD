package com.cg.drinkanddelight.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.drinkanddelight.dao.Database;
import com.cg.drinkanddelight.service.ProductService;

public class Main {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Main mObj = new Main();
		Database.data();
		mObj.call();
		Database.getmMap().forEach((K, V) -> {
			System.out.println("Order Id - " + V.getOrderId() + "\n" + "Name - " + V.getName() + "\n"
					+ "Quantity value - " + V.getQuantityValue() + "\n" + "Manufacturing Date - "
					+ V.getManufacturingDate() + "\n" + "Expiry Date - " + V.getExpiryDate() + "\n" + "Exit Date - "
					+ V.getExitDate() + "\n" + "Quality - " + V.getQualityCheck());
		});
		mObj.sc.close();

	}

	public void call() {
		String ch;
		try {
			do {
				System.out.println("Enter Order Id: ");
				String id = sc.next();
				System.out.println("Enter Exit Date:- in (YYYYMMDD)");
				String date = sc.next();

				System.out.println(Main.setExitDate(id, splitDate(date)));

				System.out.println("Enter Manufacturing Date:- in (YYYYMMDD)");
				String mDate = sc.next();
				System.out.println("Enter Expiry Date:- in (YYYYMMDD)");
				String eDate = sc.next();
				System.out.println("Enter quality status: ");
				String qs = sc.next();
				System.out.println(Main.updateProductStock(id, splitDate(mDate), splitDate(eDate), qs));

				System.out.println("Update More Entries: Enter(yes/no)");
				ch = sc.next();
			} while (ch.equalsIgnoreCase("yes"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public LocalDate splitDate(String date) {
		int y, m, d;
		y = Integer.parseInt(date.substring(0, 4));
		m = Integer.parseInt(date.substring(4, 6));
		d = Integer.parseInt(date.substring(6, 8));
		LocalDate dt = LocalDate.of(y, m, d);
		return dt;
	}

	public static String setExitDate(String id, LocalDate date) {
		ProductService ps = new ProductService();
		return ps.exitDateCheck(id, date);
	}

	public static String updateProductStock(String orderId, LocalDate manufacturingDate, LocalDate expiryDate,
			String qualityAnalysis) {
		ProductService ps = new ProductService();
		return ps.updateProductStock(orderId, manufacturingDate, expiryDate, qualityAnalysis);
	}

}
