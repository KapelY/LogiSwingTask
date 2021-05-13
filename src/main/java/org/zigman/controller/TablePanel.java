package org.zigman.controller;

import lombok.Getter;
import lombok.Setter;
import org.zigman.model.Client;
import org.zigman.model.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Setter
@Getter
public class TablePanel extends JPanel {
    private List<Client> clientsTable;
    private JPanel jPanel;

    public TablePanel(List<Client> clientsTable) {
        this.clientsTable = clientsTable;
        createTable();
    }

    private void createTable() {
        int raws = clientsTable.size();
        int columns = clientsTable.get(clientsTable.size() - 1).getTextFields().size();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        System.out.println("raws = " + raws);
        System.out.println("columns = " + columns);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Client lastSavedClient = clientsTable.get(clientsTable.size() - 1);
        gbc.weightx = 1f / lastSavedClient.getTextFields().size();
        for (org.zigman.model.TextField textField : lastSavedClient.getTextFields()) {
            gbc.gridx++;
            jPanel.add(textField.getLabel(), gbc);
        }
        gbc.gridy = 1;
        for (Client client : clientsTable) {
            gbc.gridx = 0;
            for (TextField field : client.getTextFields()) {
                gbc.gridx++;
                JTextField temp = field.getJTextField();
                System.out.print(temp.getText() + " ");
                temp.setEditable(false);
                jPanel.add(temp, gbc);
            }
            System.out.println();
            gbc.gridy++;
        }
        this.jPanel = jPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createTable();
    }
}
