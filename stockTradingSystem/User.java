package stockTradingSystem;

public class User implements StockObserver{
    private String username;
    private Portfolio portfolio;
    private String password;
    private double initialBalance;
    private double creditAccount;

    public User(String username, String password, double initialBalance, double creditAccount) {
        this.username = username;
        this.password = password;
        this.portfolio = new Portfolio();
        this.initialBalance = initialBalance;
        this.creditAccount=creditAccount;
    }


	public String getUsername() {
		return username;
	}


	public Portfolio getPortfolio() {
		return portfolio;
	}


	public String getPassword() {
		return password;
	}



	public double getInitialBalance() {
		return initialBalance;
	}

	

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}


	public double getCreditAccount() {
		return creditAccount;
	}


	public void setCreditAccount(double creditAccount) {
		this.creditAccount = creditAccount;
	}


	@Override
    public void update(Stock stock) {
		System.out.println(username + " received an update for stock: " + stock.getSymbol());
    }
	
	   public void chargeAccount(double amount) {
		   initialBalance -= amount;
	        System.out.println("Account charged: " + amount + ". Remaining balance: " +initialBalance);
	    }
	
}
