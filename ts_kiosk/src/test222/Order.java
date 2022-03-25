package test222;

import java.util.Date;

public class Order {
	private int orderNum; // 주문번호
	private String cId; // 고객 아이디
	private String pName; // 상품 이름
	private int quantity; // 수량
	private int price; // 가격
	private Date time; //주문 시간
	private int status; // 주문 상태
	private int totalQ; //총 수량
	private int totalP; //총 가격
	
	public static final int ORDER_REQUEST = 1;
	public static final int ORDER_PREPARE = 2;
	public static final int ORDER_COMPLETE = 3;
	
	public String toString() {

		return "order [orderNum=" + orderNum + ", memId=" + cId + ", productName="
				+ pName + ", quantity=" + quantity + ", price=" + price + 
				", orderTime=" + time + ", orderStatus=" + status + ", totalQuantity=" + totalQ + ", totalPrice=" + totalP
				+ "]";
		
	}
	
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getCustomerId() {
		return cId;
	}
	public void setCustomerId(String customerId) {
		this.cId = customerId;
	}
	public String getProductName() {
		return pName;
	}
	public void setProductName(String productName) {
		this.pName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getTotalQuantity() {
		return totalQ;
	}
	public void setTotalQuantity(int totalQ) {
		this.totalQ = totalQ;
	}
	
	public int getTotalPrice() {
		return totalP;
	}
	public void setTotalPrice(int totalP) {
		this.totalP = totalP;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int orderNum, String cId, String pName, int quantity, int price, Date time, int status,
			int totalQ, int totalP) {
		super();
		this.orderNum = orderNum;
		this.cId = cId;
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
		this.time = time;
		this.status = status;
		this.totalQ = totalQ;
		this.totalP = totalP;
	}
	
	

}
