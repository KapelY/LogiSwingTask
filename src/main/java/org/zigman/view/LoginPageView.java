package org.zigman.view;

import lombok.Getter;
import lombok.Setter;
import org.zigman.controller.SaveListener;
import org.zigman.model.Button;
import org.zigman.model.Client;
import org.zigman.model.TextField;
import org.zigman.util.PanelBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LoginPageView extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel tablePanel = new JPanel();
//    final JScrollPane scrollPane = new JScrollPane(tablePanel);
    private final List<TextField> textFieldList;
    private final List<Button> buttonList;
    private final List<Client> clientList = new ArrayList<>();

    public LoginPageView(String title) {
        super(title);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        labPanel.setLayout(new BoxLayout(labPanel, BoxLayout.Y_AXIS));
        tablePanel.setLayout(new GridBagLayout());

        //todo rm this
        textFieldList = new ArrayList<>();
        TextField name = TextField.builder().label(new JLabel("name")).build();
        TextField email = TextField.builder().label(new JLabel("email")).build();;
        TextField address = TextField.builder().label(new JLabel("address")).build();;
        textFieldList.add(name);
        textFieldList.add(email);
        textFieldList.add(address);

        createTextPanel();
        mainPanel.add(textPanel);





        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JTextField jTextField3 = new JTextField();
        jTextField1.setText("Jorge");
        jTextField2.setText("jorge@gmail.com");
        List<TextField> client1FieldList = new ArrayList<>();
        client1FieldList.add(new TextField(new JLabel("name"), jTextField1));
        client1FieldList.add(new TextField(new JLabel("email"), jTextField2));
        Client client1 = new Client(client1FieldList);
        clientList.add(client1);

        jTextField1 = new JTextField();
         jTextField2 = new JTextField();
         jTextField3 = new JTextField();
        jTextField1.setText("Jorge2");
        jTextField2.setText("jorge2@gmail.com");
        jTextField3.setText("Kyiv");
        client1FieldList = new ArrayList<>();
        client1FieldList.add(new TextField(new JLabel("name"), jTextField1));
        client1FieldList.add(new TextField(new JLabel("email"), jTextField2));
        client1FieldList.add(new TextField(new JLabel("address"), jTextField3));
        Client client2 = new Client(client1FieldList);
        clientList.add(client2);

        createTablePanel();
        mainPanel.add(tablePanel);

        //todo rm this
        buttonList = new ArrayList<>();
        Button save = Button.builder().jButton(new JButton("save")).build();
        save.getJButton().setActionCommand(save.getJButton().getName());
        save.getJButton().addActionListener(this);
        buttonList.add(save);
        Button ok = Button.builder().jButton(new JButton("ok")).build();
        ok.getJButton().setActionCommand(save.getJButton().getName());
//        ok.getJButton().addActionListener(this);
        buttonList.add(ok);
        Button cancel = Button.builder().jButton(new JButton("cancel")).build();
        cancel.getJButton().setActionCommand(save.getJButton().getName());
//        cancel.getJButton().addActionListener(this);
        buttonList.add(cancel);

        createButtonPanel();
        mainPanel.add(buttonPanel);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTablePanel() {

        PanelBuilder.buildTable(tablePanel, clientList);
    }

    private void createButtonPanel() {

        PanelBuilder.buildButtons(buttonPanel, buttonList);
    }

    private void createTextPanel() {

        PanelBuilder.buildTextFields(textPanel, textFieldList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client client = new Client(new ArrayList<>(textFieldList));
//        textFieldList.forEach(t -> t.getJTextField().setText("") );
//        mainPanel.removeAll();
        clientList.add(client);
        PanelBuilder.buildTable(tablePanel, clientList);
//        textFieldList.forEach(textField -> {textField.getJTextField().setText("");});
//        mainPanel.add(textPanel);
//        mainPanel.add(buttonPanel);
//        mainPanel.add(tablePanel);
        mainPanel.revalidate();
        mainPanel.repaint();



//        String action =  e.getActionCommand();
//        System.out.println(action);
//        textFieldList.forEach((eeee)-> System.out.println(eeee.getJTextField().getText()));
    }
}
