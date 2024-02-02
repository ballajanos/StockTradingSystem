package stockTradingSystem;

import java.util.List;

public class StockTradingFacade {

    private StockExchange stockExchange;
    private UserManagementFacade userManagementFacade;
    private TradingStrategy tradingStrategy;
    private User currentUser;

    public StockTradingFacade(TradingStrategy tradingStrategy) {
        this.stockExchange = StockExchange.getInstance();
        this.userManagementFacade = new UserManagementFacade();
        this.tradingStrategy = tradingStrategy;
    }
    
    public void setTradingStrategy(TradingStrategy tradingStrategy) {
        this.tradingStrategy = tradingStrategy;
    }

    public boolean loginUser(String username, String password) {
        User user = userManagementFacade.authenticateUser(username, password);
        if (user != null) {
            currentUser = user;
            System.out.println("Login successful. Current user: " + currentUser.getUsername());
            return true;
        } else {
            System.out.println("Login failed. Please check your credentials.");
            return false;
        }
    }

    public void logoutUser() {
        if (currentUser != null) {
            System.out.println("Logout successful. Logged out user: " + currentUser.getUsername());
        }
        currentUser = null;
    }

    public void buyStock(String stockSymbol, int quantity) {
        if (currentUser != null) {
            System.out.println("User " + currentUser.getUsername() + " is buying " + quantity + " shares of stock " + stockSymbol + ".");
            Stock stock = stockExchange.getStockBySymbol(stockSymbol);
            if (stock != null) {
                tradingStrategy.execute(currentUser, stock, quantity, "buy");
                stockExchange.addTransaction(new Transaction(currentUser, stock, quantity, stock.getCurrentPrice()));
                currentUser.getPortfolio().addStock(stock, quantity);
                System.out.println("Stock bought successfully.");
            } else {
                System.out.println("Stock not found. Available stocks in exchange: " + stockExchange.getStocks());
            }
        } else {
            System.out.println("User not logged in. Please log in to perform stock trading operations.");
        }
    }

    public void sellStock(String stockSymbol, int quantity) {
        if (currentUser != null) {
            System.out.println("User " + currentUser.getUsername() + " is selling " + quantity + " shares of stock " + stockSymbol + ".");
            Stock stock = stockExchange.getStockBySymbol(stockSymbol);
            if (stock != null) {
                tradingStrategy.execute(currentUser, stock, quantity, "sell");
                stockExchange.addTransaction(new Transaction(currentUser, stock, quantity, stock.getCurrentPrice()));
                currentUser.getPortfolio().removeStock(stock, quantity);
                System.out.println("Stock sold successfully.");
            } else {
                System.out.println("Stock not found. Available stocks in exchange: " + stockExchange.getStocks());
            }
        } else {
            System.out.println("User not logged in. Please log in to perform stock trading operations.");
        }
    }

    public void displayPortfolio() {
        if (currentUser != null) {
            currentUser.getPortfolio().displayPortfolio(currentUser);
            System.out.println("All Stocks in StockExchange:");
            for (Stock stock : stockExchange.getStocks()) {
                System.out.println(stock.getName() + " (" + stock.getSymbol() + ")");
            }
        } else {
            System.out.println("User not logged in.");
        }
    }
    public Stock searchStock(String stockSymbol) {
        Stock stock = stockExchange.getStockBySymbol(stockSymbol);
        return stock;
    }

    public void addStockToExchange(Stock stock) {
        stockExchange.addStock(stock);
    }
}




