package stockTradingSystem;

public class DayTradingStrategy implements TradingStrategy {
    @Override
    public void execute(User user, Stock stock, int quantity, String action) {
        if (action.equals("buy")) {
            System.out.println("Executing day trading buy strategy.");
        } else if (action.equals("sell")) {
            System.out.println("Executing day trading sell strategy.");
        }
    }
}
