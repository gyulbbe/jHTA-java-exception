package demo3;

public class SampleService {

	/*
	 * 예외강제 발생시키기
	 * 	이 메소드는 업무로직을 위배하는 상황이 발생했을 때, Exception 예의를 강제발생시킨다.
	 * 	Exception 예외는 컴파일러가 예외처리 여부를 체크하는 예외이기 때문에 throws 키워드를 사용해서 명시적으로 이 메소드를 호출하는 측이게 예외처리를 위임해야 한다.
	 */
	public void test1(String prevPwd, String pwd) throws Exception {
		// 업무로직에 위해되는 상황을 체크 - null 허용하지 않음
		if(pwd == null) {
			throw new Exception("비밀번호는 null을 허용하지 않습니다.");
		}
		
		// 업무로직에 위해되는 상황을 체크 - 빈 문자열을 허용하지 않음
		if(pwd.isBlank()) {
			throw new Exception("비밀번호는 빈 값을 허용하지 않습니다.");
		}
		
		// // 업무로직에 위해되는 상황을 체크 - 이전 비밀번호와 새 비밀번호가 동일
		if (prevPwd.equals(pwd)) {
			throw new Exception("이전 비밀번호와 같은 비밀번호로 변경할 수 없습니다.");
		}
	}
	
	/*
	 * 예외 강제 발생시키기
	 * 	이 메소드는 업무로직을 위배하는 상황이 발생했을 때, RuntimeException 예외를 강제발생시킨다.
	 * 	RuntimeException은 컴파일러가 예외처리여부를 체크하지 않는 예외기 때문이 throws 키워드를 사용하지 않고도 예외처리를 위임할 수 있다.
	 */
	public void test2(String prevPwd, String pwd){
		// 업무로직에 위해되는 상황을 체크 - null 허용하지 않음
		if(pwd == null) {
			throw new RuntimeException("비밀번호는 null을 허용하지 않습니다.");
		}
		
		// 업무로직에 위해되는 상황을 체크 - 빈 문자열을 허용하지 않음
		if(pwd.isBlank()) {
			throw new RuntimeException("비밀번호는 빈 값을 허용하지 않습니다.");
		}
		
		// // 업무로직에 위해되는 상황을 체크 - 이전 비밀번호와 새 비밀번호가 동일
		if (prevPwd.equals(pwd)) {
			throw new RuntimeException("이전 비밀번호와 같은 비밀번호로 변경할 수 없습니다.");
		}
	}
}
