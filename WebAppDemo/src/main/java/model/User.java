package model;

public class User {
    private static final String USERNAME = "Bach";
    private static final String PASSWORD = "123456";

    public boolean validation (String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}