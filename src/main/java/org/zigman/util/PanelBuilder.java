package org.zigman.util;

import org.zigman.model.Button;
import org.zigman.model.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelBuilder {
    public static JPanel buildTextFields( List<TextField> textFieldList) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        for (TextField textfield: textFieldList) {
            JPanel temp = new JPanel();
            temp.setLayout(new FlowLayout(FlowLayout.CENTER));
            temp.add(textfield.getLabel());
            temp.add(textfield.getJTextField());
            jPanel.add(temp);
        }
        return jPanel;
    }
    public static JPanel buildButtons(List<Button> buttonList) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (Button button: buttonList) {
            jPanel.add(button.getJButton());
        }
        return jPanel;
    }
}
