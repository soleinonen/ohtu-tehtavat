package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.lang.Character;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
    	// username validity check
    	if(this.userDao.findByName(username)!=null || username.length()<3 || Pattern.matches(".*[^a-z].*", username)) {
    		return true;
    	}
    	// password validity check
    	if(password.length()<8 || !Pattern.matches(".*[^a-zA-Z]{1,}.*", password)) {
    		return true;
    	}
        return false;
    }
}
