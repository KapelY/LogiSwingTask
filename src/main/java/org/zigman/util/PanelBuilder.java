package org.zigman.util;

import org.zigman.model.Button;
import org.zigman.model.Client;
import org.zigman.model.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelBuilder {
    public static JPanel buildTextFields(JPanel textPanel, List<TextField> textFieldList) {

        for (TextField textfield : textFieldList) {
            JPanel temp = new JPanel();
//            temp.setLayout(new FlowLayout(FlowLayout.CENTER));
            temp.add(textfield.getLabel());
            temp.add(textfield.getJTextField());
            textPanel.add(temp);
        }
        return textPanel;
    }

    public static JPanel buildButtons(JPanel buttonPanel, List<Button> buttonList) {

        for (Button button : buttonList) {
            buttonPanel.add(button.getJButton());
        }
        return buttonPanel;
    }

    public static JPanel buildTable(JPanel tablePanel, List<Client> clientsTable) {
        int raws = clientsTable.size();
        int columns = clientsTable.get(clientsTable.size() - 1).getTextFields().size();

        System.out.println("raws = " + raws);
        System.out.println("columns = " + columns);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Client lastSavedClient = clientsTable.get(clientsTable.size() - 1);
        gbc.weightx = 1f / lastSavedClient.getTextFields().size();
        for (TextField textField : lastSavedClient.getTextFields()) {
            gbc.gridx++;
            tablePanel.add(new Label(textField.getLabel().getText()), gbc);
        }
        gbc.gridy = 1;
        for (Client client : clientsTable) {
            gbc.gridx = 0;
            for (TextField field : client.getTextFields()) {
                gbc.gridx++;
                String temp = field.getJTextField().getText();
                System.out.print(temp + " ");
                tablePanel.add(new Label(temp), gbc);
            }
            System.out.println();
            gbc.gridy++;
        }
        return tablePanel;
    }
}