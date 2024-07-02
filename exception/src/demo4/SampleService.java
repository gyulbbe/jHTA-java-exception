package demo4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleService {

	/*
	 *  예외반환하기
	 *  	SimpleDateFormat의 parse() 메소드가 발생시키는 ParseException을 catch블록으로 가로채고 대신 SampleException 예외를 발생시킨다.
	 *  	이렇게 함으로써, 우리가 사용하는 다양한 메소드에서 발생하는 다양한 예외들을 SampleException으로 변환해서 발생시키면
	 *  	예외를 일괄처리하는 곳에서는 SampleException 한 종류의 예외에 대해서만 처리하면 된다.
	 */
	public Date textToDate(String text) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(text);
		} catch (ParseException e) {
			throw new SampleException(e);
		}
	}
}