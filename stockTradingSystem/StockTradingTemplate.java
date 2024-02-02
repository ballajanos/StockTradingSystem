package stockTradingSystem;

public abstract class StockTradingTemplate {
	public final void tradeStock(User user, Stock stock, int quantity) {
        validateTrade(user, stock, quantity);
        executeTrade(user, stock, quantity);
        updatePortfolio(user, stock, quantity);
    }

    protected abstract void validateTrade(User user, Stock stock, int quantity);

    protected abstract void executeTrade(User user, Stock stock, int quantity);

    protected abstract void updatePortfolio(User user, Stock stock, int quantity);
}
