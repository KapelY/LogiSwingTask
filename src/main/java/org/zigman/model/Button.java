package org.zigman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;

@Data
@AllArgsConstructor
@Builder
public class Button {
    @Builder.Default
    private JButton jButton = new JButton("");
}
