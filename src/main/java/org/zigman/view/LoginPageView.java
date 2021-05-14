package org.zigman.view;

import org.zigman.controller.DataController;
import org.zigman.controller.SaveListener;
import org.zigman.model.Button;
import org.zigman.model.Client;
import org.zigman.model.TextField;
import org.zigman.util.PanelBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To add new input field - just add it's name to textFieldNames array.
 */
public class LoginPageView extends JFrame {
    private final String[] textFieldNames = {
            "Name",
            "Email"
    };


    private List<TextField> textFieldList;
    private List<Button> buttonList;
    private List<Client> clientList;
    private JPanel mainPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel tablePanel = new JPanel();

    public LoginPageView(String title) {
        super(title);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tablePanel.setLayout(new GridLayout(1, 0));
        tablePanel.setOpaque(true);

        textFieldList = createTextFieldList(textFieldNames);
        createTextPanel();
        mainPanel.add(textPanel);

        clientList = loadData();

        buttonList = new ArrayList<>();
        Button save = Button.builder().jButton(new JButton("save")).build();
        save.getJButton().addActionListener(
                new SaveListener(textFieldList, clientList, tablePanel, textFieldNames));
        buttonList.add(save);

        createButtonPanel();
        mainPanel.add(buttonPanel);

        createTablePanel();
        mainPanel.add(tablePanel);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private List<Client> loadData() {
        return DataController.readData();
    }

    private void createTablePanel() {
        PanelBuilder.buildTable(tablePanel, clientList, textFieldNames);
    }

    private void createButtonPanel() {
        PanelBuilder.buildButtons(buttonPanel, buttonList);
    }

    private void createTextPanel() {
        PanelBuilder.buildTextFields(textPanel, textFieldList);
    }

    private List<TextField> createTextFieldList(String[] labels) {
        return Arrays.stream(labels)
                .map(e -> TextField.builder().label(new JLabel(e)).build())
                .collect(Collectors.toList());
    }
}
