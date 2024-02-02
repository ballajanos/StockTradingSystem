package stockTradingSystem;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
	 private List<Stock> stocks;

	    public StockManager() {
	        this.stocks = new ArrayList<>();
	    }

	    public void addStock(Stock stock) {
	        stocks.add(stock);
	    }

	    public List<Stock> getAllStocks() {
	        return new ArrayList<>(stocks); 
	    }

	    public Stock getStockBySymbol(String symbol) {
	        for (Stock stock : stocks) {
	            if (stock.getSymbol().equals(symbol)) {
	                return stock;
	            }
	        }
	        return null;
	    }
}
