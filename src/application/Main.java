package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {		
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter the amount for withdraw:" );
			double withdraw = sc.nextDouble();
			account.withdraw(withdraw);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}

		catch (InputMismatchException e) {
			System.out.println("Input error");
		}
		catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		sc.close();
	}

}
