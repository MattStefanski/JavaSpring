package com.crud.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {


    @JsonProperty("id")
    private String name;

    @JsonProperty("name")
    private String id;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;


}
