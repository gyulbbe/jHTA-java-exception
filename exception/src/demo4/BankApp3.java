package demo4;

public class BankApp3 {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		long amount = bank.withdraw(10, 124, 50000);
		System.out.println(amount);
	}
}