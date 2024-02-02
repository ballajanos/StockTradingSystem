package stockTradingSystem;

import java.util.ArrayList;
import java.util.List;

public class StockExchange {
	private static StockExchange instance;
	private List<Stock> stocks;
	private List<User> users;
	private List<Transaction> transactions;
	
	public StockExchange() {
		this.stocks = new ArrayList<>();
		this.users = new ArrayList<>();
		this.transactions = new ArrayList<>();
	}
	
	public static synchronized StockExchange getInstance() {
		if(instance == null) {
			instance = new StockExchange();
		}
		return instance;
	}
	
	 public void addStock(Stock stock) {
	        stocks.add(stock);
	    }

	    public void addUser(User user) {
	        users.add(user);
	    }

	    public void addTransaction(Transaction transaction) {
	        transactions.add(transaction);
	    }

	    public List<Stock> getStocks() {
	        return stocks;
	    }

	    public List<User> getUsers() {
	        return users;
	    }

	    public List<Transaction> getTransactions() {
	        return transactions;
	    }
	  
	    public Stock getStockBySymbol(String symbol) {
	        for (Stock stock : stocks) {
	            if (stock.getSymbol().equals(symbol)) {
	                return stock;
	            }
	        }
	        return null; 
	    }
	    
	    public Stock searchStock(String symbol) {
	        for (Stock stock : stocks) {
	            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
	                return stock;
	            }
	        }
	        return null;
	    }
}
