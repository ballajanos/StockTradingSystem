package stockTradingSystem;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       
        StockTradingFacade stockTradingFacade = new StockTradingFacade(new DayTradingStrategy());
        UserManagementFacade userManagementFacade = new UserManagementFacade();
        LocalDate currentDate = LocalDate.now();

     
        User user = userManagementFacade.authenticateUser("john", "password123");

       
        if (user != null) {
            System.out.println("Login successful. Current user: " + user.getUsername());

           
            stockTradingFacade.loginUser("john", "password123");

          
            Stock aaplStock = new Stock("AAPL", "Apple Inc.", 150.0, 100, currentDate); // Provide appropriate values
            stockTradingFacade.addStockToExchange(aaplStock);
            stockTradingFacade.buyStock("AAPL", 10);
            stockTradingFacade.sellStock("AAPL", 5);
            
            Stock googStock = new Stock("GOOGL", "Google.", 450.0, 90, currentDate); // Provide appropriate values
            stockTradingFacade.addStockToExchange(googStock);
            stockTradingFacade.buyStock("GOOGL", 5);
            stockTradingFacade.sellStock("GOOGL", 3);
            
          
            stockTradingFacade.displayPortfolio();
            

            Stock searchedStock = stockTradingFacade.searchStock("AAPL");
            if (searchedStock != null) {
                System.out.println("Searched Stock: " + searchedStock.getName() + " (" + searchedStock.getSymbol() + ")");
                System.out.println("Current Price: " + searchedStock.getCurrentPrice());
            } else {
                System.out.println("Stock not found.");
            }
         
            stockTradingFacade.logoutUser();
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
}






