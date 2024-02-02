package stockTradingSystem;

public class UserManagementFacade {

    private UserManager userManager;

    public UserManagementFacade() {
        this.userManager = new UserManager();
    }

    public User createUser(String username, String password, double initialBalance, double creditAcount) {
        return userManager.createUser(username, password, initialBalance, creditAcount);
    }

    public User authenticateUser(String username, String password) {
        return userManager.authenticateUser(username, password);
    }
}