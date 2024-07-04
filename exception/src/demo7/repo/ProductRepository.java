package demo7.repo;

import java.util.ArrayList;
import java.util.List;

import demo7.vo.Product;

public class ProductRepository {

	private List<Product> db = new ArrayList<Product>();
	private int sequence = 100;
	
	public ProductRepository() {
		db.add(new Product(sequence++, "운동화", 5000, 10));
		db.add(new Product(sequence++, "체육복", 3000, 10));
		db.add(new Product(sequence++, "반바지", 1000, 2));
		db.add(new Product(sequence++, "축구공", 2000, 3));
		db.add(new Product(sequence++, "농구공", 2000, 1));
	}
	
	/**
	 * 모든 상품정보를 반환한다.
	 * @return 상품정보 리스트
	 */
	public List<Product> findAll(){
		return db;
	}
	
	/**
	 * 상품번호를 전달받아서 상품정보를 반환한다.
	 * @param no 상품번호
	 * @return 상품정보
	 */
	public Product findProductByNo(int no) {
		Product product = null;
		
		for(Product p : db) {
			if(p.getNo() == no) {
				product = p;
				break;
			}
		}
		
		return product;
	}
}