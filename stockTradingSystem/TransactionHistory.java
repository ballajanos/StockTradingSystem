package stockTradingSystem;

import java.util.List;

public interface TransactionHistory {
	
	void addTransaction(Transaction transaction);
	
    List<Transaction> getTransactionHistory();
}
