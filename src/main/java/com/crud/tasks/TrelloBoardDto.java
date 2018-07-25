package com.crud.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;



@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TrelloBoardDto {


    private String name;
    private String id;
    private ArrayList<TrelloBoardDto> lists;
}
