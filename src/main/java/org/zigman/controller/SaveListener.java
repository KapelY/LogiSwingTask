package org.zigman.controller;

import org.zigman.model.Client;
import org.zigman.model.TextField;
import org.zigman.util.PanelBuilder;
import org.zigman.view.LoginPageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SaveListener implements ActionListener {
    List<TextField> textFieldList;
    private List<Client> clientList;
    private JPanel tablePanel;
    private final static String EMAIL_FIELD_LABEL = "email";
    private final static String NAME_FIELD_LABEL = "name";

    public SaveListener(List<TextField> textFieldList, List<Client> clientList, JPanel tablePanel) {
        this.textFieldList = textFieldList;
        this.clientList = clientList;
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField save = textFieldList.stream().filter((textField) ->
                textField.getLabel().getText().equals(EMAIL_FIELD_LABEL)
        ).findAny().orElse(null);
        TextField name = textFieldList.stream().filter((textField) ->
                textField.getLabel().getText().equals(NAME_FIELD_LABEL)
        ).findAny().orElse(null);
//        System.out.println("In save ---  " + save.getJTextField().getText());
        verifyEmailAddress(save.getJTextField().getText());
//        System.out.println("In name --- " + name.getJTextField().getText());
        verifyName(name.getJTextField().getText());

        Client client = new Client(textFieldList);
//        textFieldList.forEach(t -> t.getJTextField().setText("") );
//        mainFrame.remove(tablePanel);
        clientList.add(client);
        tablePanel.removeAll();
        tablePanel = PanelBuilder.buildTable(tablePanel, clientList);
        tablePanel.revalidate();
        tablePanel.repaint();

//        mainFrame.add(PanelBuilder.buildTable(clientList));
//        mainFrame.revalidate();
//        mainFrame.repaint();
//        mainFrame.add(tablePanel);
//        mainFrame.setTablePanel(tablePanel);
        System.out.println("Before repaint");
//        mainFrame.pack();
//        mainFrame.setVisible(true);
//        mainFrame.repaint();
        System.out.println("After repaint");

    }

    private void verifyName(String nameText) {
        final String REGEX = "(^[A-Za-z]+)(\\s+[A-Za-z]+){0,3}";
        System.out.println(nameText.trim().matches(REGEX));
    }

    private void verifyEmailAddress(String emailAddress) {
        final String REGEX = "(^[A-Za-z]+)([A-Za-z0-9+_.-]*)@[A-Za-z0-9+_.-]+$";
        System.out.println(emailAddress.matches(REGEX));
    }
}
