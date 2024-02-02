package stockTradingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stock{
	private String symbol;
	private String name;
	private double currentPrice;
	private int quantity;
	private List<StockObserver> observers;
	private LocalDate date;
	
	public Stock(String symbol, String name, double currentPrice, int quantity, LocalDate date) {
		this.symbol = symbol;
		this.name = name;
		this.currentPrice = currentPrice;
		this.quantity = quantity;
		this.observers = new ArrayList<>();
		this.date = date;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public int getQuantity() {
		return quantity;
	}

    public LocalDate getDate() {
        return date;
    }
    
    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
        notifyObservers();
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
        notifyObservers();
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }
}
