package org.zigman;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame{
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField emailField;
    private JButton saveButton;

    public LoginPage(String title) throws HeadlessException {
        super(title);
        setContentPane(mainPanel);
    }
}
