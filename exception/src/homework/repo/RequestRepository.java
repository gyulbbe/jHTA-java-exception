package homework.repo;

import java.util.ArrayList;
import java.util.List;

import homework.vo.Request;

public class RequestRepository {

	private List<Request> db = new ArrayList<Request>();
	// 수강신청 번호
	private int requestSequence = 1000;
	
	// 수강 신청 철회
	public void requestWithdrawal(Request req) {
		req.setWithdrawalStatus(true);
	}
	
	// 수강 신청
	public void signUp(Request req) {
		req.setRequestNo(requestSequence++);
		db.add(req);
	}
	
	// 아이디로 수강 신청 조회
	public List<Request> getRequestInfoById(String id){
		List<Request> request = new ArrayList<Request>();
		
		for(Request req : db) {
			if(req.getId().equals(id)) {
				request.add(req);
			}
		}
		
		return request;
	}
	
	// 수강 신청 번호로 조회
	public Request getRequestInfoByNo(int requestNo){
		Request request = new Request();
		
		for(Request req : db) {
			if(req.getRequestNo() == requestNo) {
				request = req;
			}
		}
		
		return request;
	}
	
}