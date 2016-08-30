package cn.tf.domain;

public class Book {
	
	private Integer bid;
	private String title;
	private String price;
	private int orderCount;
	
	
	
	
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", price=" + price
				+ ", orderCount=" + orderCount + "]";
	}
	

	
	
	

}
