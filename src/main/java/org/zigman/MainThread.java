package org.zigman;

import org.zigman.view.LoginPageView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingUtilities.invokeLater;

public class MainThread {
    private static final String TITLE = "LOGIN CASE";

    public static void main(String[] args) {
        final JFrame loginPage = new LoginPageView(TITLE);
        invokeLater(() -> {
                    loginPage.setPreferredSize(new Dimension(600, 300));
                    loginPage.pack();
                    loginPage.setVisible(true);
                }
        );

    }
}
