package stockTradingSystem;

public class BuyStockTradingTemplate extends StockTradingTemplate {

	 @Override
	    protected void validateTrade(User user, Stock stock, int quantity) {
	        if (user == null || stock == null || quantity <= 0) {
	            throw new IllegalArgumentException("Invalid trade parameters. Please provide valid inputs.");
	        }

	        if (user.getInitialBalance() < stock.getCurrentPrice() * quantity) {
	            throw new IllegalStateException("Insufficient funds to buy the specified quantity of stocks.");
	        }
	    }

	    @Override
	    protected void executeTrade(User user, Stock stock, int quantity) {
	        double totalCost = stock.getCurrentPrice() * quantity;

	        user.setInitialBalance(user.getInitialBalance() - totalCost);

	        System.out.println("Executing buy trade for " + quantity + " shares of " + stock.getName() +
	                " (Symbol: " + stock.getSymbol() + ") for a total cost of $" + totalCost);
	    }

	    @Override
	    protected void updatePortfolio(User user, Stock stock, int quantity) {
	        user.getPortfolio().addStock(stock, quantity);

	        System.out.println("Updated portfolio for user " + user.getUsername() + ":");
	        user.getPortfolio().displayPortfolio(user);
	    }

}
