package demo4;

public class Account {

	private int no;			// 계좌번호
	private String owner;	// 예금주
	private int password;	// 비밀번호
	private long balance;	// 잔액
	
	public Account() {}
	
	public Account(int no, String owner, int password, long balance) {
		super();
		this.no = no;
		this.owner = owner;
		this.password = password;
		this.balance = balance;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
}