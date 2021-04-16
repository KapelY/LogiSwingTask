package org.zigman;

public class MainThread {
    private static final String TITLE = "LOGIN CASE";

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage(TITLE);
        loginPage.setVisible(true);
    }
}
