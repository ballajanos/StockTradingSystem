package stockTradingSystem;

import java.time.LocalDate;

public class StockBuilder {
	private String symbol;
	private String name;
	private double currentPrice;
	private int quantity;
	private LocalDate date;
	
	public StockBuilder setSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}
	
	public StockBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public StockBuilder setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
		return this;
	}
	
	public StockBuilder setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
    public StockBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Stock build() {
        return new Stock(symbol, name, currentPrice, quantity, date);
    }
	
}
