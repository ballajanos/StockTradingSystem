package stockTradingSystem;

public class SellStockTradingTemplate extends StockTradingTemplate {

	    @Override
	    protected void validateTrade(User user, Stock stock, int quantity) {
	        
	        if (user.getPortfolio().getOwnedStockQuantity(stock) >= quantity) {
	            System.out.println("Trade validation successful.");
	        } else {
	            System.out.println("Trade validation failed. Not enough stocks to sell.");
	        }
	    }

	    @Override
	    protected void executeTrade(User user, Stock stock, int quantity) {
	        double stockValue = stock.getCurrentPrice() * quantity;
	        user.setCreditAccount(stockValue); 
	        System.out.println("Stock sold successfully. Credited account with: " + stockValue);
	    }

	    @Override
	    protected void updatePortfolio(User user, Stock stock, int quantity) {
	        user.getPortfolio().removeStock(stock, quantity);
	        System.out.println("Updated portfolio after selling stocks.");
	    }
}
