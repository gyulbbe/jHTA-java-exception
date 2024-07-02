package demo3;

public class SampleServiceApp {

	public static void main(String[] args) {
		
		SampleService service = new SampleService();
		
		/*
		 * 예외를 일괄처리하는 곳
		 * 	예외를 일괄처리하는 곳에서는 메소드에서 발생하는 예외가 최종적으로 처리되는 곳이다.
		 * 	예외를 일괄처리하는 곳에서는 예외를 종류에 상관없이 예외처리가 필수다.
		 * 	(Checked, Unchecked 예외에 상관없이 모든 예외에 대한 처리를 수행해야 한다.)
		 * 	일반적으로 예외에 대한 일괄처리는 공통기능이기 때문에 프로젝트 시작시 공통팀에서 미리 구현하거나,
		 *  예외 일괄처리를 지원하는 프레임워크나 라이브러리를 사용한다면 해당 프레임워크나 라이브러리에서 가이드하는 방식에 맞춰서 예외에 대한 처리를 수행한다.
		 */
		
		// Checked 예외를 강제발생시키는 메소드 호출하기
		try {
		 service.test1("hong", "hong");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			service.test2("hong", "hong");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}