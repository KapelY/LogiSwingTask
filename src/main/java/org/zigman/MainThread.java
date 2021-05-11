package org.zigman;

import org.zigman.view.LoginPageView;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

public class MainThread {
    private static final String TITLE = "LOGIN CASE";

    public static void main(String[] args) {
        final JFrame loginPage = new LoginPageView(TITLE);
        invokeLater(() -> {
            loginPage.pack();
            loginPage.setVisible(true);
        }
        );

    }
}
