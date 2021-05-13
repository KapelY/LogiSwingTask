package org.zigman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Client {
    @Builder.Default
    private List<TextField> textFields = new ArrayList<>();
}
