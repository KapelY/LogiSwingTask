package org.zigman.controller;

import org.zigman.model.Client;
import org.zigman.model.TextField;
import org.zigman.util.PanelBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class SaveListener implements ActionListener {
    private final static String EMAIL_FIELD_LABEL = "Email";
    private final static String NAME_FIELD_LABEL = "Name";
    private final List<Client> clientList;
    private final JPanel tablePanel;
    private final String[] textFieldNames;
    List<TextField> textFieldList;


    public SaveListener(List<TextField> textFieldList, List<Client> clientList, JPanel tablePanel, String[] textFieldNames) {
        this.textFieldList = textFieldList;
        this.clientList = clientList;
        this.tablePanel = tablePanel;
        this.textFieldNames = textFieldNames;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField save = textFieldList.stream().filter((textField) ->
                textField.getLabel().getText().equals(EMAIL_FIELD_LABEL)
        ).findAny().orElse(TextField.builder().build());
        TextField name = textFieldList.stream().filter((textField) ->
                textField.getLabel().getText().equals(NAME_FIELD_LABEL)
        ).findAny().orElse(TextField.builder().build());

        boolean isValidEmail = verifyEmailAddress(save.getJTextField().getText());
        boolean isValidName = verifyName(name.getJTextField().getText());

        if (isValidEmail && isValidName) {
            Client client = new Client(deepCopyTextFieldList());
            clientList.add(client);
            clearAllTextFields();

            repaintTablePanel();
            DataController.writeData(clientList);
        }
    }

    private boolean verifyName(String nameText) {
        final String REGEX = "(^[A-Za-z]+)(\\s+[A-Za-z]+){0,3}";
        if (!nameText.trim().matches(REGEX)) {
            JOptionPane.showMessageDialog(null, "name is not valid(only Latin alphabet, no more than 4 words)");
            return false;
        }
        return true;
    }

    private boolean verifyEmailAddress(String emailAddress) {
        final String REGEX = "(^[A-Za-z]+)([A-Za-z0-9+_.-]*)@[A-Za-z0-9+_.-]+$";
        if (!emailAddress.trim().matches(REGEX)) {
            JOptionPane.showMessageDialog(null, "email is not valid(address consists of two parts, \nseparated by \"@\". Only Latin alphabet, numbers and symbols \"-\", \"_\", \".\". Starts only with Latin alphabet.");
            return false;
        }
        return true;
    }

    private void repaintTablePanel() {
        tablePanel.removeAll();
        PanelBuilder.buildTable(tablePanel, clientList, textFieldNames);
        tablePanel.revalidate();
        tablePanel.repaint();
    }

    private List<TextField> deepCopyTextFieldList() {
        return textFieldList.stream()
                .map(e1 -> new TextField(e1.getLabel(), new JTextField(e1.getJTextField()
                        .getText())))
                .collect(Collectors.toList());
    }

    private void clearAllTextFields() {
        textFieldList.forEach(t -> t.getJTextField().setText(""));
    }

}
