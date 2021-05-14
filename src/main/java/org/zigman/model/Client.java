package org.zigman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Client implements Serializable {
    @Builder.Default
    private List<TextField> textFields = new ArrayList<>();
}
