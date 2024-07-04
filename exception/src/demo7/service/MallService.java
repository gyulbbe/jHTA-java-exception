package demo7.service;

import java.util.Date;
import java.util.List;

import demo7.exception.MallException;
import demo7.repo.OrderRepository;
import demo7.repo.ProductRepository;
import demo7.repo.UserRepository;
import demo7.vo.Order;
import demo7.vo.Product;
import demo7.vo.User;

public class MallService {

	private UserRepository userRepo = new UserRepository();
	private ProductRepository productRepo = new ProductRepository();
	private OrderRepository orderRepo = new OrderRepository();
	
	/**
	 * 아이디를 전달받아서 주문내역을 반환한다.
	 * @param userId 사용자아이디
	 * @return 주문내역
	 */
	public List<Order> getMyOrders(String userId){
		List<Order> orders = null;
		User user = getUserInfo(userId);
		orders = orderRepo.findOrdersByUserId(user.getId());
		
		return orders;
	}
	
	/**
	 * 사용자아이디, 상품번호, 구매수량을 전달받아서 주문한다.
	 * @param userId 사용자 아이디
	 * @param productNo 상품번호
	 * @param amount 구매수량
	 */
	public void order(String userId, int productNo, int amount) {
		// 사용자의 포인트를 확인하기 위해서 상품정보를 조회한다.
		User user = this.getUserInfo(userId);
		// 재고수량, 상품가격을 확인하기 위해서 상품정보를 조회한다.
		Product product = productRepo.findProductByNo(productNo);
		if(product == null) {
			throw new MallException("상품정보를 찾을 수 없습니다.");
		}
		
		if(product.getStock() < amount) {
			throw new MallException("재고수량이 부족합니다.");
		}
		int orderPrice = product.getPrice()*amount;
		if(orderPrice > user.getPoint()) {
			throw new MallException("포인트가 부족합니다.");
		}
		
		Order order = new Order();
		order.setDate(new Date());
		order.setProductNo(product.getNo());
		order.setProductName(product.getName());
		order.setProductPrice(product.getPrice());
		order.setAmount(amount);
		order.setTotalPrice(orderPrice);
		order.setUserId(userId);
		
		// 주문정보를 저장시킨다.
		orderRepo.saveOrder(order);
		
		product.setStock(product.getStock() - amount);
		
		user.setPoint(user.getPoint() - orderPrice);
	}
	
	/**
	 * 모든 상품정보를 반환한다.
	 * @return 상품정보 리스트
	 */
	public List<Product> getAllProducts() {
		List<Product> products = productRepo.findAll();
		return products;
	}
	
	/**
	 * 신규 사용자정보를 전달받아서 가입시킨다.
	 * @param user 신규 사용자 정보
	 */
	public void registerUser(User user) {
		User savedUser = userRepo.getUserById(user.getId());
		if (savedUser != null) {
			throw new MallException("["+user.getId()+"]는 이미 사용중인 아이디입니다.");
		}
		
		user.setPoint(3000);
		userRepo.saveUser(user);
	}
	
	/**
	 * 아이디와 충전금액을 전달받아서 사용자의 포인트를 증가시킨다.
	 * @param id 사용자 아이디
	 * @param amount 충전금액
	 */
	public void chargePoint(String id, int amount) {
		User user = getUserInfo(id);
		int currentPoint = user.getPoint();
		user.setPoint(currentPoint + amount);
	}
	
	/**
	 * 아이디를 전달받아서 사용자 정보를 반환한다.
	 * @param id 조회할 사용자 아이디
	 * @return 사용자정보, 사용자 정보가 존재하지 않으면 예외가 발생한다.
	 */
	public User getUserInfo(String id) {
		User user = null;
		user = userRepo.getUserById(id);
		if(user == null) {
			throw new MallException("사용자를 찾을 수 없습니다.");
		}
		
		return user;
	}
}