package stockTradingSystem;

import java.util.Date;

public class Transaction {

	private User user;
	private Stock stock;
	private int quantity;
	private double price;
	private Date date;
	
	public Transaction(User user, Stock stock, int quantity, double price) {
		this.user = user;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
		this.date = new Date();
	}

	public User getUser() {
		return user;
	}

	public Stock getStock() {
		return stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public Date getDate() {
		return date;
	}
}
