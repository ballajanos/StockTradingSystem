package stockTradingSystem;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class LongTermInvestingStrategy implements TradingStrategy {
	private static final double DAY_TRADE_CHARGE_PERCENTAGE = 5.0;
    private StockExchange stockExchange;

    public LongTermInvestingStrategy(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    private static final double FEE_PERCENTAGE = 0.05;

    @Override
    public void execute(User user, Stock stock, int quantity, String action) {
        if ("buy".equalsIgnoreCase(action)) {

            user.getPortfolio().addStock(stock, quantity);

        } else if ("sell".equalsIgnoreCase(action)) {
           
            if (user.getPortfolio().getOwnedStockQuantity(stock) >= quantity) {
                user.getPortfolio().removeStock(stock, quantity);
                if (isSameDay(stock.getDate(), new Date())) {
                  
                    System.out.println("Executing long-term investing sell strategy.");
                } else {
                  
                    double stockValue = stock.getCurrentPrice() * quantity;
                    double fee = stockValue * FEE_PERCENTAGE;
                    user.chargeAccount(fee);
                    System.out.println("Executing long-term investing sell strategy. Charged fee: " + fee);
                }
            } else {
                System.out.println("Not enough stocks to sell.");
            }
        }
    }

    private boolean isSameDay(LocalDate localDate, Date date2) {
      
        Instant instant = date2.toInstant();
        LocalDate convertedDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

       
        return localDate.equals(convertedDate);
    }

    private double calculateCharge(Stock stock, int quantity) {
        
        return stock.getCurrentPrice() * quantity * DAY_TRADE_CHARGE_PERCENTAGE / 100.0;
    }
}
