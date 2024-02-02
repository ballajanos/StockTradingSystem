package stockTradingSystem;

public interface TradingStrategy {
	void execute(User user, Stock stock, int quantity, String action);
}
