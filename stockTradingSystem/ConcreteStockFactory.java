package stockTradingSystem;

import java.time.LocalDate;

public class ConcreteStockFactory implements StockFactory {
	
    public Stock createStock(String symbol, String name, double currentPrice, int quantity, LocalDate date) {
        return new Stock(symbol, name, currentPrice, quantity, date);
    }
}
