package stockTradingSystem;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
        
        users.put("john", new User("john", "password123", 1000.0, 800.0));
        
    }

    public User authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null; 
    }

    public User createUser(String username, String password, double initialBalance, double creditAcount) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password, initialBalance,creditAcount );
            users.put(username, newUser);
            return newUser;
        } else {
            return null;
        }
    }
}
