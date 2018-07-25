package com.crud.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloCardDto {


    public TrelloCardDto() {
    }

    @JsonProperty("name")
    private  String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("pos")
    private String pos;

    @JsonProperty("listId")
    private String listId;


}
