package com.wordsworth.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String id;
    private String name;
    private boolean host;

}
