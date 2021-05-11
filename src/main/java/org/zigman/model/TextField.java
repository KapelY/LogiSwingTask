package org.zigman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;

@Data
@AllArgsConstructor
@Builder
public class TextField {
    @Builder.Default
    private JLabel label = new JLabel("");
    @Builder.Default
    private JTextField jTextField = new JTextField(10);
}
