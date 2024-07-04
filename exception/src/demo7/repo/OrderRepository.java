package demo7.repo;

import java.util.ArrayList;
import java.util.List;

import demo7.vo.Order;

public class OrderRepository {

	private List<Order> db = new ArrayList<Order>();
	private int sequence = 1000;
	
	/**
	 * 신규 주문정보를 전달받아서 저장시킨다.
	 * @param order 주문정보
	 */
	public void saveOrder(Order order) {
		order.setNo(sequence++);
		db.add(order);
	}
	
	/**
	 * 사용자 아이디를 전달받아서 해당 사용자의 주문내역정보를 반환한다.
	 * @param userId
	 * @return 주문내역
	 */
	public List<Order> findOrdersByUserId(String userId){
		List<Order> orders = new ArrayList<Order>();
		
		// ArrayList에서 Order를 하나씩 꺼낸다.
		// 주문정보의 사용자아이디와 전달받은 사용자아이디가 일치하는 주문을 미리 생성한 ArrayList객체에 저장한다.
		for(Order order : db) {
			if(order.getUserId().equals(userId)) {
				orders.add(order);
			}
		}
		
		return orders;
	}
}