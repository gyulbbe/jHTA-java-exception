package demo4;

public class BankApp1 {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		// 신규 계좌등록하기
		Account acc = new Account(10, "류관순", 1234, 100000);
		bank.addNewAccount(acc);
	}
}
