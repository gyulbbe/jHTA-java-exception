package demo7.vo;

import java.util.Date;

public class Order {
	
	private int no;
	private Date date;
	private int productNo;
	private String productName;
	private int productPrice;
	private int amount;
	private int totalPrice;
	private String userId;
	
	public Order() {}
	
	public Order(int no, Date date, int productNo, String productName, int productPrice, int amount, int totalPrice,
			String userId) {
		this.no = no;
		this.date = date;
		this.productNo = productNo;
		this.productName = productName;
		this.amount = amount;
		this.productPrice = productPrice;
		this.totalPrice = totalPrice;
		this.userId = userId;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}