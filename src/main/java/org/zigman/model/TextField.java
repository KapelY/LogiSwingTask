package org.zigman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class TextField implements Serializable {
    @Builder.Default
    private JLabel label = new JLabel("");
    @Builder.Default
    private JTextField jTextField = new JTextField(10);
}
