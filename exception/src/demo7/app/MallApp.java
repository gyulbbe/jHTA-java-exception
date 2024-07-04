package demo7.app;

import java.util.List;

import demo7.exception.MallException;
import demo7.service.MallService;
import demo7.vo.Order;
import demo7.vo.Product;
import demo7.vo.User;
import util.Keyboard;

public class MallApp {

	private MallService service = new MallService();

	public void menu() {
		System.out.println("------------------------------");
		System.out.println("1.상품조회 2.주문하기  3.주문내역조회");
		System.out.println("4.회원가입 5.포인트충전 6.내 정보조회");
		System.out.println("0.종료");
		System.out.println("------------------------------");
		System.out.println();

		System.out.println("메뉴선택: ");
		int menuNo = Keyboard.readInt();
		System.out.println();

		try {
			if (menuNo == 1) {
				상품조회();
			} else if (menuNo == 2) {
				주문하기();
			} else if (menuNo == 3) {
				주문내역조회();
			} else if (menuNo == 4) {
				회원가입();
			} else if (menuNo == 5) {
				포인트충전();
			} else if (menuNo == 6) {
				내정보조회();
			} else if (menuNo == 0) {
				종료();
			}
		} catch (MallException e) {
			System.out.println("------------------------------");
			System.out.println("###[오류발생] " + e.getMessage());
			System.out.println("------------------------------");
		}

		System.out.println();
		menu();
	}

	private void 상품조회() {
		System.out.println("[상품 조회]");

		List<Product> products = service.getAllProducts();
		if (products.isEmpty()) {
			System.out.println("### 상품이 없습니다.");
		} else {
			System.out.println("------------------------------");
			System.out.println("번호\t이름\t가격\t재고수량");
			System.out.println("------------------------------");
			for (Product p : products) {
				System.out.print(p.getNo() + "\t");
				System.out.print(p.getName() + "\t");
				System.out.print(p.getPrice() + "\t");
				System.out.print(p.getStock());
				System.out.println();
			}
		}
	}

	private void 주문하기() {
		System.out.println("[상품 주문]");
		
		System.out.println("### 상품주문에 필요한 정보를 입력하세요.");
		
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();
		System.out.print("상품번호 입력: ");
		int no = Keyboard.readInt();
		System.out.print("구매수량 입력: ");
		int amount = Keyboard.readInt();
		
		service.order(id, no, amount);
		
		System.out.println();
	}

	private void 주문내역조회() {
		System.out.println("[주문내역조회]");
		
		System.out.println("### 주문내역을 조회할 사용자 아이디를 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();
		List<Order> orders = service.getMyOrders(id);
		if(orders.isEmpty()) {
			System.out.println("### 주문내역이 존재하지 않습니다.");
		} else {
			System.out.println("------------------------------");
			System.out.println("번호\t이름\t가격\t재고수량");
			System.out.println("------------------------------");
			for(Order order : orders) {
				System.out.print(order.getNo() + "\t");
				System.out.print(order.getProductName() + "\t");
				System.out.print(order.getProductPrice() + "\t");
				System.out.print(order.getAmount() + "\t");
				System.out.print(order.getTotalPrice());
				System.out.println();
			}
		}
		
	}

	private void 회원가입() {
		System.out.println("[회원가입]");
		System.out.println("### 신규 사용자 정보를 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();
		System.out.print("이름 입력: ");
		String name = Keyboard.readString();
		System.out.print("이메일 입력: ");
		String email = Keyboard.readString();
		System.out.print("연락처 입력: ");
		String tel = Keyboard.readString();

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setTel(tel);

		service.registerUser(user);

		System.out.println("### 회원가입이 완료되었습니다.");
	}

	private void 포인트충전() {
		System.out.println("[포인트충전]");

		System.out.println("### 사용자 아이디와 충전금액을 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();
		System.out.print("충전금액 입력: ");
		int amount = Keyboard.readInt();

		service.chargePoint(id, amount);
		User user = service.getUserInfo(id);

		System.out.println("### 충전 후 포인트: " + user.getPoint());
	}

	private void 내정보조회() {
		System.out.println("[내정보조회]");

		System.out.println("### 조회할 사용자 아이디를 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();

		User user = service.getUserInfo(id);
		System.out.println("------------------------------");
		System.out.println("아이디: " + user.getId());
		System.out.println("이름: " + user.getName());
		System.out.println("이메일: " + user.getEmail());
		System.out.println("전화번호: " + user.getTel());
		System.out.println("포인트: " + user.getPoint());
		System.out.println("------------------------------");
	}

	private void 종료() {
		System.out.println("[종료]");
		System.exit(1);
	}

	public static void main(String[] args) {
		MallApp app = new MallApp();
		app.menu();
	}
}