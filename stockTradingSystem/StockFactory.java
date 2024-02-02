package stockTradingSystem;

import java.time.LocalDate;

public interface StockFactory {
		Stock createStock (String symbol, String name, double currentPrice, int quantity, LocalDate date);
}
