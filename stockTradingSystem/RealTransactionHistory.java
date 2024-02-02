package stockTradingSystem;

import java.util.ArrayList;
import java.util.List;

public class RealTransactionHistory implements TransactionHistory {
	 private List<Transaction> transactions;

	    public RealTransactionHistory() {
		this.transactions = transactions;
	}

	    @Override
	    public void addTransaction(Transaction transaction) {
	        transactions.add(transaction);
	    }

	    @Override
	    public List<Transaction> getTransactionHistory() {
	        return new ArrayList<>(transactions); 
	    }
}
