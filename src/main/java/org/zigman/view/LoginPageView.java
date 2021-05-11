package org.zigman.view;

import org.zigman.controller.SaveListener;
import org.zigman.model.Button;
import org.zigman.model.TextField;
import org.zigman.util.PanelBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginPageView extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private final List<TextField> textFieldList;
    private final List<Button> buttonList;

    public LoginPageView(String title) {
        super(title);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //todo rm this
        textFieldList = new ArrayList<>();
        TextField name = TextField.builder().label(new JLabel("name")).build();
        TextField email = TextField.builder().label(new JLabel("email")).build();;
        textFieldList.add(name);
        textFieldList.add(email);

        createTextPanel();
        mainPanel.add(textPanel);

        //todo rm this
        buttonList = new ArrayList<>();
        Button save = Button.builder().jButton(new JButton("save")).build();
        save.getJButton().setActionCommand(save.getJButton().getName());
        save.getJButton().addActionListener(new SaveListener(textFieldList));
        buttonList.add(save);
        Button ok = Button.builder().jButton(new JButton("ok")).build();
        ok.getJButton().setActionCommand(save.getJButton().getName());
        ok.getJButton().addActionListener(this);
        buttonList.add(ok);
        Button cancel = Button.builder().jButton(new JButton("cancel")).build();
        cancel.getJButton().setActionCommand(save.getJButton().getName());
        cancel.getJButton().addActionListener(this);
        buttonList.add(cancel);

        createButtonPanel();
        mainPanel.add(buttonPanel);
        createTablePanel();
//        mainPanel.add(tablePanel);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTablePanel() {
    }

    private void createButtonPanel() {
        buttonPanel = PanelBuilder.buildButtons(buttonList);
    }

    private void createTextPanel() {
        textPanel = PanelBuilder.buildTextFields(textFieldList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action =  e.getActionCommand();
        System.out.println(action);
        textFieldList.forEach((eeee)-> System.out.println(eeee.getJTextField().getText()));
    }
}
