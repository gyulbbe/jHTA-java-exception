package demo4;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private List<Account> repo = new ArrayList<Account>();
	
	public Bank() {
		repo.add(new Account(10, "홍길동", 1234, 100000));
		repo.add(new Account(20, "김유신", 1234, 100000));
		repo.add(new Account(30, "강감찬", 1234, 100000));
	}
	
	/**
	 * 신규 계좌정보를 전달받아서 저장시킨다.
	 * 	동일한 계좌번호로 등록된 계좌정보가 있으면 예외를 발생시킨다.
	 * @param account 신규 계좌정보
	 */
	public void addNewAccount(Account account) {
		// 신규 계좌정보의 계좌번호로 기존 계좌정보를 조회한다.
		Account savedAccount = this.getAccount(account.getNo());
		if (savedAccount != null) {
			throw new SampleException("이미 사용중인 계좌번호입니다.");
		}
		
		// savedAccount가 null일 때만 실행되는 코드
		repo.add(account);
	}
	
	/**
	 * 계좌번호를 전달받아서 계좌정보를 반환한다.
	 * @param accNo 조회할 계좌번호
	 * @return 계좌정보, 일치하는 계좌번호가 없으면 null을 반환한다.
	 */
	public Account getAccount(int accNo) {
		Account foundAccount = null;
		for (Account acc : repo) {
			if (acc.getNo() == accNo) {
				foundAccount = acc;
				break;
			}
		}
		return foundAccount;
	}
	
	/**
	 * 계좌번호, 이전 비밀번호, 새 비밀번호를 전달받아서 비밀번호를 변경한다.
	 * 이전 비밀번호와 새 비밀번호가 동일하면 예외가 발생된다.
	 * 계좌정보가 존재하지 않으면 예외가 발생된다.
	 * 계좌의 비밀번호와 이전 비밀번호가 일치하지 않으면 예외가 발생된다.
	 * @param accNo 계좌번호
	 * @param prevPwd 이전 비밀번호
	 * @param pwd 새 비밀번호
	 */
	public void changePassword(int accNo, int prevPwd, int pwd) {
		if (prevPwd == pwd) {
			throw new SampleException("이전 비밀번호와 동일한 번호로 변겨할 수 없습니다.");
		}
		
		Account savedAccount = this.getAccount(accNo);
		if (savedAccount == null) {
			throw new SampleException("계좌번호와 일치하는 계좌정보를 찾을 수 없습니다.");
		}
		
		if (savedAccount.getPassword() != prevPwd) {
			throw new SampleException("비밀번호가 일치하지 않습니다.");
		}
		
		// 비밀번호를 변경한다.
		savedAccount.setPassword(pwd);
	}
	
	/**
	 * 계좌번호, 비밀번호, 출금액을 전달받아서 출금액만큼 인출한다.
	 * 오류상황에 맞는 오류 메시지가 포함된 예의를 강제 발생시킨다.
	 * 예외가 발생되면 반환값을 고려할 필요가 없다.
	 * @param accNo 계좌번호
	 * @param pwd 비밀번호
	 * @param amount 출금액
	 * @return 신청한 출금액
	 */
	public long withdraw(int accNo, int pwd, long amount) {

		Account savedAccount = this.getAccount(accNo);
		if (savedAccount == null) {
			throw new SampleException("계좌번호와 일치하는 계좌정보를 찾을 수 없습니다.");
		}
		
		if (savedAccount.getPassword() != pwd) {
			throw new SampleException("비밀번호가 일치하지 않습니다.");
		}
		
		if (savedAccount.getBalance() < amount) {
			throw new SampleException("잔액이 부족합니다.");
		}
		
		long updateBalance = savedAccount.getBalance() - amount;
		savedAccount.setBalance(updateBalance);
		
		return amount;
	}
}