package com.crud.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TrelloBoardDto {

    public TrelloBoardDto() {
    }

    private String name;
    private String id;
}
