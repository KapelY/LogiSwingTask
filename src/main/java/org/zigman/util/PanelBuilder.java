package org.zigman.util;

import org.zigman.model.Button;
import org.zigman.model.Client;
import org.zigman.model.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class PanelBuilder {
    public static JPanel buildTextFields(JPanel textPanel, List<TextField> textFieldList) {

        for (TextField textfield : textFieldList) {
            JPanel temp = new JPanel();
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

    public static JPanel buildTable(JPanel tablePanel, List<Client> clientsTable, String[] textFieldNames) {

        int maxCountTextFields = clientsTable.stream()
                .max(Comparator.comparing(v -> v.getTextFields().size())).get()
                .getTextFields().size();
        Client[] clients = clientsTable.toArray(new Client[0]);
        String[][] data = new String[clients.length][maxCountTextFields];
        for (int i = 0; i < clients.length; i++) {
            String[] text = new String[maxCountTextFields];
            String[] srcText = clients[i].getTextFields()
                    .stream().map(e -> e.getJTextField().getText()).toArray(String[]::new);
            System.arraycopy(srcText, 0, text, 0, srcText.length);
            for (int j = 0; j < textFieldNames.length; j++) {
                data[i][j] = text[j] != null ? text[j] : "";
            }
        }
        final JTable table = new JTable(data, textFieldNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        tablePanel.add(scrollPane);

        return tablePanel;
    }
}