package org.zigman.controller;

import org.zigman.model.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SaveListener implements ActionListener {
    List<TextField> textFieldList;
    private final static String EMAIL_FIELD_LABEL = "email";
    private final static String NAME_FIELD_LABEL = "name";

    public SaveListener(List<TextField> textFieldList) {
        this.textFieldList = textFieldList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField save = textFieldList.stream().filter((textField) ->
                textField.getLabel().getText().equals(EMAIL_FIELD_LABEL)
        ).findAny().orElse(null);
        TextField name = textFieldList.stream().filter((textField) ->
                textField.getLabel().getText().equals(NAME_FIELD_LABEL)
        ).findAny().orElse(null);
        assert name != null;
        System.out.println("In save ---  " + save.getJTextField().getText());
        verifyEmailAddress(save.getJTextField().getText());
        System.out.println("In name --- " + name.getJTextField().getText());
        verifyName(name.getJTextField().getText());
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
