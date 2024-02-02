package stockTradingSystem;

import java.util.List;

public class TransactionHistoryProxy implements TransactionHistory {
	private RealTransactionHistory realTransactionHistory;
	
	public TransactionHistoryProxy(RealTransactionHistory realTransactionHistory) {
		this.realTransactionHistory = realTransactionHistory;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		System.out.println("Logging transaction: " + transaction.getTimestamp());
        realTransactionHistory.addTransaction(transaction);
	}

	@Override
	public List<Transaction> getTransactionHistory() {
		return realTransactionHistory.getTransactionHistory();
	}

}
