package stockTradingSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Portfolio {

    private List<Stock> ownedStocks;

    public Portfolio() {
        this.ownedStocks = new ArrayList<>();
    }

    public void addStock(Stock stock, int quantity) {
        for (int i = 0; i < quantity; i++) {
            ownedStocks.add(new Stock(stock.getSymbol(), stock.getName(), stock.getCurrentPrice(), 1, stock.getDate()));
        }
    }

    public void removeStock(Stock stock, int quantity) {
        Iterator<Stock> iterator = ownedStocks.iterator();
        int count = 0;

        while (iterator.hasNext() && count < quantity) {
            Stock ownedStock = iterator.next();
            if (ownedStock.getSymbol().equals(stock.getSymbol())) {
                iterator.remove();
                count++;
            }
        }
    }

    public List<Stock> getOwnedStocks() {
        return ownedStocks;
    }

    public void displayPortfolio(User user) {
        System.out.println("Portfolio for user: " + user.getUsername());
        System.out.println("Owned Stocks:");
        for (Stock stock : ownedStocks) {
            System.out.println(stock.getName() + " (" + stock.getSymbol() + ")");
        }
    }
    
    public int getOwnedStockQuantity(Stock stock) {
        int count = 0;
        for (Stock ownedStock : ownedStocks) {
            if (ownedStock.equals(stock)) {
                count++;
            }
        }
        return count;
    }
}
